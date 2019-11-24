package com.rev.dao;
import java.util.List;
import com.rev.model.User;



public interface UserLogInDao {
	public List<User> getUsers();
	public User getUserById(int id);
	public int createUser(User u);
	public int updateUser(User u);
	public int deleteUser(User u);
	public User getUserByUserName(String user);
}
