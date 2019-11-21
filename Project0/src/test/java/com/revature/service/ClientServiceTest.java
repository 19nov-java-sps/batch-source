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

import com.revature.dao.ClientDao;
import com.revature.model.Client;

@RunWith(MockitoJUnitRunner.class)
public class ClientServiceTest {
	
	@InjectMocks
	private ClientService cs;
	
	@Mock
	private ClientDao cd;
	
	// Tests the createClient method
	@Test
	public void testCreatingClient() {
		
		String expected = "\n Client Created! \n";
		
		Client c = new Client("revatureguy", "revaturejava123", "john", "doe", 125);
		
		when(cd.createClient(c)).thenReturn(1);
		
		String actual = cs.createClient(c);
		
		assertEquals(expected, actual);
	}
	
	// Tests the updateClient method
	@Test
	public void testUpdatingClient() {
		
		boolean expected = true;
		
		Client c = new Client("revatureguy", "revaturejava123", "john", "doe", 250);
		
		when(cd.updateClient(c.getUsername(), c.getClientBalance())).thenReturn(true);
		
		boolean actual = cs.updateClient(c.getUsername(), c.getClientBalance());
		
		assertEquals(expected, actual);
	}
	
	// Tests the deleteClient method
	@Test
	public void testDeletingClient() {
		
		int expected = 1;
		
		Client c = new Client("revatureguy", "revaturejava123", "john", "doe", 125);
		
		when(cd.deleteClient(c.getUsername())).thenReturn(1);
		
		int actual = cs.deleteClient(c.getUsername());
		
		assertEquals(expected, actual);
	}
	
	// Tests the getClientTable method
	@Test
	public void testGetClientTable() {
		
		List<Client> clientTable = new ArrayList<>();
		
		clientTable.add(new Client());
		clientTable.add(new Client());
		
		when(cd.getClientTable()).thenReturn(clientTable);
		
		assertEquals(cs.getClientTable().size(),2);
	}
}