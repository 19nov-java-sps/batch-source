package com.revature.service;

import java.util.List;

import com.revature.dao.UserDao;
import com.revature.dao.impl.UserDaoImpl;
import com.revature.model.Department;
import com.revature.model.User;

public class UserService {
	
	private UserDao userDao = new UserDaoImpl();

	public List<User> getUsers() {
		return userDao.getUsers();
	}
	
	public boolean createUser(User u) {
		int userCreated = userDao.createUser(u);
		if(userCreated != 0) {
		return true;
		}
		return false;
	}

}
