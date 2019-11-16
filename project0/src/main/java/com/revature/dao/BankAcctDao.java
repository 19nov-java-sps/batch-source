package com.revature.dao;

import java.util.List;

import com.revature.model.BankAcct;

public interface BankAcctDao {
	
	public List<BankAcct> getBankAcct();
	public int createBankAcct(BankAcct b);
	public int updateBankAcct(BankAcct b);
	public int deleteBankAcct(BankAcct b);
	

}
