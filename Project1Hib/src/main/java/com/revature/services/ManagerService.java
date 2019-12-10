package com.revature.services;

import java.util.List;

import com.revature.daos.ManagerDao;
import com.revature.daos.ManagerDaoImpl;
import com.revature.models.Manager;

public class ManagerService {
	
	private ManagerDao md = new ManagerDaoImpl();

	public ManagerService() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public List<Manager> getManagers() {
		
		return md.getManagers();
	}
	
	public Manager getManagerByUsername(String username) {
		
		return md.getManagerByUsername(username);
	}
}
