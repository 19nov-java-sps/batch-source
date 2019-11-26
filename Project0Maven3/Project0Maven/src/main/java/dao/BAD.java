package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import model.AccountOwner;
import model.BankAccount;
import util.ConnectionUtil;

public interface BAD 

{
	public List<BankAccount> listBankAccount();
	public int deposit(BankAccount accountX, int depositAmount);
	public int withdraw(BankAccount accountX, int withdrawAmount);
	public int createBankAccount(BankAccount account);
	public BankAccount checkBalance(String userName);
}
