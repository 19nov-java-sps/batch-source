package com.revature.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.dao.UsersDao;
import com.revature.model.Department;
import com.revature.model.Users;
import com.revature.util.ConnectionUtil;

public class UsersDaoImpl implements UsersDao {
	
	public List<Users> getUsers() {
		String sql = "select * from users";
		List<Users> users = new ArrayList<>();
		
		try (Connection c = ConnectionUtil.getConnection();
				Statement s = c.createStatement();
				ResultSet rs = s.executeQuery(sql)) {
			
			while(rs.next()) {
				int userId = rs.getInt("userId");
				String firstName = rs.getString("firstname");
				String lastName = rs.getString("lastname");
				String email= rs.getString("emailaddress");
				String password=rs.getString("pass");
				Users d = new Users(firstName, lastName,userId,email,password);
				users.add(d);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return users;
	}


	@Override
	public boolean createUser(Users user) throws SQLException {
	
		String sql3 = "Select emailaddress from users";
		ResultSet rs;
		try (Connection c = ConnectionUtil.getConnection();
				PreparedStatement ps = c.prepareStatement(sql3)) {
			
			rs=ps.executeQuery();
		
		
		
	
		while(rs.next()) {
			
			 if(rs.getString("emailaddress").equalsIgnoreCase(user.getEmailAddress())) {
				 
				 return false;

			}
			 
		}
	
			
		
		}
		


	
		
		
	
			String sql = "insert into Users (userid,firstname, lastname, emailaddress, pass) VALUES (? ,? ,?,?,?)";
			
			try (Connection c = ConnectionUtil.getConnection();
					PreparedStatement ps = c.prepareStatement(sql)) {
				ps.setInt(1, user.getUserId());
				ps.setString(2,  user.getFirstName());
				ps.setString(3,  user.getLastName());
				ps.setString(4, user.getEmailAddress());
				ps.setString(5, user.getPassword());
				ps.executeUpdate();
			
			}
			
		
			
			 
	
			
			return true;
			
			 }


	public boolean isRegistered(String email, String password) throws SQLException {
		String sql = "Select emailaddress, pass from users where emailaddress=?";
		boolean result=false;
		ResultSet rs;
		try (Connection c = ConnectionUtil.getConnection();
				PreparedStatement ps = c.prepareStatement(sql)) {
			ps.setString(1,email);
			rs=ps.executeQuery();
		
		
		
	while(rs.next()) {
		
			if(rs.getString("pass").equals(password)) {
				result=true;
			}
			
			
		
		else {
			result=false;
		}
			
	}
		return result;
	
	}

	}

}
	


