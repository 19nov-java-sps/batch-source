package com.revature.dao;

import java.util.List;

import com.revature.model.Users;

public interface UsersDao {
	
	public List<Users> getUsers();
	public int createUsers(Users u);
	public Users getUsers(String username);
	
}
