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

		// Performs an update and it invokes it with user DAO
		public String updateUser(String firstName, String lastName, int userId) {
			int usersUpdated = userDao.updateUser(firstName, lastName, userId);
			if(usersUpdated != 0) {
				return "\n User Updated! \n";
			}
			return "\n Error! Could not update user. \n";
		}
		
}
