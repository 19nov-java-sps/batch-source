package com.revature.delegates;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.Employee;
import com.revature.services.EmployeeService;

public class EmployeeDelegate {
	
	private EmployeeService employeeService = new EmployeeService();
	
	public void getEmployees(HttpServletRequest request, HttpServletResponse response ) throws IOException {
		List<Employee> employees = employeeService.getAll();
		
		try(PrintWriter pw = response.getWriter()){
			pw.write(new ObjectMapper().writeValueAsString(employees));
		}
 	}

}
