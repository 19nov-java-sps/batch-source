package com.revature.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.delegates.AuthenticateDelegate;
import com.revature.delegates.EmployeeDelegate;
import com.revature.delegates.ManagerDelegate;
import com.revature.delegates.ReimbursementDelegate;
import com.revature.delegates.ViewDelegate;

public class RequestHelper {
	
	private EmployeeDelegate eDel = new EmployeeDelegate();
	private ManagerDelegate mDel = new ManagerDelegate();
	private ReimbursementDelegate rDel = new ReimbursementDelegate();
	private ViewDelegate vDel = new ViewDelegate();
	private AuthenticateDelegate aDel = new AuthenticateDelegate();
	
	public RequestHelper() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void processGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		String path = request.getRequestURI().substring(request.getContextPath().length());
		if (path.startsWith("/api/")) {
			String record = path.substring(5);
			
			switch (record) {
			case "employees":	// where we get all the employees (either all, or by username)
				eDel.getEmployees(request, response);
				break;
			case "managers":	// where we get all the managers (either all, or by username)
				mDel.getManagers(request, response);
				break;
			case "reimbursements":	// where we get all the reimbursements (either all, by status, by username, or by both)
				rDel.getReimbursements(request, response);
				break;
			default:
				response.sendError(404);
			}
		} else {
			vDel.resolveView(request, response);
		}
	}
	
	public void processPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		String path = request.getServletPath();
		
		switch(path) {
		case "/login":	// Employee login
			aDel.authenticate(request, response);
			break;
		case "/mlogin":	// Manager login
			aDel.authenticateM(request, response);
			break;
		case "/create":	// Creating a Reimbursement
			rDel.createReimbursement(request);
			break;
		case "/updateReim":	// Updating a Reimbursement
			rDel.updateReimbursement(request);
			break;
		case "/updateEmp":	// Update an Employee
			eDel.updateEmployee(request);
			break;
		default:
			response.sendError(405);
		}
	}
}
