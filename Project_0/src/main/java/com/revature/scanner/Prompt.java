package com.revature.scanner;

import java.util.Scanner;

import com.revature.model.User;
import com.revature.service.UserService;

public class Prompt {
	
	Scanner sc = new Scanner(System.in);	// Used to read in console input.
	UserService us = new UserService();		// Used to call various methods for CRUD operations.
	
	public Prompt() {
		super();
	}
	
	// This is the function that gets invoked in the Driver class.
	public void welcomeMsg() {
		System.out.println("Welcome!\nWhat would you like to do?\n\n1.Create new user\n\n2.Log in\n\n3.Quit");
		
		int answer = sc.nextInt();
				
		switch (answer) {
		
		// CREATE NEW USER
		case 1:
			createUsrMsg();
			
			break;
			
		// LOG IN
		case 2:
			logInMsg();
			
			break;
			
		// QUIT
		case 3:
			System.out.println("\nHave A Nice Day!");
			System.exit(0);
			
			break;
		}
	}
	
	// This function is invoked when the user wants to create a new account.
	private void createUsrMsg() {
		
		User newUser = new User();
		
		System.out.println("Create a username: ");
		String username = sc.next();
		
		while (us.getUser(username.toLowerCase()).getUsername() != null) {
			System.out.println("\nusername taken!");
			System.out.println("\n\nCreate a username: ");
			username = sc.next();
		}
		
		System.out.println("Create a password: ");
		String password = sc.next();
		
		System.out.println("Enter your first name: ");
		String firstName = sc.next();
		
		System.out.println("Enter your last name: ");
		String lastName = sc.next();
		
		newUser.setUsername(username.toLowerCase());	// use toLowerCase to not have similar user names that only vary with capital letters.
		newUser.setPassword(password);
		newUser.setFirstName(firstName);
		newUser.setLastName(lastName);
		newUser.setBalance(0);
			
		String result = us.createUser(newUser);
		System.out.println(result);
		
		logInMsg();	// After the user is created, it takes the user to the log in "page".
	}
	
	// This function is invoked when the user wants to log in or if the user recently created an account.
	// This function is the log in "page" where it then validates them and invokes the loggedInMsg function.
	private void logInMsg() {
		System.out.println("\nLog In\n");
		
		System.out.println("Enter your username: ");
		String username = sc.next();
		
		System.out.println("\nEnter your password: ");
		String password = sc.next();
		
		User u = us.getUser(username);
				
		if (u.getUsername() != null && password.equals(u.getPassword())) {
			loggedInMsg(u);
		} else {
			System.out.println("Wrong username or password");
			logInMsg();	// calls itself again if the username / password is wrong.
		}
		
	}
	
	// This function is called after the username and password is validated.
	// This function shows choices to the user like deposit withdraw etc.
	// After the user decides to log out, the welcomeMsg function gets invoked again.
	private void loggedInMsg(User u) {
		
		System.out.println("\nWelcome " + u.getFirstName() + " " + u.getLastName() + ".");
		System.out.println("\nWhat would you like to do today?\n\n1.View Balance\n\n2.Deposit\n\n3.Withdraw\n\n4.Log out\n\n5.Delete account");
		
		int answer = sc.nextInt();
		
		while (answer != -1) {	// This -1 is never used, since we have a log out option, but I needed to put this switch in a loop.
			
			switch (answer) {
			// VIEW BALANCE
			case 1:
				
				System.out.println("Your balance is: $" + u.getBalance());
				break;
				
			// DEPOSIT
			case 2:
				
				deposit(u);
				u = us.getUser(u.getUsername());
				break;
				
			// WITHDRAW
			case 3:
				
				withdraw(u);
				u = us.getUser(u.getUsername());				
				break;
				
			// LOG OUT
			case 4:
				
				System.out.println("Logging out\n");
				welcomeMsg();	// after logging out it goes back to the welcome message prompt.
				break;
				
			// DELETE USER
			case 5:
				
				// checks if the user still has funds in their account before deleting.
				if (u.getBalance() > 0) {	
					System.out.println("Please withdraw all funds before deleting account!");
				} else {
					us.deleteUser(u.getUsername());
					System.out.println("User deleted!\n");
					welcomeMsg();	// After deleting the account it goes back to the welcome message prompt.
				}
				break;
			}
			
			System.out.println("\nWhat else would you like to do?");
			answer = sc.nextInt();	// After the switch statement, the user can choose another option.
		}
		
	}
	
	// Deposit function
	private void deposit(User u) {
		
		System.out.println("How much do you want to deposit? ");
		double depositAmount = sc.nextDouble();
		
		
		while (depositAmount < 0) {
			System.out.println("Negative values are not allowed!");
			System.out.println("\nHow much do you want to deposit? ");
			depositAmount = sc.nextDouble();
		}
		
		
		double newBalanceDep = depositAmount + u.getBalance();
		
		
		us.updateUser(u.getUsername(), newBalanceDep);
		System.out.println("Deposit Successful!");
	}
	
	// Withdraw function
	private void withdraw(User u) {
		
		System.out.println("How much do you want to withdraw? ");
		double withdrawAmount = sc.nextDouble();
		
		
		while (withdrawAmount < 0) {
			System.out.println("Negative values are not allowed!");
			System.out.println("\n\nHow much do you want to withdraw? ");
			withdrawAmount = sc.nextDouble();
		}
		
		
		double newBalanceWit = u.getBalance() - withdrawAmount;	// new balance after withdrawing.
		
		
		// if it is negative that means the withdraw amount was larger than balance.
		while (newBalanceWit < 0) {	
			System.out.println("You dont have enough funds!");
			System.out.println("\n\nHow much do you want to withdraw? ");
			withdrawAmount = sc.nextDouble();
			newBalanceWit = u.getBalance() - withdrawAmount;
		}
		
		
		us.updateUser(u.getUsername(), newBalanceWit);	// updates the user balance.
		System.out.println("Withdraw Successful!");
	}
	
}
