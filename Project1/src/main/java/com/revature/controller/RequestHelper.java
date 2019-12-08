package com.revature.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.delegates.AuthDelegate;
import com.revature.delegates.InvoiceDelegate;
import com.revature.delegates.UserDelegate;
import com.revature.delegates.ViewDelegate;

public class RequestHelper {
	
	private ViewDelegate viewDelegate = new ViewDelegate();
	private UserDelegate userDelegate = new UserDelegate();
	private AuthDelegate authDelegate = new AuthDelegate();
	private InvoiceDelegate invoiceDelegate = new InvoiceDelegate();

	public void processGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String path = request.getServletPath();
		if(path.startsWith("/api/")) {
		 // we will authenticate the token here
			if(!authDelegate.isAuthorized(request)) {
				response.sendError(401);
				return;
			}
			
			String record = path.substring(5);
			switch(record) {
			case "users":
				userDelegate.getUsers(request, response);
				break;
			case "invoices":
				invoiceDelegate.getInvoices(request, response);
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
		case "/home":
			authDelegate.authenticate(request, response);
			break;
		case "/update":
			userDelegate.update(request, response);
			break;
		case "/new-invoice":
			invoiceDelegate.newInvoice(request, response);
			break;
		case "/approved":
			invoiceDelegate.approved(request, response);
			break;
		case "/denied":
			invoiceDelegate.denied(request, response);
		default:
			response.sendError(405);
		}
	}
}
