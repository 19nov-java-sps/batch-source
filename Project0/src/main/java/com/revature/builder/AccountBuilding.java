package com.revature.builder;

import java.sql.SQLException;
import java.util.*;

import com.revature.model.Balance;
import com.revature.model.Users;
import com.revature.service.BalanceService;
import com.revature.service.UsersService;
import com.revature.util.ConnectionUtil;

public class AccountBuilding {
	

	static String continueBank = "no";
	static int counter = 1;
	
	public static void bankStart() {
		while (continueBank != "yes") {
		
		UsersService usersService = new UsersService();
		List<Users> usersList = new ArrayList<>();
		usersList = usersService.getUsers();
		
		BalanceService balService = new BalanceService();
		List<Balance> balList =  new ArrayList<>();
		balList = balService.getBalance();
		System.out.println("Enter NewUser to create a new user,"
				+ " LoginIn to enter account"
				+ " N to exit");
		Scanner scanner = new Scanner(System.in);
		
		String Choice = scanner.nextLine(); 
			if (Choice.equals("N")){
				System.out.println("Bye");
				continueBank = "yes";
			}
			if (Choice.equals("NewUser")){
    			System.out.println("Enter username");

    		    String userName = scanner.nextLine();

    		    System.out.println("Username is: " + userName);  
    		    	
    		    
    		    System.out.println("Enter email");
    		    
    		    String userEmail = scanner.nextLine(); 
    		    System.out.println("Email is: " + userEmail);
    		   
    		    System.out.println("Enter password");
    		    
    		    String userPass = scanner.nextLine(); 
    		    System.out.println("Password is: " + userPass);
    		    
    		    System.out.println("ID is: " + counter);
    		    
    			Users createdUser = new Users(counter, userName, userEmail, userPass);
    		    Balance userBalance = new Balance(counter, 0);
    		    counter ++;
    		    BalanceService.createBalance(userBalance);
    			if (UsersService.createUsers(createdUser) == 1) {
    				System.out.println("Thank you, your account has been approved");

			}
    		
			}
  
			if (Choice.equals("LoginIn")){
				String continuelogin = "yes";
				int id = 0;
				while (continuelogin != "no") {
					System.out.println("Type in Current Username");
					String username = scanner.nextLine();
					System.out.println("Type in Current Password");
					String Password = scanner.nextLine();
					for (Users info: usersList) {
						if ( info.getUsername().equals(username) && info.getPassword().equals(Password)) {
					
							System.out.println("You have logged in! You can choose to Withdraw,Deposit,ViewInfo,Logout");
							String ChoiceTwo = scanner.nextLine();
							
							if (ChoiceTwo.equals("Withdraw")) {
								System.out.println("Type in amount you want to withdraw");
								double withdraw = scanner.nextDouble();
								if (withdraw < 0)
								{
									System.out.println("Can't withdraw negative amounts logging you out");
									continuelogin = "no";
								}
								for (Balance information: balList) {
									if ( info.getId() == information.getId()){
										if((information.getBalance()-withdraw) < 0) {
											System.out.print("System shutting down");
											System.exit(0);
										}
										System.out.println(information.getBalance()-withdraw);
										System.out.print(" = Total Amount");
										BalanceService.withdraw(info.getId(), information.getBalance()-withdraw);
								}
								}
							}
							
							if (ChoiceTwo.equals("Deposit")) {
								System.out.println("Type in amount you want to deposit");
								double deposit = scanner.nextDouble();
								if (deposit < 0) {
									System.out.println("Can't deposit negative amounts logging you out");
									continuelogin = "no";
								}
								for (Balance informationtwo: balList) {
									if ( info.getId() == informationtwo.getId()){
										System.out.println(informationtwo.getBalance()+deposit);
										System.out.print(" = Total Amount");
								BalanceService.deposit(info.getId(), informationtwo.getBalance()+deposit);
									}
								}
							}
							if (ChoiceTwo.equals("ViewInfo")){
								System.out.println(info.getUsername() + " " + info.getEmail() + " " + info.getId() + " " + info.getPassword());
								for (Balance informationthree: balList) {
									if ( info.getId() == informationthree.getId()){
										System.out.println(informationthree.getBalance());
									}
								}
							}
							if (ChoiceTwo.equals("Logout")){
								System.out.println("Bye");
								continuelogin = "no";
					    }
						}
						}
						}
	

				}

		    
    		
				
			}
			
			


 
		}		
	}
