package com.revature.dao;
import java.util.List;

import com.revature.model.BankAccount;

public interface BankAccountDao {

	public List<BankAccount> getBankAccount();

	public BankAccount getBankById (int id);
	
	public void deposit(BankAccount b, double increase);
	
	public void withdraw(BankAccount b, double decrease);
	
	public int createBankAccount(BankAccount b);

	public int updateBankAccount(BankAccount b);

	public int deleteBankAccount(BankAccount b);

}
