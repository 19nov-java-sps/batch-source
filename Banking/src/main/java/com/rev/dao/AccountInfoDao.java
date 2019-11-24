package com.rev.dao;

import java.util.List;

import com.rev.model.AccountInfo;
import com.rev.model.User;

public interface AccountInfoDao {
	public List <AccountInfo> getAccountInfo();
	public int withdrawal(AccountInfo a, double amount);
	public int deposit(AccountInfo a, double amount);
	public AccountInfo getAccountById(int id);
	public int createAccount(AccountInfo a);
	public int updateAccount(AccountInfo a);
	public int deleteAccount(AccountInfo a);
}
