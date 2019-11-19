package com.revature.dao;

import java.util.List;

import com.revature.model.User;

public interface UserDao {
	
	public List<User> getUsers();
	public User getUserById(int id);
	public User getUserByUsername(String username);
	public User verifyUserByPassword(String username, String password);
	public int createUser (User u);
	public int updateUser(User u);
	public int addUser(User u);
	public int deleteUser(User u);

}
