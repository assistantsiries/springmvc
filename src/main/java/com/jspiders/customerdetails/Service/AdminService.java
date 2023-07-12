package com.jspiders.customerdetails.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jspiders.customerdetails.Repository.AdminRepository;
import com.jspiders.customerdetails.Repository.Pojo.AdminPojo;

@Service
public class AdminService {
	
	@Autowired
	private AdminRepository Adminrepository;
	
	public AdminPojo addAdmin(String username, String password) {
		AdminPojo admin=Adminrepository.addAllAdmin(username,password);
		return admin;
	}

	public AdminPojo login(String username, String password) {
		AdminPojo admin=Adminrepository.loginUser(username,password);
		return admin;
	}
	
	

}

	
