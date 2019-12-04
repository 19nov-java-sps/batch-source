package com.revature.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.delegates.AuthDelegate;
import com.revature.delegates.EmployeesDelegate;
import com.revature.delegates.ViewDelegate;

public class RequestHelper {

	private ViewDelegate viewDelegate = new ViewDelegate();
	private EmployeesDelegate employeesDelegate = new EmployeesDelegate();
//	private ReimbursementDelegate reimDelegate = new ReimbursementDelegate();
	private AuthDelegate authDelegate = new AuthDelegate();

	public RequestHelper() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void processGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		String path = request.getServletPath();
		if (path.startsWith("/api/")) {
			// we will authenticate the token here
//			if (!authDelegate.isAuthorized(request)) {
//				response.sendError(401);
//				return;
//			}

			String record = path.substring(5);
			System.out.print(record);
			switch (record) {
			case "employees":
				employeesDelegate.getEmployees(request, response);
				break;
			case "reimbursements":
//				reimDelegate.getReimbursments(request, response);
				break;
			case "reimbursements/pending":
//				reimDelegate.getPendingReimbursements(request, response);
				break;
			case "reimbursements/resolved":
//				reimDelegate.getResolvedReimbursements(request, response);
				break;
			default:
				response.sendError(404, "Request Record(s) Not Found");
			}

		} else {
			viewDelegate.returnView(request, response);
		}

	}

	public void processPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		String path = request.getServletPath();
		switch (path) {
		case "/login":
//			authDelegate.authenticate(request, response);
			break;
		default:
			response.sendError(405);
		}
	}
}
