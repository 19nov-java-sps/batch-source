package com.revature.scanner;

import java.util.List;
import java.util.Scanner;

import com.revature.model.User;
import com.revature.service.UserService;

public class UserActions {
	
	Scanner sc = new Scanner(System.in);	// Used to read input from console.
	UserService us = new UserService();		// Used to call various methods for CRUD operations.
	
	public UserActions() {
		super();
	}

	
	// Deposit function
	void deposit(User u) {
		
		System.out.println("\nHow much do you want to deposit?");
		double depositAmount = sc.nextDouble();
		
		
		// checks for negative values.
		while (depositAmount < 0) {
			System.out.println("\nNegative values are not allowed!");
			System.out.println("\n\nHow much do you want to deposit?");
			depositAmount = sc.nextDouble();
		}
		
		
		// stores the new balance by adding the deposit to the existing balance.
		double newBalanceDep = depositAmount + u.getBalance();
		
		
		us.updateUser(u.getUsername(), newBalanceDep);
		System.out.println("\n\tDeposit Successful!"); // message to show that the deposit went through.
	}
	
	
	// Withdraw function
	void withdraw(User u) {
		
		System.out.println("\nHow much do you want to withdraw?");
		double withdrawAmount = sc.nextDouble();
		
		
		// checks if the input is negative.
		while (withdrawAmount < 0) {
			System.out.println("\nNegative values are not allowed!");
			System.out.println("\n\nHow much do you want to withdraw?");
			withdrawAmount = sc.nextDouble();
		}
		
		
		// stores the new balance by subtracting the withdraw amount from the current balance.
		double newBalanceWit = u.getBalance() - withdrawAmount;
		
		
		// if it is negative that means the withdraw amount was larger than balance.
		while (newBalanceWit < 0) {	
			
			System.out.println("\nYou dont have enough funds!");
			System.out.println("\n\nHow much do you want to withdraw? ");
			withdrawAmount = sc.nextDouble();
			newBalanceWit = u.getBalance() - withdrawAmount;
			
		}
		
		us.updateUser(u.getUsername(), newBalanceWit);	// updates the user balance.
		System.out.println("\n\tWithdraw Successful!");	// message to show that the withdraw went through.
	}
	
	
	// transfer to a user function.
	void transfer(User usr1) {
		
		System.out.println("\nWho do you want to transfer to?");
		
		// Shows a list of the users you can transfer money to.
		System.out.println("\n\nUsers");
		System.out.println("--------");
		List<User> userTable = us.getUserTable();
		for (User u : userTable) {
			// doesn't display the username of the person that is transferring.
			if (u.getUsername().equals(usr1.getUsername())) {
				continue;
			}
			System.out.println(u.getUsername());
		}
		
		String user = sc.next().toLowerCase();
		
		// checks if the username exists or if the user is trying to transfer to itself.
		while (us.getUser(user).getUsername() == null || user.equals(usr1.getUsername())) {
			System.out.println("\nThat username doesnt exist or you entered your username!");
			System.out.println("\nWho do you want to transfer to?");
			user = sc.next();
		}
		
		
		// creates a new User by calling the getUser method with the username that was entered.
		User usr2 = us.getUser(user);
		
		System.out.println("\nHow much?");
		double transferAmount = sc.nextDouble();
		
		
		// Checks if the user has enough funds to transfer.
		while (usr1.getBalance() - transferAmount < 0) {
			System.out.println("\nYou dont have enough funds!");
			System.out.println("\nHow much?");
			transferAmount = sc.nextDouble();
		}
		
		
		// updates both users.
		us.updateUser(usr1.getUsername(), usr1.getBalance() - transferAmount);
		us.updateUser(usr2.getUsername(), usr2.getBalance() + transferAmount);
		
		// Confirms that the transfer worked.
		System.out.println("\n\tTransfer Successful!");
	}
}
