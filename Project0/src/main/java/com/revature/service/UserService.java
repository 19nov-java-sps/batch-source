package com.revature.service;

import java.util.Scanner;

import com.revature.Driver;
import com.revature.dao.UserDao;
import com.revature.dao.impl.UserDaoImpl;

public class UserService {
	
	private UserDao userDao = new UserDaoImpl();
	
    private static Scanner sc = new Scanner(System.in);
    
    public void startService() {

    	if (Driver.isLogin() == false) {
	    	System.out.println("Welcome to MyBank!");
	        System.out.println("==================");
	        System.out.println("Login-------------1");
	        System.out.println("Register----------2");
    	} else {
    		System.out.println("   Welcome Back User!   ");
    		System.out.println("Account Information----4");
    		System.out.println("Update Account Info----5");
	        System.out.println("Logout-----------------3");
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
			this.logout();
			break;

		default:
			this.startService();
			break;
		}

    }
    
	public void login() {
		
		if (Driver.isLogin() == false) {
			
			sc.nextLine();
			System.out.println("Username: ");
			String userName = sc.nextLine();
			System.out.println("Password: ");
			String password = sc.nextLine();

			if (userDao.login(userName, password) == true) {
	    		System.out.println("Login success");
			} else {
		        System.out.println("Wrong User Name or Password. Please try again!");
			}
		} else {
			System.out.println("You already login.");
		}
		
		this.startService();
	}
	
	public void login(String userName, String password) {
		
		userDao.login(userName, password);
		
		if (userDao.login(userName, password) == true) {
    		System.out.println("Login success");
		} else {
	        System.out.println("Wrong User Name or Password. Please try again!");
		}
		
		this.startService();
	}
	
	public void register() {
		
		if (Driver.isLogin() == false) {
			
			sc.nextLine();
			System.out.println("Enter Username (must be 5 to 10 characters)");
			String userName = sc.nextLine();
			System.out.println("Enter Password (must be 8 to 16 characters)");
			String password = sc.nextLine();
			System.out.println("Enter First Name");
			String firstName = sc.nextLine();
			System.out.println("Enter Last Name");
			String lastName = sc.nextLine();
			System.out.println("Enter Your Email");
			String email = sc.nextLine();
			System.out.println("Enter Your Phone");
			String phone = sc.nextLine();
						
			if (userDao.register(userName, password, firstName, lastName, email, phone) == true) {
				this.login(userName, password);
			}
			
		} else {
			System.out.println("You Already Login.");
		}

		this.startService();
	}
	
	public void logout() {
		
		userDao.logout();
		this.startService();
	}

}
