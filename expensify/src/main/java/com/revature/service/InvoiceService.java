package com.revature.service;

import java.util.List;

import com.revature.dao.InvoiceDao;
import com.revature.dao.impl.InvoiceDaoImpl;
import com.revauture.model.Invoice;

public class InvoiceService {

	private InvoiceDao invoiceDao = new InvoiceDaoImpl();
	
	public List<Invoice> getInvoices(){
		return invoiceDao.getInvoices();
	}
	
	public Invoice getInvoiceById(int id) {
		return invoiceDao.getInvoiceById(id);
	}
	
	public boolean deleteInvoice(Invoice i) {
		int acctCreated = invoiceDao.deleteInvoice(i);
		if(acctCreated != 0) {
			return true;
		}
		return false;
	}
	
	
	public boolean createInvoice(Invoice i) {
		int acctCreated = invoiceDao.createInvoice(i);
		if(acctCreated != 0) {
			return true;
		}
		return false;
	}
	public boolean updateInvoice(Invoice i) {
		int acctCreated = invoiceDao.updateInvoice(i);
		if(acctCreated != 0) {
			return true;
		}
		return false;
	}
}
