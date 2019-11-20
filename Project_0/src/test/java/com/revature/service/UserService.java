package com.revature.service;

import java.sql.SQLException;
import java.util.List;

import com.revature.dao.DepartmentDao;
import com.revature.dao.UsersDao;
import com.revature.dao.impl.DepartmentDaoImpl;
import com.revature.dao.impl.UsersDaoImpl;
import com.revature.model.Department;
import com.revature.model.Users;

public class UserService {

	private UsersDaoImpl userDao = new UsersDaoImpl();
	
	public List<Users> getUsers(){
		return userDao.getUsers();
	}
	
	public boolean createUser(Users user) throws SQLException {
		
		return userDao.createUser(user);
		
	}
public boolean isRegistered(String email, String password) throws SQLException {
	
	return userDao.isRegistered(email, password);
	
	
}
	
	
	
	
}
