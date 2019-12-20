package com.revature.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.Account;

@RestController
@RequestMapping("/accounts")
public class AccountController {
	
	private Logger log = Logger.getLogger(AccountController.class);
	
	private List<Account> accounts = new ArrayList<>();
	
	public AccountController() {
		accounts.add(new Account(1,7824.23,1));
		accounts.add(new Account(2,478.12,1));
		accounts.add(new Account(3,481.67,2));
		accounts.add(new Account(4,83.92,2));
		accounts.add(new Account(5,9373.08,2));
		accounts.add(new Account(6,37843.29,3));
	}
			
	@GetMapping
	public List<Account> getAllAccounts(){
		log.info("GET /accounts - getting all accounts");
		return new ArrayList<>(accounts);
	}

	@GetMapping("/{accountId}")
	public Account getAccountById(@PathVariable("accountId")int accountId) {
		log.info("GET /accounts/{id} - getting account with id: "+accountId);
		Account a = null;
		for(Account account: accounts) {
			if(account.getAccountId()==accountId) {
				a = account;
			}
		}
		return a;
	}
	
	@GetMapping("/customer/{customerId}")
	public List<Account> getAccountsByCustomerId(@PathVariable("customerId")int customerId){
		log.info("GET /accounts/customer/{id} - getting account with customer id: "+customerId);
		return accounts.stream().filter(acct->acct.getCustomerId() == customerId).collect(Collectors.toList());
	}
	
}
