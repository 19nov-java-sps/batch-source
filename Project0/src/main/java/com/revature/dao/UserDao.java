package com.revature.dao;

import com.revature.model.User;

public interface UserDao {

	public boolean login(String userName, String password);
	public void logout();
	public int register(String userName, String password, String firstName, String lastName, String email, String phone);
	
	public User getAccInfo();
	public int UpdateAccInfo(User u, String password, String email, String phone);

}
