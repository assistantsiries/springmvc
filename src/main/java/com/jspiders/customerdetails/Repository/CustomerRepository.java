package com.jspiders.customerdetails.Repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.jspiders.customerdetails.Repository.Pojo.AdminPojo;
import com.jspiders.customerdetails.Repository.Pojo.CustomerPojo;

@Repository
public class CustomerRepository {
	
	private static EntityManagerFactory factory;
	private static EntityManager manager;
	private static EntityTransaction transaction;
	private static String jpql;
	private static Query query;
	
	private static void openConnection() {
		factory=Persistence.createEntityManagerFactory("customer");
		manager=factory.createEntityManager();
		transaction=manager.getTransaction();
	}
	
	private static void closeConnection() {
		if(factory!=null) {
			factory.close();
		}
		if(manager!=null) {
			manager.close();
		}
		if(transaction.isActive()) {
			transaction.rollback();
		}
	}
	public CustomerPojo addCust(String name, String email, long contact, String address) {
		openConnection();
		transaction.begin();
		CustomerPojo pojo=new CustomerPojo();
		pojo.setName(name);
		pojo.setEmail(email);
		pojo.setContact(contact);
		pojo.setAddress(address);
		manager.persist(pojo);
		transaction.commit();
		closeConnection();
		return pojo;
	}

	public CustomerPojo searchCustomer(int id) {
		openConnection();
		transaction.begin();
		CustomerPojo pojo=manager.find(CustomerPojo.class, id);
		transaction.commit();
		closeConnection();
		return pojo;
		
	}

	public List<CustomerPojo> searchAllCustomer() {
		openConnection();
		transaction.begin();
		jpql="from CustomerPojo";
		query=manager.createQuery(jpql);
		List<CustomerPojo> customers=query.getResultList();
		transaction.commit();
		closeConnection();
		return customers;
	}

	public void removeCustomer(int id) {
	openConnection();
	transaction.begin();
	CustomerPojo pojo=manager.find(CustomerPojo.class, id);
	manager.remove(pojo);
	transaction.commit();
	closeConnection();
	
	}

	public void updateCustData(int id, String name, String email, long contact, String address) {
		
		openConnection();
		transaction.begin();
		CustomerPojo customer=manager.find(CustomerPojo.class, id);
		customer.setName(name);
		customer.setEmail(email);
		customer.setContact(contact);
		customer.setAddress(address);
		manager.persist(customer);
		transaction.commit();
		closeConnection();
		
		}

	

}
