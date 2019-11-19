package com.revature.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.dao.UserDao;
import com.revature.model.Account;
import com.revature.model.User;
import com.revature.util.ConnectionUtil;

public class UserDaoImpl implements UserDao {

	public List<User> getUsers() {
		String sql = "select * from  Users";
		List<User> users = new ArrayList<>();
		
		try(Connection c = ConnectionUtil.getConnection();
				Statement s = c.createStatement();
				ResultSet rs = s.executeQuery(sql)){
			
			while(rs.next()) {
				int userId = rs.getInt("user_id");
				String firstName = rs.getString("first_name");
				String lastName = rs.getString("last_name");
				String userName = rs.getString("user_name");
				String passWord = rs.getString("pass_word");
				String email = rs.getString("email");
				User u = new User(userId, firstName, lastName, userName, passWord, email);
				users.add(u);
			}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		
		return users;
	}
		
	@Override
	public int createUser(User u) {
		String sql = "insert into Users (first_name, last_name, user_name, pass_word, email) values (?,?,?,?,?)";
		int userCreated = 0;
		
		try(Connection c = ConnectionUtil.getConnection();
				PreparedStatement ps = c.prepareStatement(sql)){
			ps.setString(1, u.getFirstName());
			ps.setString(2, u.getLastName());
			ps.setString(3, u.getUserName());
			ps.setString(4, u.getPassWord());
			ps.setString(5, u.getEmail());
			
			userCreated = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return userCreated;
	}

	@Override
	public User getUserById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getUserByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User verifyUserByPassword(String username, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateUser(User u) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int addUser(User u) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteUser(User u) {
		// TODO Auto-generated method stub
		return 0;
	}
}
