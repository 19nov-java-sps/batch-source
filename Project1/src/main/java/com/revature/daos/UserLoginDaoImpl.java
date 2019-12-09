package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import com.revature.models.UserLogin;
import com.revature.util.ConnectionUtil;

public class UserLoginDaoImpl implements UserLoginDao {

	@Override
	public List<UserLogin> getUsers() {
		String sql = "select * from employees";
		List<UserLogin> users = new ArrayList<>();
		
		try (Connection c = ConnectionUtil.getConnection();
				Statement s = c.createStatement();
				ResultSet rs = s.executeQuery(sql)) {
			
			while(rs.next()) {
				int user_id = rs.getInt("userid");
				String email = rs.getString("email");
				String name = rs.getString("name");
				String passWord = rs.getString("passwordo");
				String employeetype = rs.getString("employeetype");
				int reportsto = rs.getInt("reportsto");
				UserLogin u = new UserLogin(user_id, email, passWord, name, employeetype, reportsto);
				users.add(u);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return users;
	}

	@Override
	public UserLogin getUserById(int id) {
		
			String sql = "select * from employees where userid = ?";
			UserLogin u = null;
			
			try (Connection c = ConnectionUtil.getConnection();
					PreparedStatement ps = c.prepareStatement(sql)) {
				ps.setInt(1, id);
				ResultSet rs = ps.executeQuery();
				
				if(rs.next()) {
					int user_id = rs.getInt("userid");
					String email = rs.getString("email");
					String name = rs.getString("name");
					String passWord = rs.getString("passwordo");
					String employeetype = rs.getString("employeetype");
					int reportsto = rs.getInt("reportsto");
					u = new UserLogin(user_id, email, passWord, name, employeetype, reportsto);
					
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			return u;
		}
	


	@Override
	public UserLogin getUserByUserName(String user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserLogin getUserByEmailAndPassword(String email, String password) {
		String sql = "select * from employees where email = ? and passwordo = ?";
		UserLogin u = null;
		try(Connection c = ConnectionUtil.getConnection();
        		PreparedStatement ps = c.prepareStatement(sql)) {
        	ps.setString(1, email);
        	ps.setString(2, password);
        	ResultSet rs = ps.executeQuery();
        	
        	if (rs.next()) {
        		int user_id = rs.getInt("userid");
				String name = rs.getString("name");
				String employeetype = rs.getString("employeetype");
				int reportsto = rs.getInt("reportsto");
		
				
				u = new UserLogin(user_id, email, password, name, employeetype, reportsto);				
				return u;
        	}
        	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	

	@Override
	public int updateUser(String name,String email, String password, int id) {
		int updated = 0;
		

		
		String sql = "update employees set email=? , name=?,passwordo=? where userid = ?";
		
		try(Connection c = ConnectionUtil.getConnection();
				PreparedStatement ps = c.prepareStatement(sql)){
			
			ps.setString(1, email);
			ps.setString(3, password);
			ps.setString(2, name);
			ps.setInt(4, id);
			updated = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return updated;
	}

	

	

	

	



}
