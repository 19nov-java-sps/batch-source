package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.Reimbursement;
import com.revature.util.ConnectionUtil;

public class ReimbursementDaoImpl implements ReimbursementDao {

	@Override
	public List<Reimbursement> getReimbursements() {
		
		String sql = "select * from reim_table";
		List<Reimbursement> reimbursements = new ArrayList<>();
		
		try(Connection c = ConnectionUtil.getConnection();
						Statement s = c.createStatement();
						ResultSet rs = s.executeQuery(sql)) {

			while(rs.next()) {
		
				Reimbursement r = new Reimbursement();
				r.setReim_id(rs.getInt("reim_id"));
				r.setAmount(rs.getDouble("amount"));
				r.setDescription(rs.getString("description"));
				r.setStatus(rs.getString("status"));
				r.setName(rs.getString("emp_name"));
				r.setUsername(rs.getString("emp_user_name"));
				r.setManagerName(rs.getString("man_name"));
				
				reimbursements.add(r);
			}
	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return reimbursements;
	}

	@Override
	public List<Reimbursement> getReimbursementsByUsername(String username) {
		
		String sql = "select * from reim_table where emp_user_name = ?";
		List<Reimbursement> reimbursementsByUsername = new ArrayList<>();
		
		try(Connection c = ConnectionUtil.getConnection();
					PreparedStatement ps = c.prepareStatement(sql)) {
			
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				Reimbursement r = new Reimbursement();
				r.setReim_id(rs.getInt("reim_id"));
				r.setAmount(rs.getDouble("amount"));
				r.setDescription(rs.getString("description"));
				r.setStatus(rs.getString("status"));
				r.setName(rs.getString("emp_name"));
				r.setUsername(rs.getString("emp_user_name"));
				r.setManagerName(rs.getString("man_name"));
				
				reimbursementsByUsername.add(r);
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return reimbursementsByUsername;
	}

	@Override
	public List<Reimbursement> getReimbursementsByStatus(String status) {
		
		String sql = "select * from reim_table where status = ?";
		List<Reimbursement> reimbursementsByStatus = new ArrayList<>();
		
		try(Connection c = ConnectionUtil.getConnection();
					PreparedStatement ps = c.prepareStatement(sql)) {
			
			ps.setString(1, status);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				Reimbursement r = new Reimbursement();
				r.setReim_id(rs.getInt("reim_id"));
				r.setAmount(rs.getDouble("amount"));
				r.setDescription(rs.getString("description"));
				r.setStatus(rs.getString("status"));
				r.setName(rs.getString("emp_name"));
				r.setUsername(rs.getString("emp_user_name"));
				r.setManagerName(rs.getString("man_name"));
				
				reimbursementsByStatus.add(r);
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return reimbursementsByStatus;
	}

	@Override
	public List<Reimbursement> getReimbursementsByStatusAndUsername(String status, String username) {
		
		String sql = "select * from reim_table where status = ? and emp_user_name = ?";
		List<Reimbursement> reimbursementsByStatusAndUsername = new ArrayList<>();
		
		try(Connection c = ConnectionUtil.getConnection();
					PreparedStatement ps = c.prepareStatement(sql)) {
			
			ps.setString(1, status);
			ps.setString(2, username);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				Reimbursement r = new Reimbursement();
				r.setReim_id(rs.getInt("reim_id"));
				r.setAmount(rs.getDouble("amount"));
				r.setDescription(rs.getString("description"));
				r.setStatus(rs.getString("status"));
				r.setName(rs.getString("emp_name"));
				r.setUsername(rs.getString("emp_user_name"));
				r.setManagerName(rs.getString("man_name"));
				
				reimbursementsByStatusAndUsername.add(r);
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return reimbursementsByStatusAndUsername;
	}
	
	@Override
	public Reimbursement getReimbursementById(int id) {
		
		String sql = "select * from reim_table where reim_id = ?";
		Reimbursement r = new Reimbursement();
		
		try(Connection c = ConnectionUtil.getConnection();
					PreparedStatement ps = c.prepareStatement(sql)) {
			
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				r.setReim_id(rs.getInt("reim_id"));
				r.setAmount(rs.getDouble("amount"));
				r.setDescription(rs.getString("description"));
				r.setStatus(rs.getString("status"));
				r.setName(rs.getString("emp_name"));
				r.setUsername(rs.getString("emp_user_name"));
				r.setManagerName(rs.getString("man_name"));
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return r;
	}
	
	@Override
	public int updateReimbursement(int reim_id, String managerName, String status) {
		
		String sql = "update reim_table set status = ?, man_name = ? where reim_id = ?";
		int reimUpdated = 0;
		
		try(Connection c = ConnectionUtil.getConnection();
					PreparedStatement ps = c.prepareStatement(sql)) {
			
			ps.setString(1, status);
			ps.setString(2, managerName);
			ps.setInt(3, reim_id);
			reimUpdated = ps.executeUpdate();
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return reimUpdated;
	}

	@Override
	public int createReimbursement(Reimbursement r) {
		
		String sql = "insert into reim_table (amount, description, status, emp_name, emp_user_name, man_name) values (?, ?, ?, ?, ?, ?)";
		int reimbursementCreated = 0;
		
		try(Connection c = ConnectionUtil.getConnection();
					PreparedStatement ps = c.prepareStatement(sql)) {
			
			ps.setDouble(1, r.getAmount());
			ps.setString(2, r.getDescription());
			ps.setString(3, r.getStatus());
			ps.setString(4, r.getName());
			ps.setString(5, r.getUsername());
			ps.setString(6, r.getManagerName());
			
			reimbursementCreated = ps.executeUpdate();
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return reimbursementCreated;
	}

}
