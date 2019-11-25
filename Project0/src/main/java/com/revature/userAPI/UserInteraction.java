package com.revature.userAPI;

import java.sql.SQLException;
import java.util.Scanner;

import com.revature.dao.AccountDao;
import com.revature.dao.UserDao;
import com.revature.dao.impl.AccountDaoImpl;
import com.revature.dao.impl.UserDaoImpl;
import com.revature.model.Account;
import com.revature.model.User;
import com.revature.service.AccountService;
import com.revature.service.UserService;

public class UserInteraction {
	
	/*******************************************
	1. Main user menu
	2. Switch statement
	3. Validate an user with a username and password
	4. Retrieve user's data method
	 *******************************************/
	public static void mainMenu() {
		
		//Shows main user menu
		System.out.println("Hello! Choose an option");
		System.out.println();
		System.out.println("Check your balance: 		enter 1");
		System.out.println("Add money: 			enter 2");
		System.out.println("Withdrow money: 		enter 3");
		System.out.println("Create a new account: 		enter 4");
		System.out.println("Delete your account: 		enter 5");
		System.out.println("Delete the user: 		enter 6");
		System.out.println("Create a new user: 		enter 7\n$>");
		
		//create a scanner instance and takes an user input
		Scanner in = new Scanner(System.in);
        int number = in.nextInt();
        	System.out.println("You entered number "+number);
        	System.out.println();
        	
        //makes a choice between creating a new user and functions that need user's validation	
        if(number == 7) {
        	System.out.println("Creating a new user ... ");
        	System.out.println();
        	
        	//takes user data to create an account
        	UserInteraction ui = new UserInteraction();
        	User newUser = ui.getUserData();
        	
        	//create a new user with a received data
        	UserDao ud = new UserDaoImpl();
        	ud.createUser(newUser);
        	
        }else {
        	//validate an user with a username  and password
        	UserInteraction ui = new UserInteraction();
        	User validUser = ui.userAuthentification();
        	ui.switchOptions(number, validUser);
        	}
        }
	
	//switch statement for choices 1-6
	public void switchOptions(int number, User validUser) {
		AccountService as = new AccountService();
		int id = validUser.getUserId();
		Scanner in = new Scanner(System.in);
		
		
		switch (number) {
		case 1:		//check balance
			System.out.println("Your balance: "+as.checkBalance(id)); //the method is in AccountServices class
			System.out.println();
			mainMenu();
			break;
		case 2:		//add money
			System.out.println("Enter ammount you want to add in this format: 00.00");
			double ammount = in.nextDouble();
			System.out.println();
		    System.out.println("You entered : "+ammount);
		    as.addMoney(id, ammount);
			System.out.println();
			System.out.println("The ammount of :" + ammount + " has been added!");
			System.out.println();
			System.out.println("Your new balance: "+as.checkBalance(id));//the method is in AccountServices class
			System.out.println();
			mainMenu();
			break;
		case 3:		//withdraw money
			System.out.println("Enter ammount you want to withdrow in this format: 00.00");
			double ammount2 = in.nextDouble();
			System.out.println();
		    System.out.println("You entered : "+ammount2);
		    as.withdrawMoney(id, ammount2);
			System.out.println();
			System.out.println("The ammount of :" + ammount2 + " has been withdrawn!");
			System.out.println();
			System.out.println("Your new balance: "+as.checkBalance(id));
			System.out.println();
			mainMenu();
			break;
		case 4: //create a new client
	       	AccountDao ad = new AccountDaoImpl();
	       	int accountId = ad.getUserAccountId(validUser.getUserId());
        	ad.createAccount(ad.getAccountById(accountId));
        	System.out.println("Creating a new account for user " +validUser.getUserName() +"... ");
        	System.out.println();
        	System.out.println(ad.getAccountById(accountId));
 			break;
		case 5:	//delete a account
			System.out.println("Enter account number you want to delete");
			int accNumber = in.nextInt();
			AccountDao ad1 = new AccountDaoImpl();
			Account accToDelete = ad1.getAccountById(accNumber);
			System.out.println();
		    System.out.println("You want to delete : "+ ad1.getAccountById(accNumber));
		    System.out.println("Enter 1 to confirm or 2 to cancel");
		    int choise = in.nextInt();
		    if(choise == 1) {
		    	ad1.deleteAccount(accToDelete);
		    	System.out.println("The account number " + accNumber +  "is deleted");
		    }else if (choise == 2){
		    	System.out.println("The action was canceled");
		    	mainMenu(); 
		    }
		    else {
		    	System.out.println("Wrong symbol!");
		    	mainMenu(); 
		    }
			break;
		case 6:  //delete a use
			System.out.println("Enter username of the account you want to delete");
			String userName = in.nextLine();
			UserDao ud = new UserDaoImpl();
			User userToDelete = ud.getUserByUsername(userName);
			System.out.println();
		    System.out.println("You want to delete : "+ ud.getUserByUsername(userName));
		    System.out.println("Enter 1 to confirm or 2 to cancel");
		    int choise1 = in.nextInt();
		    if(choise1 == 1) {
		    	ud.deleteUser(userToDelete);
		    	System.out.println("The user" + userName +  "is deleted");
		    }else if (choise1 == 2){
		    	System.out.println("The action was canceled");
		    	mainMenu(); 
		    }
		    else {
		    	System.out.println("Wrong symbol!");
		    	mainMenu(); 
		    }
			break;
		}
	}

