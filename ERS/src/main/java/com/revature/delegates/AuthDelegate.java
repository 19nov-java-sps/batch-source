package com.revature.delegates;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.dao.impl.EmployeeDaoImpl;
import com.revature.daos.EmployeeDao;

import com.revature.models.Employee;
import com.revature.services.EmployeeService;

import java.util.Scanner;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import com.revature.models.Employee;
import com.revature.services.EmployeeService;
import com.revature.util.ConnectionUtil;

public class AuthDelegate {
	
	private EmployeeDao empDao = new EmployeeDaoImpl();
	private EmployeeService empservice= new EmployeeService();
	
	public boolean isAuthorized(HttpServletRequest request) {
		String authToken = request.getHeader("Authorization");
		// check to see if there is an auth header
		if(authToken!=null) {
			String[] tokenArr = authToken.split(":");
			// if the token is formatted the way we expect, we can take the id from it and query for that user
			if(tokenArr.length == 2) {
				String idStr = tokenArr[0];
				String userRoleStr = tokenArr[1];
				if(idStr.matches("^\\d+$")) {
					// check to see if there is a valid user and if that user is the appropriate role in their token
					Employee u = empDao.getEmployeeById(Integer.parseInt(idStr));
					if(u!=null && u.getEmployeeType().equals(userRoleStr)) {
						return true;
					}
				}
			}
		}
		return false;
	}
	
	
	public void authenticate(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");

		Employee u =empDao.Login(email,password);

		if(u!=null) {
			String token = u.getId()+":"+u.getEmployeeType();
		System.out.print(token);
			response.setStatus(200);
			response.setHeader("Authorization", token);
		} else {
			response.sendError(401);
		}
		
	}
	

}