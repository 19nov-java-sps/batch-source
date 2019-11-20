package com.revature.bucci.Project_0;

import java.util.Scanner;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import com.revature.dao.UsersDao;
import com.revature.dao.impl.AccountDaoImpl;
import com.revature.model.Account;
import com.revature.model.Department;
import com.revature.model.Users;
import com.revature.service.AccountService;
import com.revature.service.DepartmentService;
import com.revature.service.UserService;
import com.revature.util.ConnectionUtil;

public class Driver {
	
	public static void main(String[] args) throws SQLException{
	boolean trigger=true;
	
		while(trigger) {
		Scanner sn= new Scanner(System.in);
	System.out.println("Welcome to Revature Bank");
	System.out.println("Menu Options");
	System.out.println("Press 1 to Sign Up" );
	System.out.println("Press 2 to Login");
	
	
	
	
	String selection=sn.nextLine();	
		
		if(Integer.parseInt(selection)==1) {
			
			System.out.println("Please Enter your email address");
			String emailAddress=sn.nextLine();
			System.out.println("Please enter your first name");
			String firstName=sn.nextLine();
			System.out.println("Please enter your last name");
			String lastName=sn.nextLine();
			System.out.println("Please enter your desired User id");
			int userid =Integer.parseInt(sn.nextLine());
			System.out.println("Please enter your password");
			String password=sn.nextLine();
			
			UserService adduser= new UserService();
			Users user= new Users(firstName, lastName, userid, emailAddress, password);
			
			
			if(adduser.createUser(user)){
				System.out.println("Success, please press any 0 to go back to main menu or 1 to exit");
				int select=Integer.parseInt(sn.nextLine());
				if(select==1) {
					trigger=false;
				}
			}
			
			
			else {
				System.out.println("Email or Id is already in use");
			}
		}
		
		
		
if(Integer.parseInt(selection)==2) {
	System.out.println("Please enter your email address");
	String email=sn.nextLine();
	System.out.println("Please enter your Password");
	String password=sn.nextLine();
	
	UserService user= new UserService();
	
	if(user.isRegistered(email, password)) {
		
		System.out.println("Login Successful");
		
		System.out.println("To create a new account press 1");
		System.out.println("To make a deposit press 2");
		System.out.println("To make a withdrawal press 3");
		System.out.println("To view your balance press 4");
		int choice=Integer.parseInt(sn.nextLine());
		
		if(choice==1) {
			
			System.out.println("Please enter your user Id");
			int id= Integer.parseInt(sn.nextLine());
			System.out.println("Please enter your initial deposit");
			double deposit= Double.parseDouble(sn.nextLine());
			System.out.println("Please enter your account pin");
			int pin= Integer.parseInt(sn.nextLine());
			System.out.println("Please select 1 to create a checking account or 2 to create a savings account");
		
			int typeofacct=Integer.parseInt(sn.nextLine());
			String type;
			if(typeofacct==1) {
				type="Checking";
			}
			else {
				type="Savings";
			}
			AccountService acct= new AccountService();
			
			Account acct1= new Account(id, deposit, type, pin);
			System.out.println(acct.createAcount(acct1));
			System.out.println("Please press any 0 to go back to main menu or 1 to exit");
			int select=Integer.parseInt(sn.nextLine());
			if(select==1) {
				trigger=false;
			}
		}
		
		if(choice==2) {
			System.out.println("Please enter your account Id");
			int id= Integer.parseInt(sn.nextLine());
			System.out.println("Please enter amount you wish to desposit");
			double deposit= Double.parseDouble(sn.nextLine());
		
			AccountService acct= new AccountService();
			if(acct.deposit(id, deposit)) {
				System.out.println("Success");
				System.out.println("Please press any 0 to go back to main menu or 1 to exit");
				int select=Integer.parseInt(sn.nextLine());
				if(select==1) {
					trigger=false;
				}
					
				
			}
			
		}
			if(choice==3) {
				System.out.println("Please enter your account Id");
				int id= Integer.parseInt(sn.nextLine());
				System.out.println("Please enter your pin");
				int pin= Integer.parseInt(sn.nextLine());
				System.out.println("Please enter amount you wish to withdraw");
				double withdraw= Double.parseDouble(sn.nextLine());
				
				
				AccountService acct= new AccountService();
				if(acct.withdrawCash(id, withdraw,pin)) {
					System.out.println("Success");
					System.out.println("Please press any 0 to go back to main menu or 1 to exit");
					int select=Integer.parseInt(sn.nextLine());
					if(select==1) {
						trigger=false;
					}
				}
					else {
						System.out.println("Insufficient funds or incorrect pin");
					}
					
				}
			
			
			if(choice==4) {
				System.out.println("Please enter your account Id");
				int id= Integer.parseInt(sn.nextLine());
				System.out.println("Please enter your account pin");
				int pin= Integer.parseInt(sn.nextLine());
				AccountService acct= new AccountService();
				if(acct.getBalance(id, pin)==0) {
					System.out.println("The pin you've entered is incorrect");
				}
				
				System.out.println(acct.getBalance(id,pin));
				System.out.println("Please press any 0 to go back to main menu or 1 to exit");
				int select=Integer.parseInt(sn.nextLine());
				if(select==1) {
					trigger=false;
				}
				
			}
		}
	else {
		
		System.out.println("The credentials you provided are incorrect");
	}
	
	}
	

	
	
}



}
}
	


		


	

	
	

	

