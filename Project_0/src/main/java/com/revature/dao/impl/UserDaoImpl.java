package com.revature.dao.impl;

import java.sql.CallableStatement;
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
	public int createUser(User u) {
		
		// using parameterized statement in order to avoid SQL injection.
		String sql = "insert into Users (user_name, pass_word, first_name, last_name, user_balance) values (?, ?, ?, ?, ?)";
		int usersCreated = 0;
		
		try(Connection c = ConnectionUtil.getConnection();
				PreparedStatement ps = c.prepareStatement(sql)){
			
			ps.setString(1, u.getUsername());
			ps.setString(2, u.getPassword());
			ps.setString(3, u.getFirstName());
			ps.setString(4, u.getLastName());
			ps.setDouble(5, u.getBalance());
			
			usersCreated = ps.executeUpdate();	// stores a 1 which refers to the updated rows in SQL.
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return usersCreated;	// returns a 1 to then check if the user was created or not.
	}

	@Override
	public boolean updateUser(String username, double newBalance) {
		
		String sql = "{ call updateBalance(?,?) }";
		boolean userCreated = false;
		
		// Using callable statement to call an SQL function.
		try(Connection c = ConnectionUtil.getConnection();
				CallableStatement cs = c.prepareCall(sql)){
			
			cs.setString(1, username);
			cs.setDouble(2, newBalance);
			userCreated = cs.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return userCreated;
	}

	@Override
	public int deleteUser(String username) {
		
		String sql = "delete from users u where u.user_name = ?";
		int userDeleted = 0;
		
		try(Connection c = ConnectionUtil.getConnection();
				PreparedStatement ps = c.prepareStatement(sql)){
			
			ps.setString(1, username);
			userDeleted = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return userDeleted;
	}

	@Override
	public User getUser(String username) {
		
		String sql = "select * from Users u where u.user_name = ?";
		User u = new User();
		
		try(Connection c = ConnectionUtil.getConnection();
				PreparedStatement ps = c.prepareStatement(sql)){
			
			ps.setString(1, username);
			//ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			
			// if there is a result then set everything and return it.
			if (rs.next()) {
				u.setUsername(rs.getString("user_name"));
				u.setPassword(rs.getString("pass_word"));
				u.setFirstName(rs.getString("first_name"));
				u.setLastName(rs.getString("last_name"));
				u.setBalance(rs.getDouble("user_balance"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return u;
	}

	@Override
	public List<User> getUserTable() {
		
		String sql = "select * from users";
		List<User> userTable = new ArrayList<>();	// Used to store all the users.
		
		try(Connection c = ConnectionUtil.getConnection();
				Statement s = c.createStatement();
				ResultSet rs = s.executeQuery(sql)){
			
				// Keeps on looping until it doesn't see any more users.
				while (rs.next()) {
					String username = rs.getString("user_name");
					String password = rs.getString("pass_word");
					String firstName = rs.getString("first_name");
					String lastName = rs.getString("last_name");
					double balance = rs.getDouble("user_balance");
					User u = new User(username, password, firstName, lastName, balance);
					userTable.add(u);
				}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return userTable;
	}
	
	

}
