package com.revature.dao;

import java.sql.SQLException;
import java.util.List;

import com.revature.model.Users;

public interface UsersDao {
	
	
	
	public List<Users> getUsers();
	public boolean createUser(Users user) throws SQLException;
	
	
	
	

	
	

}
