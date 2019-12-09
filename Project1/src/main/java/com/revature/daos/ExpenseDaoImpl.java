package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.Expenses;
import com.revature.models.UserLogin;
import com.revature.util.ConnectionUtil;

public class ExpenseDaoImpl implements ExpenseDao {

	@Override
	public int createExpense(Expenses e) {
		int created = 0;
		String sql = "insert into expensereport(approvalstatus,reimbursementamount,userid,expensetype) values(?, ?, ?, ?)";
			
		try(Connection c = ConnectionUtil.getConnection();
				PreparedStatement ps = c.prepareStatement(sql)){
			ps.setString(1, "Pending");
			ps.setDouble(2, e.getExpenseAmount());
			ps.setInt(3, e.getUserId());
			ps.setString(4, e.getExpenseType());
			
			
			created = ps.executeUpdate();
			
		} catch (SQLException ex) {
			ex.printStackTrace();
		}

		return created;
	}

	@Override
	public int updateExpense(Expenses es) {
		int updated = 0;
		
		String sql = "update expensereport set approvalstatus=? , managerid=? where userid = ?";
		
		try(Connection c = ConnectionUtil.getConnection();
				PreparedStatement ps = c.prepareStatement(sql)){
			
			ps.setString(1, es.getApprovalStatus());
			ps.setInt(2, es.getManagerId());
			ps.setInt(3, es.getUserId());
			updated = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return updated;
	}

	@Override
	public List<Expenses> getExpenses() {
		String sql = "select * from expensereport";
		Expenses es = null;
		List<Expenses> ex = new ArrayList<>();
		
		try (Connection c = ConnectionUtil.getConnection();
				PreparedStatement ps = c.prepareStatement(sql)) {
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				int expenseid = rs.getInt("expenseid");
				String approvalstatus = rs.getString("approvalstatus");
				double reimbursementamount = rs.getDouble("reimbursementamount");
				int userid = rs.getInt("userid");
				String expensetype = rs.getString("expensetype");
				int managerid = rs.getInt("managerid");
				es = new Expenses(expenseid,approvalstatus,reimbursementamount,userid,expensetype,managerid);
				ex.add(es);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return ex;
	}

	@Override
	public List<Expenses> getExpenseById(int id) {
		String sql = "select * from expensereport where userid = ? and approvalStatus!=?";
		Expenses es=null;
		List<Expenses> ex = new ArrayList<>();
		try (Connection c = ConnectionUtil.getConnection();
				PreparedStatement ps = c.prepareStatement(sql)) {
			ps.setInt(1, id);
			ps.setString(2, "Pending");
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				int expenseid = rs.getInt("expenseid");
				String approvalstatus = rs.getString("approvalstatus");
				double reimbursementamount = rs.getDouble("reimbursementamount");
				int userid = rs.getInt("userid");
				String expensetype = rs.getString("expensetype");
				int managerid = rs.getInt("managerid");
				es = new Expenses(expenseid,approvalstatus,reimbursementamount,userid,expensetype,managerid);
				ex.add(es);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return ex;
	}
	
	
	public List<Expenses> getIndividualsExpenseById(int id) {
		String sql = "select * from expensereport where userid = ?";
		Expenses es=null;
		List<Expenses> ex = new ArrayList<>();
		try (Connection c = ConnectionUtil.getConnection();
				PreparedStatement ps = c.prepareStatement(sql)) {
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				int expenseid = rs.getInt("expenseid");
				String approvalstatus = rs.getString("approvalstatus");
				double reimbursementamount = rs.getDouble("reimbursementamount");
				int userid = rs.getInt("userid");
				String expensetype = rs.getString("expensetype");
				int managerid = rs.getInt("managerid");
				es = new Expenses(expenseid,approvalstatus,reimbursementamount,userid,expensetype,managerid);
				ex.add(es);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return ex;
	}
	
	
	
	
	
	public List<Expenses> getPendingById(int id) {
		
		String sql = "select * from expensereport where userid = ? and approvalStatus=?";
		Expenses es=null;
		List<Expenses> ex = new ArrayList<>();
		try (Connection c = ConnectionUtil.getConnection();
				PreparedStatement ps = c.prepareStatement(sql)) {
			ps.setInt(1, id);
			ps.setString(2, "Pending");
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				int expenseid = rs.getInt("expenseid");
				String approvalstatus = rs.getString("approvalstatus");
				double reimbursementamount = rs.getDouble("reimbursementamount");
				int userid = rs.getInt("userid");
				String expensetype = rs.getString("expensetype");
				int managerid = rs.getInt("managerid");
				es = new Expenses(expenseid,approvalstatus,reimbursementamount,userid,expensetype,managerid);
				ex.add(es);
				System.out.println("this is pending"+ex);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return ex;
	}
	
	
	
	

	@Override
	public List<Expenses> pendingExpenses() {
		String sql = "select * from expensereport where approvalstatus = ?";
		Expenses es = null;
		List<Expenses> ex = new ArrayList<>();
		
		try (Connection c = ConnectionUtil.getConnection();
				PreparedStatement ps = c.prepareStatement(sql)) {
			ps.setString(1, "Pending");
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				int expenseid = rs.getInt("expenseid");
				String approvalstatus = rs.getString("approvalstatus");
				double reimbursementamount = rs.getDouble("reimbursementamount");
				int userid = rs.getInt("userid");
				String expensetype = rs.getString("expensetype");
				int managerid = rs.getInt("managerid");
				es = new Expenses(expenseid,approvalstatus,reimbursementamount,userid,expensetype,managerid);
				ex.add(es);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return ex;
	}

	@Override
	public List<Expenses> resolvedExpenses() {
		String sql = "select * from expensereport where approvalstatus != ?";
		Expenses es = null;
		List<Expenses> ex = new ArrayList<>();
		
		try (Connection c = ConnectionUtil.getConnection();
				PreparedStatement ps = c.prepareStatement(sql)) {
			ps.setString(1, "Pending");
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				int expenseid = rs.getInt("expenseid");
				String approvalstatus = rs.getString("approvalstatus");
				double reimbursementamount = rs.getDouble("reimbursementamount");
				int userid = rs.getInt("userid");
				String expensetype = rs.getString("expensetype");
				int managerid = rs.getInt("managerid");
				es = new Expenses(expenseid,approvalstatus,reimbursementamount,userid,expensetype,managerid);
				ex.add(es);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return ex;
	}

	@Override
	public int submitExp(double amount, int userid, String type) {
		int created = 0;
		String sql = "insert into expensereport(approvalstatus,reimbursementamount,userid,expensetype) values(?, ?, ?, ?)";
			
		try(Connection c = ConnectionUtil.getConnection();
				PreparedStatement ps = c.prepareStatement(sql)){
			ps.setString(1, "Pending");
			ps.setDouble(2, amount);
			ps.setInt(3, userid);
			ps.setString(4, type);
			
			
			created = ps.executeUpdate();
			
		} catch (SQLException ex) {
			ex.printStackTrace();
		}

		return created;
	}

	@Override
	public int updateExpense(int expenseid, int managerid, String approvalstatus) {
int updated = 0;
		System.out.println("from updateExpensedaoimp");
		System.out.println("from updateExpensedaoimp expid" + expenseid);
		System.out.println("from updateExpensedaoimp manid"+managerid);
		System.out.println("from updateExpensedaoimp appstats"+approvalstatus);
		String sql = "update expensereport set approvalstatus=? , managerid=? where expenseid = ?";
		
		try(Connection c = ConnectionUtil.getConnection();
				PreparedStatement ps = c.prepareStatement(sql)){
			
			ps.setString(1, approvalstatus);
			ps.setInt(2, managerid);
			ps.setInt(3, expenseid);
			updated = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return updated;
	}

}
