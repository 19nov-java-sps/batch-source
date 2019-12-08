package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.daos.ReimbursementDao;
import com.revature.models.Employee;
import com.revature.models.Reimbursement;
import com.revature.util.ConnectionUtil;
import com.revature.model.Reimbursements;
public class ReimbursementDaoImpl implements ReimbursementDao{

	@Override
	public List<Reimbursements> getPendingReimbursements() {


		String sql = "Select * from reimbursements where ispending=?";
		List<Reimbursements>re= new ArrayList<>();
		try (Connection c = ConnectionUtil.getConnection();
				PreparedStatement ps = c.prepareStatement(sql)) {
		
			ps.setBoolean(1,true);

		
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				int Id = rs.getInt("id");
				double amount = rs.getDouble("amount");
				int userId= rs.getInt("userid");
				String reasonfor= rs.getString("reasonfor");
				boolean ispending=rs.getBoolean("ispending");
			
				
				Reimbursements d= new Reimbursements(reasonfor, amount, ispending, userId);
				re.add(d);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return re;
	}
	
	

	@Override
	public List<Reimbursements> getResolvedReimbursements() {

		String sql = "Select * from reimbursements where ispending=?";
		List<Reimbursements>re= new ArrayList<>();
		try (Connection c = ConnectionUtil.getConnection();
				PreparedStatement ps = c.prepareStatement(sql)) {
		
			ps.setBoolean(1,false);

		
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				int Id = rs.getInt("id");
				double amount = rs.getDouble("amount");
				int userId= rs.getInt("userid");
				String reasonfor= rs.getString("reasonfor");
				boolean ispending=rs.getBoolean("ispending");
				int resolved=rs.getInt("resolvedby");
				String status= rs.getString("status");
				
				Reimbursements d= new Reimbursements(reasonfor, amount, ispending, userId, resolved, status);
				re.add(d);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return re;
	}
	
	

	@Override
	public List<Reimbursements> getPendingReimbursementById(int id) {
		String sql = "Select * from reimbursements where ispending=? And userid=?";
		List<Reimbursements>re= new ArrayList<>();
		try (Connection c = ConnectionUtil.getConnection();
				PreparedStatement ps = c.prepareStatement(sql)) {
		
			ps.setBoolean(1,true);
			ps.setInt(2, id);

		
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				int Id = rs.getInt("id");
				double amount = rs.getDouble("amount");
				int userId= rs.getInt("userid");
				String reasonfor= rs.getString("reasonfor");
				boolean ispending=rs.getBoolean("ispending");
				
				Reimbursements d= new Reimbursements(reasonfor, amount, ispending, userId);
				re.add(d);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return re;
	}



	@Override
	public List<Reimbursements> getResolvedReimbursementById(int id) {
		String sql = "Select * from reimbursements where ispending=? And userid=?";
		List<Reimbursements>re= new ArrayList<>();
		try (Connection c = ConnectionUtil.getConnection();
				PreparedStatement ps = c.prepareStatement(sql)) {
		
			ps.setBoolean(1,false);
			ps.setInt(2, id);

		
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				int Id = rs.getInt("id");
				double amount = rs.getDouble("amount");
				int userId= rs.getInt("userid");
				String reasonfor= rs.getString("reasonfor");
				boolean ispending=rs.getBoolean("ispending");
				int resolvedBy=rs.getInt("resolvedby");
				String status=rs.getString("status");
				Reimbursements rem= new Reimbursements(reasonfor, amount, ispending, Id, resolvedBy, status);
				re.add(rem);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return re;
	}

	@Override
	public boolean createReimbursement(Reimbursements re) throws SQLException {
		String sql = "insert into reimbursements (amount,userid,reasonfor,ispending,status) VALUES (? ,? ,?,?,?)";
		int count=0;
		try (Connection c = ConnectionUtil.getConnection();
				PreparedStatement ps = c.prepareStatement(sql)) {
			
			ps.setDouble(1,  re.getReimbursementAmount());
			ps.setInt(2,  re.getUserId());
			ps.setString(3, re.getReasonForReimbursement());
			ps.setBoolean(4, re.isPending());
			ps.setString(5,re.getStatus());
		
			count=ps.executeUpdate();
		
		}
		
	
		return true;
	}



	@Override
	public void resolveReimbursement(int i, int manager, String status) throws SQLException {
String sql2 = "update reimbursements set ispending=false, resolvedby=?, status=? where id=?";
		
		try (Connection c = ConnectionUtil.getConnection();
				PreparedStatement ps = c.prepareStatement(sql2)) {
		
			ps.setInt(1,manager);

			ps.setString(2,status);
			
			ps.setInt(3,i );
			ps.executeUpdate();
	
	}
	}



	@Override
	public void resolveReimbursement(int i) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public boolean createReimbursement(com.revature.dao.Reimbursement re) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}



	@Override
	public boolean createReimbursement(com.revature.dao.Reimbursement re) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}
}
