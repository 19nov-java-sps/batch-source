package com.revature.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.servlets.DefaultServlet;

public class FrontController extends DefaultServlet {

	private static final long serialVersionUID = 1L;
	
	private RequestHelper requestHelper = new RequestHelper();
	

	public FrontController() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String path = request.getServletPath();
		//System.out.println("FrontController doGet");
		//System.out.println(path);
		//System.out.println(request.getHeader("Autorisation"));
			if(path.startsWith("/static/")) {
		//	System.out.println("FrontController doGet if");
		//	System.out.println(request.getHeader("Autorisation"));
		//	System.out.println(path);
			super.doGet(request, response);
		}else {
		//	System.out.println("FrontController request helper processGet doGet");
		//	System.out.println(request.getHeader("Autorisation"));
			requestHelper.processGet(request, response);
		}
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		requestHelper.processPost(request, response);
	}

}
