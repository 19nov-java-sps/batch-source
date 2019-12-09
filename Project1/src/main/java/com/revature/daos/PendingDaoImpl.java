package com.revature.daos;

import java.sql.*;
import java.util.*;

import com.revature.daos.PendingDao;
import com.revature.models.Pending;
import com.revature.util.ConnectionUtil;

public class PendingDaoImpl implements PendingDao{
	private static PendingDaoImpl pInstance;
	private List<Pending> p = new ArrayList<>();	

	public PendingDaoImpl() {
		this.loadAll();
		System.out.print( "Loaded " + p.size() + " users");
	}
	
	public static PendingDaoImpl getInstance( ) {
    	if( pInstance == null ) {
    		pInstance = new PendingDaoImpl();
    	}
		return pInstance;
	}

	@Override
	public List<Pending> getAll() {
		return p;
	}

	@Override
	public List<Pending> getAll( String username) {
		List<Pending> userRequests = new ArrayList<>();
		for(Pending request: p) {
			if(request.getUsername().equals( username ) ) {
				userRequests.add(request);
			}
		}
		return userRequests;
	}

	public List<Pending> loadAll() {
		p = new ArrayList<>();
		
		String sql =  "select * from pending";

		
		try (Connection c = ConnectionUtil.getConnection();
				Statement s = c.createStatement();
				ResultSet  rs = s.executeQuery(sql)) {
			
			while(rs.next()) {
				String username = rs.getString("username");
				int id = rs.getInt("requestid");
				String reason = rs.getString("reason");
				int amount = rs.getInt("amount");
				Pending pending = new Pending(username, id, reason, amount);
				p.add(pending);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return p;
	}
	

	@Override
	public Pending getRequestByUsername(String username) {
		for(Pending p: p) {
			if(p.getUsername() == username) {
				return p;
			}
		}
		return null;
	}

	@Override
	public int createPending(String username, String reason, int amount) {
		String sql = "insert into pending (username, requestid, reason, amount) values (?, ?, ?, ?)";
		int pendingCreate = 0;
		int requestId = 1;
		
		for(Pending p: p) {
			if(p.getId() >= requestId) {
				requestId = p.getId() + 1;
			}
		}		
		
		try(Connection c = ConnectionUtil.getConnection();
				PreparedStatement ps = c.prepareStatement(sql)){
			
			ps.setString(1, username);
			ps.setInt(2, requestId);
			ps.setString(3, reason);
			ps.setInt(4, amount);
			pendingCreate = ps.executeUpdate();
			
			p.add( new Pending(username, requestId, reason, amount) );
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
				
		return pendingCreate;
	}


}
