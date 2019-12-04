package com.revature.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.delegates.AuthDelegate;
import com.revature.delegates.EmployeeDelegate;
import com.revature.delegates.ReimbursementDelegate;
import com.revature.delegates.ViewDelegate;

public class RequestHelper {
	
	private ViewDelegate viewDelegate = new ViewDelegate();
	private EmployeeDelegate empDelegate= new EmployeeDelegate(); 
	private AuthDelegate authDelegate = new AuthDelegate();
	private ReimbursementDelegate burse= new ReimbursementDelegate();

	public void processGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String path = request.getServletPath();
		String record = path.substring(5);
		System.out.println(path +" : "+record);
	
		if(path.startsWith("/api/")) {
			
			
			/*
			if(!authDelegate.isAuthorized(request)) {
				response.sendError(401);
				return;
			}
			*/
			
			
			switch(record) {
			case "employees":
				empDelegate.Employees(request, response);
				break;
			case "pendingreimbursements":
				burse.Reimbursements(request, response);
				break;
			case "finalreimbursements":
				burse.FinalReimbursements(request, response);
				break;
			case "allreimbursements":
				burse.Reimbursements(request, response);
				break;
				
				
				
				
			default:
				response.sendError(404, "Request Record(s) Not Found");
			}
			
		
		

			
		}
			
			
			else {
			viewDelegate.returnView(request, response);
		}
		
	}

	
	public void processPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, SQLException {
		String path = request.getServletPath();
		switch(path) {
		case "/login":
			authDelegate.authenticate(request, response);
			break;
		case "/submitreimbursement":
			burse.createReimbursement(request, response);
			break;
		case "/updateinfo":
		empDelegate.updateInfo(request, response);
			break;
		case "/approveordeny":
		burse.amendReimbursement(request, response);
				break;
		default:
			response.sendError(405);
		}
	}
}
