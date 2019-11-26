package com.revature;

import java.sql.SQLException;
import java.util.List;

import com.revature.model.BankAccount;
import com.revature.service.BankAccountService;
import com.revature.util.ConnectionUtil;

public class Driver {

	public static void main(String[] args) {

//		try {
//		String driverName = ConnectionUtil.getConnection().getMetaData().getDriverName();
//		System.out.println(driverName);
//	} catch (SQLException e) {
//		e.printStackTrace();
//	}
		
//		CommandView cv = new CommandView();
//		cv.begin();

	
		
		
//		BankAccountService bs = new BankAccountService();
//		List<BankAccount> acct = bs.getBankAccount();
//		for (BankAccount bb : acct) {
//			System.out.println(bb);
//		}

//		BankAccount myacct = bs.getBankById(1);
//		System.out.println(myacct);

		// create new bank account
		
//		BankAccount newBankAccount = new BankAccount();
//		newBankAccount.setFirstName("Ryan");
//		newBankAccount.setLastName("Carstons");
//		newBankAccount.setUserId(2);
//		newBankAccount.setBalance(2000.00);
//		boolean success = bs.createBankAccount(newBankAccount);
//		System.out.println("success? " + success);

//		// updating a bank account
		
//		BankAccount previouslyCreatedBank = bs.getBankById(2);
//		System.out.println(previouslyCreatedBank);
//		
//		System.out.print("============================");
//		
//		previouslyCreatedBank.setUserId(3);
//		previouslyCreatedBank.setFirstName("Gabe");
//		previouslyCreatedBank.setLastName("Ryan");
//		previouslyCreatedBank.setBalance(500);
//		boolean success = bs.updateBankAccount(previouslyCreatedBank);
//		System.out.println("success? " + success);
//		BankAccount postUpdate = bs.getBankById(1);
//		System.out.println(postUpdate);

		//deleting a bank account
//		boolean success = bs.deleteBankAccount(new BankAccount(3));
//		System.out.println("success? "+ success);
	}

}
