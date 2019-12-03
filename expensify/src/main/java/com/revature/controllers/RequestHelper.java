package com.revature.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.delegates.AuthDelegate;
import com.revature.delegates.EmployeeDelegate;
import com.revature.delegates.InvoiceDelegate;
import com.revature.delegates.ViewDelegate;

public class RequestHelper {
	
	private ViewDelegate viewDelegate = new ViewDelegate();
	private EmployeeDelegate employeeDelegate = new EmployeeDelegate();
	private AuthDelegate authDelegate = new AuthDelegate();
	private InvoiceDelegate invoiceDelegate = new InvoiceDelegate();
	
	public RequestHelper() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	protected void processGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// at this point, we are either requesting a resource or a static page
		String path = request.getRequestURI().substring(request.getContextPath().length());
		if(path.startsWith("/api/")) {
			if(!authDelegate.isAuthorized(request)) {
				response.sendError(401);
				return;
			}
			// we're requesting a resource
			String record = path.substring(5);
			
			System.out.println(record);
			// evaluate the rest of the uri to figure out what resource is being requested
			// send to the appropriate resource delegate
			switch(record) {
			case "employees":
				//process with the employee delegate
				employeeDelegate.getEmployees(request, response);
				break;
			case "invoices":
				//process with the department delegate
				invoiceDelegate.getInvoices(request, response);
				break;
			default:
				response.sendError(404, "Record not supported.");
			}
			
		} else {
			// we want to request a view 
			// send to view delegate
			viewDelegate.resolveView(request, response);
		}	
	
	}
	public void processPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String path = request.getRequestURI().substring(request.getContextPath().length());
		System.out.println(path+"this is the path when someone logins");
		switch(path) {
		case "/home":
			authDelegate.authenticate(request, response);
			break;
		case "/employee":
			employeeDelegate.postEmployees(request, response);
		default:
			response.sendError(405);
		}
	}
	
	public void processPut(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException  {
		
	}
	
	public void processDelete(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException  {
		
	}

}
