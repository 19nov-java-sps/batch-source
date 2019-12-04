package com.revature.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.dao.ReimbursementDao;
import com.revature.model.Employees;
import com.revature.model.Reimbursement;
import com.revature.util.ConnectionUtil;

public class ReimbursementDaoImpl implements ReimbursementDao {

	@Override
	public List<Reimbursement> getAllReimbursements() {
		List<Reimbursement> reimbursement = new ArrayList<>();
		String sql = "select * from reimbursement";

		try (Connection con = ConnectionUtil.getConnection();
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {
			while (rs.next()) {
				int reimbursementID = rs.getInt("reim_id");
				int employeeID = rs.getInt("emp_id");
				double amount = rs.getDouble("amount");
				String description = rs.getString("description");
				String dateSubmission = rs.getString("date_submission");
				String dateApproval = rs.getString("date_approval");
				boolean rejected = rs.getBoolean("rejected");

				Reimbursement reim = new Reimbursement(reimbursementID, employeeID, amount, description, dateSubmission,
						dateApproval, rejected);
				reimbursement.add(reim);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return reimbursement;
	}

	@Override
	public Reimbursement getReimbursementById(int id) {
		String sql = "select * from reimbursement where reim_id = ?";
		Reimbursement r = null;

		try (Connection con = ConnectionUtil.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				int reimbursementID = rs.getInt("reim_id");
				int employeeID = rs.getInt("emp_id");
				double amount = rs.getDouble("amount");
				String description = rs.getString("description");
				String dateSubmission = rs.getString("date_submission");
				String dateApproval = rs.getString("date_approval");
				boolean rejected = rs.getBoolean("rejected");
				r = new Reimbursement(reimbursementID, employeeID, amount, description, dateSubmission, dateApproval,
						rejected);
			}
		} catch (SQLException error) {
			error.printStackTrace();
		}
		return r;
	}

	@Override
	public int createReimbursement(Reimbursement r) {
		String sql = "insert into reimbursement (reim_id, emp_id, amount, description, date_submission, date_approval, rejected) values (?,?,?,?,?,?,?)";
		int reimbursementCreated = 0;

		try (Connection con = ConnectionUtil.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {

			ps.setInt(1, r.getReimbursementID());
			ps.setInt(2, r.getEmployeeID());
			ps.setDouble(3, r.getAmount());
			ps.setString(4, r.getDescription());
			ps.setString(5, r.getDateSubmission());
			ps.setString(6, r.getDateApproval());
			ps.setBoolean(7, r.getisRejected());

			reimbursementCreated = ps.executeUpdate();

		} catch (SQLException error) {
			error.printStackTrace();
		}
		return reimbursementCreated;
	}

	@Override
	public int updateReimbursement(Reimbursement r) {
		String sql = "insert into reimbursement (reim_id, emp_id, amount, description, date_submission, date_approval, rejected) values (?,?,?,?,?,?,?)";
		int reimbursementUpdated = 0;

		try (Connection con = ConnectionUtil.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {

			ps.setInt(1, r.getReimbursementID());
			ps.setInt(2, r.getEmployeeID());
			ps.setDouble(3, r.getAmount());
			ps.setString(4, r.getDescription());
			ps.setString(5, r.getDateSubmission());
			ps.setString(6, r.getDateApproval());
			ps.setBoolean(7, r.getisRejected());

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

}
