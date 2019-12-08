package com.revature.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.dao.ReimbursementDao;
import com.revature.models.Reimbursement;
import com.revature.util.ConnectionUtil;

public class ReimbursementDaoImpl implements ReimbursementDao {

//	@Override
//	public Reimbursement getReimbursementById(int id) {
//		String sql = "select * from reimbursement where reim_id = ?";
//		Reimbursement r = null;
//
//		try (Connection con = ConnectionUtil.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
//			ps.setInt(1, id);
//			ResultSet rs = ps.executeQuery();
//
//			while (rs.next()) {
//				int reimbursementID = rs.getInt("reim_id");
//				int employeeID = rs.getInt("emp_id");
//				double amount = rs.getDouble("amount");
//				String description = rs.getString("description");
//				String dateSubmission = rs.getString("date_submission");
//				String dateApproval = rs.getString("date_approval");
//				boolean rejected = rs.getBoolean("rejected");
//				r = new Reimbursement(reimbursementID, employeeID, amount, description, dateSubmission, dateApproval,
//						rejected);
//			}
//		} catch (SQLException error) {
//			error.printStackTrace();
//		}
//		return r;
//	}

	@Override
	public int createReimbursement(Reimbursement r) {
		String sql = "insert into reimbursement (emp_id, amount, reason, pending, approved, denied, resolved) values (?,?,?,?,?,?,?)";
		int reimbursementCreated = 0;

		try (Connection con = ConnectionUtil.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {

			ps.setInt(1, r.getEmployeeID());
			ps.setDouble(2, r.getAmount());
			ps.setString(3, r.getReason());
			ps.setBoolean(4, r.isPending());
			ps.setBoolean(5, r.isApproved());
			ps.setBoolean(6, r.isDenied());
			ps.setBoolean(7, r.isResolved());

			reimbursementCreated = ps.executeUpdate();

		} catch (SQLException error) {
			error.printStackTrace();
		}
		return reimbursementCreated;
	}

	@Override
	public int updateReimbursement(Reimbursement r) {
		String sql = "insert into reimbursement (reim_id, emp_id, amount, reason, pending, approved, denied, resolved) values (?,?,?,?,?,?,?,?)";
		int reimbursementUpdated = 0;

		try (Connection con = ConnectionUtil.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {

			ps.setInt(1, r.getReimbursementID());
			ps.setInt(2, r.getEmployeeID());
			ps.setDouble(3, r.getAmount());
			ps.setString(4, r.getReason());
			ps.setBoolean(5, r.isPending());
			ps.setBoolean(6, r.isApproved());
			ps.setBoolean(7, r.isDenied());
			ps.setBoolean(8, r.isResolved());

			reimbursementUpdated = ps.executeUpdate();

		} catch (SQLException error) {
			error.printStackTrace();
		}
		return reimbursementUpdated;
	}

	@Override
	public int deleteReimbursement(Reimbursement r) {
		String sql = "delete from reimbursement where reim_id = ?";
		int reimbursementDeleted = 0;

		try (Connection con = ConnectionUtil.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setInt(1, r.getReimbursementID());
			reimbursementDeleted = ps.executeUpdate();

		} catch (SQLException error) {
			error.printStackTrace();
		}
		return reimbursementDeleted;
	}

	@Override
	public List<Reimbursement> getPendingReimbursements() {

		String sql = "select * from reimbursement where pending=?";
		List<Reimbursement> reim = new ArrayList<>();
		try (Connection c = ConnectionUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {

			ps.setBoolean(1, true);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

//				int id = rs.getInt("id");
				int userID = rs.getInt("emp_id");
				int invoiceID = rs.getInt("reim_id");
				double amount = rs.getDouble("amount");
				String reason = rs.getString("reason");
				boolean pending = rs.getBoolean("pending");
				boolean approved = rs.getBoolean("approved");
				boolean denied = rs.getBoolean("denied");
				boolean resolved = rs.getBoolean("resolved");

				Reimbursement d = new Reimbursement(userID, invoiceID, amount, reason, pending, approved, denied,
						resolved);
				reim.add(d);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return reim;
	}

	@Override
	public List<Reimbursement> getResolvedReimbursements() {
		String sql = "select * from reimbursement where resolved=?";
		List<Reimbursement> reim = new ArrayList<>();
		try (Connection c = ConnectionUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {

			ps.setBoolean(1, true);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				int userID = rs.getInt("emp_id");
				int invoiceID = rs.getInt("reim_id");
				double amount = rs.getDouble("amount");
				String reason = rs.getString("reason");
				boolean pending = rs.getBoolean("pending");
				boolean approved = rs.getBoolean("approved");
				boolean denied = rs.getBoolean("denied");
				boolean resolved = rs.getBoolean("resolved");

				Reimbursement d = new Reimbursement(userID, invoiceID, amount, reason, pending, approved, denied,
						resolved);
				reim.add(d);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return reim;
	}

	@Override
	public List<Reimbursement> getPendingReimbursementById(int id) {
		String sql = "select * from reimbursement where pending=?";
		List<Reimbursement> reim = new ArrayList<>();
		try (Connection c = ConnectionUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {

			ps.setBoolean(1, true);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

//				int id = rs.getInt("id");
				int userID = rs.getInt("emp_id");
				int invoiceID = rs.getInt("reim_id");
				double amount = rs.getDouble("amount");
				String reason = rs.getString("reason");
				boolean pending = rs.getBoolean("pending");
				boolean approved = rs.getBoolean("approved");
				boolean denied = rs.getBoolean("denied");
				boolean resolved = rs.getBoolean("resolved");

				Reimbursement d = new Reimbursement(userID, invoiceID, amount, reason, pending, approved, denied,
						resolved);
				reim.add(d);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return reim;
	}

	@Override
	public List<Reimbursement> getResolvedReimbursementById(int id) {

		return null;
	}

	@Override
	public void resolveReimbursement(int i) {
		// TODO Auto-generated method stub

	}

}
