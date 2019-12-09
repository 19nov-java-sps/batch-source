package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import delegates.*; 

public class RequestHelper {
	
	private ViewDelegate viewDelegate = new ViewDelegate();
	private EmployeeDelegate emplDelegate = new EmployeeDelegate();
	private AuthDelegate authDelegate = new AuthDelegate();
	private ReimbursementDelegate reimbursementDelegate = new ReimbursementDelegate();
	private DepartmentDelegate departmentDelegate = new DepartmentDelegate();

	public void processGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String path = request.getServletPath();
		if(path.startsWith("/api/")) {
			if(!authDelegate.isAuthorized(request)) {
				response.sendError(401);
				return;
			}
			
			String record = path.substring(5);
			switch(record) {		
			case "employees":
				emplDelegate.getEmployees(request, response);
				break;
			case "reimbursements":
				reimbursementDelegate.getReimbursements(request, response);
				break;
			case "reimbursements/pending":
				reimbursementDelegate.getPendingReimbursements(request, response);
				break;
			case "reimbursements/resolved":
				reimbursementDelegate.getResolvedReimbursements(request, response);
				break;
			case "departments":
				departmentDelegate.getDepartments(request, response);
				break;
			default:
				response.sendError(404, "Not Found");
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
		case "/reimbursement/new":
			reimbursementDelegate.submitReimbursement(request, response);
			break;
		case "/employee/new":
			emplDelegate.registerEmpl(request, response);
			break;
		default:
			response.sendError(405);
		}
	}
	
	public void processPut(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String path = request.getServletPath();

		switch(path) {
		case "/reimbursement/update":
			reimbursementDelegate.resolveReimbursement(request, response);
			break;
		case "/employee/update":
			emplDelegate.updateEmployee(request, response);
			break;
		default:
			response.sendError(405);
		}
	}
}