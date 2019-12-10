package com.revature.services;

import java.util.List;

import com.revature.daos.EmployeeDao;
import com.revature.daos.EmployeeDaoImpl;
import com.revature.models.Employee;

public class EmployeeService {
	
	private EmployeeDao ed = new EmployeeDaoImpl();

	public EmployeeService() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public List<Employee> getEmployees() {
		
		return ed.getEmployees();
	}
	
	public Employee getEmployeeByUsername(String username) {
		
		return ed.getEmployeeByUsername(username);
	}
	
	public int updateEmployee(String fName, String lName, int emp_id) {
		
		return ed.updateEmployee(fName, lName, emp_id);
	}
	
}
