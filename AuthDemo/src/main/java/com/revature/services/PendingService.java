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

import com.revature.daos.PendingDao;
import com.revature.daos.PendingDaoImpl;
import com.revature.daos.UserDaoImpl;
import com.revature.models.Pending;

public class PendingService {
	
	public List<Pending> getAll(){
		return PendingDaoImpl.getInstance().getAll();
	}
	public Pending getRequestByUsername(String username) {
		return PendingDaoImpl.getInstance().getRequestByUsername(username);
	}
	
}
