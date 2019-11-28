package com.revature.dao;

import java.util.List;

import com.revauture.model.Invoice;

public interface InvoiceDao {
	
	public List<Invoice> getInvoices(Invoice i);
	public Invoice getInvoiceById(int id);
	public int deleteInvoice(Invoice i);
	public int createInvoice(Invoice i);
	public int updateInvoice(Invoice i);
}
