package com.revature.delegates;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.dao.ReimbursementDao;
import com.revature.daoimpl.ReimbursementDaoImpl;
import com.revature.models.Employee;
import com.revature.models.Reimbursement;
import com.revature.servicelayer.ReimbursementService;

public class ReimbursementDelegate {

	private ReimbursementDao reimbursementDao = new ReimbursementDaoImpl();
	private ReimbursementService reimService = new ReimbursementService();

	// gets all pending reimbursements
	public void getPendingReimbursement(HttpServletRequest request, HttpServletResponse response) throws IOException {

		List<Reimbursement> reim = reimbursementDao.getPendingReimbursements();
//				getPendingReimbursementById(Integer.parseInt(idString));
//				reimbursementDao.getPendingReimbursements()
//		System.out.println("I made it to getPendingReimbursement");
		try (PrintWriter pw = response.getWriter();) {
			pw.write(new ObjectMapper().writeValueAsString(reim));
			System.out.println(reim);
		}
	}

	// gets all resolved reimbursements
	public void getResolvedReimbursement(HttpServletRequest request, HttpServletResponse response) throws IOException {
		List<Reimbursement> reim = reimbursementDao.getResolvedReimbursements();
		System.out.println("I made it to getResolvedReimbursement");
		try (PrintWriter pw = response.getWriter();) {
			pw.write(new ObjectMapper().writeValueAsString(reim));
			System.out.println(reim);
		}
	}

	// creates a reimbursement request
	public void createReimbursement(HttpServletRequest request, HttpServletResponse response)
			throws IOException, SQLException {
		String path = request.getServletPath();
		System.out.println("I am in ReimbursementDelegate." + " Servlet path is " + path);
		String reason = request.getParameter("reason");
		String amount = request.getParameter("amount");
		double parseAmount = Double.parseDouble(amount);
		String id = request.getParameter("id");
		int parseId = Integer.parseInt(id);

		Reimbursement r = new Reimbursement(parseId, parseAmount, reason, true, false, false, false);

		reimService.createReimbursement(r);
		System.out.println(reimService.createReimbursement(r));

	}

	public void approved(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String pending = request.getParameter("pending");
		String approved = request.getParameter("approved");
		String denied = request.getParameter("denied");
		String resolved = request.getParameter("resolved");
		String reimbursementID = request.getParameter("reimbursementID");
		
		int convertedBooleans;
		convertedBooleans = reimbursementDao.approved(Boolean.parseBoolean(pending), Boolean.parseBoolean(approved),
				Boolean.parseBoolean(denied), Boolean.parseBoolean(resolved), Integer.parseInt(reimbursementID));

	}

	public void denied(HttpServletRequest request, HttpServletResponse response) throws IOException{
		String pending = request.getParameter("pending");
		String approved = request.getParameter("approved");
		String denied = request.getParameter("denied");
		String resolved = request.getParameter("resolved");
		String reimbursementID = request.getParameter("reimbursementID");

		int convertedBooleans;
		convertedBooleans = reimbursementDao.denied(Boolean.parseBoolean(pending), Boolean.parseBoolean(approved),
				Boolean.parseBoolean(denied), Boolean.parseBoolean(resolved), Integer.parseInt(reimbursementID));

	}

}