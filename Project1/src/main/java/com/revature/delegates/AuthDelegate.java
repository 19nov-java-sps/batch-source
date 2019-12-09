package com.revature.delegates;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.daos.UserDao;
import com.revature.daos.UserDaoImpl;
import com.revature.models.User;

public class AuthDelegate {
	static private Map< String, Integer> tokens = new HashMap<>();

	public User getCurrentUser(HttpServletRequest request) {
		String authToken = request.getHeader("Authorization");
		if( authToken == null ) {
			authToken = request.getParameter( "auth" );
		}
		// UserDao userDao = UserDaoImpl.getInstance();
		// check to see if there is an auth header
		if(authToken!=null) {
			Integer userId = tokens.get(authToken);
			if( userId != null ) {
				return UserDaoImpl.getInstance().getUserById( userId );
			}
		}
		return null;
		/*
			.containsKey(authToken)())
			String[] tokenArr = authToken.split(":");
			// if the token is formatted the way we expect, we can take the id from it and query for that user
			if(tokenArr.length == 2) {
				String idStr = tokenArr[0];
				String userRoleStr = tokenArr[1];
				if(idStr.matches("^\\d+$")) {
					// check to see if there is a valid user and if that user is the appropriate role in their token
					User u = userDao.getUserById(Integer.parseInt(idStr));
					if(u!=null && u.getUserRole().equals(userRoleStr)) {
						return true;
					}
				}
			}
		}
		return false;
		*/
	}
	
	
	public void authenticate(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		UserDao userDao = UserDaoImpl.getInstance();

		User u = userDao.getUserByUsernameAndPassword(username, password);

		if(u!=null) {
			UUID uuid = UUID.randomUUID();
			String token = uuid.toString();
			tokens.put( token, u.getId() );
			response.setStatus(200);
			response.setHeader("Authorization", token);
			response.getWriter().write(u.getUserRole());
			response.getWriter().flush();
			response.getWriter().close();
		} else {
			response.sendError(401);
		}		
	}
}
