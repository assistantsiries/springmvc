package com.jspiders.customerdetails.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jspiders.customerdetails.Repository.CustomerRepository;
import com.jspiders.customerdetails.Repository.Pojo.AdminPojo;
import com.jspiders.customerdetails.Repository.Pojo.CustomerPojo;

@Service
public class CustomerService {
 
	@Autowired
	private CustomerRepository repository;

	public CustomerPojo addCustomer(String name, String email, long contact, String address) {
		CustomerPojo pojo=repository.addCust(name,email,contact,address);
		return pojo;
	}

	public CustomerPojo searchCust(int id) {
		CustomerPojo pojo=repository.searchCustomer(id);
		return pojo;
	}

	public List<CustomerPojo> getAllCustomers() {
		List<CustomerPojo> customers=repository.searchAllCustomer();
		
		return customers;
	}

	public void removeCustomerId(int id) {
		repository.removeCustomer(id);
		  
}

	public void updateCustomer(int id, String name, String email, long contact, String address) {
		repository.updateCustData(id,name,email,contact,address);
		
	}

	
	
}
