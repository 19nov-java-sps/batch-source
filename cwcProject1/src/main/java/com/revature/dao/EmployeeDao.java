package com.revature.dao;

import java.util.List;

import com.revature.models.Employee;

public interface EmployeeDao {

	public List<Employee> getAllEmpl();
	public Employee getEmplById(int id);
	public Employee emplLogin(String email, String password);
	public int createEmpl(Employee e);
	public int updateEmpl(int emplId, String password, String email, String phone);
}
