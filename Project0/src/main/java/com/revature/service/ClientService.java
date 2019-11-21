package com.revature.service;

import java.util.List;

import com.revature.dao.ClientDao;
import com.revature.dao.impl.ClientDaoImpl;
import com.revature.model.Client;

/* A Service class/interface provides a way for a client to interact
 * with functionality in the application. 
 * The service layer is there to provide logic to operate on the data
 * sent to and from the DAO and the client
 */


public class ClientService {
	
	private ClientDao clientDao = new ClientDaoImpl();
	
	public ClientService() {
		super();
	}
	
	// Returns all the clients in the database 
	public List<Client> getClientTable(){
		return clientDao.getClientTable();
	}
	
	// Returns a client by their username
	public Client getClient(String username) {
		return clientDao.getClient(username);
	}

	// Creates a new user and returns true or false
	// if the client was created or not
	public String createClient(Client c) {
		int clientsCreated = clientDao.createClient(c);
		if(clientsCreated != 0) {
			return "\n Client Created! \n";
		}
		return "\n Error! Could not create client. \n";
	}
		
	// Performs an update and it invokes it with client DAO
	public boolean updateClient(String username, double newBalance) {
		return clientDao.updateClient(username, newBalance);
	}
	
	
	// Deletes a user and returns true or false
	// if the user was deleted or not
	public int deleteClient(String username) {
		return clientDao.deleteClient(username);
	}


}
