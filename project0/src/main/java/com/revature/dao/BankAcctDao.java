package com.revature.dao;

import java.util.List;

import com.revature.model.BankAcct;
import com.revature.model.Client;

public interface BankAcctDao {
	
	public List<BankAcct> getBankAcct();
	public BankAcct getBankAcctByUserId(int id);
	public int createBankAcct(BankAcct b);
//	public int createBankAcctWithClient(Client c);
	public int updateBankAcct(BankAcct b);
	public int deleteBankAcct(BankAcct b);
	public void withdraw(BankAcct b, double withdrawAmount);
	public void deposit(BankAcct b, double depositAmount);
	

}
