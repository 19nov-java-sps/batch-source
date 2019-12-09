package com.revature.services;

import java.util.List;
import java.sql.SQLException;
import java.util.Scanner;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.revature.models.User;
import com.revature.util.ConnectionUtil;
import java.util.List;

import com.revature.daos.PendingDaoImpl;
import com.revature.daos.ResolvedDao;
import com.revature.daos.ResolvedDaoImpl;
import com.revature.models.Resolved;

public class ResolvedService {
	
	public List<Resolved> getAll(){
		return ResolvedDaoImpl.getInstance().getAll();
	}
	
	public Resolved getRequestByUsername(String username) {
		return ResolvedDaoImpl.getInstance().getRequestByUsername(username);
	}
	
	public int createResolvedDeletePending(int requestid, String status, String manager) {
		return ResolvedDaoImpl.getInstance().createResolvedDeletePending(requestid,status,manager);
	}
	
}
	
