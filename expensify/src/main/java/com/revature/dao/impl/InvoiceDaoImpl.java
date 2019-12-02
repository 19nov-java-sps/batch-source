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

	public List<Invoice> dummyInvoiceList = new ArrayList<>();
	
	public InvoiceDaoImpl() {
		dummyInvoiceList.add(new Invoice(1, 200.00, "coffee", "2019-10-10", null, false, 1));
		dummyInvoiceList.add(new Invoice(2, 100.00, "gas", "2019-10-09", null, true, 2));
		dummyInvoiceList.add(new Invoice(3, 5000.00, "office party", "2019-10-10", null, false, 1));
		
	}
	
	@Override
	public List<Invoice> dummyInvoiceList() {
		return new ArrayList<>(dummyInvoiceList);
	}

	@Override
	public Invoice dummyInvoice(int id) {
		for (Invoice invoice : dummyInvoiceList) {
			if (invoice.getUserId() == id) {
				return invoice;
			}
		}
		return null;
	}
	
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
				String dateSubmitted = resultSet.getString("date_submitted");
				String dateApproved = resultSet.getString("date_approved");
				boolean rejected  =  resultSet.getBoolean("rejected");
				int userId = resultSet.getInt("user_id");
				Invoice invoice = new Invoice(invoiceId, amount, description, dateSubmitted, dateApproved, rejected, userId);
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
				String dateSubmitted = resultSet.getString("date_submitted");
				String dateApproved = resultSet.getString("date_approved");
				boolean rejected  =  resultSet.getBoolean("rejected");
				int userId = resultSet.getInt("user_id");
				newInvoice = new Invoice(invoiceId, amount, description, dateSubmitted, dateApproved, rejected, userId);	
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
		String string = "insert into Invoice (invoice_id, amount, description, date_submitted, date_approved, rejected, user_id)  values (?,?,?,?,?,?,?)";
		int success = 0;
		
		try (Connection connection =  ConnectionUtil.getConnection();
				PreparedStatement preparedStatement =  connection.prepareStatement(string)){
			preparedStatement.setInt(1, i.getInvoiceId());
			preparedStatement.setDouble(2, i.getAmount());
			preparedStatement.setString(3, i.getDescription());
			preparedStatement.setString(4, i.getDateSubmitted());
			preparedStatement.setString(5, i.getDateApproved());
			preparedStatement.setBoolean(6, i.isRejected());
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
		String string =  "update from Invoice set invoice_id = ?,  amount = ?, desciption = ?, date_submitted = ?,  date_approved = ?, rejected =? where Invoice.user_id =  ?";
		int success = 0;
		
		try (Connection connection =  ConnectionUtil.getConnection();
				PreparedStatement preparedStatement =  connection.prepareStatement(string)){
			preparedStatement.setInt(1, i.getInvoiceId());
			preparedStatement.setDouble(2, i.getAmount());
			preparedStatement.setString(3, i.getDescription());
			preparedStatement.setString(4, i.getDateSubmitted());
			preparedStatement.setString(5, i.getDateApproved());
			preparedStatement.setBoolean(6, i.isRejected());
			preparedStatement.setInt(7, i.getUserId());
			success = preparedStatement.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return success;
	}



}
