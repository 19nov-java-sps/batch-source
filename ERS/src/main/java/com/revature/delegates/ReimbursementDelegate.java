package com.revature.delegates;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.dao.ReimbursementDao;
import com.revature.daoimpl.ReimbursementDaoImpl;
import com.revature.models.Reimbursement;

public class ReimbursementDelegate {

	private ReimbursementDao reimbursementDao = new ReimbursementDaoImpl();

	public void getReimbursement(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String idStr = request.getParameter("id");
		if (idStr == null) {
			List<Reimbursement> reimbursement = reimbursementDao.getAllReimbursements();
			try (PrintWriter pw = response.getWriter();) {
				pw.write(new ObjectMapper().writeValueAsString(reimbursement));
			}
		} else {
			if (idStr.matches("^\\d+$")) {
				Reimbursement r = reimbursementDao.getReimbursementById(Integer.parseInt(idStr));
				if (r == null) {
					response.sendError(404, "No user with given ID");
				} else {
					try (PrintWriter pw = response.getWriter()) {
						pw.write(new ObjectMapper().writeValueAsString(r));
					}
				}
			} else {
				response.sendError(400, "Invalid ID param");
			}
		}

	}
}
