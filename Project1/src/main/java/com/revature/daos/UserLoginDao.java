package com.revature.daos;
import com.revature.models.*;
import java.util.List;

public interface UserLoginDao {
	public List<UserLogin> getUsers();
	public UserLogin getUserById(int id);
	public int updateUser(String email, String password,String name, int id);
	public UserLogin getUserByUserName(String user);
	public UserLogin getUserByEmailAndPassword(String email, String password);
}
