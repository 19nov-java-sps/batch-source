package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.dao.ReimbursementDao;
import com.revature.daoimpl.ReimbursmentDaoImpl;
import com.revature.model.Reimbursement;


public class ReimbursementServlet extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private ReimbursementDao reimbDao = new ReimbursmentDaoImpl();
	
	public ReimbursementServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ObjectMapper om = new ObjectMapper();
		
		String idStr = request.getParameter("reimId");
		
		if(idStr!=null) {
			if(idStr.matches("^\\d+$")) {
				int id = Integer.parseInt(idStr);
				Reimbursement r = reimbDao.getReimbursementById(id);
				if(r==null) {
					response.sendError(404);
				} else {
					String reimbJSON = om.writeValueAsString(r);
					try(PrintWriter pw = response.getWriter()){
						pw.write(reimbJSON);
					}
				}
			} else {
				response.sendError(400);
			}
		} else {
			List<Reimbursement> reimbursements = reimbDao.getAllReimbursement();	
			
			String reimbJSON = om.writeValueAsString(reimbursements);
			
			try(PrintWriter pw = response.getWriter()){
				pw.write(reimbJSON);
			}
		}
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String newReimb = request.getParameter("descr");
		String newSum = request.getParameter("sum");
		
	//	System.out.println(newReimb + " in ammount of "+newSum);
		
		Reimbursement r = new Reimbursement();
		r.setDescr(newReimb);
		r.setSum(Double.parseDouble(newSum));
	
	
		
	reimbDao.createReimbursement(r);
		
		response.sendRedirect("reimbursements");
		
	}

	

}
