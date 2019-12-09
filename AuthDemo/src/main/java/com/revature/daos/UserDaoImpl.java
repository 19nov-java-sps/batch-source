package com.revature.daos;


import java.sql.*;
import java.util.*;

import com.revature.daos.UserDao;
import com.revature.models.Pending;
import com.revature.models.User;
import com.revature.util.ConnectionUtil;


public class UserDaoImpl implements UserDao {
	private static UserDaoImpl instance;
	
	private List<User> u = new ArrayList<>();		

	public UserDaoImpl() {
		this.getUsers();
		System.out.print( "Loaded " + u.size() + " users");
	}
	
    public static UserDaoImpl getInstance( ) {
    	if( instance == null ) {
    		instance = new UserDaoImpl();
    	}
		return instance;
	}
	
	@Override
	public List<User> getUsers() {
		String sql =  "select * from Users";
		
		for( int ntry=0; ntry < 5; ntry++) {
		
		try (Connection c = ConnectionUtil.getConnection();
				Statement s = c.createStatement();
				ResultSet  rs = s.executeQuery(sql)) {
			
			while(rs.next()) {
				int id = rs.getInt("user_id");
				String username = rs.getString("username");
				String password = rs.getString("password");
				String userRole = rs.getString("role");
				User user = new User(id, username, password, userRole);
				u.add(user);
			}
			break;
			
		} catch (SQLException e) {
			if(ntry == 4) {
				e.printStackTrace();
			}
		} }
		return u;
	}

	@Override
	public List<User> getAll() {
		return u;
	}

	@Override
	public User getUserById(int id) {
		for(User u: u) {
			if(u.getId() == id) {
				return u;
			}
		}
		return null;
	}
	
	

	@Override
	public User getUserByUsernameAndPassword(String username, String password) {
		for(User u: u) {
			if(u.getUsername() != null && u.getUsername().equals(username)) {
				if(u.getPassword() != null && u.getPassword().equals(password)) {
					return u;
				}
			}
		}
		return null;
	}

	@Override
	public int updateUser(String username, String role, String password, int id) {
		String sql = "update Users set username = ?, role = ?, password = ? where user_id =  ?";
		int updatedUser = 0;
		
		try (Connection c = ConnectionUtil.getConnection();
				PreparedStatement ps = c.prepareStatement(sql)){
			ps.setString(1, username);
			ps.setString(2, role);
			ps.setString(3, password);
			ps.setInt(4, id);
			updatedUser = ps.executeUpdate();
			u.clear();
			getUsers();
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return updatedUser;
	}


}
	