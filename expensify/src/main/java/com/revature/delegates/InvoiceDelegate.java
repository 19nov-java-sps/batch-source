package com.revature.delegates;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.dao.InvoiceDao;

import com.revature.dao.impl.InvoiceDaoImpl;

import com.revauture.model.Invoice;

public class InvoiceDelegate {

	private InvoiceDao invoiceDao = new InvoiceDaoImpl();
	
	public void getInvoices(HttpServletRequest request, HttpServletResponse response) throws IOException{
		String idStr = request.getParameter("id");
		if(idStr == null) {
			List<Invoice> invoices = invoiceDao.getInvoices();
			try(PrintWriter pw = response.getWriter();){
				pw.write(new ObjectMapper().writeValueAsString(invoices));
			}	
		} else {
			if(idStr.matches("^\\d+$")) {
				Invoice invoice = invoiceDao.getInvoiceById(Integer.parseInt(idStr));
				if(invoice==null) {
					response.sendError(404, "No invoice with given ID");
				} else {
					try(PrintWriter pw = response.getWriter()){
						pw.write(new ObjectMapper().writeValueAsString(invoice));
					}
				}
			} else {
				response.sendError(400, "Invalid ID param");
			}
		}
	}
	public void getInvoicesByUserId(HttpServletRequest request, HttpServletResponse response) throws IOException{
		String idStr = request.getParameter("userid");
		
		System.out.println(idStr);
//			if(idStr.matches("^\\d+$")) {
				List<Invoice> invoice = invoiceDao.getInvoiceByUserId(Integer.parseInt(idStr));
				if(invoice==null) {
					response.sendError(404, "No resource found");
				} else {
					try(PrintWriter pw = response.getWriter()){
						pw.write(new ObjectMapper().writeValueAsString(invoice));
					}
		}
	}
	
	public void postInvoices(HttpServletRequest request, HttpServletResponse response) throws IOException{
		String amountString = request.getParameter("amount");
		String descriptionString = request.getParameter("description");
		String idString = request.getParameter("userid");
		Double  amountDouble = Double.valueOf(amountString);
		System.out.print(amountDouble);
		Invoice newInvoice = new Invoice();
		newInvoice.setAmount(amountDouble);
		newInvoice.setDescription(descriptionString);
		newInvoice.setUserId(Integer.parseInt(idString));
		newInvoice.setApproved(false);
		newInvoice.setPending(true);
		newInvoice.setResolved(false);
		newInvoice.setRejected(false);
		invoiceDao.createInvoice(newInvoice);
		if(newInvoice!=null) {
			try(PrintWriter pw = response.getWriter()){
					pw.write(new ObjectMapper().writeValueAsString(newInvoice));
			}
		}
	}
	public void approvedInvoice(HttpServletRequest request, HttpServletResponse response) throws IOException {

		String invoiceId = request.getParameter("invoiceId");
		
		invoiceDao.putApprovedCallable(Integer.parseInt(invoiceId));
		
		response.sendRedirect("/landing");
		
	}
	
	public void deniedInvoice(HttpServletRequest request, HttpServletResponse response) throws IOException {
			

			String invoiceId = request.getParameter("invoiceId");
			
			invoiceDao.putDenyCallable(Integer.parseInt(invoiceId));
			
			response.sendRedirect("/landing");
			
			
		
		}
	
}
