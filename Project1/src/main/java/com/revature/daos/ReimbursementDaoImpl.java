package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.Employee;
import com.revature.models.Reimbursement;
import com.revature.services.EmployeeService;
import com.revature.util.ConnectionUtil;

public class ReimbursementDaoImpl implements ReimbursementDao {
	
	EmployeeService es = new EmployeeService();

	@Override
	public List<Reimbursement> getPendingReim() {

		List<Reimbursement> reims = new ArrayList<>();
		String sql = "select * from Reimbursement where status = \"pending\"";
		
		try (Connection c = ConnectionUtil.getConnection();
				Statement s = c.createStatement();
				ResultSet rs = s.executeQuery(sql)){
			
			while (rs.next()) {
				int reimId = rs.getInt("reimId");
				double amount = rs.getDouble("amount");
				String status = rs.getString("status");
				String result = rs.getString("resolvedResult");
				int submitById = rs.getInt("submitBy");
				int resolvedById = rs.getInt("resolvedBy");
				String submitDate = rs.getString("submitDate");
				String resolvedDate = rs.getString("resolvedDate");
				String description = rs.getString("description");
				String reason = rs.getString("reason");
				
				Employee empl = es.getEmplById(submitById);
				Employee manager = es.getEmplById(resolvedById);
				
				Reimbursement r = new Reimbursement(reimId, amount, status, result, empl, manager, submitDate, resolvedDate, description, reason);
				reims.add(r);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return reims;
	}

	@Override
	public List<Reimbursement> getResolvedReim() {

		List<Reimbursement> reims = new ArrayList<>();
		String sql = "select * from Reimbursement where status = \"resolved\"";
		
		try (Connection c = ConnectionUtil.getConnection();
				Statement s = c.createStatement();
				ResultSet rs = s.executeQuery(sql)){
			
			while (rs.next()) {
				int reimId = rs.getInt("reimId");
				double amount = rs.getDouble("amount");
				String status = rs.getString("status");
				String result = rs.getString("resolvedResult");
				int submitById = rs.getInt("submitBy");
				int resolvedById = rs.getInt("resolvedBy");
				String submitDate = rs.getString("submitDate");
				String resolvedDate = rs.getString("resolvedDate");
				String description = rs.getString("description");
				String reason = rs.getString("reason");
				
				Employee empl = es.getEmplById(submitById);
				Employee manager = es.getEmplById(resolvedById);
				
				Reimbursement r = new Reimbursement(reimId, amount, status, result, empl, manager, submitDate, resolvedDate, description, reason);
				reims.add(r);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return reims;
	}

	@Override
	public List<Reimbursement> getPendingReimById(int emplId) {
		
		List<Reimbursement> reims = new ArrayList<>();
		String sql = "select * from Reimbursement where status = \"pending\" and submitBy = ?";
		
		try(Connection c = ConnectionUtil.getConnection();
        		PreparedStatement ps = c.prepareStatement(sql)) {
        	
        	ps.setInt(1, emplId);
        	ResultSet rs = ps.executeQuery();
        	
        	while (rs.next()) {
				int reimId = rs.getInt("reimId");
				double amount = rs.getDouble("amount");
				String status = rs.getString("status");
				String result = rs.getString("resolvedResult");
				int submitById = rs.getInt("submitBy");
				int resolvedById = rs.getInt("resolvedBy");
				String submitDate = rs.getString("submitDate");
				String resolvedDate = rs.getString("resolvedDate");
				String description = rs.getString("description");
				String reason = rs.getString("reason");
				
				Employee empl = es.getEmplById(submitById);
				Employee manager = es.getEmplById(resolvedById);
				
				Reimbursement r = new Reimbursement(reimId, amount, status, result, empl, manager, submitDate, resolvedDate, description, reason);
				reims.add(r);
			}
        	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return reims;
	}

	@Override
	public List<Reimbursement> getResolvedReimById(int emplId) {
		
		List<Reimbursement> reims = new ArrayList<>();
		String sql = "select * from Reimbursement where status = \"resolved\" and submitBy = ?";
		
		try(Connection c = ConnectionUtil.getConnection();
        		PreparedStatement ps = c.prepareStatement(sql)) {
        	
        	ps.setInt(1, emplId);
        	ResultSet rs = ps.executeQuery();
        	
        	while (rs.next()) {
				int reimId = rs.getInt("reimId");
				double amount = rs.getDouble("amount");
				String status = rs.getString("status");
				String result = rs.getString("resolvedResult");
				int submitById = rs.getInt("submitBy");
				int resolvedById = rs.getInt("resolvedBy");
				String submitDate = rs.getString("submitDate");
				String resolvedDate = rs.getString("resolvedDate");
				String description = rs.getString("description");
				String reason = rs.getString("reason");
				
				Employee empl = es.getEmplById(submitById);
				Employee manager = es.getEmplById(resolvedById);
				
				Reimbursement r = new Reimbursement(reimId, amount, status, result, empl, manager, submitDate, resolvedDate, description, reason);
				reims.add(r);
			}
        	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return reims;
	}

	@Override
	public int updateReim(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int createReim(Reimbursement reim) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Reimbursement getReimById(int reimId) {

		String sql = "select * from Reimbursement where reimId = ?";
		
		try(Connection c = ConnectionUtil.getConnection();
        		PreparedStatement ps = c.prepareStatement(sql)) {
        	
        	ps.setInt(1, reimId);
        	ResultSet rs = ps.executeQuery();
        	
        	if (rs.next()) {
				double amount = rs.getDouble("amount");
				String status = rs.getString("status");
				String result = rs.getString("resolvedResult");
				int submitById = rs.getInt("submitBy");
				int resolvedById = rs.getInt("resolvedBy");
				String submitDate = rs.getString("submitDate");
				String resolvedDate = rs.getString("resolvedDate");
				String description = rs.getString("description");
				String reason = rs.getString("reason");
				
				Employee empl = es.getEmplById(submitById);
				Employee manager = es.getEmplById(resolvedById);
				
				Reimbursement r = new Reimbursement(reimId, amount, status, result, empl, manager, submitDate, resolvedDate, description, reason);
				return r;
        	}
        	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

}
