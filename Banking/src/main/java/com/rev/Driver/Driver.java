package com.rev.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.rev.model.AccountInfo;
import com.rev.model.User;
import com.rev.service.AccountInfoService;
import com.rev.service.UserLogInService;
import com.rev.util.ConnectionUtil;



public class Driver {
	static Scanner input = new Scanner(System.in);
	static String info="";
	public static void MainMenu(AccountInfoService a,UserLogInService u) {
		int selection;

		
		System.out.println("Welcome to the bank \n");
		System.out.println("Please select an option");
		System.out.println("1) Create an account");
		System.out.println("2) Log in to existing account");
		System.out.println("3) Quit");
		
		
		selection=input.nextInt();
		switch (selection) {
		case 1:
			System.out.println("You have chosen to create an account");
			System.out.println("Please Enter a username");
			String userName=input.next();
			User check= u.getUserByUserName(userName);
			if(check==null) {
			System.out.println("Please Enter a password");
			String passWord=input.next();
			User newUser = new User();
			
			
			
			
			
			newUser.setUserName(userName);
			newUser.setPassWord(passWord);
			boolean success = u.createUser(newUser);
			if(success) {System.out.println("Created user: " + userName);}
			
			
			AccountInfo newAccnt = new AccountInfo();
			newAccnt.setAccount_balance(0);
			newAccnt.setUser_id(newUser.getUser_id());
			boolean success2 = a.createAccount(newAccnt);
			
			}else {System.out.println("Username taken already, please login");}
			System.out.println();
			MainMenu(a,u);
			break;
		case 2:
			System.out.println("You have chosen to Log in");
			System.out.println("Please Enter your Username");
			String LogInfo=input.next().toLowerCase();
			info=LogInfo;
			System.out.println("Please Enter your Password");
			String PassInfo=input.next().toLowerCase();
			
			User user= u.getUserByUserName(LogInfo);
			
			if(PassInfo.equals(user.getPassWord().toLowerCase())) {
				System.out.println("Successfully logged in: " + LogInfo);
				System.out.println();
				LogInMenu(a,u);
			} else {
				System.out.println("Invalid credentials, try again");
				MainMenu(a,u);
			}
			
			break;
		case 3:
			System.out.println("You have chosen to exit");
			System.out.println("GoodBye");
			break;

		default:
			System.out.println("Invalid option");
			MainMenu(a,u);
			break;
		}
		
		System.out.println("");
	}
	
	
	
	
	public static void LogInMenu(AccountInfoService a,UserLogInService u) {
		User ax= u.getUserByUserName(info);
		System.out.println("Please select an option");
		System.out.println("1) View Account Balance");
		System.out.println("2) Withdraw Cash");
		System.out.println("3) Deposit Cash");
		System.out.println("4) Log out");
		

		
		int selection2=input.nextInt();
		switch (selection2) {
		case 1:
			System.out.println("You have chosen to view your account balance");
			System.out.println(a.getAccountInfoById(ax.getUser_id()).getAccount_balance());
			System.out.println();
			LogInMenu(a,u);
			break;
		case 2:
			System.out.println("Choose amount to Withdraw");
			float withAmount=input.nextFloat();
			if(a.getAccountInfoById(ax.getUser_id()).getAccount_balance()-withAmount<0) {
				System.out.println("Cannot withdraw as balance will be negative");
				
			} else {
				a.withdrawal(a.getAccountInfoById(ax.getUser_id()), withAmount);
				System.out.println("Successfully withdrew "+withAmount+" from Account");
			}
			LogInMenu(a,u);


			break;
		case 3:
			System.out.println("Choose amount to Deposit");
			float depAmount=input.nextFloat();
			
			a.deposit(a.getAccountInfoById(ax.getUser_id()), depAmount);
			System.out.println("Successfully deposited "+depAmount+" into Account");
			System.out.println();
			
			LogInMenu(a,u);
			break;
		case 4:
			System.out.println("Logging out, Goodbye!");
			System.out.println();
			MainMenu(a,u);
			break;
		default:
			System.out.println("Invalid optionz");
			break;
		}
	}
	
	
	
	public static void main(String[] args) throws SQLException {
		AccountInfoService a= new AccountInfoService();
		UserLogInService u= new UserLogInService();
		MainMenu(a,u);
	}
}

		








//obsolete code
////////////////////////////////////////////////////////////////Accounts
//List<AccountInfo> accts = a.getAccountInfo();
//for(AccountInfo i: accts) {
//	System.out.println(i);
//}
////prints all accountInfo
//
//


//
//AccountInfo myAccnt = a.getAccountInfoById(4);
//System.out.println(myAccnt);
//prints selected account
//




