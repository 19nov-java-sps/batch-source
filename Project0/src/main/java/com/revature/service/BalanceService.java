package com.revature.service;

import java.util.List;

import com.revature.dao.BalanceDao;
import com.revature.dao.impl.BalanceDaoImpl;
import com.revature.model.Balance;

public class BalanceService {
	
	private static BalanceDao bd = new BalanceDaoImpl();
	
	public List<Balance> getBalance(){
		return bd.getBalance();
	}
	
	public Balance getBalanceById(int id) {
		return bd.getBalanceById(id);
	}


	public static int createBalance(Balance b) {
		int balInitialized = bd.createBalance(b);
		if (balInitialized == 0) {
			return 0;
		}
		return balInitialized;
		
	}
	public static void withdraw(int id, double amount) {
		bd.withdraw(id, amount);
	}
	
	public static void deposit(int id, double amount) {
		bd.deposit(id, amount);
	}
}
