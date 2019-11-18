package com.revature;

import java.util.List;

import com.revature.model.User;
import com.revature.scanner.Prompt;
import com.revature.service.UserService;

public class Driver {

	public static void main(String[] args) {
		
		// Creates a new prompt and calls welcomeMsg which then calls other functions depending on the user's choices.
		Prompt p = new Prompt();
		p.welcomeMsg();
		
		// USED TO CREATE A TABLE			(ONLY USED ONCE)
//		UserService us = new UserService();
//		us.createUserTable();
		
		// USED TO CHECK THE USERS TABLE.	(ONLY USED FOR TESTING)
//		List<User> userTable = us.getUserTable();
//		for (User u : userTable) {
//			System.out.println(u);
//		}
		
	}
}
