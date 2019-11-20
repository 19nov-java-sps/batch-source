package com.revature.service;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import com.revature.dao.UsersDao;
import com.revature.dao.impl.AccountDaoImpl;
import com.revature.model.Account;
import com.revature.model.Department;
import com.revature.model.Users;
import com.revature.service.AccountService;
import com.revature.service.DepartmentService;
import com.revature.service.UserService;
import com.revature.util.ConnectionUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import com.revature.dao.UsersDao;
import com.revature.dao.impl.AccountDaoImpl;
import com.revature.model.Account;
import com.revature.model.Department;
import com.revature.model.Users;
import com.revature.service.AccountService;
import com.revature.service.DepartmentService;
import com.revature.service.UserService;
import com.revature.util.ConnectionUtil;
public class UserServiceTest {
	
	private static final UserService UserService = new UserService();

	

	/*******************************************************************
	 * Question 1
	 * @throws SQLException 
	 ******************************************************************/
	
	@Test
	public void checkFirstName() throws SQLException {
		String expected="Paulie";
		UserService service= new UserService();
		Users user= new Users("Paulie", "Smith", 500, "smithington@gmail.com", "what");
	
		assertEquals(expected,user.getFirstName());
		
	}
	
	@Test
	public void checkLastName() throws SQLException {
		String expected="Smith";
		UserService service= new UserService();
		Users user= new Users("Paulie", "Smith", 500, "smithington@gmail.com", "what");
	
		assertEquals(expected,user.getLastName());
		
	}
	

	
}


