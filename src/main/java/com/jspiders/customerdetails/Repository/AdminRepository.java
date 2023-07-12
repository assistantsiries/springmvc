package com.jspiders.customerdetails.Repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.jspiders.customerdetails.Repository.Pojo.AdminPojo;

@Repository
public class AdminRepository {
	
	private static EntityManagerFactory factory;
	private static EntityManager manager;
	private static EntityTransaction transaction;
	private static String jpql;
	private static Query query;
	
	public static void openConnection() {
		factory=Persistence.createEntityManagerFactory("customer");
		manager=factory.createEntityManager();
		transaction=manager.getTransaction();
	}
	public static void closeConnection() {
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

	public AdminPojo addAllAdmin(String username, String password) {
		openConnection();
		transaction.begin();
		AdminPojo admin=new AdminPojo();
		admin.setUsername(username);
		admin.setPassword(password);
		manager.persist(admin);
		transaction.commit();
		closeConnection();
		
	
		return admin;
	}
	public AdminPojo loginUser(String username, String password) {
		openConnection();
		transaction.begin();
		jpql= "from AdminPojo "
				          + "where username = '" + username + "' "
				          + "and password = '" + password + "' ";
		query=manager.createQuery(jpql);
		List<AdminPojo> list=query.getResultList();
		for(AdminPojo admin : list) {
			transaction.commit();
			closeConnection();
			return admin;
		}
		return null;
	}

}
