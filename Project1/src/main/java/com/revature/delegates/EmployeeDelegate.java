package com.revature.delegates;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.daos.EmployeeDao;
import com.revature.daos.EmployeeDaoImpl;
import com.revature.models.Employee;
import com.revature.services.EmployeeService;

public class EmployeeDelegate {

	private EmployeeService employeeService = new EmployeeService();
	
	public void getEmployees(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		String idStr = request.getParameter("id");
		if (idStr == null) {
			List<Employee> employees = employeeService.getEmployees();
			
			try(PrintWriter pw = response.getWriter();){
				pw.write(new ObjectMapper().writeValueAsString(employees));
			}	
		} else {
			if(idStr.matches("^\\d+$")) {
				Employee e = employeeService.getEmplById(Integer.parseInt(idStr));
				
				if (e == null) {
					response.sendError(404, "No employee with given ID");
				} else {
					try(PrintWriter pw = response.getWriter()){
						pw.write(new ObjectMapper().writeValueAsString(e));
					}
				}
			} else {
				response.sendError(400, "Invalid ID param");
			}
		}		
	}
	
	public void updateEmployee(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int emplId = Integer.parseInt(request.getParameter("emplId"));
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");

		int newReim = employeeService.updateEmplInfo(emplId, password, email, phone);
		if (newReim == 1) {
			response.setStatus(204);
		} else {
			response.sendError(400);
		}
	}
	
	public void registerEmpl(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// code
	}
}


