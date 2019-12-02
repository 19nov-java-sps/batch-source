package com.revature.delegates;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ViewDelegate {

	public void returnView(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String path = request.getServletPath();
		
		switch(path) {
		case "/login":
			request.getRequestDispatcher("/static/views/Login.html").forward(request, response);
			break;
		case "/home":
			request.getRequestDispatcher("/static/views/Home.html").forward(request, response);
			break;
		case "/reimbursement/new":
			request.getRequestDispatcher("/static/views/NewReim.html").forward(request, response);
			break;
		case "/reimbursement/update":
			request.getRequestDispatcher("/static/views/ResolveReim.html").forward(request, response);
			break;
		default:
			response.sendError(404, "static resource not found");
		}
	}
}
