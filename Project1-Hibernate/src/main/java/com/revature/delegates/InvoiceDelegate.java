package com.revature.delegates;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.dao.InvoiceDao;
import com.revature.dao.impl.InvoiceDaoImpl;
import com.revature.model.Invoice;

public class InvoiceDelegate {

	private InvoiceDao invoiceDao = new InvoiceDaoImpl();

	public void getInvoices(HttpServletRequest request, HttpServletResponse response) throws IOException{
		String idStr = request.getParameter("id");
		if(idStr == null) {
			List<Invoice> invoice = invoiceDao.getInvoiceTable();
			try(PrintWriter pw = response.getWriter();){
				pw.write(new ObjectMapper().writeValueAsString(invoice));
			}	
		} else {
			if(idStr.matches("^\\d+$")) {
				System.out.println(idStr);
				Invoice i = invoiceDao.getInvoiceById(Integer.parseInt(idStr));
				System.out.println("reaching invoice Delgate");
				if(i==null) {
					response.sendError(404, "No user with given ID");
				} else {
					try(PrintWriter pw = response.getWriter()){
						pw.write(new ObjectMapper().writeValueAsString(i));
					}
				}
			} else {
				response.sendError(400, "Invalid ID param");
			}
		}
	}
	
	public void newInvoice(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		String userId = request.getParameter("userId");
		String amount = request.getParameter("amount");
		String description = request.getParameter("description");
		String pending = request.getParameter("pending");
		String approved = request.getParameter("approved");
		String denied = request.getParameter("denied");
		String resolved = request.getParameter("resolved");
		
		
		int invoiceCreated;
		Invoice i = new Invoice(Integer.parseInt(userId), Double.valueOf(amount), description, Boolean.parseBoolean(pending), Boolean.parseBoolean(approved), Boolean.parseBoolean(denied), Boolean.parseBoolean(resolved));
		
		invoiceCreated = invoiceDao.createInvoice(i);
				
	}
	
	public void approved(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		String pending = request.getParameter("pending");
		String approved = request.getParameter("approved");
		String denied = request.getParameter("denied");
		String resolved = request.getParameter("resolved");
		String invoiceId = request.getParameter("invoiceId");
		
		int updated;
		updated = invoiceDao.approved(Boolean.parseBoolean(pending), Boolean.parseBoolean(approved), Boolean.parseBoolean(denied), Boolean.parseBoolean(resolved), Integer.parseInt(invoiceId));
		
	}
	
	public void denied(HttpServletRequest request, HttpServletResponse response) throws IOException {
			
			String pending = request.getParameter("pending");
			String approved = request.getParameter("approved");
			String denied = request.getParameter("denied");
			String resolved = request.getParameter("resolved");
			String invoiceId = request.getParameter("invoiceId");
			
			int updated;
			updated = invoiceDao.denied(Boolean.parseBoolean(pending), Boolean.parseBoolean(approved), Boolean.parseBoolean(denied), Boolean.parseBoolean(resolved), Integer.parseInt(invoiceId));
			
		}

	
	
}
