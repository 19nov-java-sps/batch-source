package com.revature.service;

import java.util.List;

import com.revature.dao.UserDao;
import com.revature.dao.impl.UserDaoImpl;
import com.revature.model.User;

public class UserService {
	
	private UserDao ud = new UserDaoImpl();
	
	// CREATE USER TABLE
	public int createUserTable() {
	
		return ud.createUserTable();
	}
	
	// CREATE NEW USER
	public String createUser(User u) {
		
		int userCreated = ud.createUser(u);
		if (userCreated != 0) {
			return "\nUser Created!\n";
		} 
		return "Something went wrong!";
	}
	
	// UPDATE USER (WITHDRAW OR DEPOSIT)
	public int updateUser(String username, double newBalance) {
		
		return ud.updateUser(username, newBalance);
	}
	
	// DELETE USER
	public int deleteUser(String username) {
		
		return ud.deleteUser(username);
	}
	
	// GET A USER USING USERNAME AND PASSWORD
	public User getUser(String username) {
		
		return ud.getUser(username);
	}
	
	public List<User> getUserTable() {
		
		return ud.getUserTable();
	}
}
