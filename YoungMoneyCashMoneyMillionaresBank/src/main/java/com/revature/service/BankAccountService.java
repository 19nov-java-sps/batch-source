package com.revature.service;

import java.util.List;

import com.revature.dao.BankAccountDao;
import com.revature.dao.impl.BankAccountDaoImpl;
import com.revature.model.BankAccount;

public class BankAccountService {

	private BankAccountDao bankaccountDao = new BankAccountDaoImpl();

	public List<BankAccount> getBankAccount() {
		return bankaccountDao.getBankAccount();
	}

	public BankAccount getBankById(int id) {
		return bankaccountDao.getBankById(id);
	}

	public boolean createBankAccount(BankAccount b) {
		int bankaccountCreated = bankaccountDao.createBankAccount(b);
		if (bankaccountCreated != 0) {
			return true;
		}
		return false;
	}

	public boolean updateBankAccount(BankAccount b) {
		int bankaccountUpdated = bankaccountDao.updateBankAccount(b);
		if (bankaccountUpdated != 0) {
			return true;
		}
		return false;
	}

	public boolean deleteBankAccount(BankAccount b) {
		int bankaccountDeleted = bankaccountDao.deleteBankAccount(b);
		if (bankaccountDeleted != 0) {
			return true;
		}
		return false;
	}

	public void deposit(BankAccount b, double increase) {
		bankaccountDao.deposit(b, increase);
	}

	public void withdraw(BankAccount b, double decrease) {
		bankaccountDao.withdraw(b, decrease);
	}

}