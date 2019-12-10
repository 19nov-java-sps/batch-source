package com.revature.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.servlets.DefaultServlet;

public class FrontController extends DefaultServlet {

	private static final long serialVersionUID = 1L;
	
	private RequestHelper rh = new RequestHelper();
	
	public FrontController() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	// Called when there is a GET request
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		String path = request.getServletPath();
		if (path.startsWith("/static/")) {	// if it starts with static then it will call the default servlet to directly access all the static files.
			super.doGet(request, response);
		} else {	// if its not then call the request helper
			rh.processGet(request, response);
		}
	}
	
	// Called when there is a POST request
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		rh.processPost(request, response);
	}
}
