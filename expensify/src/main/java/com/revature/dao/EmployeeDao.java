package com.revature.dao;

import java.util.List;

import com.revauture.model.Employee;

public interface EmployeeDao {
	
	public List<Employee> getEmployees(Employee e);
	public Employee getEmployeeById(int id);
	public int createEmployee(Employee e);
	public int updateEmployee(Employee e);
	public int deleteEmployee(Employee e);
	
}
