package com.revature.controllers;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.intercom.AccountClient;
import com.revature.models.Account;
import com.revature.models.Customer;

@RestController
@RequestMapping("/customers")
public class CustomerController {
	
	private Logger log = Logger.getLogger(CustomerController.class);
	
	@Autowired
	private AccountClient accountClient;
	
	private List<Customer> customers = new ArrayList<>();
	
	public CustomerController() {
		customers.add(new Customer(1,"Sally Jenkins", "sjenkins37@gmail.com"));
		customers.add(new Customer(2,"Peter Smith", "pjsmith800@gmail.com"));
		customers.add(new Customer(3,"Thomas Crowley", "tcrowls@gmail.com"));
		customers.add(new Customer(4,"Bertrand Russel", "brussel@gmail.com"));
	}
	
	
	@GetMapping
	public List<Customer> getAllCustomers(){
		log.info("GET /customers - getting all customers");
		return new ArrayList<>(customers);
	}

	@GetMapping("/{customerId}")
	public Customer getCustomerById(@PathVariable("customerId")int customerId) {
		log.info("GET /customers/{id} - getting customer with id: " + customerId);
		Customer customer = null;
		for(Customer c: customers) {
			if(c.getCustomerId() == customerId) {
				customer = c;
				List<Account> customerAccounts = accountClient.getAccountByCustomerId(customerId);
				customer.setAccounts(customerAccounts);
			}
		}
		return customer;
	}
}
