package com.revature.delegates;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ViewDelegate {
	
	public void returnView(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("I am in VeiwDeligate method");
		String path = request.getServletPath();
		System.out.println("The path is " + path);
		switch(path) {
		case "/login":
			System.out.println("Here is ViewDeligate for /login");
			request.getRequestDispatcher("/static/login.html").forward(request, response);
			break;
		case "/index":
			System.out.println("Here is ViewDeligate for /index");
			request.getRequestDispatcher("/static/Index.html").forward(request, response);
			break;
//		case "/empl":
//			System.out.println("Here is ViewDeligate for /empl");
//			request.getRequestDispatcher("/static/Employees.html").forward(request, response);
//			break;
		default:
		//	System.out.println("Here is ViewDeligate for 404");
			response.sendError(404, "static resource not found");
			
		}
	}



}
