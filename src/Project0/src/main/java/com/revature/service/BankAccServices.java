package com.revature.service;

import java.util.List;

import com.revature.dao.BankAccDao;
import com.revature.dao.impl.BankAccDaoImpl;
import com.revature.model.BankAcc;

public class BankAccServices {

	private BankAccDao bad = new BankAccDaoImpl();
	
	public boolean createBankAcc(BankAcc ba) {
		int bankAccCreated = bad.createBankAcc(ba);
		if (bankAccCreated != 0) {
			return true;
		}
		return false;
	}
	
	public BankAcc findBankAcc(int id) {
		return bad.findBankAcc(id);
	}
	
	public void depositStatement(int increase, int bankid) {
		bad.depositStatement(increase, bankid);
	}
	
	public void withdrawStatement(int decrease, int bankid) {
		bad.withdrawStatement(decrease, bankid);
	}
	
	public List<BankAcc> getBankAcc(int id){
		return bad.getBankAcc(id);
	}
	
	public int getBalance(int bankid) {
		return bad.getBalance(bankid);
	}
}
