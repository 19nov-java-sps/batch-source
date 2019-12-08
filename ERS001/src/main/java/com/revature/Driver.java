package com.revature;

import java.util.List;


import com.revature.dao.EmployeeDaoImpl;

import com.revature.util.HibernateUtil;

public class Driver {

	public static void main(String[] args) {
		EmployeeDaoImpl emp= new EmployeeDaoImpl();
		//System.out.print(emp.getEmployees());
		
		System.out.print(emp.getEmployeeById(1));

		
		
		HibernateUtil.closeSessionFactory();
	}

}
