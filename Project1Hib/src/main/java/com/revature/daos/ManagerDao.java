package com.revature.daos;

import java.util.List;

import com.revature.models.Manager;

public interface ManagerDao {
	
	public List<Manager> getManagers();
	public Manager getManagerByUsername(String username);
}
