package com.revature.service;


import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.revature.dao.InvoiceDao;
import com.revauture.model.Invoice;

@RunWith(MockitoJUnitRunner.class)
public class InvoiceServiceTest {

	@InjectMocks
	private InvoiceService invoiceService;
	
	@Mock
	private InvoiceDao invoiceDao;
	
	@Test
	public void testGetInvoice() {
		List<Invoice> invoicesList = new ArrayList<>();
		invoicesList.add(new Invoice());
		when(invoiceDao.getInvoices()).thenReturn(invoicesList);
		assertEquals(invoiceService.getInvoices().size(),1);
		
	}
	
	
	@Test
	public void testDeleteInvoice() {
		boolean expected = true;
		Invoice invoice = new Invoice();
		invoice.setUserId(1);
		invoice.setInvoiceId(1);
		when(invoiceDao.deleteInvoice(invoice)).thenReturn(1);
		boolean actual= invoiceService.deleteInvoice(invoice);
		assertEquals(expected, actual);
	}
	
	
	@Test
	public void testUpdateInvoice() {
		boolean expected = true;
		Invoice invoice = new Invoice();
		invoice.setUserId(2);
		invoice.setInvoiceId(1);
		when(invoiceDao.updateInvoice(invoice)).thenReturn(1);
		boolean actual= invoiceService.updateInvoice(invoice);
		assertEquals(expected, actual);
	}
	
	
	@Test
	public void testGetInvoiceById() {
//		Invoice invoice = new Invoice();
//		invoice.setInvoiceId(1);
//		invoice.setAmount(100.00);
//		invoice.setDescription("Testing the Junit");
//		
//		when(invoiceDao.getInvoiceById(1)).thenReturn(1);
//		assertEquals(invoiceService.g
//		
//		
		
	}
	
	
	@Test
	public void testCreateInvoice() {
		boolean expected = true;
		Invoice invoice = new Invoice();
		when(invoiceDao.createInvoice(invoice)).thenReturn(1);
		boolean actual =  invoiceService.createInvoice(invoice);
		assertEquals(expected, actual);
		
	}
	
	
}
