package com.rev.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.rev.dao.UserLogInDao;
import com.rev.model.AccountInfo;
import com.rev.model.User;
import com.rev.util.ConnectionUtil;

public class UserLogInDaoImpl implements UserLogInDao {


	public List<User> getUsers() {
		String sql = "select * from userlogin";
		List<User> users = new ArrayList<>();
		
		try (Connection c = ConnectionUtil.getConnection();
				Statement s = c.createStatement();
				ResultSet rs = s.executeQuery(sql)) {
			
			while(rs.next()) {
				int account_id = rs.getInt("UserID");
				String account_balance = rs.getString("UserName");
				String user_id = rs.getString("PassWordo");
				User u = new User(account_id, account_balance, user_id);
				users.add(u);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return users;
	}

	public User getUserById(int id) {
		String sql = "select * from userlogin where userid = ?";
		User u = null;
		
		try (Connection c = ConnectionUtil.getConnection();
				PreparedStatement ps = c.prepareStatement(sql)) {
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				int account_id = rs.getInt("UserID");
				String account_balance = rs.getString("UserName");
				String user_id = rs.getString("PassWordo");
				u = new User(account_id, account_balance, user_id);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return u;
	}
	
	
	public User getUserByUserName(String user) {
		String sql = "select * from userlogin where username = ?";
		User u = null;
		
		try (Connection c = ConnectionUtil.getConnection();
				PreparedStatement ps = c.prepareStatement(sql)) {
			ps.setString(1, user);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				int account_id = rs.getInt("UserID");
				String account_balance = rs.getString("UserName");
				String user_id = rs.getString("PassWordo");
				u = new User(account_id, account_balance, user_id);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return u;
	}
	
	
	

	
	
	
	public int createUser(User u) {
		String sql = "insert into userlogin (username,passwordo) values (?, ?)";
		int usersCreated = 0;
		
		try(Connection c = ConnectionUtil.getConnection();
				PreparedStatement ps = c.prepareStatement(sql)){
			ps.setString(1, u.getUserName());
			ps.setString(2, u.getPassWord());
			
			usersCreated = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return usersCreated;
	}

	
	
	
	public int updateUser(User u) {
		int usersUpdated = 0;
		String sql = "update userlogin set username = ?, passwordo=? where userid = ?";
		
		try(Connection c = ConnectionUtil.getConnection();
				PreparedStatement ps = c.prepareStatement(sql)){
			
			ps.setString(1, u.getUserName());
			ps.setString(2,u.getPassWord());
			ps.setInt(3,u.getUser_id());
			usersUpdated = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return usersUpdated;
	}

	public int deleteUser(User u) {
		// TODO Auto-generated method stub
		return 0;
	}

}
