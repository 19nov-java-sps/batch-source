package com.revature.services;

import java.sql.SQLException;
import java.util.Scanner;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import com.revature.models.User;
import com.revature.util.ConnectionUtil;

import com.revature.daos.UserDaoImpl;
import com.revature.daos.UserDao;
import com.revature.models.User;

public class UserService {
	
	public List<User> getUsers(){
		return UserDaoImpl.getInstance().getUsers();
	}
	public List<User> getAll(){
		return UserDaoImpl.getInstance().getAll();
	}
	public User getUserById(int id) {
		return UserDaoImpl.getInstance().getUserById(id);
	}
	public User getUserByUsernameAndPassword(String username, String password){
		return UserDaoImpl.getInstance().getUserByUsernameAndPassword(username, password);
	}
	
}

