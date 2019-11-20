package com.revature.dao;

import java.util.List;

import com.revature.model.BankAcct;

public interface BankAcctDao {
	
	public List<BankAcct> getBankAcct();
	public BankAcct getBankAcctByUserId(int id);
	public int createBankAcct(BankAcct b);
	public int updateBankAcct(BankAcct b);
	public int deleteBankAcct(BankAcct b);
	public void withdraw(BankAcct b, double withdrawAmount);
	public void deposit(BankAcct b, double depositAmount);
	

}
