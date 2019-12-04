package com.revature.daos;

import java.util.List;

import com.revature.models.UserAcc;

public interface UserAccDao {

	public List<UserAcc> getAll();
	public UserAcc getUserById(int id);
	public UserAcc getuserByUserAndPass(String username, String password);
}
