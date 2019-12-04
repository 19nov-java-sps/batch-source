package com.revature.daos.impls;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.daos.InvoiceDao;
import com.revature.models.Invoice;
import com.revature.models.UserAcc;
import com.revature.util.ConnectionUtil;

public class InvoiceDaoImpl implements InvoiceDao{

	@Override
	public List<Invoice> getAll() {
		// TODO Auto-generated method stub
		String sql = "Select * from invoice";
		
		List<Invoice> myInvoice = new ArrayList<>();
		
		try(Connection c = ConnectionUtil.getConnection();
				Statement s = c.createStatement();
				ResultSet rs = s.executeQuery(sql)){
			
			while(rs.next()) {
				int invoice_id = rs.getInt("invoice_id");
				int user_id = rs.getInt("user_id");
				int amount = rs.getInt("amount");
				boolean status = rs.getBoolean("status");
				int manager_id = rs.getInt("manager_id");
				Invoice invoice = new Invoice(invoice_id, user_id, amount, status, manager_id);
				myInvoice.add(invoice);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return myInvoice;
	}

	@Override
	public Invoice getInvoiceById(int id) {
		// TODO Auto-generated method stub
		String sql = "Select * from invoice";
		
		List<Invoice> myInvoice = new ArrayList<>();
		
		try(Connection c = ConnectionUtil.getConnection();
				Statement s = c.createStatement();
				ResultSet rs = s.executeQuery(sql)){
			
			while(rs.next()) {
				int invoice_id = rs.getInt("invoice_id");
				int user_id = rs.getInt("user_id");
				int amount = rs.getInt("amount");
				boolean status = rs.getBoolean("status");
				int manager_id = rs.getInt("manager_id");
				Invoice invoice = new Invoice(invoice_id, user_id, amount, status, manager_id);
				myInvoice.add(invoice);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
			for(Invoice i : myInvoice) {
				if(i.getUser_id() == id) {
					return i;
				}
			}
		return null;
	}

	@Override
	public int createInvoice(Invoice i) {
		// TODO Auto-generated method stub
		String sql = "insert into invoice (user_id, amount, status, manager_id) values (?,?,?,?);";
		int invoiceCreated = 0;
		
		try(Connection c = ConnectionUtil.getConnection();
				PreparedStatement ps = c.prepareStatement(sql)){
			
			ps.setInt(1, i.getUser_id());
			ps.setInt(2, i.getAmount());
			ps.setBoolean(3, i.isStatus());
			ps.setInt(4, i.getManager_id());
			
			invoiceCreated = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return invoiceCreated;
	}

	@Override
	public List<Invoice> getInvoiceByUserId(int id) {
		// TODO Auto-generated method stub
		String sql = "Select * from invoice where user_id=?";
		
		List<Invoice> myInvoice = new ArrayList<>();
		
		try(Connection c = ConnectionUtil.getConnection();
				PreparedStatement ps = c.prepareStatement(sql)){
			
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				int invoice_id = rs.getInt("invoice_id");
				int amount = rs.getInt("amount");
				boolean status = rs.getBoolean("status");
				int manager_id = rs.getInt("manager_id");
				Invoice invoice = new Invoice(invoice_id, id, amount, status, manager_id);
				myInvoice.add(invoice);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return myInvoice;
	}

	@Override
	public int approveInvoice(int managerId, int InvoiceId) {
		// TODO Auto-generated method stub
		String sql = "update invoice set status=?, manager_id=? where invoice_id=?";
		int invoiceApprove = 0;
		
		try(Connection c = ConnectionUtil.getConnection();
				PreparedStatement ps = c.prepareStatement(sql)){
			
			ps.setBoolean(1, true);
			ps.setInt(2, managerId);
			ps.setInt(3, InvoiceId);
			
			invoiceApprove = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return invoiceApprove;

	}

	@Override
	public int rejectInvoice(int managerId, int InvoiceId) {
		// TODO Auto-generated method stub
		String sql = "update invoice set status=?, manager_id=? where invoice_id=?";
		int invoiceReject = 0;
		
		try(Connection c = ConnectionUtil.getConnection();
				PreparedStatement ps = c.prepareStatement(sql)){
			
			ps.setBoolean(1, false);
			ps.setInt(2, managerId);
			ps.setInt(3, InvoiceId);
			
			invoiceReject = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return invoiceReject;
	}

	
}
