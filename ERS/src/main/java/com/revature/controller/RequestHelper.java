package com.revature.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.delegates.AuthDelegate;
import com.revature.delegates.EmployeeDelegate;
import com.revature.delegates.ReimbursementDelegate;
import com.revature.delegates.ViewDelegate;

public class RequestHelper {

	private ViewDelegate viewDelegate = new ViewDelegate();
	private EmployeeDelegate employeeDelegate = new EmployeeDelegate();
	private ReimbursementDelegate reimDelegate = new ReimbursementDelegate();
	private AuthDelegate authDelegate = new AuthDelegate();

	public RequestHelper() {
		super();

	}

	public void processGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException, SQLException {
		String path = request.getServletPath();
		if (path.startsWith("/api/")) {

			if (!authDelegate.isAuthorized(request)) {
				response.sendError(401);
				return;
			}

			String record = path.substring(5);
			switch (record) {
			case "employee":
				employeeDelegate.getEmployees(request, response);
				break;
			case "pendingreimbursement":
				reimDelegate.getPendingReimbursement(request, response);
				break;
			case "resolvedreimbursement":
				reimDelegate.getResolvedReimbursement(request, response);
				break;
			case "allpending":
				reimDelegate.getPendingReimbursement(request, response);
				break;
			case "allresolved":
				reimDelegate.getResolvedReimbursement(request, response);
				break;
//			case "viewpendingbyid":
//				reimDelegate.viewPendingById(request, response);
//				break;
			default:
				response.sendError(404, "Request Record(s) Not Found");
			}
		} else

		{
			viewDelegate.returnView(request, response);
		}

	}

	public void processPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException, SQLException {
		String path = request.getServletPath();
		switch (path) {
		case "/login":
			authDelegate.authenticate(request, response);
			break;
		case "/updateemployee":
			employeeDelegate.updateEmployee(request, response);
			break;
		case "/createreimbursement":
			reimDelegate.createReimbursement(request, response);
			break;
		case "/approveordeny":
			reimDelegate.resolveReimbursement(request, response);
			break;
		default:
			response.sendError(405);
		}
	}

}
