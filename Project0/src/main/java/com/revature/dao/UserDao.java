package com.revature.dao;

public interface UserDao {

	public boolean login(String userName, String password);
	public void logout();
	public boolean register(String userName, String password, String firstName, String lastName, String email, String phone);
	
	public String getUserInfo();
	public String UpdateUserInfo(String password, String firstName, String lastName, String email, String phone);

}
