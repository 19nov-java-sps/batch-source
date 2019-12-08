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
	
		// Tests the updateInvoice method
		@Test
		public void testUpdatingInvoice() {
			
			String expected = "\n Invoice Updated! \n";
			
			Invoice i = new Invoice(1234, 567, "Certification Expense", false, true, false, true);
			
			when(id.updateInvoice(i)).thenReturn(1);
			
			String actual = is.updateInvoice(i);
			
			assertEquals(expected, actual);
		}
		
		// Tests the deleteInvoice method
		@Test
		public void testDeletingInvoice() {
			
			int expected = 1;
			
			Invoice i = new Invoice(1234, 567, "Certification Expense", true, false, false, false);
			
			when(id.deleteInvoice(i.getUserId())).thenReturn(1);
			
			int actual = is.deleteInvoice(i.getUserId());
			
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
