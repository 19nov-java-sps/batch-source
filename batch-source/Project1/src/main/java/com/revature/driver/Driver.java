package com.revature.driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.dao.EmployeeDao;
import com.revature.daoimpl.EmployeeDaoImpl;
import com.revature.daoimpl.ReimbursmentDaoImpl;
import com.revature.delegates.EmplDelegate;
import com.revature.model.Employee;
import com.revature.util.ConnectionUtil;

public class Driver {

	public static void main(String[] args) throws SQLException {
		
		
		System.out.println("!");
		
		/*
		 * String driverName =
		 * ConnectionUtil.getConnection().getMetaData().getDriverName();
		 * System.out.println(driverName);
		 */
		  
		EmployeeDaoImpl edi = new EmployeeDaoImpl();
		Employee e = new Employee();
		e = edi.getEmployeeById(7);
		System.out.println(e);
		
	

		
		
		/*
		 * EmployeeDaoImpl edi = new EmployeeDaoImpl(); Employee e =
		 * edi.getEmployeeById(2); System.out.println(e);
		 */
		 
		  
		/* EmployeeDaoImpl edi = new EmployeeDaoImpl(); */
	//	 Employee e = new Employee (106, "Max", "KOrse", "Accounting", 2, "456", "Brooms", "Cops", "NY", "48076", "248-346-2681", "ghdsj@kfkgf.com", "user3", "pass");
		// edi.createNewEmployee(e);
	//	 System.out.println(e);
		/*
		 * System.out.println(edi.getEmployeeById(106));
		 * 
		 * edi.deleteEmployee(edi.getEmployeeById(106));
		 * System.out.println(edi.getEmployeeById(106));
		 */
		 
		
		/*
		 * ReimbursmentDaoImpl rdi = new ReimbursmentDaoImpl();
		 * System.out.println(rdi.getAllReimbursement());
		 */
		 
		  
		/*
		 * List<Employee> empl = edi.getAllEmployee(); for(Employee e: empl) {
		 * System.out.println(e);
		 * 
		 * }
		 */
		 
		
	}

}
