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
		clientsList = clientService.getClient();

		
	
	
		
		
		System.out.println("=====================================================");
		System.out.println("========WELCOME TO THE BEST BANKING APP==============");
		
		System.out.println("\n");
		
		System.out.println("Would you like to do?");
		System.out.println("\n");
		System.out.println("1 - Register For A New Account");
		System.out.println("2 - Sign In With An Existing Account");
		System.out.println("3 - Exit");
		System.out.println("\n");
		System.out.println("\n");
		System.out.println("\n");
		
		optionChosen = scanner.nextLine();
		System.out.println("\n");
		
		
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
				
				System.out.println("=====================================================");
				ActionController(createdClient);

				
			} else {
				System.out.println("Due to Technical Difficulties, your request has not been process");
				start();
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
			
			
			
			
			for (Client details: clientsList) {
				if ( details.getUsername().equals(inputUsernameString) && details.getPassword().equals(inputPasswordString)) {
					System.out.println("Thank you for verifying your credentials");
					ActionController(details);
				} else {
					System.out.println("Unfortunately, we are unable to locate  your account");
					start();
				}
			}
			
			
			break;
		default:
			System.out.println("Thank you for using our service and have a wonderful day");
			System.exit(0);
			break;
		}
		
		scanner.close();
		
	}


	private static void ActionWithdrawController(Client createdClient) {
		BankAcctService bService =  new BankAcctService();
		BankAcct acct = bService.getBankAcctByUserId(createdClient.getUserId());
		
		System.out.println("How much would you like to withdraw?");
		
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		double withdrawAmount =  scanner.nextDouble();
		double currentBalance = acct.getBalance();
		
		if (currentBalance == 0 || currentBalance -  withdrawAmount <= 0)  {
			System.out.println("Sorry, your account has insufficient funds.");
			System.out.println("\n");
			ActionViewAcctController(createdClient);
		} else {
			bService.withdraw(acct, withdrawAmount);
			ActionViewAcctController(createdClient);
		}
		
		
		
	}

	@SuppressWarnings("resource")
	private static void ActionDepositController(Client createdClient) {
		BankAcctService bService =  new BankAcctService();
		BankAcct acct = bService.getBankAcctByUserId(createdClient.getUserId());
		System.out.println("How much would you like to Deposit?");
		Scanner scanner =  new Scanner(System.in);
		double depositAmount =  (double) scanner.nextDouble() * -1;
		
		bService.deposit(acct, depositAmount);
		System.out.println("\n");
		ActionViewAcctController(createdClient);
		
	}

	private static void ActionViewAcctController(Client c) {
		
		BankAcctService bService =  new BankAcctService();
		BankAcct acct = bService.getBankAcctByUserId(c.getUserId());
		System.out.println("Your current balance is" + " " + acct.getBalance());
		ActionController(c);
		
		
	}

	public static void ActionController(Client c) {
		System.out.println("=====================================================");
		System.out.println("\n");
		System.out.println("\tWhat would you like to do?");
		System.out.println("\t1. View Your Account Balance");
		System.out.println("\t2. Deposit");
		System.out.println("\t3. Withdraw");
		System.out.println("\t4. Sign Out");
		System.out.println("\t5. Delete Account");
		
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		int answer = scanner.nextInt();
		
		switch(answer) {
		
		case 1:
			ActionViewAcctController(c);
			break;
		case 2:
			ActionDepositController(c);
			break;
		case 3:
			ActionWithdrawController(c);
			break;
		case 4:
			System.exit(0);
			break;
		case 5:
			ActionDeleteController(c);
			break;
		default:
			System.exit(0);
			break;
		}
		

		

	}


	private static void ActionDeleteController(Client c) {
		BankAcctService bService =  new BankAcctService();
		ClientService  clientService = new ClientService();
		
		BankAcct acct = bService.getBankAcctByUserId(c.getUserId());
		
		clientService.deleteClient(c);
		
		bService.deleteBankAcct(acct);
		
		
		
	}
	
	

}
