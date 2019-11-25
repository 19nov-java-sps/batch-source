package com.revature.service;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.List;

import com.revature.dao.UserDao;
import com.revature.dao.impl.UserDaoImpl;
import com.revature.model.User;
import com.revature.util.ConnectionUtil;


/*******************************************
1. Check user name uniqueness
2. Verify(compare) user's name and password with saved in the database CALLABLE STATEMENT
3. Withdraw money
 *******************************************/

public class UserService {
	
	//Check uniqueness of the user name
		public int checkUserUniqueness (String userName) throws SQLException {
			String sql = "select findUserIdByUserName(?)";
			
			int result = 0;
			try(Connection c = ConnectionUtil.getConnection();
					PreparedStatement ps = c.prepareStatement(sql)){
					ps.setString(1, userName);
					ResultSet rs = ps.executeQuery();
					
				while(rs.next()) {
					   result = rs.getInt("finduseridbyusername");
					}
				}
						return result;	
			}
		
		//Verifies an user using function in database
		public boolean UserVerification (String userName, String passWord) {
			String sql = "{ call validateUser(?,?)}";
			boolean result = false;
			try(Connection c = ConnectionUtil.getConnection();
					CallableStatement cs = c.prepareCall(sql)){
				cs.setString(1, userName);
				cs.setString(2, passWord);
				cs.registerOutParameter(1, java.sql.Types.BOOLEAN);
				boolean rs = cs.execute();
				 result=cs.getBoolean(1);
				} catch (SQLException e) {
				e.printStackTrace();
			}
			
			return result;
			
		}
		
	//***************************************************************	
	
	private UserDao userDao = new UserDaoImpl();

	public List<User> getUsers() {
		return userDao.getUsers();
	}
	
	public boolean createUser(User u) {
		int userCreated = userDao.createUser(u);
		if(userCreated != 0) {
		return true;
		}
		return false;
	}

	public User getUserById(int id) {
		return userDao.getUserById(id);
	}
	
}
	





		
		




