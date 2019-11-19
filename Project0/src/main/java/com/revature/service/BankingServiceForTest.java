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

public class BankingServiceForTest {
	
	private UserDao userDao = new UserDaoImpl();
	private TransactionDao transactionDao = new TransactionDaoImpl();
	
    private static Scanner sc = new Scanner(System.in);
    
	public boolean login() {
		
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
		        return false;
			}
		} else {
			System.out.println("You already login.");
		}
		return true;
	}
	
	public boolean login(String user, String password) {
		
		boolean loginSuccess = userDao.login(user, password);
		
		if (loginSuccess == true) {
    		System.out.println("Login Successful");
		} else {
	        System.out.println("Wrong User Name or Password. Please try again!");
		}
		return true;
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
				return false;
			}
			
			phone = phone.replaceFirst("(\\d{3})(\\d{3})(\\d+)", "($1) $2-$3");
			
			if (userDao.register(userName, password, firstName, lastName, email, phone) == 1) {
				return true;
			} else {
				return false;
			}
		
			
		} else {
			System.out.println("You Already Login.");
		}

		System.out.println("Register Successful!");
		return true;
	}
	
	public void logout() {
		
		userDao.logout();
	}
	
	public User getUserAcc(String account) {

		User u = userDao.getAccInfo(account);
		System.out.println("Name: " + u.getFirstName() + " " + u.getLastName() + "\n");
		System.out.println("Email: " + u.getEmail() + "\n");
		System.out.println("Phone: " + u.getPhone() + "\n");
		System.out.println("Account Number: " + u.getAccountNum() + "\n");
		System.out.println("Current Balance: " + u.getBalance() + "\n");
		
		sc.nextLine();
		sc.nextLine();
		
		return u;
	}
	
	public boolean updateAcc(String account) {
		
		if (Driver.getAccount() == null) {
			System.out.println("Please Login First!");
		}
		
		User u = userDao.getAccInfo(account);
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
			return false;
		}
		
		if (userDao.UpdateAccInfo(u, password, email, phone) == 0) {
			return false;
		}
		
		System.out.println("Update Your Account Information Success!");
		return true;
	}
	
	public void viewTransHistory(String account) {
		
		if (Driver.getAccount() == null) {
			System.out.println("Please Login First!");
		} else {
			List<Transaction> transHistoy = transactionDao.getTransactionHistory(account);
			
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
		}
	}
	

	

}
