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
		
	}
	
	
	@Test
	public void testUpdateInvoice() {
		
	}
	
	
	@Test
	public void testGetInvoiceById() {
		
	}
	
	
	@Test
	public void testCreatInvoice() {
		
	}
	
	
}
