package com.revature.daos.impls;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.daos.UserAccDao;
import com.revature.models.UserAcc;
import com.revature.util.ConnectionUtil;

public class UserAccDaoImpl implements UserAccDao{

	@Override
	public List<UserAcc> getAll() {
		// TODO Auto-generated method stub
		String sql = "select * from user_acc";
		List<UserAcc> myUserAcc = new ArrayList<>();
		
		try(Connection c = ConnectionUtil.getConnection();
				Statement s = c.createStatement();
				ResultSet rs = s.executeQuery(sql)){
			
			while(rs.next()) {
				int user_id = rs.getInt("user_id");
				String user_name = rs.getString("user_name");
				String pass_word = rs.getString("pass_word");
				String user_role = rs.getString("user_role");
				UserAcc ua = new UserAcc(user_id, user_name, pass_word, user_role);
				myUserAcc.add(ua);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return myUserAcc;
	}

	@Override
	public UserAcc getUserById(int id) {
		// TODO Auto-generated method stub
		String sql = "select * from user_acc";
		List<UserAcc> myUserAcc = new ArrayList<>();
		
		try(Connection c = ConnectionUtil.getConnection();
				Statement s = c.createStatement();
				ResultSet rs = s.executeQuery(sql)){
			
			while(rs.next()) {
				int user_id = rs.getInt("user_id");
				String user_name = rs.getString("user_name");
				String pass_word = rs.getString("pass_word");
				String user_role = rs.getString("user_role");
				UserAcc ua = new UserAcc(user_id, user_name, pass_word, user_role);
				myUserAcc.add(ua);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		for(UserAcc u : myUserAcc) {
			if(u.getUser_id() == id) {
				return u;
			}
		}
		return null;
	}

	@Override
	public UserAcc getuserByUserAndPass(String username, String password) {
		// TODO Auto-generated method stub
		String sql = "select * from user_acc";
		List<UserAcc> myUserAcc = new ArrayList<>();
		
		try(Connection c = ConnectionUtil.getConnection();
				Statement s = c.createStatement();
				ResultSet rs = s.executeQuery(sql)){
			
			while(rs.next()) {
				int user_id = rs.getInt("user_id");
				String user_name = rs.getString("user_name");
				String pass_word = rs.getString("pass_word");
				String user_role = rs.getString("user_role");
				UserAcc ua = new UserAcc(user_id, user_name, pass_word, user_role);
				myUserAcc.add(ua);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		for(UserAcc u : myUserAcc) {
			if(u.getuser_name() != null && u.getuser_name().equals(username)) {
				if(u.getPass_word() !=null && u.getPass_word().equals(password)) {
					return u;
				}
			}
		}
		return null;
	}

	
}
