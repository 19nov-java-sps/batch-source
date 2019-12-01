package com.revature.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.delegates.AuthDelegate;
import com.revature.delegates.EmployeeDelegate;
import com.revature.delegates.ReimbursementDelegate;
import com.revature.delegates.ViewDelegate;

public class RequestHelper {
	
	private ViewDelegate viewDelegate = new ViewDelegate();
	private EmployeeDelegate emplDelegate = new EmployeeDelegate();
	private AuthDelegate authDelegate = new AuthDelegate();
	private ReimbursementDelegate reimbursementDelegate = new ReimbursementDelegate();

	public void processGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String path = request.getServletPath();
		if(path.startsWith("/api/")) {
			if(!authDelegate.isAuthorized(request)) {
				response.sendError(401);
				return;
			}
			
			String record = path.substring(5);
			switch(record) {		
			case "employees":
				emplDelegate.getEmployees(request, response);
				break;
			case "reimbursements":
				reimbursementDelegate.getReimbursements(request, response);
				break;
			case "reimbursements/pending":
				reimbursementDelegate.getPendingReimbursements(request, response);
				break;
			case "reimbursements/resolved":
				reimbursementDelegate.getResolvedReimbursements(request, response);
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
		case "/reimbursement/new":
			reimbursementDelegate.submitReimbursement(request, response);
			break;
		default:
			response.sendError(405);
		}
	}
}
