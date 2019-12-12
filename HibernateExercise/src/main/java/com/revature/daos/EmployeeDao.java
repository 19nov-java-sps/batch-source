package com.revature.daos;

import java.util.List;

import com.revature.models.Employee;

public interface EmployeeDao {
	public List<Employee> getEmpls();
	public Employee getEmplById(int id);
	public int createEmpl(Employee empl);
	public void updateEmpl(Employee empl);
	public Employee emplLogin(String email, String password);
}
