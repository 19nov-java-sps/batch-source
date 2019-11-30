package com.revature.service;

import java.util.List;

import com.revature.dao.EmployeeDao;
import com.revature.dao.impl.EmployeeDaoImpl;
import com.revauture.model.Employee;

public class EmployeeService {
	
	private EmployeeDao employeeDao = new EmployeeDaoImpl();
	
	public List<Employee> getEmployees(){
		return employeeDao.getEmployees();
	}
	
	public Employee getEmployeeById(int id){
		return employeeDao.getEmployeeById(id);
	}
	
	public boolean createEmployee(Employee e) {
		int i =  employeeDao.createEmployee(e);
		if (i !=  0) {
			return true;
		}  else {
			return false;
		}
		
	}

	public boolean deleteEmployee(Employee e) {
		int i =  employeeDao.deleteEmployee(e);
		if (i !=  0) {
			return true;
		}  else {
			return false;
		}
		
	}
	
	public boolean updateEmployee(Employee e) {
		int i =  employeeDao.updateEmployee(e);
		if (i !=  0) {
			return true;
		}  else {
			return false;
		}
		
	}
	
	
}
