package com.commandview;

import java.util.Scanner;

import javax.xml.stream.events.Characters;

import com.dao.CustomerDao;
import com.daoimpl.CustomerDaoImpl;
import com.model.Customer;
import com.servicelayer.CustomerService;

public class CommandView {

	Scanner sc = new Scanner(System.in);
	CustomerService cs = new CustomerService();
	private int input;

	public void startMenu() {
		System.out.println("\t Welcome to DankBank!");
		System.out.println("====================================");
		System.out.println("\t Sign in: 1");
		System.out.println("\t Create account: 2");
		System.out.println("\t Quit: 3");

		int input = sc.nextInt();

		switch (input) {

		// sign into your dank account
		case 1:
			signInView();
			break;

		// create a dank account
		case 2:
			createAccountView();
			break;

		// exit menu
		case 3:
			System.out.println("Thank you for visting Dank Bank.");
			break;

		// checks for invalid values
		default:
			System.out.println("Invalid input. Try again. \n");
			startMenu();
		}
	}

	private void signInView() {
		Customer customer = new Customer();
		System.out.println("Welcome to the sign in menu!");
		System.out.println("Enter your username to sign in or enter 'quit' to return to main menu.");
		String username = sc.next();

		if (username.equals("quit")) {
			startMenu();
		}

		System.out.println("Enter your password ");
		String password = sc.next();

		Customer validatedCustomer = cs.getUserPass(username.toLowerCase());
		if (validatedCustomer.getUserName() != null && username.equals(validatedCustomer.getUserName())
				&& password.equals(validatedCustomer.getPassWord())) {
			activeUserView(validatedCustomer);
		} else {
			System.out.println("You entered an incorrect username and/or password. Try again.");
			signInView();

		}
	}

	private void activeUserView(Customer validatedCustomer) {
//		CustomerDaoImpl cdi = new CustomerDaoImpl();

		System.out.println("\t Welcome to your account.");
		System.out.println("========================================");
		System.out.println("\t View account balance: 1");
		System.out.println("\t Deposit from balance: 2");
		System.out.println("\t Withdraw from balance: 3");
		System.out.println("\t Sign out: 4");
		System.out.println("\t Remove your account: 5");
		int input = sc.nextInt();

		switch (input) {

		case 1:
			System.out.println("Your account balance is: " + validatedCustomer.getBalance());
			activeUserView(validatedCustomer);
			break;

		case 2:
			System.out.println("How much would you like to deposit?");
			double depositAmount = sc.nextDouble();
			if (depositAmount >= 0) {

				cs.deposit(validatedCustomer, depositAmount);

				Customer afterDeposit = cs.getCustomerId(validatedCustomer.getCustomerId());
				System.out.println("Your new balance is " + afterDeposit.getBalance());
				activeUserView(validatedCustomer);
			} else {
				System.out.println("Please enter an amount greater than 0");
				activeUserView(validatedCustomer);
			}
			break;

		case 3:
			System.out.println("How much would you like to withdraw?");
			double withdrawAmount = sc.nextDouble();
			double checksForEnoughFunds = validatedCustomer.getBalance() - withdrawAmount;
			if (checksForEnoughFunds >= 0) {
				cs.withdraw(validatedCustomer, withdrawAmount);

				Customer afterWithdraw = cs.getCustomerId(validatedCustomer.getCustomerId());
				System.out.println("Your new balance is " + afterWithdraw.getBalance());
				activeUserView(validatedCustomer);
			} else {
				if (checksForEnoughFunds < 0) {
					System.out.println("Insufficient funds in your account. Try again.");
					activeUserView(validatedCustomer);
					;
				}

			}
			break;

		case 4:
			System.out.println("Thank you for being a customer of Dank Bank, take care.");
//			System.exit(0);
			startMenu();

		case 5:
			System.out.println("We are sorry that you no longer wish to have an account with us.");
			startMenu();
			// need to add delete account functionality

		default:
			System.out.println("Invalid input. Try again. \n");
			startMenu();

		}
	}

	/*if user wants to create an account this method is invoked
	 * the method checks if user name and password meet the minimum and maximum character range
	 * once user creates account it invokes the start up menu
	*/
	private void createAccountView() {
		Customer newAccount = new Customer();
		CustomerDao cd = new CustomerDaoImpl();
		System.out.println("Signing up with Dank Bank is a great choice!");
		System.out.println("Enter your new username or enter 'quit' to return to main menu.");
		String username = sc.next().toLowerCase();

		if (username.equals("quit")) {
			startMenu();
		}

		if (username.length() < 4 || username.length() > 20) {
			System.out.println("Username must contain characters between 4 and 20. Try again. \n");
			createAccountView();
		}

		System.out.println("Enter your new password");
		String password = sc.next();

		if (password.length() < 4 || username.length() > 20) {
			System.out.println("Password must contain characters between 4 and 20. Try again. \n");
			createAccountView();

		}

		System.out.println("Enter you first name");
		String firstname = sc.next();
		System.out.println("Enter your last name");
		String lastname = sc.next();

		// I added an auto-generated account id that increments a newly created account
		// by 1 and has a range between 0 and 1000
		cd.generateCustomerId();
		newAccount.setUserName(username);
		newAccount.setPassWord(password);
		newAccount.setFirstName(firstname);
		newAccount.setLastName(lastname);
		boolean finishedAccount = cs.createCustomer(newAccount);
		System.out.println("New bank account created: " + finishedAccount);
		signInView();
	}

}
