package com.revature;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.revature.model.BankAcct;
import com.revature.model.Client;
import com.revature.service.BankAcctService;
import com.revature.service.ClientService;

public class Menu {
	
	private static String optionChosen;
	private static String inputUsernameString;
	private static String inputPasswordString;
	private static String inputFirstnameString;
	private static String inputLastnameString;
	
	private static int userId;
	
	public static void start() {
		Scanner scanner = new Scanner(System.in);
		ClientService clientService = new ClientService();
		BankAcctService bankAcctService = new BankAcctService();
		
		
		//Loading Existing Clients and Accounts
		
		List<Client> clientsList = new ArrayList<>();
		List<BankAcct> bankAcctsList =  new ArrayList<>();
		
		clientsList = clientService.getClient();
		bankAcctsList = bankAcctService.getBankAcct();
		
		
		
		
		System.out.println("=====================================================");
		System.out.println("========WELCOME TO THE BEST BANKING APP==============");
		
		System.out.println("\n");
		
		System.out.println("Would you like to do?");
		System.out.println("\n");
		System.out.println("1 - Register For A New Account");
		System.out.println("2 - Sign In With An Existing Account");
		System.out.println("3 - Exit");
		System.out.println("\n");
		
		optionChosen = scanner.nextLine();
		
		switch (optionChosen) {
		case "1":
			System.out.println("\n");
			System.out.println("Please enter your First Name");
			System.out.println("\n");
			System.out.println("\n");
			inputFirstnameString = scanner.nextLine();
			System.out.println("\n");
			System.out.println("\n");
		
			System.out.println("Please enter your Last Name");
			System.out.println("\n");
			System.out.println("\n");
			inputLastnameString = scanner.nextLine();
			System.out.println("\n");
			System.out.println("\n");
			System.out.println("Please Enter Your Username");
			System.out.println("\n");
			System.out.println("\n");
			inputUsernameString = scanner.nextLine();
			System.out.println("\n");
			System.out.println("\n");
			System.out.println("Please Enter Your Password");
			inputPasswordString = scanner.nextLine();
			System.out.println("\n");
			
			//generate  userID
			userId = (int) Math.ceil(Math.random() * 10000);
			
			BankAcct clientBankAcct = new BankAcct(inputFirstnameString, inputLastnameString, 0, userId);
			Client createdClient = new Client(inputUsernameString, inputPasswordString, userId);
			
			if (clientService.createClient(createdClient) == true) {
				System.out.println("Thank you, your account has been approved");
				
				bankAcctService.createBankAcct(clientBankAcct);
				
				
			} else {
				System.out.println("Due to Technical Difficulties, your request has not been process");
				start();
			}
			
			ActionController();
				
				switch(optionChosen) {
				
				case "1":
					ActionViewAcctController(createdClient);
					break;
				case "2":
					ActionDepositController();
					break;
				case "3":
					ActionWithdrawController();
					break;
				default:
					System.exit(0);
					break;
				
				}
		
			
			break;
		case "2":
			System.out.println("\n");
			System.out.println("Please Enter Your Username");
			System.out.println("\n");
			inputUsernameString = scanner.nextLine();
			System.out.println("\n");
			System.out.println("Please Enter Your Password");
			inputPasswordString = scanner.nextLine();
			
			
			
			break;
		default:
			System.out.println("Thank you for using our service and have a wonderful day");
			System.exit(0);
			break;
		}
		
		scanner.close();
		
	}

	private static void ActionWithdrawController() {
		ClientService clientService = new ClientService();
		BankAcctService bankAcctService = new BankAcctService();
		
	}

	private static void ActionDepositController() {
		ClientService clientService = new ClientService();
		BankAcctService bankAcctService = new BankAcctService();
	}

	private static void ActionViewAcctController(Client createdClient) {
		BankAcctService bankAcctService = new BankAcctService();
		BankAcct bankAcct = bankAcctService.getBankAcctByUserId(createdClient.getUserId());
		
		System.out.print(bankAcct);
		
		
	}

	public static void ActionController() {
		System.out.println("\n");
		System.out.println("\n");
		System.out.println("What would you like to do?");
		System.out.println("\n");
		System.out.println("1. View Your Account Balance");
		System.out.println("\n");
		System.out.println("\n");
		System.out.println("2. Deposit");
		System.out.println("\n");
		System.out.println("3. Withdraw");
		System.out.println("\n");
		System.out.println("4. Sign Out");

	}
	

}
