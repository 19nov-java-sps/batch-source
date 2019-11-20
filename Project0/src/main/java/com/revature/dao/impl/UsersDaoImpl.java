package com.revature.dao.impl;

import java.sql.*;
import java.util.*;

import com.revature.dao.UsersDao;
import com.revature.model.Users;
import com.revature.util.ConnectionUtil;



public class UsersDaoImpl implements UsersDao {
	@Override
	public List<Users> getUsers() {
		String sql =  "select * from Users";
		List<Users> u = new ArrayList<>();
		
		try (Connection c = ConnectionUtil.getConnection();
				Statement s = c.createStatement();
				ResultSet  rs = s.executeQuery(sql)) {
			
			while(rs.next()) {
				int id = rs.getInt("user_id");
				String username = rs.getString("username");
				String email = rs.getString("email");
				String password = rs.getString("password");
				Users user = new Users(id, username, email, password);
				u.add(user);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return u;
	}
	
	@Override
	public int createUsers(Users u) {
		String sql = "insert into Users (user_id, username, email, password) values (?, ?, ?, ?)";
		int success = 0;
		
		try(Connection c = ConnectionUtil.getConnection();
			PreparedStatement ps = c.prepareStatement(sql)){
				ps.setInt(1, u.getId());
				ps.setString(2, u.getUsername());
				ps.setString(3, u.getEmail());
				ps.setString(4, u.getPassword());
			
				success = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return success;	// returns a 1 to then check if the user was created or not.
	}


	@Override
	public Users getUsers(String username) {
		String sql = "select * from Users u where u.username = ?";
		Users u = new Users();
		
		try(Connection c = ConnectionUtil.getConnection();
				PreparedStatement ps = c.prepareStatement(sql)){
			
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				u.setUsername(rs.getString("username"));
				u.setEmail(rs.getString("email"));
				u.setPassword(rs.getString("password"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return u;



	

}
}
