package com.revature.dao;

import java.sql.SQLException;
import java.util.List;

import com.revature.model.Account;
import com.revature.model.Users;

public interface AccountDao {

	public List<AccountDao> getAccounts();
	
	public double getAccountBalance(int id, int accountpass) throws SQLException;
	
public boolean withdrawCash(int accountid, double amount, int pin) throws SQLException;

	boolean deposit(int userId, double balance) throws SQLException;
	
	public String createAccount(Account acct) throws SQLException;


	
	
	
	
	
	
}
