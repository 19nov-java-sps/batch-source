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
}
