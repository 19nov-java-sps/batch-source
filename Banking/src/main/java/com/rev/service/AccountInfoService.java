package com.rev.service;

import java.util.List;

import com.rev.dao.AccountInfoDao;
import com.rev.dao.impl.AccountInfoDaoImpl;
import com.rev.model.AccountInfo;

public class AccountInfoService {
		private AccountInfoDao accountInfoDao = new AccountInfoDaoImpl();
		
		public List<AccountInfo> getAccountInfo(){
			return accountInfoDao.getAccountInfo();
		}
		
		public AccountInfo getAccountInfoById(int id) {
			return accountInfoDao.getAccountById(id);
		}
		
		public boolean createAccount(AccountInfo a) {
			int accountCreated = accountInfoDao.createAccount(a);
			if(accountCreated != 0) {
				return true;
			}
			return false;
		}
		
		public boolean updateAccount(AccountInfo a) {
			int accountUpdated = accountInfoDao.updateAccount(a);
			if(accountUpdated != 0) {
				return true;
			}
			return false;
		}
		
		public boolean deleteAccount(AccountInfo a) {
			int accountDeleted = accountInfoDao.deleteAccount(a);
			if(accountDeleted != 0) {
				return true;
			}
			return false;
		}
		public void withdrawal(AccountInfo a, double amount) {
			accountInfoDao.withdrawal(a, amount);
		}
		public void deposit(AccountInfo a, double amount) {
			accountInfoDao.deposit(a, amount);
		}

}
