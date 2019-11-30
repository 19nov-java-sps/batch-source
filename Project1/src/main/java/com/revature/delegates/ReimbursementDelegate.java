package com.revature.delegates;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.Reimbursement;
import com.revature.services.ReimbursementService;

public class ReimbursementDelegate {
	
	private ReimbursementService rs = new ReimbursementService();

	public void getPendingReimbursements(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		String idStr = request.getParameter("id");
		
		if (idStr == null) {
			List<Reimbursement> reimbursements = rs.viewPendingReim();
			
			try(PrintWriter pw = response.getWriter();){
				pw.write(new ObjectMapper().writeValueAsString(reimbursements));
			}
		} else {
			if (idStr.matches("^\\d+$")) {
				List<Reimbursement> reimbursements = rs.viewPendingReimById(Integer.parseInt(idStr));
				try(PrintWriter pw = response.getWriter()){
					pw.write(new ObjectMapper().writeValueAsString(reimbursements));
				}
			} else {
				response.sendError(400, "Invalid ID param");
			}
		}

	}
	
	public void getResolvedReimbursements(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		String idStr = request.getParameter("id");
		
		if (idStr == null) {
			List<Reimbursement> reimbursements = rs.viewResolvedReim();
			
			try(PrintWriter pw = response.getWriter();){
				pw.write(new ObjectMapper().writeValueAsString(reimbursements));
			}
		} else {
			if (idStr.matches("^\\d+$")) {
				List<Reimbursement> reimbursements = rs.viewResolvedReimById(Integer.parseInt(idStr));
				try(PrintWriter pw = response.getWriter()){
					pw.write(new ObjectMapper().writeValueAsString(reimbursements));
				}
			} else {
				response.sendError(400, "Invalid ID param");
			}
		}
		
	}
	
	public void getReimbursements(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		String idStr = request.getParameter("id");
		
		if (idStr.matches("^\\d+$")) {
			Reimbursement reimbursement = rs.viewReimbursementById(Integer.parseInt(idStr));
			
			if (reimbursement == null) {
				response.sendError(404, "No reimbursement with given ID");
			} else {
				try(PrintWriter pw = response.getWriter()){
					pw.write(new ObjectMapper().writeValueAsString(reimbursement));
				}
			}
		} else {
			response.sendError(400, "Invalid ID param");
		}
	}
}
