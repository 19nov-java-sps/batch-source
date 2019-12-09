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
			System.out.println(reimbursementCreated);
		} catch (SQLException error) {
			error.printStackTrace();
		}
		return reimbursementCreated;
	}

	@Override
	public int updateReimbursement(Reimbursement r) {
		String sql = "update employee set pending=?, approved=?, denied=?, resolved=? where reim_id =?";
		int reimbursementUpdated = 0;

		try (Connection con = ConnectionUtil.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {

			ps.setBoolean(1, r.isPending());
			ps.setBoolean(2, r.isApproved());
			ps.setBoolean(3, r.isDenied());
			ps.setBoolean(4, r.isResolved());
			ps.setInt(5, r.getReimbursementID());

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

				int userID = rs.getInt("emp_id");
				int reimbursementID = rs.getInt("reim_id");
				double amount = rs.getDouble("amount");
				String reason = rs.getString("reason");
				boolean pending = rs.getBoolean("pending");
				boolean approved = rs.getBoolean("approved");
				boolean denied = rs.getBoolean("denied");
				boolean resolved = rs.getBoolean("resolved");

				Reimbursement d = new Reimbursement(userID, reimbursementID, amount, reason, pending, approved, denied,
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
				int reimbursementID = rs.getInt("reim_id");
				double amount = rs.getDouble("amount");
				String reason = rs.getString("reason");
				boolean pending = rs.getBoolean("pending");
				boolean approved = rs.getBoolean("approved");
				boolean denied = rs.getBoolean("denied");
				boolean resolved = rs.getBoolean("resolved");

				Reimbursement d = new Reimbursement(userID, reimbursementID, amount, reason, pending, approved, denied,
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
				int reimbursementID = rs.getInt("reim_id");
				double amount = rs.getDouble("amount");
				String reason = rs.getString("reason");
				boolean pending = rs.getBoolean("pending");
				boolean approved = rs.getBoolean("approved");
				boolean denied = rs.getBoolean("denied");
				boolean resolved = rs.getBoolean("resolved");

				Reimbursement d = new Reimbursement(userID, reimbursementID, amount, reason, pending, approved, denied,
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
	public int approved(boolean pending, boolean approved, boolean denied, boolean resolved, int reimbursementID) {
		int reimResolved = 0;
		String sql = "update reimbursement set pending = ?, approved = ?, denied = ?, resolved = ? where reim_id = ?";

		try (Connection c = ConnectionUtil.getConnection();

				PreparedStatement ps = c.prepareStatement(sql)) {

			ps.setBoolean(1, pending);
			ps.setBoolean(2, approved);
			ps.setBoolean(3, denied);
			ps.setBoolean(4, resolved);
			ps.setInt(5, reimbursementID);

			reimResolved = ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return reimResolved;
	}

	@Override
	public int denied(boolean pending, boolean approved, boolean denied, boolean resolved, int reimbursementID) {
		int reimResolved = 0;
		String sql = "update reimbursement set pending = ?, approved = ?, denied = ?, resolved = ? where reim_id = ?";

		try (Connection c = ConnectionUtil.getConnection();

				PreparedStatement ps = c.prepareStatement(sql)) {

			ps.setBoolean(1, pending);
			ps.setBoolean(2, approved);
			ps.setBoolean(3, denied);
			ps.setBoolean(4, resolved);
			ps.setInt(5, reimbursementID);

			reimResolved = ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return reimResolved;

	}

}
