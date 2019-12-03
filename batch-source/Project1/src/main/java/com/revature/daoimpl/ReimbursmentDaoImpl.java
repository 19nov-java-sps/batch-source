package com.revature.daoimpl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.dao.ReimbursementDao;
import com.revature.model.Reimbursement;
import com.revature.util.ConnectionUtil;

public class ReimbursmentDaoImpl implements ReimbursementDao {

	@Override
	public List<Reimbursement> getAllReimbursement() {
		String sql = "select * from p1reimb";
		List<Reimbursement> reimbursements = new ArrayList<>();
		
		
		try(Connection c = ConnectionUtil.getConnection();
				Statement s = c.createStatement();
				ResultSet rs = s.executeQuery(sql)){
			
			while(rs.next()) {
				int rId = rs.getInt("r_id");
				String descr = rs.getString("description");
				double sum = rs.getDouble("sum");
				Date date = rs.getDate("date");
				String status = rs.getString("status");
				int emplId = rs.getInt("id");
				
				Reimbursement r = new Reimbursement (rId, descr,  date,   status, sum, emplId);
				reimbursements.add(r);
				
			}
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return reimbursements;
	}

	@Override
	public Reimbursement getReimbursementById(int reimId) {
		String sql = "select * from p1reimb where r_id = ?";
		Reimbursement r = null;
		
		try(Connection c = ConnectionUtil.getConnection();
				PreparedStatement ps = c.prepareStatement(sql)){
			ps.setInt(1, reimId);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				int rId = rs.getInt("r_id");
				String descr = rs.getString("description");
				double sum = rs.getDouble("sum");
				Date date = rs.getDate("date");
				String status = rs.getString("status");
				int emplId = rs.getInt("id");
				
				r = new Reimbursement (rId, descr,  date,   status, sum, emplId);
			
			}
			
		} catch (SQLException e) {

			e.printStackTrace();
		}
		
		return r;
	}

	@Override
	public int createReimbursement(Reimbursement r) {
		String sql = "insert into p1reimb (r_id, description, sum, date, status, id) values (?,?,?,?,?,?)";
		int reimCreated = 0;
		
		try(Connection c = ConnectionUtil.getConnection();
				PreparedStatement ps = c.prepareStatement(sql)){
			ps.setInt(1, r.getReimId());
			ps.setString(2, r.getDescr());
			ps.setDouble(3, r.getSum());
			ps.setDate(4, r.getDate());
			ps.setString(5, r.getStatus());
			ps.setInt(6, r.getId());
			
			reimCreated = ps.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return reimCreated;
	}

	@Override
	public int deleteReimbursement(Reimbursement r) {
		String sql = "delete from p1reimb where r_id = ?";
		int rowsDeleted = 0;
		
		try(Connection c = ConnectionUtil.getConnection();
				PreparedStatement ps = c.prepareStatement(sql)){
			ps.setInt(1, r.getReimId());
			rowsDeleted = ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return rowsDeleted;
	}

	@Override
	public int updateReimbursement(Reimbursement r) {
		String sql = "update p1reimb set r_id = ?, description = ?, sum = ?, date = ?, status = ?, id = ?";
		int reimbUpdate = 0;
		
		try(Connection c = ConnectionUtil.getConnection();
				PreparedStatement ps = c.prepareStatement(sql)){
			ps.setInt(1, r.getReimId());
			ps.setString(2, r.getDescr());
			ps.setDouble(3, r.getSum());
			ps.setDate(4, r.getDate());
			ps.setString(5, r.getStatus());
			ps.setInt(6, r.getId());
			
			reimbUpdate = ps.executeUpdate();
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
		return reimbUpdate;

	}
	
}
