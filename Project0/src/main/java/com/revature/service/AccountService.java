package com.revature.service;

import java.util.List;

import com.revature.dao.AccountDao;
import com.revature.dao.impl.AccountDaoImpl;
import com.revature.model.Account;

public class AccountService {
	
	private AccountDao accountDao = new AccountDaoImpl();
	
	
	public List<Account> getAccount(){
		return accountDao.getAccounts();
	}
	
	public boolean createAccount(Account a) {
		
		int accCreated = accountDao.createAccount(a);
		if(accCreated !=0) {
			return true;
		}
		return false;
	}
	

}
