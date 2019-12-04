package com.revature.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.delegates.AuthDelegate;
import com.revature.delegates.InvoiceDelegate;
import com.revature.delegates.ProfileDelegate;
import com.revature.delegates.UserDelegate;
import com.revature.delegates.ViewDelegate;

public class RequestHelper {
	
	private ViewDelegate viewDelegate = new ViewDelegate();
	private UserDelegate userDelegate = new UserDelegate();
	private AuthDelegate authDelegate = new AuthDelegate();
	private InvoiceDelegate invoiceDelegate = new InvoiceDelegate();
	private ProfileDelegate profileDelegate = new ProfileDelegate();
	
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
				invoiceDelegate.getInvoicesByUserId(request, response);
				break;
			case "maninvoices":
				invoiceDelegate.getInvoices(request, response);
				break;
			case "userprofiles":
				profileDelegate.getProfile(request, response);
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
		System.out.println(path);
		switch(path) {
		case "/login":
			authDelegate.authenticate(request, response);
			break;
		case "/invoices":
			invoiceDelegate.createInvoice(request, response);
			break;
		case "/pendinvoices":
			invoiceDelegate.approveInvoice(request, response);
			break;
		case "/rejectinvoices":
			invoiceDelegate.rejectInvoice(request, response);
			break;
		case "/updateprofile":
			profileDelegate.updateProfile(request, response);
			break;
		default:
			response.sendError(405);
		}
	}
}
