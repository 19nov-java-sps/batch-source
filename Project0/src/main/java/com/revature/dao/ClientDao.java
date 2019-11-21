package com.revature.dao;

import java.util.List;

import com.revature.model.Client;

// DAO: Data Access Object - an object or in this case an interface 
// that provides access to an underlying database

public interface ClientDao { 
	
		public List<Client> getClientTable(); // Used to view all the clients in the clients table
		public Client getClient(String username); // Used to get client info by their username 
		public int createClient(Client c); // Used to create a new client
		public boolean updateClient(String username, double newBalance); // Used to update client balance & perform withdrawals & deposits
		public int deleteClient(String username); // Used to delete a client
		
}
