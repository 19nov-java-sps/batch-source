package com.revature.dao.impl;

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
	public List<Transaction> getTransactionHistory() {
		
		List<Transaction> transactions = new ArrayList<>();
		String sql = "select * from \"Transaction\" where \"AccountNumber\" = " + Driver.getAccount();
		
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
	public boolean deposit(Double amount) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean withdraw(Double amount) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean transferTo(Double amount, String transferAcc) {
		// TODO Auto-generated method stub
		return false;
	}

}
