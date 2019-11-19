package com.revature.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.dao.UserDao;
import com.revature.model.User;
import com.revature.util.ConnectionUtil;

public class UserDaoImpl implements UserDao {
	
	
	public List<User> getUser(){
		String sql = "select * from users"; // assigns SQL statement to a string
		List<User> user = new ArrayList<>(); // creates a new ArrayList type object to hold result of the database query
		
		try (Connection c = ConnectionUtil.getConnection(); // establishes a connection to the database
				Statement s = c.createStatement(); // creates a statement which is used to send an SQL statement to be executed in our database
				ResultSet rs = s.executeQuery(sql)) { // stores the result when we execute the SQL query
			
			// while loop iterates thru the database 
			// gets all the column data & assigns values 
			// to object instance variables
			while(rs.next()) {
				int userId = rs.getInt("user_id"); 
				String username = rs.getString("username");
				String password = rs.getString("pass_word");
				User client = new User(username, password, userId); // creates an object representation of the table rows
				user.add(client);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return user; // returns an object with all the data from the SQL database query
	}
	
	
	@Override
	public User getUserById(int id) {
		String sql = "select * from users where user_id = ?";
		User u = null;
		
		try (Connection c = ConnectionUtil.getConnection(); 
				
				// Prepared Statement pre-compiles our SQL statement so we are able 
				// to parameterize our SQL statement without vulnerability to SQL Injection
				PreparedStatement ps = c.prepareStatement(sql)) { 
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				int userId = rs.getInt("user_id");
				String username = rs.getString("username");
				String password = rs.getString("pass_word");
				u = new User(username, password, userId);
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return u;
	}
	

	@Override
	public int createUser(User u) {
		String sql = "insert into users (username, pass_word, user_id ) values (?, ?, ?)";
		int usersCreated = 0;
		
		try(Connection c = ConnectionUtil.getConnection();
				PreparedStatement ps = c.prepareStatement(sql)){
			ps.setString(1, u.getUsername());
			ps.setString(2, u.getPassword());
			ps.setInt(3, u.getUser_id());
			
			
			usersCreated = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return usersCreated;
	}

	@Override
	public int updateUser(User u) {
		String sql = "update users set username = ?, pass_word = ?, user_id = ?";
		int usersUpdated = 0;
		
		try(Connection c = ConnectionUtil.getConnection();
				PreparedStatement ps = c.prepareStatement(sql)){
			ps.setString(1, u.getUsername());
			ps.setString(2, u.getPassword());
			ps.setInt(3, u.getUser_id());
			
			usersUpdated = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return usersUpdated;
	}

	@Override
	public int deleteUser(User u) {
		String sql = "delete from users where user_id = ?";
		int usersDeleted = 0;
		
		try(Connection c = ConnectionUtil.getConnection();
				PreparedStatement ps = c.prepareStatement(sql)){
			ps.setInt(1, u.getUser_id());
			
			usersDeleted = ps.executeUpdate();
			this.getUser();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return usersDeleted;
	}

		
}
	
	

