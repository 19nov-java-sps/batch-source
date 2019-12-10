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

	private EmployeeService es = new EmployeeService();
	
	public void getEmployees(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		String username = request.getParameter("username");
		
		if (username == null) {
			List<Employee> employees = es.getEmployees();
			
			try(PrintWriter pw = response.getWriter()) {
				pw.write(new ObjectMapper().writeValueAsString(employees));
			}
		} else {
			Employee e = es.getEmployeeByUsername(username);
			
			if (e == null) {
				response.sendError(404);
			} else {
				try(PrintWriter pw = response.getWriter()) {
					pw.write(new ObjectMapper().writeValueAsString(e));
				}
			}
		}
	}
	
	public void updateEmployee(HttpServletRequest request) throws IOException {
		
		String fName = request.getParameter("fName");
		String lName = request.getParameter("lName");
		String emp_id = request.getParameter("emp_id");
		
		es.updateEmployee(fName, lName, Integer.parseInt(emp_id));
	}
}
