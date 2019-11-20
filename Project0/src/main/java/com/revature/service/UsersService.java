package com.revature.service;

import java.util.List;

import com.revature.dao.UsersDao;
import com.revature.dao.impl.UsersDaoImpl;
import com.revature.model.Users;

public class UsersService {
	
	private static UsersDao ud = new UsersDaoImpl();
	
	public List<Users> getUsers(){
		return ud.getUsers();
	}
	public Users getUsers(String username) {
		return ud.getUsers(username);
	}

	
	public static int createUsers(Users u) {
		int i =  ud.createUsers(u);
		if (i !=  0) {
			return 1;
		}  else {
			return 0;
		}
		
	}

}
