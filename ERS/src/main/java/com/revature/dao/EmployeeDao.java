package com.revature.dao;

import java.util.List;

import com.revature.models.Employee;

public interface EmployeeDao {

	public List<Employee> getAllEmployees();

	public Employee getEmployeeById(int id);

	public Employee getEmployeeByUsernameAndPassword(String username, String password);

	public int createEmployee(Employee e);

	public int updateEmployee(Employee e);

	public int deleteEmployee(Employee e);
}
