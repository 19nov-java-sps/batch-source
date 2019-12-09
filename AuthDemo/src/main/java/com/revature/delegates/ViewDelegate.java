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
			request.getRequestDispatcher("/static/Login.html").forward(request, response);
			break;
		case "/home":
			request.getRequestDispatcher("/static/Home.html").forward(request, response);
			break;
		case "/manager":
			request.getRequestDispatcher("/static/Manager.html").forward(request, response);
			break;
		case "/changeinfo":
			request.getRequestDispatcher("/static/changeinfo.html").forward(request, response);
			break;
		case "/viewinfo":
			request.getRequestDispatcher("/static/viewinfo.html").forward(request, response);
			break;
		case "/viewreimbuersement":
			request.getRequestDispatcher("/static/viewreimbursement.html").forward(request, response);
			break;
		case "/submitreimbursement":
			request.getRequestDispatcher("/static/submitreimbursement.html").forward(request, response);
			break;
		case "/resolve":
			request.getRequestDispatcher("/static/resolve.html").forward(request, response);
			break;
		case "/viewemployees":
			request.getRequestDispatcher("/static/viewemployees.html").forward(request, response);
			break;
		case "/viewpending":
			request.getRequestDispatcher("/static/viewpending.html").forward(request, response);
			break;
		case "/viewresolved":
			request.getRequestDispatcher("/static/viewresolved.html").forward(request, response);
			break;
		default:
			response.sendError(404, "static resource not found");
		}
	}
	

}
