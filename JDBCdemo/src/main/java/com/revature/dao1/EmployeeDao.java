package com.revature.dao1;

import java.util.List;

import com.revature.model.Department;
import com.revature.model.Employee;

public interface EmployeeDao {

	public List<Employee> getEmployees();
	public Department getEmployeesById(int id);
	public int createEmployee(Employee e);
	public int updateEmployee(Employee e);
	public int deleteEmployee(Employee e);

	
}
