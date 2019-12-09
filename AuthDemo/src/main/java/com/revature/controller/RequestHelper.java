package com.revature.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.delegates.AuthDelegate;
import com.revature.delegates.UserDelegate;
import com.revature.delegates.ViewDelegate;
import com.revature.models.User;

public class RequestHelper {
	private AuthDelegate authDelegate = new AuthDelegate();
	private ViewDelegate viewDelegate = new ViewDelegate();
	private UserDelegate userDelegate = new UserDelegate();


	public void processGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String path = request.getServletPath();
		System.out.println(path);
		if(path.startsWith("/api/")) {
			// we will authenticate the token here
			User currentUser = authDelegate.getCurrentUser(request);
			if(currentUser == null) {;
				response.sendError(401);
				return;
			}
			
			String record = path.substring(5);
			switch(record) {
			case "getUserInfo":
				userDelegate.getUserInfo(currentUser, request, response);
				break;
			case "getallusers":
				if( currentUser.getUserRole().equals( "manager" ) ) {
				    userDelegate.getAllUsers(request, response);
				} else {
					response.sendError(401, "Only manager can get all users");
				}				
				break;
			case "reimbursement/getpending":
				userDelegate.getAllPending(currentUser, request, response);
				break;
			case "reimbursement/getresolved":
				userDelegate.getAllResolved(currentUser, request, response);
				break;
			case "reimbursement/new":
				userDelegate.addReimbursment( currentUser, request, response);
				break;
			case "reimbursement/approve":
				userDelegate.approveReimbursment( currentUser, request, response);
				break;
			case "reimbursement/deny":
				userDelegate.denyReimbursment( currentUser, request, response);
				break;
			case "updateinfo/new":
				userDelegate.changeInfo( currentUser, request, response );
				break;
			default:
				response.sendError(404, "Request Record(s) Not Found");
			}
			
		} else {
			viewDelegate.returnView(request, response);
		}
		
	}

	
	public void processPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String path = request.getServletPath();
		switch(path) {
		case "/login":
			authDelegate.authenticate(request, response);
			break;
		default:
			response.sendError(405);
		}
	}
}
