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
	
	
	@Override
	public List<User> getUserTable(){
		String sql = "select * from users"; // assigns SQL statement to a string
		List<User> userTable = new ArrayList<>(); // creates a new ArrayList type object to store result of the database query
		
		try (Connection c = ConnectionUtil.getConnection(); // establishes a connection to the database
				Statement s = c.createStatement(); // creates a statement which is used to send an SQL statement to be executed in our database
				ResultSet rs = s.executeQuery(sql)) { // stores the result when we execute the SQL query
			
			// while loop iterates thru the database 
			// gets all the column data & assigns values 
			// to object instance variables
			while(rs.next()) { 
				
				int userId = rs.getInt("user_id");
				String username = rs.getString("user_name");
				String password = rs.getString("pass_word");
				String firstName = rs.getString("first_name");
				String lastName = rs.getString("last_name");
				int invoiceId = rs.getInt("invoice_id");
				boolean isManager = rs.getBoolean("is_manager");
				
				User user = new User(userId, username, password, firstName, lastName, invoiceId, isManager); 
				userTable.add(user);
			}
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		return userTable; // returns an object with all the data from the SQL database query
						  // which in this case would be all the user info in the users table
				
	}
	
	@Override
	public User getUserById(int userId) {
		String sql = "select * from users where user_id = ?";
		User user = new User();
		
		try (Connection c = ConnectionUtil.getConnection(); 
		
				
		// Prepared Statement pre-compiles our SQL statement so we are able 
		// to parameterize our SQL statement without vulnerability to SQL Injection		
		PreparedStatement ps = c.prepareStatement(sql)) { 
			ps.setInt(1, userId);
			ResultSet rs = ps.executeQuery();
			
			
			// if the query returns a result, set each result value 
			// and return the new object	
			while(rs.next()) {
				user.setUserId(rs.getInt("user_id"));
				user.setUsername(rs.getString("user_name"));
				user.setPassword(rs.getString("pass_word"));
				user.setFirstName(rs.getString("first_name"));
				user.setLastName(rs.getString("last_name"));
				user.setInvoiceId(rs.getInt("invoice_id"));
				user.setManager(rs.getBoolean("is_manager"));					
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return user;
	}
	
	
	@Override
	public int createUser(User user) {
		String sql = "insert into users (user_id, user_name, pass_word, first_name, last_name, invoice_id, is_manager ) values (?, ?, ?, ?, ?, ?, ?)";
		int usersCreated = 0; // variable to store the number of updated rows
		
		try(Connection c = ConnectionUtil.getConnection();
				
		PreparedStatement ps = c.prepareStatement(sql)){
			ps.setInt(1, user.getUserId());
			ps.setString(2, user.getUsername());
			ps.setString(3, user.getPassword());
			ps.setString(4, user.getFirstName());
			ps.setString(5, user.getLastName());
			ps.setInt(6, user.getInvoiceId());
			ps.setBoolean(7, user.isManager());
			
			
			usersCreated = ps.executeUpdate(); // stores 1 because we created a new row in the table
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return usersCreated; // returns 1 to let user know a new user was created successfully
	}
	
	
	@Override
	public int updateUser(String firstName, String lastName, int userId) {
		
		int usersUpdated = 0;
		String sql = "update users set first_name = ?, last_name = ? where user_id = ?";
		
		try(Connection c = ConnectionUtil.getConnection();
				
		PreparedStatement ps = c.prepareStatement(sql)){
			
			
			ps.setString(1, firstName);
			ps.setString(2, lastName);
			ps.setInt(3, userId);
			
			
			usersUpdated = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return usersUpdated;
	}
	
	
	@Override
	public int deleteUser(int userId) {
		
		int usersDeleted = 0;
		
		String sql = "delete from users where user_id = ? ";
		
		try(Connection c = ConnectionUtil.getConnection();
		
		PreparedStatement ps = c.prepareStatement(sql)){
			ps.setInt(1, userId);
			usersDeleted = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return usersDeleted;
		
	}

	@Override
	public User getUserByUsernameAndPassword(String username, String password) {
		String sql = "select * from users where user_name = ? and pass_word = ?";
		User user = new User();
		
		try (Connection c = ConnectionUtil.getConnection(); 
		
				
		// Prepared Statement pre-compiles our SQL statement so we are able 
		// to parameterize our SQL statement without vulnerability to SQL Injection		
		PreparedStatement ps = c.prepareStatement(sql)) { 
			ps.setString(1, username);
			ps.setString(2, password);
			
			ResultSet rs = ps.executeQuery();
			
			
			// if the query returns a result, set each result value 
			// and return the new object	
			while(rs.next()) {
				user.setUserId(rs.getInt("user_id"));
				user.setUsername(rs.getString("user_name"));
				user.setPassword(rs.getString("pass_word"));
				user.setFirstName(rs.getString("first_name"));
				user.setLastName(rs.getString("last_name"));
				user.setInvoiceId(rs.getInt("invoice_id"));
				user.setManager(rs.getBoolean("is_manager"));					
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return user;
		
	}

}


