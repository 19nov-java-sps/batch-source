package com.revature.dao.impl;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;



import com.revature.dao.InvoiceDao;
import com.revature.util.ConnectionUtil;
import com.revauture.model.Invoice;

public class InvoiceDaoImpl implements InvoiceDao{
	
	@Override
	public List<Invoice> getInvoices() {
		String sqlString = "select * from Invoice";
		List<Invoice> invoiceslList = new ArrayList<>();
		
		try (Connection connection = ConnectionUtil.getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery(sqlString)){
			
			while (resultSet.next()) {
				int invoiceId = resultSet.getInt("invoice_id");
				Double amount = resultSet.getDouble("amount");
				String description = resultSet.getString("description");
				boolean pending = resultSet.getBoolean("pending");
				boolean approved = resultSet.getBoolean("approved");
				boolean rejected  =  resultSet.getBoolean("rejected");
				boolean resolved = resultSet.getBoolean("resolved");
				int userId = resultSet.getInt("user_id");
				Invoice invoice = new Invoice(invoiceId, amount, description, pending, approved, rejected, resolved, userId);
				invoiceslList.add(invoice);
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return invoiceslList;
		
		
	
	}

	@Override
	public Invoice getInvoiceById(int id) {
		String sqlString = "select * from Invoice where Invoice.user_id = ?";
		Invoice newInvoice = null;
		
		try (Connection connection = ConnectionUtil.getConnection();
				PreparedStatement  preparedStatement = connection.prepareStatement(sqlString)){
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				int invoiceId = resultSet.getInt("invoice_id");
				Double amount = resultSet.getDouble("amount");
				String description = resultSet.getString("description");
				boolean pending = resultSet.getBoolean("pending");
				boolean approved = resultSet.getBoolean("approved");
				boolean rejected  =  resultSet.getBoolean("rejected");
				boolean resolved = resultSet.getBoolean("resolved");
				int userId = resultSet.getInt("user_id");
				newInvoice = new Invoice(invoiceId, amount, description, pending, approved, rejected, resolved, userId);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();		
		}
		return newInvoice;
	}

	@Override
	public int deleteInvoice(Invoice i) {
		String sqlString = "delete from Invoice where Invoice.user_id =  ?";
		int success  = 0;
		
		try (Connection connection =  ConnectionUtil.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(sqlString)){
			preparedStatement.setInt(1, i.getUserId());
			success = preparedStatement.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return success;
	}

	@Override
	public int createInvoice(Invoice i) {
		String string = "insert into Invoice (amount, description, pending, approved, rejected, resolved, user_id)  values (?,?,?,?,?,?,?)";
		int success = 0;
		
		try (Connection connection =  ConnectionUtil.getConnection();
				PreparedStatement preparedStatement =  connection.prepareStatement(string)){
			preparedStatement.setDouble(1, i.getAmount());
			preparedStatement.setString(2, i.getDescription());
			preparedStatement.setBoolean(3, i.isPending());
			preparedStatement.setBoolean(4, i.isApproved());
			preparedStatement.setBoolean(5, i.isRejected());
			preparedStatement.setBoolean(6, i.isResolved());
			preparedStatement.setInt(7, i.getUserId());
			success = preparedStatement.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return success;
	}

	@Override
	public int updateInvoice(Invoice i) {
		String string =  "update from Invoice set amount = ?, desciption = ?, pending = ?,  approved = ?, rejected = ?, resolved = ? where Invoice.user_id =  ?";
		int success = 0;
		
		try (Connection connection =  ConnectionUtil.getConnection();
				PreparedStatement preparedStatement =  connection.prepareStatement(string)){
			preparedStatement.setDouble(1, i.getAmount());
			preparedStatement.setString(2, i.getDescription());
			preparedStatement.setBoolean(3, i.isPending());
			preparedStatement.setBoolean(4, i.isApproved());
			preparedStatement.setBoolean(5, i.isRejected());
			preparedStatement.setBoolean(6, i.isResolved());
			preparedStatement.setInt(7, i.getUserId());
			success = preparedStatement.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return success;
	}

	public List<Invoice> getInvoiceByUserId(int id) {
		String sqlString = "select * from Invoice where Invoice.user_id = ?";
		List<Invoice> newInvoice = new ArrayList<>();
		
		try (Connection connection = ConnectionUtil.getConnection();
				PreparedStatement  preparedStatement = connection.prepareStatement(sqlString)){
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				int invoiceId = resultSet.getInt("invoice_id");
				Double amount = resultSet.getDouble("amount");
				String description = resultSet.getString("description");
				boolean pending = resultSet.getBoolean("pending");
				boolean approved = resultSet.getBoolean("approved");
				boolean rejected  =  resultSet.getBoolean("rejected");
				boolean resolved = resultSet.getBoolean("resolved");
				int userId = resultSet.getInt("user_id");
				Invoice invoice = new Invoice(invoiceId, amount, description, pending, approved, rejected, resolved, userId);
				
				newInvoice.add(invoice);
			}
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();		
		}
		return newInvoice;
	}



}
