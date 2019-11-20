package com.revature.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.revature.dao.UserAccDao;
import com.revature.model.UserAcc;
import com.revature.util.ConnectionUtil;

public class UserAccDaoImpl implements UserAccDao{

	@Override
	public int createUserAccount(UserAcc ua) {
		// TODO Auto-generated method stub
		String sql = "insert into user_acc (user_name, pass_word) values(?,?)";
		int userCreated = 0;
		try (Connection c = ConnectionUtil.getConnection();
				PreparedStatement ps = c.prepareStatement(sql);){
			ps.setString(1, ua.getUserName());
			ps.setString(2, ua.getPassword());
			userCreated = ps.executeUpdate();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return userCreated;
	}

	@Override
	public int getUserId(String username) {
		// TODO Auto-generated method stub
		String sql = "select * from user_acc where user_name = ?";
		int userid =0;
		try(Connection c = ConnectionUtil.getConnection();
				PreparedStatement ps = c.prepareStatement(sql)){
			
			ps.setString(1, username);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				userid = rs.getInt("user_id");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return userid;
	}

	@Override
	public boolean verifyLogin(String username, String password) {
		// TODO Auto-generated method stub
		String sql = "select * from user_acc";
		try(Connection c = ConnectionUtil.getConnection();
				Statement s = c.createStatement();
				ResultSet rs = s.executeQuery(sql)){
			
			while(rs.next()) {
				String getUsername = rs.getString("user_name");
				String getPassword = rs.getString("pass_word");
				if (username.equals(getUsername) && password.equals(getPassword)) {
					return true;
				}
				
			}
			
		} catch (SQLException e) {
			
		}
		return false;
	}


}
