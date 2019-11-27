package com.revature.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.delegates.ViewDelegate;

public class RequestHelper {
	
	private ViewDelegate viewDelegate = new ViewDelegate();
	
	public void processGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// at this point, we are either requesting a resource or a static page
		String path = request.getRequestURI().substring(request.getContextPath().length());
		if(path.startsWith("/api/")) {
			// we're requesting a resource
			String record = path.substring(5);
			
			System.out.println(record);
			// evaluate the rest of the uri to figure out what resource is being requested
			// send to the appropriate resource delegate
		} else {
			// we want to request a view 
			// send to view delegate
			viewDelegate.resolveView(request, response);
		}	
	
	}

}
