package com.revature.service;

import com.revature.dao.UserAccDao;
import com.revature.dao.impl.UserAccDaoImpl;
import com.revature.model.UserAcc;

public class UserAccService {

	private UserAccDao uad = new UserAccDaoImpl();

	// checks to see if the account has been create.
	public boolean createUserAcc(UserAcc ua) {
		int userAccCreated = uad.createUserAccount(ua);
		if (userAccCreated != 0) {
			return true;
		}
		return false;
	}
	
	public int getUserId(String id) {
		return uad.getUserId(id);
	}
	
	public boolean verfiyLogin(String username, String password) {
		return uad.verifyLogin(username, password);
	}
}
