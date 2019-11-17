package com.revature.dao.impl;

import java.sql.Connection;
import java.sql.SQLException;

import com.revature.Driver;
import com.revature.dao.UserDao;
import com.revature.util.ConnectionUtil;

public class UserDaoImpl implements UserDao {
		
	@Override
	public boolean login(String userName, String password) {
		
        try(Connection c = ConnectionUtil.getConnection();
        		) {
        	if (userName.equals("user1") && password.equals("123456")) {
				Driver.setLogin(true);
        		return true;
        	}
		} catch (SQLException e) {
			e.printStackTrace();
		}
        
		return false;
	}

	@Override
	public void logout() {

		Driver.setLogin(false);
	}

	@Override
	public boolean register(String userName, String password, String firstName, String lastName, String email,
			String phone) {
		// TODO Auto-generated method stub
		System.out.println("Register Successful!");
		return true;
	}

	@Override
	public String getUserInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String UpdateUserInfo(String password, String firstName, String lastName, String email, String phone) {
		// TODO Auto-generated method stub
		return null;
	}

}
