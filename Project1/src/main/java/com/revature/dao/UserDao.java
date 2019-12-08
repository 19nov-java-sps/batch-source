package com.revature.dao;

import java.util.List;

import com.revature.model.User;

//DAO: Data Access Object - an object or in this case an interface 
//that provides access to an underlying database

public interface UserDao {
	
	public List<User> getUserTable(); // Used to view all the users in the users table
	public User getUserById(int userId); // Used to get user info by user ID
	public int createUser(User u); // Used to create a new user
	public int updateUser(String firstName, String lastName, int userId); // Used to update a user's first & last name
	public int deleteUser(int userId); // Used to delete a user
	public User getUserByUsernameAndPassword(String username, String password); // Used to get user info by username & password
	
}