//AccountInfo newAccnt = new AccountInfo();
//newAccnt.setAccount_balance(450000);
//newAccnt.setUser_id(2);
//boolean success = a.createAccount(newAccnt);
//System.out.println("success? "+success);
//creates new record
//swap ds with a, need to make a user to make account





//AccountInfo previouslyCreatedAccount = a.getAccountInfoById(9);
//System.out.println(previouslyCreatedAccount);
//previouslyCreatedAccount.setAccount_balance(455000);
//boolean success = a.updateAccount(previouslyCreatedAccount);
//System.out.println("success? "+ success);
//AccountInfo postUpdate = a.getAccountInfoById(9);
//System.out.println(postUpdate);
////updates existing





//AccountInfo accountToDelete = a.getAccountInfoById(4);
//System.out.println(accountToDelete);
//boolean success = a.deleteAccount(accountToDelete);
//System.out.println("success? "+ success);
////deletes record by userid






//AccountInfo accountToDeposit = a.getAccountInfoById(9);
//System.out.println(accountToDeposit);
//a.deposit(accountToDeposit, 5);
//deposits into account





//AccountInfo accountToWithdraw = a.getAccountInfoById(9);
//System.out.println(accountToWithdraw);
//a.withdrawal(accountToWithdraw, 5);
//withdraws








////////////////////////////////////////////////////////////////users
/*
 * List<User> users = u.getUsers(); for(User i: users) { System.out.println(i);
 * } prints all userInfo
 * 
 * 
 * 
 * 
 * 
 * 
 * User user = u.getUserById(2); System.out.println(user); prints selected user
 * 
 * 
 * 
 * 
 * User newUser = new User(); newUser.setUserName("Joe Smith");
 * newUser.setPassWord("SmithJoe"); boolean success = u.createUser(newUser);
 * System.out.println("success? "+success); creates new user
 * 
 * 
 * 
 * 
 * 
 * User previouslyCreatedUser = u.getUserById(3);
 * System.out.println(previouslyCreatedUser);
 * previouslyCreatedUser.setUserName("Not Joe Smith");
 * previouslyCreatedUser.setPassWord("Not passWord"); boolean success =
 * u.updateUser(previouslyCreatedUser); System.out.println("success? "+
 * success); User postUpdate = u.getUserById(3); System.out.println(postUpdate);
 * updates existing Scanner input = new Scanner(System.in);
 * 
 * System.out.println("Welcome to the bank \n");
 * System.out.println("Please select an option");
 * System.out.println("1) Create an account");
 * System.out.println("2) Log in to existing account");
 * System.out.println("3) Quit");
 * 
 * String selection=input.nextLine(); String info=""; switch (selection) { case
 * "1": System.out.println("You have chosen to create an account");
 * System.out.println("Please Enter a username"); String userName=input.next();
 * System.out.println("Please Enter a password"); String passWord=input.next();
 * User newUser = new User(); newUser.setUserName(userName);
 * newUser.setPassWord(passWord); boolean success = u.createUser(newUser);
 * if(success) {System.out.println("Created user: " + userName);} //add
 * PSQLException for duplicate user
 * 
 * AccountInfo newAccnt = new AccountInfo(); newAccnt.setAccount_balance(0);
 * newAccnt.setUser_id(newUser.getUser_id()); boolean success2 =
 * a.createAccount(newAccnt); System.out.println("success? "+success);
 * 
 * 
 * 
 * 
 * 
 * break; case "2": System.out.println("You have chosen to Log in");
 * System.out.println("Please Enter your Username"); String
 * LogInfo=input.next(); info=LogInfo;
 * System.out.println("Please Enter your Password"); String
 * PassInfo=input.next();
 * 
 * User user= u.getUserByUserName(LogInfo);
 * if(PassInfo.equals(user.getPassWord())) {
 * System.out.println("Successfully logged in: " + LogInfo); } else {
 * System.out.println("Invalid credentials, try again"); }
 * 
 * break; case "3": System.out.println("You have chosen to exit");
 * System.out.println("GoodBye"); break;
 * 
 * default: System.out.println("Invalid option"); break; }
 * 
 * System.out.println("");
 * 
 * User ax= u.getUserByUserName(info);
 * System.out.println("Please select an option");
 * System.out.println("1) View Account Balance");
 * System.out.println("2) Withdraw Cash");
 * System.out.println("3) Deposit Cash"); System.out.println("4) Log out");
 * 
 * 
 * String selection2=input.nextLine(); switch (selection2) { case "1":
 * System.out.println("You have chosen to view your account balance");
 * System.out.println(a.getAccountInfoById(ax.getUser_id()).getAccount_balance()
 * );
 * 
 * break; case "2": break; case "3": break; case "4": break; default:
 * System.out.println("Invalid option"); break; }
 */

		

