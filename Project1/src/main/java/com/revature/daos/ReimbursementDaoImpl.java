package com.revature.daos;

import java.sql.Timestamp;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
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
		String sql = "select * from Reimbursement where status = ?";
		
		try(Connection c = ConnectionUtil.getConnection();
        		PreparedStatement ps = c.prepareStatement(sql)) {
        	
			ps.setString(1, "pending");
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
	public List<Reimbursement> getResolvedReim() {

		List<Reimbursement> reims = new ArrayList<>();
		String sql = "select * from Reimbursement where status = ? order by submitBy";
		
		try(Connection c = ConnectionUtil.getConnection();
        		PreparedStatement ps = c.prepareStatement(sql)) {
        	
			ps.setString(1, "resolved");
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
	public List<Reimbursement> getPendingReimById(int emplId) {
		
		List<Reimbursement> reims = new ArrayList<>();
		String sql = "select * from Reimbursement where status = ? and submitBy = ?";
		
		try(Connection c = ConnectionUtil.getConnection();
        		PreparedStatement ps = c.prepareStatement(sql)) {
        	
			ps.setString(1, "pending");
        	ps.setInt(2, emplId);
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
		String sql = "select * from Reimbursement where status = ? and submitBy = ?";
		
		try(Connection c = ConnectionUtil.getConnection();
        		PreparedStatement ps = c.prepareStatement(sql)) {
        	
			ps.setString(1, "resolved");
        	ps.setInt(2, emplId);
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
	public int createReim(double amount, int emplId, String description) {
		
		int reimCreated = 0;
		String sql = "insert into Reimbursement(amount, status, submitBy, submitDate, description) values(?, ?, ?, ?, ?)";
		
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		
		try(Connection c = ConnectionUtil.getConnection();
				PreparedStatement ps = c.prepareStatement(sql)){
			ps.setDouble(1, amount);
			ps.setString(2, "pending");
			ps.setInt(3, emplId);
			ps.setString(4, timestamp.toString());
			ps.setString(5, description);
			
			reimCreated = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return reimCreated;
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
