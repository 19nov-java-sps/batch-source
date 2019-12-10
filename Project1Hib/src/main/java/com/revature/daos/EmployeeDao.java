package com.revature.daos;

import java.util.List;

import com.revature.models.Employee;

public interface EmployeeDao {
	
	public List<Employee> getEmployees();
	public Employee getEmployeeByUsername(String username);
	public Employee getEmployeeById(int emp_id);
	public int updateEmployee(String fName, String lName, int emp_id);
}
