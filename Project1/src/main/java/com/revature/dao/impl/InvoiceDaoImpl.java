package com.revature.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.dao.InvoiceDao;
import com.revature.model.Invoice;
import com.revature.util.ConnectionUtil;

public class InvoiceDaoImpl implements InvoiceDao{
	
	@Override
	public List<Invoice> getInvoiceTable(){
		String sql = "select * from invoice"; // assigns SQL statement to a string
		List<Invoice> invoiceTable = new ArrayList<>(); // creates a new ArrayList type object to store result of the database query
		
		try (Connection c = ConnectionUtil.getConnection(); // establishes a connection to the database
				Statement s = c.createStatement(); // creates a statement which is used to send an SQL statement to be executed in our database
				ResultSet rs = s.executeQuery(sql)) { // stores the result when we execute the SQL query
			
			// while loop iterates thru the database 
			// gets all the column data & assigns values 
			// to object instance variables
			while(rs.next()) { 
				
				int invoiceId = rs.getInt("invoice_id");
				int userId = rs.getInt("user_id");
				double amount = rs.getDouble("amount");
				String description = rs.getString("description");
				boolean pending = rs.getBoolean("pending");
				boolean approved = rs.getBoolean("approved");
				boolean denied = rs.getBoolean("denied");
				boolean resolved = rs.getBoolean("resolved");
				
				Invoice invoice = new Invoice(invoiceId, userId, amount, description, pending, approved, denied, resolved);
				invoiceTable.add(invoice);
			}
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		return invoiceTable; // returns an object with all the data from the SQL database query
						  	// which in this case would be all the user info in the invoice table
				
	}

	@Override
	public Invoice getInvoiceById(int userId) {
		String sql = "select * from invoice where user_id = ?";
		Invoice invoice = new Invoice(); 
		
		try (Connection c = ConnectionUtil.getConnection(); 
				PreparedStatement ps = c.prepareStatement(sql)) { 
				ps.setInt(1, userId);
				ResultSet rs = ps.executeQuery();

				if(rs.next()) {
					invoice.setInvoiceId(rs.getInt("invoice_id"));
					invoice.setUserId(rs.getInt("user_id"));
					invoice.setAmount(rs.getDouble("amount"));
					invoice.setDescription(rs.getString("description"));
					invoice.setPending(rs.getBoolean("pending"));
					invoice.setApproved(rs.getBoolean("approved"));
					invoice.setDenied(rs.getBoolean("denied"));
					invoice.setResolved(rs.getBoolean("resolved"));
			}
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		return invoice;
	}

	@Override
	public int createInvoice(Invoice invoice) {
		String sql = "insert into invoice(user_id, amount, description, pending, approved, denied, resolved) values (?, ?, ?, ?, ?, ?, ?)";
		int invoicesCreated = 0; // variable to store the number of updated rows

		
		try(Connection c = ConnectionUtil.getConnection();
				
		PreparedStatement ps = c.prepareStatement(sql)){
			ps.setInt(1, invoice.getUserId());
			ps.setDouble(2, invoice.getAmount());
			ps.setString(3, invoice.getDescription());
			ps.setBoolean(4, invoice.isPending());
			ps.setBoolean(5, invoice.isApproved());
			ps.setBoolean(6, invoice.isDenied());
			ps.setBoolean(7, invoice.isResolved());
			
			
			invoicesCreated = ps.executeUpdate(); // stores 1 because we created a new row in the table
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return invoicesCreated; // returns 1 to let user know a new invoice was created successfully
	}

	@Override
	public int updateInvoice(Invoice invoice) {
		int invoicesUpdated = 0;
		String sql = "update invoice set invoice_id = ?, amount = ?, description = ?, pending = ?, approved = ?, denied = ?, resolved = ? where user_id = ?";
		
		try(Connection c = ConnectionUtil.getConnection();
				
		PreparedStatement ps = c.prepareStatement(sql)){
			
			ps.setInt(1, invoice.getInvoiceId());
			ps.setInt(2, invoice.getUserId());
			ps.setDouble(3, invoice.getAmount());
			ps.setString(4, invoice.getDescription());
			ps.setBoolean(5, invoice.isPending());
			ps.setBoolean(6, invoice.isApproved());
			ps.setBoolean(7, invoice.isDenied());
			ps.setBoolean(8, invoice.isResolved());
			
			
			invoicesUpdated = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return invoicesUpdated;
	}

	@Override
	public int deleteInvoice(int userId) {
		
		int invoicesDeleted = 0;
		
		String sql = "delete from invoice where user_id = ? ";
		
		try(Connection c = ConnectionUtil.getConnection();
		
		PreparedStatement ps = c.prepareStatement(sql)){
			ps.setInt(1, userId);
			invoicesDeleted = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return invoicesDeleted;
	}
	
	public int approved(boolean pending, boolean approved, boolean denied, boolean resolved, int invoiceId) {
		int invoicesResolved = 0;
		String sql = "update invoice set pending = ?, approved = ?, denied = ?, resolved = ? where invoice_id = ?";
		
		try(Connection c = ConnectionUtil.getConnection();
				
		PreparedStatement ps = c.prepareStatement(sql)){
			
			ps.setBoolean(1, pending);
			ps.setBoolean(2, approved);
			ps.setBoolean(3, denied);
			ps.setBoolean(4, resolved);
			ps.setInt(5, invoiceId);
			
			invoicesResolved = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return invoicesResolved;
	}
	
	public int denied(boolean pending, boolean approved, boolean denied, boolean resolved, int invoiceId) {
		int invoicesResolved = 0;
		String sql = "update invoice set pending = ?, approved = ?, denied = ?, resolved = ? where invoice_id = ?";
		
		try(Connection c = ConnectionUtil.getConnection();
				
		PreparedStatement ps = c.prepareStatement(sql)){
			
			ps.setBoolean(1, pending);
			ps.setBoolean(2, approved);
			ps.setBoolean(3, denied);
			ps.setBoolean(4, resolved);
			ps.setInt(5, invoiceId);
			
			invoicesResolved = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return invoicesResolved;
	}
	

}

