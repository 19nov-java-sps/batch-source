package com.revature.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.revature.dao.AccountDao;
import com.revature.dao.impl.AccountDaoImpl;
import com.revature.model.Account;
import com.revature.model.User;
import com.revature.util.ConnectionUtil;


/*******************************************
1. Check a balance
2. Add money
3. Withdraw money
 *******************************************/

public class AccountService {
	
	//Checking balance method
	public double checkBalance (int accId) {
		String sql = "select balance from accounts where account_id = ?";
		double ammount=0;
				try(Connection c = ConnectionUtil.getConnection();
				PreparedStatement ps = c.prepareStatement(sql)){
			ps.setInt(1, accId);
			ResultSet rs = ps.executeQuery();
		
			while(rs.next()) {
				 ammount = rs.getDouble("balance");
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ammount;
	}
	
	//adding money
	public void addMoney (int acId, double sum) {
		String sql = "update accounts set balance = balance + ? where account_id=?";
		
		try(Connection c = ConnectionUtil.getConnection();
				PreparedStatement ps = c.prepareStatement(sql)){
			ps.setDouble(1, sum);
			ps.setInt(2, acId);
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//withdraw money
	public void withdrawMoney (int acId, double sum) {
		String sql = "update accounts set balance = balance - ? where account_id=?";
		
		try(Connection c = ConnectionUtil.getConnection();
				PreparedStatement ps = c.prepareStatement(sql)){
			ps.setDouble(1, sum);
			ps.setInt(2, acId);
			ps.execute();
		} catch (SQLException e) {
			System.out.println("You tried to exceede avalable funds of " + checkBalance(acId) );
			e.printStackTrace();
		}
	}

	
	//************************************************************************************
	
	private AccountDao accountDao = new AccountDaoImpl();
	
	
	public List<Account> getAccount(){
		return accountDao.getAccounts();
	}
	
	public boolean createAccount(Account a) {
		
		int accCreated = accountDao.createAccount(a);
		if(accCreated !=0) {
			return true;
		}
		return false;
	}
	

}
