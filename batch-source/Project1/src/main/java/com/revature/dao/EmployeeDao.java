package com.revature.dao;

import java.util.List;

import com.revature.model.Employee;

public interface EmployeeDao {
	
	public List<Employee> getAllEmployee();
	public Employee getEmployeeById(int id);
	public int createNewEmployee(Employee e);
	public int deleteEmployee(Employee e);
	public int updateEmployee(Employee e);
	public Employee getEmployeeByUserNameAndPassWord(String username, String password);
	
			
}
