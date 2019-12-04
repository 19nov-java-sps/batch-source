package com.revature.delegates;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.daos.UserAccDao;
import com.revature.daos.impls.UserAccDaoImpl;
import com.revature.models.User;
import com.revature.models.UserAcc;

public class AuthDelegate {
	
	private UserAccDao uad = new UserAccDaoImpl();
	
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
					UserAcc ua = uad.getUserById(Integer.parseInt(idStr));
					if(ua!=null && ua.getUser_role().equals(userRoleStr)) {
						return true;
					}
				}
			}
		}
		return false;
	}
	
	
	public void authenticate(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		UserAcc ua = uad.getuserByUserAndPass(username, password);

		if(ua!=null) {
			String token = ua.getUser_id()+":"+ua.getUser_role();
			response.setStatus(200);
			response.setHeader("Authorization", token);
		} else {
			response.sendError(401);
		}
		
	}
	

}
