package com.revature.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.revature.delegates.*;

public class RequestHelper {
	private ViewDelegate viewDelegate = new ViewDelegate();
	private UserDelegate userDelegate = new UserDelegate();
	private AuthDelegate authDelegate = new AuthDelegate();
	private EmployeeDelegate empDelegate=new EmployeeDelegate();
	private ExpDelegate expDelegate=new ExpDelegate();

	public void processGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String path = request.getServletPath();
		if(path.startsWith("/api/")) {
			// we will authenticate the token here
//			if(!authDelegate.isAuthorized(request)) {
//				System.out.println("error on here");
//				response.sendError(401);
//				return;
//			}
			
			String record = path.substring(5);
			switch(record) {
			case "users":
				userDelegate.getUsers(request, response);
				break;
			case "employees":
				empDelegate.getEmployees(request, response);
				break;
			case "expenses":
				expDelegate.getExpenses(request, response);
				break;
			case "expenses/resolved":
				expDelegate.resolvedExpenses(request, response);
				break;
			case "expenses/resolved2":
				expDelegate.resolvedExpenses2(request, response);
				break;
			case "/expenses/resolved":
				expDelegate.resolvedExpenses(request, response);
				break;
			case "/expenses/pending":
				expDelegate.pendingExpenses(request, response);
				break;
			case "expenses/pending":
				expDelegate.pendingExpenses(request, response);
				break;
			case "/expenses/all":
				expDelegate.getExpenses(request, response);
				break;
			default:
				response.sendError(404, "Request Record(s) Not Found");
			}
			
		} else {
			viewDelegate.returnView(request, response);
		}
		
	}

	
	public void processPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String path = request.getServletPath();
		switch(path) {
		case "/login":
			authDelegate.authenticate(request, response);
			break;
		case "/expenses":
			expDelegate.addExpenses(request, response);
			break;
		case "/expenses/resolved":
			expDelegate.resolvedExpenses(request, response);
			break;
		case "expenses/resolved":
			expDelegate.resolvedExpenses(request, response);
			break;
		case "/expenses/pending":
			expDelegate.pendingExpenses(request, response);
			break;
		case "/expenses/all":
			expDelegate.getExpenses(request, response);
			break;
//		case "/expenses/pending/approve":
//			expDelegate.getExpenses(request, response);
//			break;
		case "/update":
			empDelegate.updateEmployee(request, response);
			break;
		case "update":
			empDelegate.updateEmployee(request, response);
			break;
		default:
			response.sendError(405);
		}
	}


	public void processPut(HttpServletRequest request, HttpServletResponse response)throws IOException, ServletException {
		String path = request.getServletPath();

		switch(path) {
		case "/expenses/pending/approve":
			expDelegate.updateExpensesById(request, response);
			break;
		case "/expenses/pending/deny":
			expDelegate.updateExpensesById(request, response);
			break;
		default:
			response.sendError(405);
		}
		
	}
}
