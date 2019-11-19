package com.revature.dao;

import java.util.List;

import com.revature.model.BankAcct;

// DAO: Data Access Object - an object or in this case an interface 
// that provides access to an underlying database

public interface BankAcctDao {
		
		public List<BankAcct> getBankAcct(); // Used to view all the bank accounts in the database
		public BankAcct getBankAcctByUserId(int id); // Used to view a user's bank account by their user ID
		public int createBankAcct(BankAcct b); // Used to create a new bank account with a first name, last name, initial balance and user ID
		public int updateBankAcct(BankAcct b); // Used to update a bank account with a new first name, last name, balance and user ID
		public int deletBankAcct(BankAcct b); // Used to delete a bank account
		
}
