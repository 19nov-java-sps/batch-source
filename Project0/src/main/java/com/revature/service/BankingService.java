package com.revature.service;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.revature.Driver;
import com.revature.dao.TransactionDao;
import com.revature.dao.UserDao;
import com.revature.dao.impl.TransactionDaoImpl;
import com.revature.dao.impl.UserDaoImpl;
import com.revature.model.Transaction;
import com.revature.model.User;
import com.revature.util.ValidateInputUtil;

public class BankingService {
	
	private UserDao userDao = new UserDaoImpl();
	private TransactionDao transactionDao = new TransactionDaoImpl();
	
    private static Scanner sc = new Scanner(System.in);
    
    public void startService() {

    	if (Driver.getAccount() == null) {
	    	System.out.println("   Welcome to MyBank!   ");
	        System.out.println("========================");
	        System.out.println("Login------------------1");
	        System.out.println("Register---------------2");
    	} else {
    		System.out.println("   Welcome Back User!   ");
    		System.out.println("========================");
    		System.out.println("Account Information----3");
    		System.out.println("Update Account Info----4");
    		System.out.println("Transaction History----5");
    		System.out.println("Deposit----------------6");
    		System.out.println("Withdraw---------------7");
    		System.out.println("Transfer---------------8");
	        System.out.println("Logout-----------------9");
    	}
    	
    	
        int action = sc.nextInt();
        
        switch (action) {
		case 1:
			this.login();
			break;
			
		case 2:
			this.register();
			break;
			
		case 3:
			this.getUserAcc();
			break;
			
		case 4:
			this.updateAcc();
			break;
			
		case 5:
			this.viewTransHistory();
			break;
			
		case 6:
			this.deposit();
			break;
			
		case 7:
			this.withdraw();
			break;
			
		case 8:
			this.transfer();
			break;
			
		case 9:
			this.logout();
			break;

		default:
			this.startService();
			break;
		}

    }
    
	public void login() {
		
		if (Driver.getAccount() == null) {
			
			sc.nextLine();
			System.out.println("Username or Email: ");
			String userName = sc.nextLine();
			System.out.println("Password: ");
			String password = sc.nextLine();

			if (userDao.login(userName, password) == true) {
	    		System.out.println("Login Successful");
			} else {
		        System.out.println("Wrong User Name or Password. Please try again!");
			}
		} else {
			System.out.println("You already login.");
		}
		
		this.startService();
	}
	
	public void login(String user, String password) {
		
		boolean loginSuccess = userDao.login(user, password);
		
		if (loginSuccess == false) {

	        System.out.println("Wrong User Name or Password. Please try again!");
		}
		
		this.startService();
	}
	
	public void register() {
		
		if (Driver.getAccount() == null) {
			
			sc.nextLine();
			
			System.out.println("Enter Username (must between 5 to 12 characters)");
			String userName = sc.nextLine();
			
			System.out.println("Enter Password (must between 8 to 16 characters)");
			String password = sc.nextLine();
			
			System.out.println("Re-Enter Your Password");
			String rePass = sc.nextLine();
			
			System.out.println("Enter Your First Name");
			String firstName = sc.nextLine();
			
			System.out.println("Enter Your Last Name");
			String lastName = sc.nextLine();
			
			System.out.println("Enter Your Email");
			String email = sc.nextLine();
			
			System.out.println("Enter Your Phone Number");
			String phone = sc.nextLine().replaceAll("[^0-9]", "");
			
			if (ValidateInputUtil.validateInput(userName, password, rePass, firstName, lastName, email, phone) == false) {
				this.startService();
			}
			
			phone = phone.replaceFirst("(\\d{3})(\\d{3})(\\d+)", "($1) $2-$3");
			
			if (userDao.register(userName, password, firstName, lastName, email, phone) == 1) {
				this.login(userName, password);
			} else {
				this.startService();
			}
			
		} else {
			System.out.println("You Already Login.");
		}

		System.out.println("Register Successful!");
		this.startService();
	}
	
	public void logout() {
		
		userDao.logout();
		this.startService();
	}
	
	public void getUserAcc() {
		
		if (Driver.getAccount() == null) {
			System.out.println("Please Login First!");
			this.startService();
		} else {
			User u = userDao.getAccInfo(Driver.getAccount());
			System.out.println("Name: " + u.getFirstName() + " " + u.getLastName() + "\n");
			System.out.println("Email: " + u.getEmail() + "\n");
			System.out.println("Phone: " + u.getPhone() + "\n");
			System.out.println("Account Number: " + u.getAccountNum() + "\n");
			System.out.println("Current Balance: " + u.getBalance() + "\n");
			
			sc.nextLine();
			sc.nextLine();
			this.startService();
			
		}
	}
	
