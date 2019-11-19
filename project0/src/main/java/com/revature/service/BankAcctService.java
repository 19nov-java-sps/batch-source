package com.revature.service;

import java.util.List;

import com.revature.dao.BankAcctDao;
import com.revature.dao.impl.BankAcctDaoImpl;
import com.revature.model.BankAcct;

public class BankAcctService {
	
	private BankAcctDao bankAcctDao = new BankAcctDaoImpl();
	
	public List<BankAcct> getBankAcct(){
		return bankAcctDao.getBankAcct();
	}
	
	public BankAcct getBankAcctByUserId(int id) {
		return bankAcctDao.getBankAcctByUserId(id);
	}
	
	public boolean createBankAcct(BankAcct b) {
		int acctCreated = bankAcctDao.createBankAcct(b);
		if(acctCreated != 0) {
			return true;
		}
		return false;
	}
	
	public boolean updateBankAcct(BankAcct b) {
		int acctDeleted = bankAcctDao.updateBankAcct(b);
		if(acctDeleted != 0) {
			return true;
		}
		return false;
	}
	
	public Boolean deleteBankAcct(BankAcct b) {
		int deptDeleted = bankAcctDao.deleteBankAcct(b);
		if(deptDeleted !=0) {
			return true;
		}
		return false;
	}
	
	public void withdraw(BankAcct b, double withdrawAmount) {
		bankAcctDao.withdraw(b, withdrawAmount);
	}
	
	public void deposit(BankAcct b, double depositAmount) {
		bankAcctDao.withdraw(b, depositAmount);
	}
	
	

}
