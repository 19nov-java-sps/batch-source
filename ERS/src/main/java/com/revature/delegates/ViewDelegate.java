package com.revature.delegates;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ViewDelegate {
	
	
	public void returnView(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String path = request.getServletPath();
		
		
		
		
		System.out.print(path);
		switch(path) {
		
		
		case "/login":
			request.getRequestDispatcher("/static/Login.html").forward(request, response);
			break;
			
		case "/manager":
			request.getRequestDispatcher("/static/ManagerHomePage.html").forward(request, response);
			break;
			
		case "/employee":
			request.getRequestDispatcher("/static/EmployeeHomePage.html").forward(request, response);
			break;
			
		case "/employeedirectory":
			request.getRequestDispatcher("/static/EmployeeDirectory.html").forward(request, response);
			break;
			
			
		case "/pending":
			request.getRequestDispatcher("/static/PendingReimbursements.html").forward(request, response);
			break;
			
		case "/finalized":
			request.getRequestDispatcher("/static/FinalizedReimbursements.html").forward(request, response);
			break;
			
		case "/pendingbyid":
			request.getRequestDispatcher("/static/PendingById.html").forward(request, response);
			break;
		case "/viewinformation":
			request.getRequestDispatcher("/static/ViewInformation.html").forward(request, response);
			break;
		case "/mypending":
			request.getRequestDispatcher("/static/MyPendingRequests.html").forward(request, response);
			break;
		case "/myresolved":
			request.getRequestDispatcher("/static/MyResolved.html").forward(request, response);
			break;
		case "/submitreimbursement":
			request.getRequestDispatcher("/static/SubmitReimbursement.html").forward(request, response);
			break;
		case "/updateinfo":
			request.getRequestDispatcher("/static/UpdateEmployee.html").forward(request, response);
			break;
		case "/approveordeny":
			request.getRequestDispatcher("/static/ResolveRequests.html").forward(request, response);
			break;
			
			
			
		default:
			response.sendError(404, "static resource not found");
		}
	}
	

}