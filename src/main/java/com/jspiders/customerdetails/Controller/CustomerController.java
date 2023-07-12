package com.jspiders.customerdetails.Controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.jspiders.customerdetails.Repository.Pojo.AdminPojo;
import com.jspiders.customerdetails.Repository.Pojo.CustomerPojo;
import com.jspiders.customerdetails.Service.AdminService;
import com.jspiders.customerdetails.Service.CustomerService;

@Controller
public class CustomerController {

@Autowired	
private CustomerService service;

@Autowired
private AdminService adminService;

//Home controller
@GetMapping("/home")
public String home(@SessionAttribute(name="login",required = false) AdminPojo login,ModelMap map) {
	if(login!=null) {
		return "Home";
	}
	map.addAttribute("msg", "Please login to proceed..!!");
	return "Login";
}

//add page controller
@GetMapping("/add")
public String add(@SessionAttribute(name="login",required = false) AdminPojo login,ModelMap map) {
	if(login!=null) {
		return "Add";
	}
	map.addAttribute("msg", "Please login to proceed..!!");
	return "Login";
}
//add data controller
@PostMapping("/add")
public String addCustomer(@SessionAttribute(name="login", required = false) AdminPojo login,
		@RequestParam String name, @RequestParam String email, 
		@RequestParam long contact, @RequestParam String address, ModelMap map) {
	if(login!=null) {
		CustomerPojo pojo=service.addCustomer(name,email,contact,address);
		if(pojo!=null) {
			//success response
			map.addAttribute("msg", "Data added successfully..!!");
			return "Add";
		}
		//failure response
		map.addAttribute("msg","Data not added..!!");
		return "Add";
	}
	map.addAttribute("msg", "Please login to proceed..!!");
	return "Login";
	
}

//search page controller
@GetMapping("/search")
public String searchPage(@SessionAttribute(name="login", required = false) AdminPojo login, ModelMap map) {
if(login!=null) {
	return "Search";
}
map.addAttribute("msg","Please login to proceed..!!");
return "Login";
	
}
//search data controller

@PostMapping("/search")
public String searchCustomer(@SessionAttribute(name="login", required = false) AdminPojo login,@RequestParam int id, ModelMap map) {
	if(login!=null) {
		CustomerPojo pojo=service.searchCust(id);
		if(pojo!=null) {
			//success response
			map.addAttribute("msg", "Data found succe,ssfully..!!" );
			map.addAttribute("data", pojo);
			return "Search";
		}
		//failure response
		map.addAttribute("msg", "Data not found..!!");
		return "Search";
	}
	map.addAttribute("msg", "Please login to proceed..!!");
	return "Login";
}

@GetMapping("/remove")
public String removePage(@SessionAttribute(name="login",required = false) AdminPojo login,  ModelMap map) {
	if(login!=null) {
		List<CustomerPojo> customers=service.getAllCustomers();
		map.addAttribute("list", customers);
		
		return "Remove";
	}
	map.addAttribute("msg", "Please login to proceed..!!");
	return "Login";
}

@PostMapping("/remove")
public String removeData(@SessionAttribute(name="login", required = false)AdminPojo login, @RequestParam int id,ModelMap map) {
	if(login!=null) {
		CustomerPojo pojo=service.searchCust(id);
		if(pojo != null) {
			//success response
			service.removeCustomerId(id);
			List<CustomerPojo> customers=service.getAllCustomers();
			map.addAttribute("msg","Data removed successfully..!!");
			map.addAttribute("list", customers);
			return "Remove";
		}
		//failure response
		map.addAttribute("msg", "Data not removed..!!");
		return "Remove";
	}
	map.addAttribute("msg", "Please to login to proceed..!!");
	return "Login";
}
//get update page
@GetMapping("/update")
public String updatePage(@SessionAttribute(name="login", required = false)AdminPojo login,ModelMap map) {
	if(login!=null) {
		return "Update";
	}
	map.addAttribute("msg", "Please login to proceed..!!");
	return "Login";
}
//Update form controller
@PostMapping("/update")
public String updateForm(@SessionAttribute(name="login", required = false) AdminPojo login, @RequestParam int id, ModelMap map) {
  if(login!=null) {
	  CustomerPojo customer=service.searchCust(id);
	  if(customer!=null) {
		  
		  //success response
		  map.addAttribute("cust", customer);
		  return "Update";
	  }
	  //failure response
	  map.addAttribute("msg", "Customer data not found");
	  List<CustomerPojo> customers=service.getAllCustomers();
	  map.addAttribute("list", customers);
		return "Update";
  }
  map.addAttribute("msg", "Please login to proceed..!!");
  return "Login";
}
//update data controller
@PostMapping("/updateData")
public String updateData(@SessionAttribute(name="login", required = false) AdminPojo login, @RequestParam int id, @RequestParam String name, @RequestParam String email,
		                 @RequestParam long contact, @RequestParam String address, ModelMap map) {
	if(login!=null) {
		CustomerPojo customer=service.searchCust(id);
		if(customer != null) {
			//success response
			service.updateCustomer(id, name, email, contact, address);
			map.addAttribute("msg", "Customer data updated successfully..!!");
			List<CustomerPojo> customers=service.getAllCustomers();
			map.addAttribute("list", customers);
			return "Update";
			
		}
		//failure response
		map.addAttribute("msg","Customer data not updated..!!");
		return "Update";
	}
	map.addAttribute("msg", "Please login to proceed..!!");
	return "Login";
	
}
//admin controller
@GetMapping("/create")
public String adminPage() {
	return "Admin";
}

@PostMapping("/create")
public String createAdmin(@RequestParam String username, @RequestParam String password, ModelMap map) {
	AdminPojo admin=adminService.addAdmin(username,password);
	if(admin!=null) {
		//success response
		map.addAttribute("msg", "Account created successfully..!!");
		return "Login";
	}
	//failure response
	map.addAttribute("msg", "Account not created..!!");
	return "Login";
	}
//login controller
@PostMapping("/login")
public String login(@RequestParam String username, @RequestParam String password,ModelMap map, HttpServletRequest request) {
	AdminPojo admin=adminService.login(username,password);
	if(admin!=null) {
		//success response
		HttpSession session=request.getSession();
		session.setAttribute("login", admin);
		return "Home";
	}
	//failure response
	map.addAttribute("msg", "Invalid username or password..!!");
	return "Login";
}

@GetMapping("/login")
public String getLoginPage() {
	return "Login";
}
@GetMapping("/logout")
public String logout(HttpSession session, ModelMap map) {
	map.addAttribute("msg", "Logged out successfully..!!");
	session.invalidate();
	return "Login";
}











}
