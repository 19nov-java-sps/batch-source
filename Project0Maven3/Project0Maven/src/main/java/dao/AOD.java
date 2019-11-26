package dao;


import java.util.List;

import model.AccountOwner;

public interface AOD {
	
	//methods
	
	public AccountOwner getAccountOwner(String fullName);
	public List<AccountOwner> findAccountOwner();
	public int createAccountOwner(AccountOwner owner);
	
	
}
