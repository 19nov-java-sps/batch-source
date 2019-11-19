package com.revature;

import java.sql.SQLException;
import java.util.List;

import com.revature.model.Account;
import com.revature.model.User;
import com.revature.service.AccountService;
import com.revature.service.UserService;
import com.revature.util.ConnectionUtil;

public class Driver {

	public static void main(String[] args) throws SQLException {
		
		
		// testing connection
		String driverName = ConnectionUtil.getConnection().getMetaData().getDriverName();
		System.out.println(driverName);
		
		// testing getAccount method
		/*
		AccountService as = new AccountService();
		List<Account> accounts = as.getAccount();
		for(Account a: accounts) {
			System.out.println(a);
		}
		*/
		
		// testing getUser method
		/*
		UserService us = new UserService(); 
		List<User> users = us.getUsers();
		for(User u: users) {
			System.out.println(u);
		}
		*/
		
		// testing create user method
		
		UserService us = new UserService(); 
		
		User newUser = new User();
		newUser.setFirstName("James");;
		newUser.setLastName("Bond");
		newUser.setUserName("spy");
		newUser.setPassWord("007");
		newUser.setEmail("007@bond.com");
		boolean success = us.createUser(newUser);
		System.out.println("success? :" + success);
		
	}
}
		



