package com.revature.delegates;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.daos.EmployeeDao;
import com.revature.daos.EmployeeDaoImpl;
import com.revature.daos.ManagerDao;
import com.revature.daos.ManagerDaoImpl;
import com.revature.models.Employee;
import com.revature.models.Manager;

public class AuthenticateDelegate {
	
	private EmployeeDao ed = new EmployeeDaoImpl();
	private ManagerDao md = new ManagerDaoImpl();
	
	public boolean isAuth(HttpServletRequest request) {
		
		String token = request.getHeader("Authorization");
		
		if (token != null) {
			String[] tokenArr = token.split(":");
			
			if (tokenArr.length == 2) {
				String username = tokenArr[0];
				String id = tokenArr[1];
				
				if (id.matches("^\\d+$")) {
					Employee e = ed.getEmployeeByUsername(username);
					
					if (e != null && e.getEmp_id() == Integer.parseInt(id)) {
						return true;
					}
				}
			}
		}
		return false;
	}
	
	public void authenticate(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		// Assigns what was inputted in the fields and sent.
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		// Uses the username to get the employee.
		Employee e = ed.getEmployeeByUsername(username);

		// if both the employee exists and password is correct then enter if
		if (e.getUsername() != null && e.getPassword().equals(password)) {
			String token = e.getUsername() + ":" + e.getEmp_id();	// Create token
			response.setStatus(200);	// set status of OK
			response.setHeader("Authorization", token);	// Set the type of token
		} else {
			response.setStatus(400);
		}
		
	}
	
	// These methods and the same as above but these are for the managers.
	public boolean isAuthM(HttpServletRequest request) {
		
		String token = request.getHeader("Authorization");
		
		if (token != null) {
			String[] tokenArr = token.split(":");
			
			if (tokenArr.length == 2) {
				String username = tokenArr[0];
				String id = tokenArr[1];
				
				if (id.matches("^\\d+$")) {
					Manager m = md.getManagerByUsername(username);
					
					if (m != null && m.getMan_id() == Integer.parseInt(id)) {
						return true;
					}
				}
			}
		}
		return false;
	}
	
	public void authenticateM(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		Manager m = md.getManagerByUsername(username);

		if (m.getUsername() != null && m.getPassword().equals(password)) {
			String token = m.getUsername() + ":" + m.getMan_id();
			response.setStatus(200);
			response.setHeader("Authorization", token);
		} else {
			response.setStatus(400);
		}
		
	}
}
