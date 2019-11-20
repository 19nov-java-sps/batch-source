package com.revature.dao;

import java.util.List;

import com.revature.model.Balance;
import com.revature.model.Users;

public interface BalanceDao {
	
	public Balance getBalanceById(int id);
	public List<Balance> getBalance();
	public int createBalance(Balance b); 
	public void withdraw(int id, double amount);
	public void deposit(int id, double amount);

}




