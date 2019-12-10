package com.revature.daos;

import java.util.List;

import com.revature.models.Employee;

public interface EmployeeDao {
	
	public List<Employee> getEmployees();
	public Employee getEmployeeByUsername(String username);
	public int updateEmployee(String fName, String lName, int emp_id);
}
