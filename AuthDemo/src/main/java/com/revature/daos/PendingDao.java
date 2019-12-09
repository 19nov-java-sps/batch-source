package com.revature.daos;

import java.util.List;

import com.revature.models.Pending;

public interface PendingDao {
	
	public List<Pending> getAll();
	public List<Pending> getAll(String username);
	public Pending getRequestByUsername(String username);
	public int createPending(String username, String reason, int amount);
}
