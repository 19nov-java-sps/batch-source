package com.revature.dao;

import java.util.List;

import com.revature.model.BankAcc;

public interface BankAccDao {

	public List<BankAcc> getBankAcc(int id);
	public BankAcc findBankAcc(int id);
	public int createBankAcc(BankAcc ba);
	public void withdrawStatement(int bankid, int decrease);
	public void depositStatement(int bankid, int increase);
	public int getBalance(int bankid);
}
