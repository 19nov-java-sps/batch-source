package com.revature.dao;

import java.util.List;

import com.revauture.model.Employee;

public interface EmployeeDao {
	
	public List<Employee> getEmployees();
	public Employee getEmployeeById(int id);
	public int createEmployee(Employee e);
	public int updateEmployee(Employee e);
	public int deleteEmployee(Employee e);
	
//	public List<Employee> dummyEmployeesList();
//	public Employee dummyEmployee(int id);
	public Employee getUserByUsernameAndPassword(String username, String password);

}
