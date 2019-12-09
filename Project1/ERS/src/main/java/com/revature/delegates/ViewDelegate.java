package com.revature.delegates;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ViewDelegate {

	public void returnView(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		String path = request.getServletPath();
		switch (path) {
		case "/login":
			request.getRequestDispatcher("/static/views/Login.html").forward(request, response);
			break;
		case "/home":
			request.getRequestDispatcher("/static/views/Home.html").forward(request, response);
			break;
		case "/myprofile":
			request.getRequestDispatcher("/static/views/MyProfile.html").forward(request, response);
			break;
		case "/viewemployees":
			request.getRequestDispatcher("/static/views/ViewEmployees.html").forward(request, response);
			break;
		case "/updateemployee":
			request.getRequestDispatcher("/static/views/UpdateEmployee.html").forward(request, response);
			break;
		case "/createreimbursement":
			request.getRequestDispatcher("/static/views/CreateReimbursement.html").forward(request, response);
			break;
		case "/pending":
			request.getRequestDispatcher("/static/views/MyPendingReimbursements.html").forward(request, response);
			break;
		case "/resolved":
			request.getRequestDispatcher("/static/views/MyResolvedReimbursements.html").forward(request, response);
			break;
		case "/managerpending":
			request.getRequestDispatcher("/static/views/ManagerPending.html").forward(request, response);
			break;
		case "/managerresolved":
			request.getRequestDispatcher("/static/views/ManagerResolved.html").forward(request, response);
			break;
		case "/approveordeny":
			request.getRequestDispatcher("/static/views/ApproveOrDeny.html").forward(request, response);
			break;
		case "/searchinvoiceid":
			request.getRequestDispatcher("/static/views/SearchInvoiceById.html").forward(request, response);
			break;
		default:
			response.sendError(404, "static resource not found");
		}
	}
}
