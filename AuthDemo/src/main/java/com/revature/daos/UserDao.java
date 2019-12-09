package com.revature.daos;

import java.util.List;

import com.revature.models.User;

public interface UserDao {
	
	public List<User> getUsers();
	public List<User> getAll();
	public User getUserById(int id);
	public int updateUser(String username, String role, String password, int id);
	public User getUserByUsernameAndPassword(String username, String password);
	

}
