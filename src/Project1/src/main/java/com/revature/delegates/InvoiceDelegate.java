package com.revature.delegates;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.daos.InvoiceDao;
import com.revature.daos.impls.InvoiceDaoImpl;
import com.revature.models.Invoice;

public class InvoiceDelegate {

	private InvoiceDao iDao = new InvoiceDaoImpl();
// get all invoices	
	public void getInvoices(HttpServletRequest request, HttpServletResponse response) throws IOException {
		List<Invoice> myInvoice = iDao.getAll();
		ObjectMapper om = new ObjectMapper();
		String invoiceJSON = om.writeValueAsString(myInvoice);
		try(PrintWriter pw = response.getWriter()){
			pw.write(invoiceJSON);
		}
	}
// get invoices by id	
	public void getInvoicesByUserId(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String USERID = request.getParameter("USERID");
		int userID = Integer.parseInt(USERID);
		List<Invoice> myInvoice = iDao.getInvoiceByUserId(userID);
		ObjectMapper om = new ObjectMapper();
		String invoiceJSON = om.writeValueAsString(myInvoice);
		try (PrintWriter pw = response.getWriter()){
			pw.write(invoiceJSON);
		}
	}
	
	public void createInvoice(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String amount = request.getParameter("amount");
		String userID = request.getParameter("userid");	
		Invoice invo = new Invoice();
		if(amount.matches("^\\d+$")) {
			invo.setUser_id(Integer.parseInt(userID));
			invo.setAmount(Integer.parseInt(amount));
		}
		
		iDao.createInvoice(invo);
	}
	
	public void approveInvoice(HttpServletRequest request, HttpServletResponse response) {
		String managerId = request.getParameter("MANAGERID");
		String invoiceId = request.getParameter("INVOICEID");
		
		int newManagerID = Integer.parseInt(managerId);
		int newInvoiceID = Integer.parseInt(invoiceId);
		
		iDao.approveInvoice(newManagerID, newInvoiceID);
	}
	
	public void rejectInvoice(HttpServletRequest request, HttpServletResponse response) {
		String managerId = request.getParameter("MANAGERID");
		String invoiceId = request.getParameter("INVOICEID");
		
		int newManagerID = Integer.parseInt(managerId);
		int newInvoiceID = Integer.parseInt(invoiceId);
		
		iDao.rejectInvoice(newManagerID, newInvoiceID);
	}
}
