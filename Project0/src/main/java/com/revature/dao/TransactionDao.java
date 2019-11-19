package com.revature.dao;

import java.util.List;

import com.revature.model.Transaction;

public interface TransactionDao {

	public List<Transaction> getTransactionHistory(String account);
	
	public double deposit(double amount, int account);
	public double withdraw(double amount, int account);
	public double transferTo(double amount, int account, int transferAcc);

}
