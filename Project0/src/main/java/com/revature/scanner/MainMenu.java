package com.revature.scanner;

import java.util.Scanner;

import com.revature.model.Client;
import com.revature.service.ClientService;

public class MainMenu {

	
	Scanner sc = new Scanner(System.in); // Used to read client input in from console
	ClientService cs = new ClientService(); // Used to call methods for C.R.U.D. operations
	ClientOptions co = new ClientOptions(); // Used to call the methods withdraw and deposit
	
	public MainMenu() {
		super();
	}
	
	
	// The Driver class invokes this function to print the Main Menu
	public void mainMenuMsg() {
		System.out.println("\t WELCOME TO REVATURE BANK");
		System.out.println("******************************************");
		System.out.println("\n Choose a transaction: \n\n 1. Create new client \n\n 2. Log in \n\n 3. Quit \n\n");
		
		String choice = sc.next();	
		
		switch (choice) {	
		
		// takes client to new client screen
		case "1":
			createClientMsg();
			
			break;
			
		// takes client to log in screen
		case "2":
			logInMsg();
			
			break;
			
		// quits the application
		case "3":
			System.out.println("\n\t Have A Nice Day!");
			System.exit(0); // quits application
			
			break;
			
		// if the client inputs anything other than 1, 2 or 3 then 
		//this message prints to the screen and it takes the client back to the main menu via recursion
		default:
			System.out.println("Invalid option! Please try again! \n\n");
			mainMenuMsg();
			
			break;
		}
	}
	
	
	
	// This method is invoked when the client wants to create a new account
		private void createClientMsg() {
			
			Client newClient = new Client();
			
			// prompts user to create a new username but 
			// also gives user the option to go back to the main menu
			System.out.println("Create a username (Enter 'back' to go back): ");
			String username = sc.next().toLowerCase(); // toLowerCase avoids redundancy by eliminating similar usernames with letter capitalization
			
			if (username.equals("back")) {
				mainMenuMsg();
			}
			
			// validates if the username is less than 6 characters long
			while (username.length() < 6) {	
				System.out.println("\n Your username should be at least 6 characters long!");
				System.out.println("\n\n Create a username: ");
				username = sc.next().toLowerCase();
			}
			
			// validates whether or not a client with the same username already exists in the database
			while (cs.getClient(username).getUsername() != null) {
				System.out.println("\n We're sorry, that username has already been taken!");
				System.out.println("\tTry creating a different username...\n");
				System.out.println("\n\n Create a username: ");
				username = sc.next().toLowerCase();
			}
			
			// prompts the client to create a new password
			System.out.println("Create a password: ");
			String password = sc.next();
			
			// checks if the password is less than 10 characters long.
			while (password.length() < 10) { 
				System.out.println("\n A strong password should be atleast 10 characters long! Try again.");
				System.out.println("\n\n Create a password: ");
				password = sc.next();
			}
			
			// prompts the client to enter their first name
			System.out.println("Enter your first name: ");
			String firstName = sc.next();
			
			// prompts the client to enter their last name 
			System.out.println("Enter your last name: ");
			String lastName = sc.next();
			
			
			newClient.setUsername(username);
			newClient.setPassword(password);
			newClient.setFirstName(firstName);
			newClient.setLastName(lastName);
			newClient.setClientBalance(125);	// All new clients get $125 when they open a new account
				
			String result = cs.createClient(newClient);
			System.out.println(result);
			
			logInMsg();	// After a client account is created, it takes the client to the log in screen
		}
		
		// This method is invoked when a client wants to log in or if a just made a new account.
		// This method is the log in screen.
		// Here we validate the username/password and invoke the loggedInMsg function.
		private void logInMsg() {
			System.out.println("\n Log In (Enter 'back' to go back): \n");
			
			System.out.println("Enter your username: ");
			String username = sc.next();
			
			if (username.equals("back")) {	// gives the client the option to go back to the main menu
				mainMenuMsg();
			}
			
			System.out.println("\n Enter your password: ");
			String password = sc.next();
			
			Client c = cs.getClient(username.toLowerCase());
					
			if (c.getUsername() != null && password.equals(c.getPassword())) {
				loggedInMsg(c);
			} else {
				System.out.println("Your username or password was incorrect");
				logInMsg();	// this method take client to the log in screen again if the username or password was incorrect.
			}
			
		}

		// After a client's username and password have been validated
		// this method is called to give the client
		// the option to withdraw, deposit, delete their account or log out
		
		private void loggedInMsg(Client c) {
			
			System.out.println("\n\n Good Morning " + c.getFirstName() + " " + c.getLastName() + "!");
			System.out.println("\n Choose a transaction from the options below: \n\n 1. View Balance \n\n 2. Withdraw \n\n 3. Deposit \n\n 4. Log out \n\n 5. Delete account");
			
			String option = sc.next();
			
			while (option != null) {	
										
				switch (option) {
				
				// View Balance option
				case "1":
					
					System.out.println("\n Your balance is: $" + c.getClientBalance());
					break;
					
				// Withdraw option
				case "2":
					
					co.withdraw(c);
					c = cs.getClient(c.getUsername());
							
					break;
		
				// Deposit option
				case "3":
					
					co.deposit(c);
					c = cs.getClient(c.getUsername());
					
					break;
				// Log out option
				case "4":
					
					System.out.println("\n Logging out... \n");
					System.out.println("**********HAVE A GREAT DAY!********* \n\n");
					mainMenuMsg();	// when a client logs out, the application goes back to the main menu
					break;
					
					
				// Delete account option
				case "5":
					
					// checks if the client has funds in their account before deleting it
					if (c.getClientBalance() > 0) {	
						System.out.println("\n You gotta withdraw all your money before you delete your account, silly!");
					} else {
						
						cs.deleteClient(c.getUsername());
						System.out.println("\n Client account deleted! \n (You won't be missed) \n\n ");
						mainMenuMsg();	// When you delete an account, the application takes you back to the main menu
					
					}
					
					break;
				
				default:
					System.out.println("That isn't an option try again! \n\n");
					loggedInMsg(c);
				}
				
				System.out.println("\n Which transaction would you like to do next?");
				option = sc.next();	// Prompt will keep asking for input until the client chooses to log out
			}
			
		}
		

}
