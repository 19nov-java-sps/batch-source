package com.revature.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.revature.Driver;
import com.revature.dao.UserDao;
import com.revature.model.User;
import com.revature.util.ConnectionUtil;

public class UserDaoImpl implements UserDao {
		
	@Override
	public boolean login(String user, String password) {
		
		String sql = "";
		
		if (user.matches("^(.+)@(.+)$")) {
			sql = "select \"UserName\", \"Password\", \"AccountNumber\" from \"User\" where \"Email\" = ? and \"Password\" = ?";
		} else {
			sql = "select \"UserName\", \"Password\", \"AccountNumber\" from \"User\" where \"UserName\" = ? and \"Password\" = ?";
		}
		
		try(Connection c = ConnectionUtil.getConnection();
        		PreparedStatement ps = c.prepareStatement(sql)) {
        	
        	ps.setString(1, user);
        	ps.setString(2, password);
        	ResultSet rs = ps.executeQuery();
        	
        	if (rs.next()) {
        		String accountNum = rs.getString("AccountNumber");
        		Driver.setAccount(accountNum);
        		return true;
        	}
        	
		} catch (SQLException e) {
			e.printStackTrace();
		}
        
		return false;
	}

	@Override
	public void logout() {

		Driver.setAccount(null);
	}

	@Override
	public int register(String userName, String password, String firstName, String lastName, String email,
			String phone) {
		// TODO Auto-generated method stub
		System.out.println("Register Successful!");
		return 1;
	}

	@Override
	public User getAccInfo() {
		
		User user = null;
		
//		String sql = "select \"UserId\", \"FirstName\", \"LastName\", \"UserName\", \"Email\", \"Phone\", \"AccountNumber\", \"AccountBalance\" from \"User\" where \"AccountNumber\" = '123456789'";
		String sql = "select * from \"User\" where \"AccountNumber\" = " + Driver.getAccount();
		
		try (Connection c = ConnectionUtil.getConnection();
				Statement s = c.createStatement();
				ResultSet rs = s.executeQuery(sql)){
			
			if (rs.next()) {
				int id = rs.getInt("UserId");
				String firstName = rs.getString("FirstName");
				String lastName = rs.getString("LastName");
				String userName = rs.getString("UserName");
				String password = rs.getString("Password");
				String email = rs.getString("Email");
				String phone = rs.getString("Phone");
				String accountNum = rs.getString("AccountNumber");
				double balance = rs.getDouble("AccountBalance");
				
				user = new User(id, firstName, lastName, userName, password, email, phone, accountNum, balance);
			}
			
			return user;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public int UpdateAccInfo(String password, String firstName, String lastName, String email, String phone) {
		// TODO Auto-generated method stub
		return 1;
	}

}
