package com.revature.services;

import java.sql.SQLException;
import java.util.Scanner;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import com.revature.models.Employee;
import com.revature.services.EmployeeService;
import com.revature.util.ConnectionUtil;
import java.util.List;

import com.revature.dao.impl.EmployeeDaoImpl;
import com.revature.daos.EmployeeDao;
import com.revature.models.Employee;

public class EmployeeService {
	
	EmployeeDao empDao = new EmployeeDaoImpl();
	
	public List<Employee> getEmployees(){
		return empDao.getEmployees();
	}
	
	public Employee getById(int id) {
		return empDao.getEmployeeById(id);
	}
	
	public boolean create(Employee e) throws SQLException {
		return empDao.createEmployee(e);
	}
	public Employee Login(String email, String password) throws SQLException {
		return empDao.Login(email, password);
	}
	
	public void updateEmployee(Employee e) throws SQLException{
		empDao.updateEmployee(e);
	}
}
