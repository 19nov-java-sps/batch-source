package com.revature.delegates;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.dao.EmployeesDao;
import com.revature.daoimpl.EmployeesDaoImpl;
import com.revature.model.Employees;

public class AuthDelegate {

//	private EmployeesDao employeesDao = new EmployeesDaoImpl();
//
//	public boolean isAuthorized(HttpServletRequest request) {
//		String authToken = request.getHeader("Authorization");
//		// check to see if there is an auth header
//		if (authToken != null) {
//			String[] tokenArr = authToken.split(":");
//			// if the token is formatted the way we expect, we can take the id from it and
//			// query for that user
//			if (tokenArr.length == 2) {
//				String idStr = tokenArr[0];
//				String isManager = tokenArr[1];
//				if (idStr.matches("^\\d+$")) {
//					// check to see if there is a valid user and if that user is the appropriate
//					// role in their token
//					Employees e = employeesDao.getEmployeesById(Integer.parseInt(idStr));
//					if (e != null && e.getisManager() == Boolean.parseBoolean(isManager)) {
//						return true;
//					}
//				}
//			}
//		}
//		return false;
//	}
//
//	public void authenticate(HttpServletRequest request, HttpServletResponse response) throws IOException {
//		String username = request.getParameter("username");
//		String password = request.getParameter("password");
//
//		Employees e = employeesDao.getUserByUsernameAndPassword(username, password);
//
//		if (e != null) {
//			String token = e.getEmployeeID() + ":" + e.getisManager();
//			response.setStatus(200);
//			response.setHeader("Authorization", token);
//		} else {
//			response.sendError(401);
//		}
//
//	}

}
