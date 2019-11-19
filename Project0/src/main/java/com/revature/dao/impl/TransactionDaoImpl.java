package com.revature.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.Driver;
import com.revature.dao.TransactionDao;
import com.revature.model.Transaction;
import com.revature.util.ConnectionUtil;

public class TransactionDaoImpl implements TransactionDao {

	@Override
	public List<Transaction> getTransactionHistory(String account) {
		
		List<Transaction> transactions = new ArrayList<>();
		String sql = "select * from \"Transaction\" where \"AccountNumber\" = " + account;
		
		try (Connection c = ConnectionUtil.getConnection();
				Statement s = c.createStatement();
				ResultSet rs = s.executeQuery(sql)){
			
			while (rs.next()) {
				int transId = rs.getInt("transactionId");
				String accNum = rs.getString("AccountNumber");
				String type = rs.getString("TransactionType");
				double amount = rs.getDouble("TransactionAmount");
				String date = rs.getString("TransactionDate");
				double balance = rs.getDouble("BalanceAfterTransaction");
				
				Transaction t = new Transaction(transId, accNum, date, amount, balance, type);
				transactions.add(t);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return transactions;
	}

	@Override
	public double deposit(double amount, int account) {
		
		double balance = 0;
		String sql = "{ call deposit(?, ?)}";
		
		try(Connection c = ConnectionUtil.getConnection();
				CallableStatement cs = c.prepareCall(sql)){
			cs.setDouble(1, amount);
			cs.setInt(2, account);
		
        	ResultSet rs = cs.executeQuery();
        	if (rs.next()) {
        		balance = rs.getDouble(1);
        	}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return balance;
	}

	@Override
	public double withdraw(double amount, int account) {
		
		double balance = 0;
		String sql = "{ call withdraw(?, ?)}";
		
		try(Connection c = ConnectionUtil.getConnection();
				CallableStatement cs = c.prepareCall(sql)){
			cs.setDouble(1, amount);
			cs.setInt(2, account);
		
        	ResultSet rs = cs.executeQuery();
        	if (rs.next()) {
        		balance = rs.getDouble(1);
        	}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return balance;
	}

	@Override
	public double transferTo(double amount, int account, int transferAcc) {
		
		double balance = 0;
		String transToString = "Transfer To Account " + transferAcc;
		String transFromString = "Transfer From Account " + account;
		String sql = "{ call transferTo(?, ?, ?, ?, ?)}";
		
		try(Connection c = ConnectionUtil.getConnection();
				CallableStatement cs = c.prepareCall(sql)){
			cs.setDouble(1, amount);
			cs.setInt(2, account);
			cs.setInt(3, transferAcc);
			cs.setString(4, transToString);
			cs.setString(5, transFromString);
		
        	ResultSet rs = cs.executeQuery();
        	if (rs.next()) {
        		balance = rs.getDouble(1);
        	}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return balance;	
	}

}
