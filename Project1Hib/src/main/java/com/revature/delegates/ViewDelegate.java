package com.revature.delegates;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ViewDelegate {
	
	public void resolveView(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		String uri = request.getServletPath();
		
		// Checks the cases and forwards the specific html file to send and render in the browser.
		switch (uri) {
		case "/login":
			request.getRequestDispatcher("/static/Views/login.html").forward(request, response);
			break;
		case "/mlogin":
			request.getRequestDispatcher("/static/Views/mlogin.html").forward(request, response);
			break;
		case "/employeeHome":
			request.getRequestDispatcher("/static/Views/employeeHome.html").forward(request, response);
			break;
		case "/managerHome":
			request.getRequestDispatcher("/static/Views/managerHome.html").forward(request, response);
			break;
		case "/profile":
			request.getRequestDispatcher("/static/Views/profile.html").forward(request, response);
		}
	}
}
