package com.revature.dao;

import java.util.List;

import com.revature.model.User;

public interface UserDao {
	
	public int createUserTable();	// Used to create the users table. (Only used once)
	public int createUser(User u);	// Used to create a new user.
	public int updateUser(String username, double newBalance);	// Used to withdraw or deposit.
	public int deleteUser(String username);	// Used to delete user.
	public User getUser(String username);	// Used to validate username and password.
	public List<User> getUserTable();		// Used to take a look at the users table.
	
}
