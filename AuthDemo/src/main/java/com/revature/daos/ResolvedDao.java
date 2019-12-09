package com.revature.daos;

import java.util.List;

import com.revature.models.Resolved;

public interface ResolvedDao {

	public List<Resolved> getAll();
	public List<Resolved> getAll(String username);
	public Resolved getRequestByUsername(String username);
	public int createResolvedDeletePending(int requestid, String status, String manager);
}
