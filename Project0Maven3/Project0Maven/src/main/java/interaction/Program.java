package interaction;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import doaImplementation.BADIMPL;
import model.AccountOwner;
import model.BankAccount;
import service.AccountOwnerService;
import service.BankAccountService;

public class Program {
	private static int userName;
	private static String phoneNumber;
	
	public void start() 
{
		System.out.print("Starting Application\n");
		System.out.println("==============================");
		Scanner scanner = new Scanner(System.in);
		
		//set services
		
		AccountOwnerService accountOwnerService = new AccountOwnerService();
		BankAccountService bankAccountService = new BankAccountService();
		
		
		List<AccountOwner> listOfAccountsInServer = new ArrayList<>();
		List<BankAccount> listOfBankAccountsInServer = new ArrayList<>();

		
		System.out.println("****************** list of account owners *****************");
		listOfAccountsInServer = accountOwnerService.findAccountOwner();
		for (AccountOwner owner: listOfAccountsInServer) {
			System.out.println((owner));

		}
		
		System.out.println("****************** list of bank account  *****************");
		listOfBankAccountsInServer = bankAccountService.listBankAccount();
		for (BankAccount account: listOfBankAccountsInServer) {
			System.out.println((account));

		}
		System.out.println("******************  *****************");
		
		AccountOwner ownerx = new AccountOwner();
		BankAccount account1 = new BankAccount();
		
//		ownerx.setUserName(listOfAccountsInServer.get(0).getUserName());
//		ownerx.setPhoneNumber(listOfAccountsInServer.get(0).getPhoneNumber());
//		ownerx.setUserEmail(listOfAccountsInServer.get(0).getUserEmail());
//		ownerx.setFullName(listOfAccountsInServer.get(0).getFullName());
			
		//******	get userName and pin number
		System.out.println("Please enter your username: ");
		String userName1 = scanner.nextLine();
			for (int i = 0; i<=listOfAccountsInServer.size()-1; i++) 
			{
		
				if (listOfAccountsInServer.get(i).getUserName().equals(userName1))
				{
					System.out.println("user found ");
					
					System.out.println("Please enter your pin number: ");
					
					int pinNumber = scanner.nextInt();
					
					if ((pinNumber) == listOfAccountsInServer.get(i).getPhoneNumber() )
					{
						System.out.println("*****	congrat account located	*****");
						// account owner activities
						System.out.println("*****	what would you like to do ?	*****");
						System.out.println("");
						System.out.println("Deposit enter 1: ");
						System.out.println("Withdraw enter 2: ");
						System.out.println("Check balance enter 3: ");
						System.out.println("Create new account enter 4: ");
						
						int choice = scanner.nextInt();
						
						int operation = choice;
						
						switch (operation) {
						  case 1:
						    System.out.println("You would like to make a deposit.");
						    
						    System.out.println("please enter the deposit amount: ");
						    int depositAmount = scanner.nextInt();
						    
//						    int currentBalance = account1.setAccountBalance(listOfBankAccountsInServer.get(i).getAccountBalance());
//						    int newBalance = depositAmount + currentBalance ;
//						    System.out.println("current balance: " + newBalance);

						    
						    BankAccountService.deposit(listOfBankAccountsInServer.get(i), depositAmount);
						    
//						    
						    break;
//						    
						  case 2:
						    System.out.println("You would like to withdraw.");
						   
						    System.out.println("please enter the deposit amount: ");
						    int withdrawAmount = scanner.nextInt();
						    BankAccountService.withdraw(listOfBankAccountsInServer.get(i), withdrawAmount);
						    
						    break;
//						    
						  case 3:
							  
							    {	
							    	System.out.println("Your avaliable balance is: $"+ listOfBankAccountsInServer.get(i).getAccountBalance());
							    }
							    break;
//						  case 4:
//							  
//						    {	
//						    	System.out.println("create new bank account");
//						    	BankAccountService.createBankAccount(account1);
//						    	
//						    }
//						    break;
//						  case 4:
//						  {
//							  System.out.println("Create a new account");
//						  }
						  default:
						    System.out.println("sorry you should enter 1, 2 or 3");
	
						}
						
					}

					
				}
				else {System.out.println("account not found");};
			}
}}
				
				
					
					


	



	