	public void updateAcc() {
		
		if (Driver.getAccount() == null) {
			System.out.println("Please Login First!");
			this.startService();
		}
		
		User u = userDao.getAccInfo(Driver.getAccount());
		sc.nextLine();		
		System.out.println("Enter Your Password (must between 8 to 16 characters)");
		String password = sc.nextLine();
		
		System.out.println("Re-Enter Your Password");
		String rePass = sc.nextLine();
		
		System.out.println("Enter Your Email");
		String email = sc.nextLine();
		
		System.out.println("Enter Your Phone Number");
		String phone = sc.nextLine().replaceAll("[^0-9]", "");
		
		if (ValidateInputUtil.validateInput(password, rePass, email, phone) == false) {
			this.startService();
		}
		
		if (userDao.UpdateAccInfo(u, password, email, phone) == 0) {
			this.startService();
		}
		
		System.out.println("Update Your Account Information Success!");
		this.startService();
	}
	
	public void viewTransHistory() {
		
		if (Driver.getAccount() == null) {
			System.out.println("Please Login First!");
			this.startService();
		} else {
			List<Transaction> transHistoy = transactionDao.getTransactionHistory(Driver.getAccount());
			
			if (transHistoy.size() > 0) {
				for (Transaction th: transHistoy) {
					if (th.getType().equals("Withdraw")) {
						System.out.println(th.getType() + " from Account " + th.getAccountNum() + "\n");
					} else if (th.getType().equals("Deposit")) {	
						System.out.println(th.getType() + " to Account " + th.getAccountNum() + "\n");
					} else {
						System.out.println(th.getType() + "\n");
					}
					System.out.println("Amount: " + th.getAmount() + "\n");
					System.out.println("Date: " + th.getDate() + "\n");
					System.out.println("Balance: " + th.getBalanceAfterTrans() + "\n");
					System.out.println("-------------------------------------");
				}
			} else {
				System.out.println("You don't have any transaction yet.");
			}
			
			sc.nextLine();
			sc.nextLine();
			this.startService();	
		}
	}
	
	public void deposit() {
		
		if (Driver.getAccount() == null) {
			System.out.println("Please Login First!");
			this.startService();
		}
		
		sc.nextLine();
						
		double amount = 0;
		int account = Integer.parseInt(Driver.getAccount());
		
		try {
			System.out.println("Enter Amount You Want To Deposit");
			amount = sc.nextDouble();
			
		} catch (InputMismatchException e) {
			System.out.println("Invalid Input");
			sc.next();
			this.startService();
		}
		
		if (amount <= 0) {
			System.out.println("Cannot Deposit 0 or Negative Amount");
			this.startService();
		}	
		
		double balance = transactionDao.deposit(amount, account);
		System.out.println("Deposit Complete. Your current account balance is " + balance + ".");
		this.startService();
	}
	
	public void withdraw() {
		if (Driver.getAccount() == null) {
			System.out.println("Please Login First!");
			this.startService();
		}
		
		sc.nextLine();
						
		double amount = 0;
		int account = Integer.parseInt(Driver.getAccount());
		
		try {
			System.out.println("Enter Amount You Want To Withdraw");
			amount = sc.nextDouble();
			
		} catch (InputMismatchException e) {
			System.out.println("Invalid Input");
			sc.next();
			this.startService();
		}
		
		if (amount <= 0) {
			System.out.println("Cannot Withdraw 0 or Negative Amount");
			this.startService();
		}
		
		User u = userDao.getAccInfo(Driver.getAccount());
		if (amount > u.getBalance()) {
			System.out.println("You don't have $" + amount + " in your account");
			this.startService();
		}
		
		double balance = transactionDao.withdraw(amount, account);
		System.out.println("Withdraw Complete. Your current account balance is " + balance + ".");
		this.startService();
	}

	public void transfer() {
		if (Driver.getAccount() == null) {
			System.out.println("Please Login First!");
			this.startService();
		}	
		sc.nextLine();
		
		// check transfer amount and user account balance
		double amount = 0;
		int account = Integer.parseInt(Driver.getAccount());
		String transferAcc = "";
		
		try {
			System.out.println("Enter Amount You Want To Transfer");
			amount = sc.nextDouble();
			
		} catch (InputMismatchException e) {
			System.out.println("Invalid Input");
			sc.next();
			this.startService();
		}
		
		if (amount <= 0) {
			System.out.println("Cannot Transfer 0 or Negative Amount");
			this.startService();
		}
		
		User u = userDao.getAccInfo(Driver.getAccount());
		if (amount > u.getBalance()) {
			System.out.println("You don't have $" + amount + " in your account");
			this.startService();
		}
		
		
		sc.nextLine();
		System.out.println("Enter Account Number You Want To Transfer");
		transferAcc = sc.nextLine();
		
		// check transfer account number
		transferAcc = transferAcc.replaceAll("[^0-9]", "");
		if (transferAcc.length() != 9) {
			System.out.println("Invalid Account Number");
			sc.next();
			this.startService();
		}
		
		User u2 = userDao.getAccInfo(transferAcc);
		if (u2 == null || u2.getAccountNum().equals(Driver.getAccount())) {
			System.out.println("The User Account Doesn't Exist");
			this.startService();
		}
		
		int transferAccInt = Integer.parseInt(transferAcc);
		double balance = transactionDao.transferTo(amount, account, transferAccInt);
		System.out.println("Transaction Complete. Your current account balance is " + balance + ".");
		this.startService();
	}
	
}
