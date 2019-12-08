package com.revature.service;

import java.util.List;

import com.revature.dao.UserDao;
import com.revature.dao.impl.UserDaoImpl;
import com.revature.model.User;

/* A Service class/interface provides a way for a user to interact
 * with functionality in the application. 
 * The service layer is there to provide logic to operate on the data
 * sent to and from the DAO and the user
 */


public class UserService {
	
	private UserDao userDao = new UserDaoImpl();
	
	public UserService() {
		super();
	}
	
	// Returns all the users in the database 
		public List<User> getUserTable(){
			return userDao.getUserTable();
		}
		
		// Returns a user by their userId
		public User getUserById(int userId) {
			return userDao.getUserById(userId);
		}

		// Creates a new user and returns true or false
		// if the user was created or not
		public String createUser(User user) {
			int usersCreated = userDao.createUser(user);
			if(usersCreated != 0) {
				return "\n User Created! \n";
			}
			return "\n Error! Could not create user. \n";
		}
			
		// Performs an update and it invokes it with user DAO
		public String updateUser(String firstName, String lastName, int userId) {
			int usersUpdated = userDao.updateUser(firstName, lastName, userId);
			if(usersUpdated != 0) {
				return "\n User Updated! \n";
			}
			return "\n Error! Could not update user. \n";
		}
		
		
		// Deletes a user and returns true or false
		// if the user was deleted or not
		public int deleteUser(int userId) {
			return userDao.deleteUser(userId);
		}

		public User getUserByUsernameAndPassword(String username, String password) {
			return userDao.getUserByUsernameAndPassword(username, password);
		}
	

}
