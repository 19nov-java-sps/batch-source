package com.revature.daos;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import com.revature.models.Employee;
import com.revature.services.EmployeeService;
import com.revature.util.ConnectionUtil;
import com.revature.models.Employee;

public interface EmployeeDao {
	
	public List<Employee> getEmployees();
	public Employee getEmployeeById(int id);
	public boolean createEmployee(Employee e) throws SQLException;
	//public boolean updateEmployee(Employee e);
	public int deleteEmployee(int id);
	public Employee Login(String email, String password) throws SQLException;
	public void updateEmployee(Employee e) throws SQLException;
}
