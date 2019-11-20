package com.revature.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.revature.dao.AccountDao;
import com.revature.model.Account;
import com.revature.model.Users;
import com.revature.util.ConnectionUtil;

public class AccountDaoImpl implements AccountDao {

	

	
	

	@Override
	public List<AccountDao> getAccounts() {
		// TODO Auto-generated method stub
		return null;
	}

	
	public double getAccountBalance(int id, int accountpass) throws SQLException {
		// TODO Auto-generated method
		double f=5;
		String sql2 = "Select balance,pin from account where accountid=?";
		
		try (Connection c = ConnectionUtil.getConnection();
				PreparedStatement ps = c.prepareStatement(sql2)) {
		
			ps.setInt(1, id);

		
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
			if(accountpass==rs.getInt("pin")) {
	 
		f=rs.getDouble("balance");
	
		}
			else {
				f=0;
		}
			
		}
		return f;
		}
		
	}




	public boolean deposit(int accountId, double deposit) throws SQLException {
		
	String sql = "{ call updateAccount(?,?)}";
		
		try(Connection c = ConnectionUtil.getConnection();
				CallableStatement cs = c.prepareCall(sql)){
			cs.setInt(1, accountId);
			cs.setDouble(2, deposit);
			
			cs.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return true;
	}
	
		
		

	@Override
	public boolean withdrawCash(int accountid, double amount, int pass) throws SQLException {
		
		int pin=0;
		double balance=0;
		
		String sql = "select balance,pin from account where accountid=?";
		
		try (Connection c = ConnectionUtil.getConnection();
				PreparedStatement ps = c.prepareStatement(sql)) {
		
			ps.setInt(1, accountid);
			
		
			ResultSet rs = ps.executeQuery();
	
		
	
		
	if(rs.next()) {
	
	 balance=rs.getDouble("balance");
	 
	 pin=rs.getInt("pin");
	}
		
		
		}		
		
		
		
		
		
		if(balance-amount<0 || pin!=pass) {
			return false;
		}
		
		
		
		else {
		
		String sql2 = "update account set balance=balance-? where accountid=?";
		
		try (Connection c = ConnectionUtil.getConnection();
				PreparedStatement ps = c.prepareStatement(sql2)) {
		
			ps.setDouble(1, amount);

			ps.setInt(2,accountid);
			

			ps.executeUpdate();
	
		
	}

return true;

		}
	}


	
	public String createAccount(Account acct) throws SQLException {
	
		String sql = "insert into account (balance,userid,typeofacct,pin) VALUES (? ,? ,?,?)";
		int count=0;
		try (Connection c = ConnectionUtil.getConnection();
				PreparedStatement ps = c.prepareStatement(sql)) {
			
			ps.setDouble(1,  acct.getBalance());
			ps.setInt(2,  acct.getUserId());
			ps.setString(3, acct.getAccountType());
			ps.setInt(4, acct.getAccountpin());
			count=ps.executeUpdate();
		
		}
		
	
		return "You have successfully created a" + " " +  acct.getAccountType() + " " + "account";


	}

	


	
	
	
	
}

	
	

	

