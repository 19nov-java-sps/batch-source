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
import com.revature.model.Invoice;

@RunWith(MockitoJUnitRunner.class)
public class InvoiceServiceTest {
	
	@InjectMocks
	private InvoiceService is;
	
	@Mock
	private InvoiceDao id;
	
		// Test the createInvoice method
		@Test
		public void testCreatingInvoice() {
			
			String expected = "\n Invoice Created! \n";
			
			Invoice i = new Invoice(1234, 567, "Certification Expense", true, false, false, false);
			
			when(id.createInvoice(i)).thenReturn(1);
			
			String actual = is.createInvoice(i);
			
			assertEquals(expected, actual);
		}
	
		
		// Tests the getInvoiceTable method
		@Test
		public void testGetInvoiceTable() {
			
			List<Invoice> invoiceTable = new ArrayList<>();
			
			invoiceTable.add(new Invoice());
			invoiceTable.add(new Invoice());
			
			when(id.getInvoiceTable()).thenReturn(invoiceTable);
			
			assertEquals(is.getInvoiceTable().size(),2);
		}
		


}
