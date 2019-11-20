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
	
	@Test
	public void gettingAllClients() {
		
		List<Client> clientList = new ArrayList<>();
		clientList.add(new Client());
		clientList.add(new Client());
		clientList.add(new Client());
		when(cd.getClient()).thenReturn(clientList);
		assertEquals(cs.getClient().size(),3);
		
	}
	
	@Test
	public void testUpdateClient() {
		boolean expected = true;
		Client client = new Client();
		client.setUserId(1);
		client.setUsername("pnguye17");
		
		when(cd.updateClient(client)).thenReturn(1);
		boolean actual = cs.updateClient(client);
		assertEquals(expected, actual);
	}
	
	@Test
	public void testDeleteBankAcct() {
		boolean expected = true;
		Client client = new Client();
		client.setUserId(1);
		client.setUsername("pnguye17");
		
		when(cd.updateClient(client)).thenReturn(1);
		boolean actual = cs.updateClient(client);
		assertEquals(expected, actual);
	}
	

	

}
