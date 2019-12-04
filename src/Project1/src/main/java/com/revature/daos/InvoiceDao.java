package com.revature.daos;

import java.util.List;

import com.revature.models.Invoice;

public interface InvoiceDao {

	public List<Invoice> getAll();
	public List<Invoice> getInvoiceByUserId(int id);
	public Invoice getInvoiceById(int id);
	public int createInvoice(Invoice i);
	public int approveInvoice(int managerId, int InvoiceId);
	public int rejectInvoice(int managerId, int InvoiceId);
}
