//package com.revature;
//
//import java.util.Scanner;
//
//import com.revature.dao.impl.UserDaoImpl;
//import com.revature.model.User;
//import com.revature.service.BankAccountService;
//import com.revature.service.UserService;
//
//public class CommandView {
//
//	// our 2 service layers to connect with our CommandView
//	BankAccountService bs = new BankAccountService();
//	UserService us = new UserService();
//
//	Scanner scanner = new Scanner(System.in);
//
//	public void begin() {
//		// initialize scanner obj
//
//
//
//		// set local input var
//		String usernameInputString;
//		String passwordInputString;
//		String firstNameInputString;
//		String lastNameInputString;
//
//		User newUser;
//		int randomNumber;
//	
//		
//
//		
//		
//
//		System.out.println("Welcome to Ryan's Banking App");
//
//		// asking them to log in or create account
//
//		System.out.println("Do you have an account with us?");
//		System.out.println("Enter 1 for yes");
//		int ans = scanner.nextInt();
//
//		
//		if (ans == 1) {
//			System.out.println("Enter your username?");
//			usernameInputString = scanner.nextLine();
//			
//			System.out.println("Enter your password");
//			passwordInputString = scanner.nextLine();
//
//			System.out.print(usernameInputString + " " + passwordInputString);
//			
//			// user.verify(user u, connection c )
//		} else {
//			
//			System.out.println("Let's create an account");
//			System.out.println("Enter your username?");
//			usernameInputString = scanner.nextLine();
//			System.out.println("Enter your password");
//			passwordInputString = scanner.nextLine();
//			System.out.println("Enter your first name");
//			firstNameInputString = scanner.nextLine();
//			System.out.println("Enter your last name");
//			lastNameInputString = scanner.nextLine();
//			newUser = new User(usernameInputString, 10, passwordInputString);
//			
//			System.out.print(newUser);
//			
//			
//		}
//
////		Switch (ans) {
////		case 1:
////			
////		
////		
////	}
//	}
//
//}
