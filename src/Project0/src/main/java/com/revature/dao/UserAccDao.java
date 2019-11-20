package com.revature.dao;

import com.revature.model.UserAcc;

public interface UserAccDao {
	
	public int createUserAccount(UserAcc ua); // create a user account
	public int getUserId(String username); // find id by username
	public boolean verifyLogin(String username, String password);

}
