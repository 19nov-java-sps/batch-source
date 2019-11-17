package com.revature;

import com.revature.scanner.Prompt;
//import com.revature.service.UserService;

public class Driver {

	public static void main(String[] args) {
	
		//UserService us = new UserService();
		
		//us.createUserTable();		//Check how to not create it again later.
		
		// Creates a new prompt and calls welcomeMsg which then calls other functions depending on the user's choices.
		Prompt p = new Prompt();
		p.welcomeMsg();	
	}

}
