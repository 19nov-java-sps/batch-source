package com.revature.dao;

import java.util.List;

import com.revature.model.Invoice;

public interface InvoiceDao {
	
	public List<Invoice> getInvoiceTable();
	public Invoice getInvoiceById(int invoiceId);
	public int createInvoice(Invoice i);
	public int updateInvoice(Invoice i);
	public int deleteInvoice(int userId);	
	public int approved(boolean pending, boolean approved, boolean denied, boolean resolved, int invoiceId);
	public int denied(boolean pending, boolean approved, boolean denied, boolean resolved, int invoiceId);


}
