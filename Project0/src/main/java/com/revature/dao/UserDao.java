package com.revature.dao;

import java.util.List;

import com.revature.model.User;

// DAO: Data Access Object - an object or in this case an interface 
// that provides access to an underlying database

public interface UserDao { 
	
		public List<User> getUser(); // Used to view all the users in the database
		public User getUserById(int id); // Used to view a user by their user ID
		public int createUser(User u); // Used to create a new user with a username, password & user ID
		public int updateUser(User u); // Used to update username, password and user ID
		public int deleteUser(User u); // Used to delete a user
		
}
