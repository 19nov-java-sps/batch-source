package com.revature.delegates;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.UserLogin;
import com.revature.service.UserLogInService;

public class EmployeeDelegate {
private UserLogInService employeeService = new UserLogInService();
	
	public void getEmployees(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		String idStr = request.getParameter("id");
//		System.out.println("from get employees"+idStr);
		if (idStr == null) {
			List<UserLogin> employees = employeeService.getUsers();
			
			try(PrintWriter pw = response.getWriter();){
				pw.write(new ObjectMapper().writeValueAsString(employees));
			}	
		} else {
			if(idStr.matches("^\\d+$")) {
				UserLogin e = employeeService.getUserById(Integer.parseInt(idStr));

				if (e == null) {
					response.sendError(404, "No bueno");
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
		
		String name = request.getParameter("updateName");
		String email = request.getParameter("updateEmail");
		String password = request.getParameter("updatePass");
		String userid = request.getParameter("emplId");
	
		
		boolean success = employeeService.updateUser(name,email,password, Integer.parseInt(userid));
		if (success == true) {
			response.setStatus(201);
		} else {
			response.sendError(400);
		}
	}
}

