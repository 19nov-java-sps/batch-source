package com.revature.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.revature.dao.AccountDao;
import com.revature.model.Department;
import com.revature.model.Employee;
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

@RunWith(MockitoJUnitRunner.class)
public class AccountServiceTest {
	
	@InjectMocks
	private AccountDaoImpl ed;
	
	@Mock
private AccountService es;
	

	
	
	
}

