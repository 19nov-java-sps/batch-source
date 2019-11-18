package com.revature.dao;

import java.util.List;

import com.revature.model.Transaction;

public interface TransactionDao {

	public List<Transaction> getTransactionHistory();
	
	public boolean deposit(Double amount);
	public boolean withdraw(Double amount);
	public boolean transferTo(Double amount, String transferAcc);

}
