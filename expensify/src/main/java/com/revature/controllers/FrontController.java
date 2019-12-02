package com.revature.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.catalina.servlets.DefaultServlet;

/**
 * Servlet implementation class FrontController
 */
public class FrontController extends DefaultServlet {
	private static final long serialVersionUID = 1L;
	private RequestHelper rh = new RequestHelper();
       
    /**
     * @see DefaultServlet#DefaultServlet()
     */
    public FrontController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = request.getRequestURI().substring(request.getContextPath().length());
		System.out.println(path+" "+ "this is in the FrontController");
		
		if(path.startsWith("/static/")) {
			super.doGet(request, response);
		} else {
			rh.processGet(request, response);
		}
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getServletPath();
		System.out.println(uri+" "+ "this is in the FrontController");
		
		
		rh.processPost(request, response);
	}

}
