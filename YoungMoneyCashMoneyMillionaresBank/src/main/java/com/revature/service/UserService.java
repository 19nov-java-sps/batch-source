package com.revature.service;

import java.util.List;

import com.revature.dao.UserDao;
import com.revature.dao.impl.UserDaoImpl;
import com.revature.model.User;

public class UserService {

	private UserDao userDao = new UserDaoImpl();

	public List<User> getUser() {
		return userDao.getUser();
	}

	public User getUserById(int id) {
		return userDao.getUserById(id);
	}

	public boolean createUser(User u) {
		int userCreated = userDao.createUser(u);
		if (userCreated != 0) {
			return true;
		}
		return false;
	}

	public boolean updateUser(User u) {
		int userUpdated = 0;
		if (userUpdated != 0) {
			return true;
		}
		return false;
	}

	public boolean deleteUser(User u) {
		int userDeleted = 0;
		if (userDeleted != 0) {
			return true;
		}
		return false;
	}

}
