package com.revature.scanner;

import java.util.Scanner;

import com.revature.model.Client;
import com.revature.service.ClientService;

public class ClientOptions {

	
	Scanner sc = new Scanner(System.in); // Used to read client input in from console
	ClientService cs = new ClientService(); // Used to call methods for C.R.U.D. operations
	
	public ClientOptions() {
		super();
	}
	
	
	// withdrawal function
	void withdraw(Client c) {
		
		System.out.println("\n How much money would you like to withdraw today?");
		
		 double withdrawalAmt =sc.nextDouble(); // gets withdrawal amount input by client
		
		
		// validates input to make sure client does not enter a negative value
		while(withdrawalAmt < 0) {
			System.out.println("\n You can't withdraw negative money, silly!");
			System.out.println("\n \n How much money would you like to withdraw today?");
			withdrawalAmt = sc.nextDouble();
		}	
			
		// creates a new variable to hold the new balance after the withdrawal
		double postWithdrawalBalance = c.getClientBalance() - withdrawalAmt;
		
		
		
		// validates new balance
		// if the client's new balance after the withdrawal is negative it means
		// the withdrawal amount was larger than their original balance
		while(postWithdrawalBalance < 0) {
			System.out.println("\n Insufficient Funds!");
			System.out.println("\n \n How much money would you like to withdraw today?");
			withdrawalAmt = sc.nextDouble();
			
			
			postWithdrawalBalance = c.getClientBalance()- withdrawalAmt;
			
		}
		
		
		cs.updateClient(c.getUsername(), postWithdrawalBalance); // updates the client's balance with the new balance
		System.out.println("\n\t Withdrawal Successful!"); // prints message to let client know that their withdrawal was successful
	
		
	}
	
	
	// deposit function
	void deposit(Client c) {
		
		System.out.println("\n How much money would you like to deposit today?");
		
		double depositAmt =sc.nextDouble(); // gets the deposit amount input by client
		
		
		double postDepositBalance = c.getClientBalance() + depositAmt;
		
		// validates input to make sure client does not enter a negative value
		while(depositAmt < 0) {
				System.out.println("\n You can't deposit negative money, silly!");
				System.out.println("\n \n How much money would you like to deposit today?");
				depositAmt = sc.nextDouble();
			}	
		
		cs.updateClient(c.getUsername(), postDepositBalance); // updates the client's balance with the new balance
		System.out.println("\n\t Deposit Successful!"); // prints message to let client know that their deposit was successful
		
	}
	
	
	
	
	
	
	
}
