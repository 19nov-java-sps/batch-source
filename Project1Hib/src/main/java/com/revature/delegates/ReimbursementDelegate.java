package com.revature.delegates;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.Employee;
import com.revature.models.Reimbursement;
import com.revature.services.EmployeeService;
import com.revature.services.ReimbursementService;

public class ReimbursementDelegate {
	
	private ReimbursementService rs = new ReimbursementService();
	private EmployeeService es = new EmployeeService();	// used to get the name of the employee when creating a reimbursement
	
	public void getReimbursements(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		// assigns what came with the request.
		String username = request.getParameter("username");
		String status = request.getParameter("status");
				
		if (username == null && status == null) {
			List<Reimbursement> reimbursements = rs.getReimbursements();
			
			try(PrintWriter pw = response.getWriter()) {
				pw.write(new ObjectMapper().writeValueAsString(reimbursements));
			}
		} else if (status == null) {
			List<Reimbursement> reimbursementsByUsername = rs.getReimbursementsByUsername(username);
			
			if (reimbursementsByUsername.size() == 0) {
				response.sendError(404);
			} else {
				try(PrintWriter pw = response.getWriter()) {
					pw.write(new ObjectMapper().writeValueAsString(reimbursementsByUsername));
				}
			}
		} else if (username == null) {
			List<Reimbursement> reimbursementsByStatus = rs.getReimbursementsByStatus(status);
			
			if (reimbursementsByStatus.size() == 0) {
				response.sendError(404);
			} else {
				try(PrintWriter pw = response.getWriter()) {
					pw.write(new ObjectMapper().writeValueAsString(reimbursementsByStatus));
				}
			}
		} else {
			List<Reimbursement> reimbursementsByStatusAndUsername = rs.getReimbursementsByStatusAndUsername(status, username);
			
			if (reimbursementsByStatusAndUsername.size() == 0) {
				response.setStatus(400);
			} else {
				try(PrintWriter pw = response.getWriter()) {
					pw.write(new ObjectMapper().writeValueAsString(reimbursementsByStatusAndUsername));
				}
			}
		}
	}
	
	public void updateReimbursement(HttpServletRequest request) throws IOException {
		
		// Assigns what came with the request
		String reim_id = request.getParameter("reim_id");
		String managerName = request.getParameter("managerName");
		String status = request.getParameter("status");
		
		rs.updateReimbursement(Integer.parseInt(reim_id), managerName, status);
	}
		
	public void createReimbursement(HttpServletRequest request) throws IOException {
		
		// Assigns what came with the request
		String amount = request.getParameter("amount");
		String description = request.getParameter("description");
		String status = "Pending";	// Since its a new reimbursement its automatically "Pending"
		String username = request.getParameter("username");
		String manName = "Manager-name-here";	// we set this later when we resolve a reimbursement
		
		Employee e = es.getEmployeeByUsername(username);	// gets employee by username
		String name = e.getfName() + " " + e.getlName();	// assigns employee name to then set on the reimbursement.
		
		Reimbursement r = new Reimbursement();
		r.setAmount(Double.parseDouble(amount));
		r.setDescription(description);
		r.setStatus(status);
		r.setName(name);
		r.setUsername(username);
		r.setManagerName(manName);
		
		rs.createReimbursement(r);
		
	}
}

