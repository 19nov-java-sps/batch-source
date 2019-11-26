package com.revature.service;

import java.util.List;

import com.revature.dao.EmployeeDao;
import com.revature.dao.impl.EmployeeDaoImpl;
import com.revature.model.Employee;
import com.revature.model.Employee;

public class EmployeeService {
	
	private EmployeeDao ed = new EmployeeDaoImpl();
	
	public List<Employee> getEmployees(){
		return ed.getEmployees();
	}
	
	public Employee getEmployeeById(int id) {
		return ed.getEmployeeById(id);
	}

	public boolean updateEmployee(Employee e) {
		int deptUpdated = ed.updateEmployee(e);
		if(deptUpdated != 0) {
			return true;
		}
		return false;
	}
	
}
