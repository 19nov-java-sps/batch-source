package com.revature.daos;

import java.sql.*;
import java.util.*;

import com.revature.daos.ResolvedDao;
import com.revature.models.Pending;
import com.revature.models.Resolved;
import com.revature.util.ConnectionUtil;

public class ResolvedDaoImpl implements ResolvedDao {
	private static ResolvedDaoImpl rInstance;
	private List<Resolved> r = new ArrayList<>();	

	public ResolvedDaoImpl() {
		this.loadAll();
		System.out.print( "Loaded " + r.size() + " users");
	}
	
	public static ResolvedDaoImpl getInstance( ) {
    	if( rInstance == null ) {
    		rInstance = new ResolvedDaoImpl();
    	}
		return rInstance;
	}
	
	
	@Override
	public List<Resolved> getAll() {
		return r;
	}

	@Override
	public List<Resolved> getAll( String username) {
		List<Resolved> userRequests = new ArrayList<>();
		for(Resolved r: r) {
			if(r.getUsername().equals( username ) ) {
				userRequests.add(r);
			}
		}
		return userRequests;
	}
	
	public List<Resolved> loadAll() {
		r = new ArrayList<>();	

		String sql =  "select * from resolved";
		
		try (Connection c = ConnectionUtil.getConnection();
				Statement s = c.createStatement();
				ResultSet  rs = s.executeQuery(sql)) {
			
			while(rs.next()) {
				String username = rs.getString("username");
				int id = rs.getInt("requestid");
				String reason = rs.getString("reason");
				int amount = rs.getInt("amount");
				String status = rs.getString("status");
				String managername = rs.getString("managername");
				Resolved resolved = new Resolved(username, id, reason, amount, status, managername);
				r.add(resolved);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return r;
	}

	@Override
	public Resolved getRequestByUsername(String username) {
		for(Resolved r: r) {
			if(r.getUsername() == username) {
				return r;
			}
		}
		return null;
	}

	@Override
	public int createResolvedDeletePending(int requestid, String status, String manager) {
		String sql = "insert into resolved select username, requestid, reason, amount, ? as status, ? as managername from pending where requestid = ?";
		int resolvedCreate = 0;
		
		try(Connection c = ConnectionUtil.getConnection();
				PreparedStatement ps = c.prepareStatement(sql)){
		
			ps.setString(1, status);
			ps.setString(2, manager);
			ps.setInt(3, requestid);
			resolvedCreate = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (resolvedCreate == 1) {
		String deletesql = "delete from pending where requestid = ?";
		
		try(Connection c = ConnectionUtil.getConnection();
				PreparedStatement ps = c.prepareStatement(deletesql)){
			
			ps.setInt(1, requestid);
			ps.executeUpdate();
			System.out.println("Record deleted successfully");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		}
		loadAll();
		PendingDaoImpl.getInstance().loadAll();
		return resolvedCreate;
	}


	

}
