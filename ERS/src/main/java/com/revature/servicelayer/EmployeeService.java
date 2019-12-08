package com.revature.servicelayer;

import java.sql.SQLException;
import java.util.List;

import com.revature.dao.EmployeeDao;
import com.revature.daoimpl.EmployeeDaoImpl;
import com.revature.models.Employee;

public class EmployeeService {

	private EmployeeDao employeeDao = new EmployeeDaoImpl();

	public List<Employee> getAllEmployees() {
		return employeeDao.getAllEmployees();
	}

	public Employee getEmployeeById(int id) {
		return employeeDao.getEmployeeById(id);
	}

	public int updateEmployee(Employee e) throws SQLException {
		return employeeDao.updateEmployee(e);
	}

	public int create(Employee e) {
		return employeeDao.createEmployee(e);
	}

}
