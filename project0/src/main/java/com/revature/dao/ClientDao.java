package com.revature.dao;

import java.util.List;

import com.revature.model.Client;

public interface ClientDao {
	
	public List<Client> getClient();
	public int createClient(Client c);
	public int updateClient(Client c);
	public int deleteClient(Client c);
	public int createBankAcctWhenClientEnrolls(Client c);
	public Client getClientByUserId(int id);
}
