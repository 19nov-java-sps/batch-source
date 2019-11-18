package com.revature.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.ThreadLocalRandom;

import com.revature.Driver;
import com.revature.dao.UserDao;
import com.revature.model.User;
import com.revature.util.ConnectionUtil;
import com.revature.util.ValidateInputUtil;

public class UserDaoImpl implements UserDao {
		
	@Override
	public boolean login(String user, String password) {
		
		String sql = "";
		
		if (user.matches("^(.+)@(.+)$")) { // matches email
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
		
		int userCreated = 0;
		String accNumString = "";
		double balance = 0;
		
		// random generate account number
		for (int i = 0; i < 9; i++) {
			int random = ThreadLocalRandom.current().nextInt(0, 10);
			accNumString += random;
		}
		int accNum = Integer.parseInt(accNumString);
		
		// check username, email, phone uniqueness
		if (ValidateInputUtil.checkUserName(userName) == false || ValidateInputUtil.checkEmail(email) == false || ValidateInputUtil.checkPhoneNum(phone) == false) {
			return userCreated;
		}

		
		String sql = "insert into \"User\" (\"FirstName\", \"LastName\", \"UserName\", \"Password\", \"Email\", \"Phone\", \"AccountNumber\", \"AccountBalance\") values (?, ?, ?, ?, ?, ?, ?, ?)";
		
		try(Connection c = ConnectionUtil.getConnection();
				PreparedStatement ps = c.prepareStatement(sql)) {
			
			ps.setString(1, firstName);
			ps.setString(2, lastName);
			ps.setString(3, userName);
			ps.setString(4, password);
			ps.setString(5, email);
			ps.setString(6, phone);
			ps.setInt(7, accNum);
			ps.setDouble(8, balance);
			
			userCreated = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
				
		return userCreated;
	}

	@Override
	public User getAccInfo() {
		
		User user = null;

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
	public int UpdateAccInfo(User u, String password, String email, String phone) {
		
		int accUpdated = 0;
		
		if (email.equals("") == false && email.equals(u.getEmail()) == false && ValidateInputUtil.checkEmail(email) == false) {
			return accUpdated;
		}
		
		if (phone.equals("") == false && phone.equals(u.getPhone()) == false && ValidateInputUtil.checkPhoneNum(phone) == false) {
			return accUpdated;
		}
		
		if (password.equals("") == false) {
			u.setPassword(password);
		}
		if (email.equals("") == false) {
			u.setEmail(email);
		}
		if (phone.equals("") == false) {
			phone = phone.replaceFirst("(\\d{3})(\\d{3})(\\d+)", "($1) $2-$3");
			u.setPhone(phone);
		}
		
		String sql = "update \"User\" set \"Password\" = ?, \"Email\" = ?, \"Phone\" = ? where \"AccountNumber\" = " + Driver.getAccount();
		try(Connection c = ConnectionUtil.getConnection();
        		PreparedStatement ps = c.prepareStatement(sql)) {
        	
        	ps.setString(1, u.getPassword());
        	ps.setString(2, u.getEmail());
        	ps.setString(3, u.getPhone());
        	
        	accUpdated = ps.executeUpdate();
        	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return 1;
	}

}
