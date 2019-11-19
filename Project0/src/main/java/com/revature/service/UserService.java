package com.revature.service;

import java.util.List;

import com.revature.dao.UserDao;
import com.revature.dao.impl.UserDaoImpl;
import com.revature.model.User;

/* A Service class/interface provides a way of a client to interact
 * with some functionality in the application. 
 * This is typically public, with some business meaning. 
 * In this case, a Bank Account that allows you to createBankAcct,
 * updateBankAcct, deleteBankAcct etc
 */

public class UserService {
	
	private UserDao userDao = new UserDaoImpl();
	
	// Returns all the users in the database 
	public List<User> getUser(){
		return userDao.getUser();
	}
	
	// Returns a user by their user ID
	public User getUserById(int id) {
		return userDao.getUserById(id);
	}

	// Creates a new user and returns true or false
	// if the user was created or not
	public boolean createUser(User u) {
		int userCreated = userDao.createUser(u);
		if(userCreated != 0) {
			return true;
		}
		return false;
	}
	
	// Updates a user and returns true or false
	// if the user was updated or not
	public boolean updateUser(User u) {
		int userUpdated = userDao.updateUser(u);
		if(userUpdated != 0) {
			return true;
		}
		return false;
	}
	
	// Deletes a user and returns true or false
	// if the user was deleted or not
	public boolean deleteUser(User u) {
		int userDeleted = userDao.deleteUser(u);
		if(userDeleted != 0) {
			return true;
		}
		return false;
	}


	
	

}
