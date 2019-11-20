package com.revature.driver;

import java.util.List;
import java.util.Scanner;

import com.revature.model.BankAcc;
import com.revature.model.UserAcc;
import com.revature.service.BankAccServices;
import com.revature.service.UserAccService;

public class Driver {

	public static void main(String[] args) {
		UserAccService uac = new UserAccService();
		UserAcc ua = new UserAcc();
		
		BankAccServices bas = new BankAccServices();
		BankAcc ba = new BankAcc();
		
		System.out.println("ATM");
		System.out.println("Enter the corresponding number to the menu");
		System.out.println("1 for creating a user account");
		System.out.println("2 for logging in");
		
		Scanner key = new Scanner(System.in);
		int menu = 0;
		String username = "";
		String password = "";
		
		menu = key.nextInt();
		
		switch(menu) {
		case 1: 
			System.out.println("Please enter a username");
			username = key.next();
			System.out.println("Please enter a password");
			password = key.next();
			ua.setUserName(username);
			ua.setPassword(password);	
			try {
				uac.createUserAcc(ua);
			} catch (Exception e) {
				System.out.println("That username has been taken. Please try again!");
				System.exit(0);
			}
		case 2: 
			System.out.println("Please enter your username");
			username = key.next();
			System.out.println("Please enter your password");
			password = key.next();
			if (uac.verfiyLogin(username, password) == true){
				System.out.println("login success");
			}
			else {
				System.out.println("login failed");
				System.exit(0);
			}
			break;
		default:
			System.out.println("Invalid selection. Turning off");
			System.exit(0);
			break;
		}
		
		int userid = uac.getUserId(username);
		int setBalance;
		
		int bankid;
		int money;
		
		int currentBalance;
		
		System.out.println("Welcome " + username);
		
		menu = key.nextInt();
		
		switch(menu) {
		case 1: 
			// create bank account
			ba.setUserID(userid);
			System.out.println("Enter how much money you would like to have");
			setBalance = key.nextInt();
			ba.setBalance(setBalance);
			boolean success = bas.createBankAcc(ba);
			System.out.println(success);
			break;
		case 2: 
			// view bank account
			List<BankAcc> banklist = bas.getBankAcc(1);
			for(BankAcc ba1: banklist) {
				System.out.println(ba1);
			}			
			break;
		case 3:
			// deposit
			System.out.println("Enter which bank account you want to use");
			bankid = key.nextInt();
			System.out.println("How much do you wish to deposit");
			money = key.nextInt();
			bas.depositStatement(money, bankid);
			break;
		case 4:
			// withdraw
			System.out.println("Enter which bank account you want to use");
			bankid = key.nextInt();
			currentBalance = bas.getBalance(bankid);
			System.out.println("You currently have: " + currentBalance);
			System.out.println("How much do you wish to withdraw");
			money = key.nextInt();
			if ((currentBalance - money) < 0) {
				System.out.println("You do not have enough funds");
			}
			else {
				bas.withdrawStatement(money, bankid);
			}
			break;
		default:
			System.out.println("Logging off");
			System.exit(0);
		}


	}
}
