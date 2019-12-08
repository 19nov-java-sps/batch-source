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
	public void denyInvoice(HttpServletRequest request, HttpServletResponse response) throws IOException{
		String invoiceIdString =  request.getParameter("invoiceId");
		System.out.println(invoiceIdString);
		System.out.print(Integer.parseInt(invoiceIdString));
		Invoice invoice = invoiceDao.getInvoiceByInvoiceId(Integer.parseInt(invoiceIdString));
		if (invoice!=null) {
			invoice.setPending(false);
			invoice.setApproved(false);
			invoice.setRejected(true);
			invoice.setResolved(true);
			invoiceDao.updateInvoice(invoice);
		} else {
			response.sendError(404, "No resource found");
		}
		
				
	}
	public void approveInvoice(HttpServletRequest request, HttpServletResponse response) throws IOException{
		String invoiceIdString =  request.getParameter("invoiceId");
		System.out.println("in the invoice delegate");
		Invoice invoice = invoiceDao.getInvoiceByInvoiceId(Integer.parseInt(invoiceIdString));
		System.out.println(invoice.toString());
	}
	
}
