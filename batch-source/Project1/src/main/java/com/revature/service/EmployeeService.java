package com.revature.service;

import java.util.List;

import com.revature.model.Employee;

public abstract class EmployeeService {
	
	public abstract List<Employee> getManagersEmployeesByEmployeeId (int empId);
	
	public abstract Employee getManagerByEmployeeId (int empId);
	
}


