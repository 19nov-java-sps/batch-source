package com.revature;

import java.sql.SQLException;
import java.util.List;

import com.revature.model.Account;
import com.revature.model.User;
import com.revature.service.AccountService;
import com.revature.service.UserService;
import com.revature.userAPI.UserInteraction;
import com.revature.util.ConnectionUtil;

public class Driver {

	public static void main(String[] args) throws SQLException {
				
		
		UserInteraction.mainMenu();
		
		
		
		//*****************************************************************************************
		//ALL CODE BELLOW IS TETS CODE FOR MY FUNCTIONS
		
		// testing connection
		/*
		String driverName = ConnectionUtil.getConnection().getMetaData().getDriverName();
		System.out.println(driverName);
		*/
		
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
		AccountService us = new AccountService(); 
		Account newAccount = new Account();
		newAccount.setType("secondary");
		newAccount.setBalance(0);
		newAccount.setUserId(5);
		boolean success = us.createAccount(newAccount);
		System.out.println("success? :" + success);
		 */
					
		// testing create user method
		/*
		UserService us = new UserService(); 
		User newUser = new User();
		newUser.setFirstName("James");;
		newUser.setLastName("Bond");
		newUser.setUserName("spy");
		newUser.setPassWord("007");
		newUser.setEmail("007@bond.com");
		boolean success = us.createUser(newUser);
		System.out.println("success? :" + success);
		*/
	
		//testing getUserById
		/*
		UserService us = new UserService();
		User myUser = us.getUserById(1);
		System.out.println(myUser);
		*/
		
		//testing checkBalance method
		/*
		AccountService as = new AccountService();
		System.out.println(as.checkBalance(1));
		as.addMoney(1, 20.00);
		System.out.println(as.checkBalance(1));
		as.withdrowMoney(1, 25);
		System.out.println(as.checkBalance(1));
		as.withdrowMoney(1, 40);
		System.out.println(as.checkBalance(1));
		*/
		
		//UserInteraction.mainMenue();
		
		
		//UserService us = new UserService();
		//System.out.println(us.checkUserUniqueness("user21"));
				
		/*
		UserService us = new UserService();
		System.out.println(us.UserVerification("user","pass"));.
		*/
		/*
		UserInteraction ui = new UserInteraction();
		System.out.println(ui.userAuthentification());
		*/
}
		

}


		



