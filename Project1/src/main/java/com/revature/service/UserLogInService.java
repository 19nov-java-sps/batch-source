package com.revature.service;

import java.util.List;

import com.revature.daos.UserLoginDao;
import com.revature.daos.UserLoginDaoImpl;
import com.revature.models.UserLogin;

public class UserLogInService {
	private UserLoginDao userLogInDao = new UserLoginDaoImpl();
	
	public List<UserLogin> getUsers(){
		return userLogInDao.getUsers();
	}
	
	public UserLogin getUserByUserName(String user) {
		return userLogInDao.getUserByUserName(user);
	}
	
	public UserLogin getUserById(int id) {
		return userLogInDao.getUserById(id);
	}
	
	
	public boolean updateUser(String name, String email,String password,int id) {
		int userUpdated = userLogInDao.updateUser(name,email,password,id);
		if(userUpdated != 0) {
		
			return true;
		}
		return false;
	}

	public UserLogin getUserByEmailAndPassword(String email, String password) {
		// TODO Auto-generated method stub
		return userLogInDao.getUserByEmailAndPassword(email, password);
		
	}
	

}
