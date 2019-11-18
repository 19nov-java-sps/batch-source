package com.revature.service;

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
	    	System.out.println("Welcome to MyBank!");
	        System.out.println("==================");
	        System.out.println("Login-------------1");
	        System.out.println("Register----------2");
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
		
		if (loginSuccess == true) {
    		System.out.println("Login Successful");
		} else {
	        System.out.println("Wrong User Name or Password. Please try again!");
		}
		
		this.startService();
	}
	
	public boolean register() {
		
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
				return false;
			}
			
			phone = phone.replaceFirst("(\\d{3})(\\d{3})(\\d+)", "($1) $2-$3");
			
			if (userDao.register(userName, password, firstName, lastName, email, phone) == 1) {
				this.login(userName, password);
			} else {
				this.startService();
				return false;
			}
			
		} else {
			System.out.println("You Already Login.");
		}

		System.out.println("Register Successful!");
		this.startService();
		return true;
	}
	
	public void logout() {
		
		userDao.logout();
		this.startService();
	}
	
	public boolean getUserAcc() {
		
		if (Driver.getAccount() == null) {
			System.out.println("Please Login First!");
			this.startService();
			return false;
		} else {
			User u = userDao.getAccInfo();
			System.out.println("Name: " + u.getFirstName() + " " + u.getLastName() + "\n");
			System.out.println("Email: " + u.getEmail() + "\n");
			System.out.println("Phone: " + u.getPhone() + "\n");
			System.out.println("Account Number: " + u.getAccountNum() + "\n");
			System.out.println("Current Balance: " + u.getBalance() + "\n");
			
			sc.nextLine();
			sc.nextLine();
			this.startService();
			
			return true;
		}
	}
	
	public boolean updateAcc() {
		
		if (Driver.getAccount() == null) {
			System.out.println("Please Login First!");
			this.startService();
			return false;
		}
		
		User u = userDao.getAccInfo();
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
			return false;
		}
		
		if (userDao.UpdateAccInfo(u, password, email, phone) == 0) {
			this.startService();
			return false;
		}
		
		System.out.println("Update Your Account Information Success!");
		this.startService();
		return true;			
	}
	
	public boolean viewTransHistory() {
		
		if (Driver.getAccount() == null) {
			System.out.println("Please Login First!");
			this.startService();
			return false;
		} else {
			List<Transaction> transHistoy = transactionDao.getTransactionHistory();
			
			if (transHistoy.size() > 0) {
				for (Transaction th: transHistoy) {
					System.out.println("_______________________________________");
					System.out.println(th.getType() + " to Account Number " + th.getAccountNum() + "\n");
					System.out.println("Amount: " + th.getAmount() + "\n");
					System.out.println("Date: " + th.getDate() + "\n");
					System.out.println("Balance: " + th.getBalanceAfterTrans() + "\n");
					System.out.println("_______________________________________");
				}
			} else {
				System.out.println("You don't have any transaction yet.");
			}
			
			sc.nextLine();
			sc.nextLine();
			this.startService();
			
			return true;
		}
	}
	

}
