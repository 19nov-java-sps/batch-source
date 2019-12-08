package com.revature.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import com.revature.model.Employees;


public interface EmployeeDao {
	
	public List<Employees> getEmployees();
	public Employees getEmployeeById(int id);
	public boolean createEmployee(Employees e) throws SQLException;
	//public boolean updateEmployee(Employee e);
	public int deleteEmployee(int id);
	public Employees Login(String email, String password) throws SQLException;
	public void updateEmployee(Employees e) throws SQLException;
}
