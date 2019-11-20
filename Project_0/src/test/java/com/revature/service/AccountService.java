package com.revature.service;

import java.sql.SQLException;

import com.revature.dao.AccountDao;
import com.revature.dao.impl.AccountDaoImpl;
import com.revature.dao.impl.UsersDaoImpl;
import com.revature.model.Account;
import com.revature.model.Users;

public class AccountService {
	private AccountDaoImpl acctDao = new AccountDaoImpl();
	
	public boolean deposit(int accountId, double deposit) throws SQLException {
		return acctDao.deposit(accountId, deposit);
	}
		public double getBalance(int accountid, int accountpass) throws SQLException {
			
			
			return acctDao.getAccountBalance(accountid, accountpass);
		}

		public boolean withdrawCash(int accountid, double amount, int pin) throws SQLException {
			
			return acctDao.withdrawCash(accountid, amount, pin);
			
			
		}
		
		public String createAcount(Account account) throws SQLException {
			
			return acctDao.createAccount(account);
			
		}


}