	//Takes user's username and pasword and validate them
	public User userAuthentification() {
		Scanner in = new Scanner(System.in);
		System.out.println("Autentification ... ");
    	System.out.println();
    	UserService us = new UserService();
		System.out.println("Please enter your user name: \\n1$>");
		 String userName = in.nextLine(); 	
		 //search trough a user table and validate a user name for uniqueness
    	try {
			while (us.checkUserUniqueness (userName) == 0) {
				 System.out.println("Your username is not in the database!");
				 System.out.println("Please enter your user name: \\n1$>");
				  userName = in.nextLine(); 	
			}
			System.out.println();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	System.out.println("Please enter your password: ");
   	    String passWord = in.nextLine();
   	    
		 //validate a user comparing username and password
    	while (us.UserVerification (userName, passWord) != true) {
    		System.out.println("Your password is not correct!");
    		System.out.println("Please enter your password: \\n1$>");
       	     passWord = in.nextLine();
    	 } 
    		 System.out.println("Your password is  correct!");
    		 System.out.println();
    		 
    		 //get user data from a database
     	UserDao ud = new UserDaoImpl();
    	User validUser = ud.getUserByUsername(userName);
    	return validUser;
    	
	}

	//gathers user input necessary to create a new user
	public  User getUserData() {

		Scanner in = new Scanner(System.in);
		System.out.println("Please input your first name");
        String firstName = in.nextLine();
        System.out.println("You entered string "+firstName);
        System.out.println();
		System.out.println("Please input your last name");
        String lastName = in.nextLine();
        System.out.println("You entered string "+lastName);
		System.out.println();
		
        UserService us = new UserService();
  		System.out.println("Please enter your UNIQUE username");
		String userName = in.nextLine();
		
		//validates a username for uniqueness
			try {
				while    (us.checkUserUniqueness(userName)!= 0) {

					System.out.println("Please enter your UNIQUE username");
					 userName = in.nextLine();
					System.out.println("Your username is not UNIQUE, please enter another username");
						}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
       	 System.out.println("You entered an UNIQUE name "+userName);

       
		System.out.println();
		
		System.out.println("Please enter your password");
        String passWord = in.nextLine();
        System.out.println("You entered string "+passWord);
		System.out.println();
		
		System.out.println("Please enter your UNIQUE email");
        String email = in.nextLine();
     //   if()
        System.out.println("You entered string "+email);
		System.out.println();
		
		User newUser = new User(firstName, lastName, userName, passWord, email);
		 UserDao ud = new UserDaoImpl();
		 ud.createUser(newUser);
		 
			System.out.println("Your user data: "  + ud.getUserByUsername(userName));
						
		return newUser;
		
	}

				

}
