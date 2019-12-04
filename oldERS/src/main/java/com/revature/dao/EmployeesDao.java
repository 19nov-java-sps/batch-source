package com.revature.dao;

import java.util.List;

import com.revature.model.Employees;

public interface EmployeesDao {

	public List<Employees> getAllEmployees();

	public Employees getEmployeesById(int id);
	
	public Employees getUserByUsernameAndPassword(String username, String password);

	public int createEmployee(Employees e);

	public int updateEmployee(Employees e);

	public int deleteEmployee(Employees e);
	
	
	
	public List<Employees> getAllDummies();

	public Employees getDummiesById(int id);
}
