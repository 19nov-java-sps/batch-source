package com.revature.dao;

import java.util.List;

import com.revauture.model.Invoice;

public interface InvoiceDao {
	
	public List<Invoice> getInvoices();
	public Invoice getInvoiceById(int id);
	public Invoice getInvoiceByInvoiceId(int id);
	public List<Invoice> getInvoiceByUserId(int id);
	public int deleteInvoice(Invoice i);
	public int createInvoice(Invoice i);
	public int updateInvoice(Invoice i);
	
	
}


