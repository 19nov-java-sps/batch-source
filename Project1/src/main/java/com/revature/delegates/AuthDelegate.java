package com.revature.delegates;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.revature.models.UserLogin;
import com.revature.service.UserLogInService;

public class AuthDelegate {
private UserLogInService userDao = new UserLogInService();
	
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
					UserLogin u = userDao.getUserById(Integer.parseInt(idStr));
					if(u!=null && u.getEmployeetype().equals(userRoleStr)) {
						return true;
					}
				}
			}
		}
		return false;
	}
	
	
	public void authenticate(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		System.out.println(email+ " " +password);
		
		UserLogin ul = userDao.getUserByEmailAndPassword(email, password);
		System.out.println(ul);
		if(ul!=null) {
			String token = ul.getUser_id()+":"+ul.getEmployeetype();
			response.setStatus(200);
			response.setHeader("Authorization", token);
		} else {
			response.sendError(401);
		}
		
	}
}
