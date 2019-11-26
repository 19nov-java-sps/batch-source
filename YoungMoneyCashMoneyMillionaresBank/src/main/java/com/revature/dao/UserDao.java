package com.revature.dao;
import java.util.List;

import com.revature.model.User;

public interface UserDao {

	public List<User> getUser();
	
	public User getUserById (int id);
	
	public int createUser(User u);

	public int updateUser(User u);

	public int deleteUser(User u);

}
