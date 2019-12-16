package com.revature.dao.impl;


import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.revature.dao.InvoiceDao;
import com.revature.model.Invoice;
import com.revature.util.HibernateUtil;

public class InvoiceDaoImpl implements InvoiceDao{
	
	@Override
	public List<Invoice> getInvoiceTable(){
		
		List<Invoice> invoiceTable = null;
		try (Session s = HibernateUtil.getSession()) { 
			CriteriaBuilder cb = s.getCriteriaBuilder();
			CriteriaQuery<Invoice> cq = cb.createQuery(Invoice.class);
			
			cq.select(cq.from(Invoice.class));
			
			Query<Invoice> query = s.createQuery(cq);
			invoiceTable = query.list();
		}
		return invoiceTable; 
	}

	@Override
	public Invoice getInvoiceById(int invoiceId) {
		
		try (Session s = HibernateUtil.getSession()) {
				
			String hql = "from Invoice where invoice_id = :idVar";
			Query<Invoice> q = s.createQuery(hql, Invoice.class);
			q.setParameter("idVar", invoiceId);
			
			System.out.println(invoiceId);
			Invoice i = null;
			List<Invoice> invoices = q.list();
			System.out.println(invoices);
			if(invoices.size()>0) {
				i = q.list().get(0);
			}
			return i;
		}
		
	}

	@Override
	public int createInvoice(Invoice invoice) {
		
			int invoicesCreated = 0; 
			try(Session s = HibernateUtil.getSession()) {
				
				Transaction tx = s.beginTransaction();
				invoicesCreated = (int) s.save(invoice);
				tx.commit();
		}
		
		return invoicesCreated; 
	}


	
	public int approved(boolean pending, boolean approved, boolean denied, boolean resolved, int invoiceId) {
		
		try(Session s = HibernateUtil.getSession()) {
				
			Transaction tx = s.beginTransaction();
			Invoice i = this.getInvoiceById(invoiceId);
			System.out.println(i);
			i.setPending(pending);
			i.setApproved(approved);
			i.setDenied(denied);
			i.setResolved(resolved);
			i.setInvoiceId(invoiceId);
			s.update(i);
			tx.commit();
			
			return 1;
		}
	}
			
	
	public int denied(boolean pending, boolean approved, boolean denied, boolean resolved, int invoiceId) {
		

		try(Session s = HibernateUtil.getSession()) {
				
			Transaction tx = s.beginTransaction();
			Invoice i = this.getInvoiceById(invoiceId);
			i.setPending(pending);
			i.setApproved(approved);
			i.setDenied(denied);
			i.setResolved(resolved);
			i.setInvoiceId(invoiceId);
			s.update(i);
			tx.commit();
			
			return 1;
		}
	}
	

}

