package com.revature.services;

import java.util.List;

import com.revature.daos.EmployeeDao;
import com.revature.daos.EmployeeDaoImpl;
import com.revature.models.Employee;

public class EmployeeService {

	EmployeeDao employeeDao = new EmployeeDaoImpl();
	
	public List<Employee> getEmployees() {
		return employeeDao.getAllEmpl();
	}
	
	public Employee getEmplById(int id) {
		return employeeDao.getEmplById(id);
	}
	
	public Employee getLogin(String email, String password) {
		return employeeDao.emplLogin(email, password);
	}
	
	public int registeEmpl(Employee e) {
		return employeeDao.createEmpl(e);
	}
	
	public int updateEmplInfo(int emplId, String password, String email, String phone) {
		return employeeDao.updateEmpl(emplId, password, email, phone);
	}
}
