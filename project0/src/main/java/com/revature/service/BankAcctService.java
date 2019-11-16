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
	
	public boolean createBankAcct(BankAcct b) {
		int acctCreated = bankAcctDao.createBankAcct(b);
		if(acctCreated != 0) {
			return true;
		}
		return false;
	}
	

}
