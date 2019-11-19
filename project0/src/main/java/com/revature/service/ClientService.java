package com.revature.service;

import java.util.List;

import com.revature.dao.ClientDao;
import com.revature.dao.impl.ClientDaoImpl;
import com.revature.model.Client;

public class ClientService {
	
	private ClientDao clientDao = new ClientDaoImpl();
	
	public List<Client> getClient(){
		return clientDao.getClient();
	}
	
	public boolean createClient(Client c) {
		int i =  clientDao.createClient(c);
		if (i !=  0) {
			return true;
		}  else {
			return false;
		}
		
	}
	
	public boolean deleteClient(Client c) {
		int i =  clientDao.deleteClient(c);
		if (i !=  0) {
			return true;
		}  else {
			return false;
		}
		
	}
	
	public boolean updateClient(Client c) {
		int i =  clientDao.updateClient(c);
		if (i !=  0) {
			return true;
		}  else {
			return false;
		}
		
	}
	

}
