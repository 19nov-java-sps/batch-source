package com.revature.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.delegates.ViewDelegate;

public class RequestHelper {
	
	private ViewDelegate viewDelegate = new ViewDelegate();
	
	public void processGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = request.getRequestURI().substring(request.getContextPath().length());
		if(path.startsWith("/api/")) {
			// we're requesting a resource
			String record = path.substring(5);
			
			System.out.println(record);
			// evaluate the rest of the uri to figure out what resource is being requested
			// send to the appropriate resource delegate
			switch(record) {
			case "employees":
				//process with the employee delegate
//				eDelegate.getEmployees(request, response);
				break;
			case "invoices":
				//process with the department delegate
//				dDelegate.getDepartments(request, response);
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
}
