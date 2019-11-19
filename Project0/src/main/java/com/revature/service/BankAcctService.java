package com.revature.service;

import java.util.List;

import com.revature.dao.BankAcctDao;
import com.revature.dao.impl.BankAcctDaoImpl;
import com.revature.model.BankAcct;

/* A Service class/interface provides a way of a client to interact
 * with some functionality in the application. 
 * This is typically public, with some business meaning. 
 * In this case, a Bank Account that allows you to createBankAcct,
 * updateBankAcct, deleteBankAcct etc
 */

public class BankAcctService {
	
	private BankAcctDao bankAcctDao = new BankAcctDaoImpl();
	
	// Returns all the users in the database
	public List<BankAcct> getBankAcct(){
		return bankAcctDao.getBankAcct();
	}
	
	// Returns a user's bank account by their user ID
	public BankAcct getBankAcctByUserId(int id) {
		return bankAcctDao.getBankAcctByUserId(id);
	}
	
	// Creates a new bank account and returns true or false
	// if the bank account was created or not
	public boolean createBankAcct(BankAcct b) {
		int bankAcctCreated = bankAcctDao.createBankAcct(b);
		if(bankAcctCreated != 0) {
			return true;
		}
		return false;
	}
	
	// Updates a user's bank account and returns true or false
	// if the bank account was updated or not
	public boolean updateBankAcct(BankAcct b) {
		int bankAcctUpdated = bankAcctDao.updateBankAcct(b);
		if(bankAcctUpdated != 0) {
			return true;
		}
		return false;
	}
	
	// Deletes a user's bank account and returns true or false
	// if the bank account was deleted or not
	public boolean deletBankAcct(BankAcct b) {
		int bankAcctDeleted = bankAcctDao.updateBankAcct(b);
		if(bankAcctDeleted != 0) {
			return true;
		}
		return false;
	}
		

}
