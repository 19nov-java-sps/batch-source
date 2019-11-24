package com.rev.service;
import java.util.List;

import com.rev.dao.UserLogInDao;
import com.rev.dao.impl.UserLogInDaoImpl;
import com.rev.model.User;




public class UserLogInService {
	private UserLogInDao userLogInDao = new UserLogInDaoImpl();
	
	public List<User> getUsers(){
		return userLogInDao.getUsers();
	}
	
	public User getUserByUserName(String user) {
		return userLogInDao.getUserByUserName(user);
	}
	
	public User getUserById(int id) {
		return userLogInDao.getUserById(id);
	}
	
	public boolean createUser(User u) {
		int userCreated = userLogInDao.createUser(u);
		if(userCreated != 0) {
			return true;
		}
		return false;
	}
	
	public boolean updateUser(User u) {
		int userUpdated = userLogInDao.updateUser(u);
		if(userUpdated != 0) {
			return true;
		}
		return false;
	}
	
	public boolean deleteUser(User u) {
		int userDeleted = userLogInDao.deleteUser(u);
		if(userDeleted != 0) {
			return true;
		}
		return false;
	}
	
	
	
}
