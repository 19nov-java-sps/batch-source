package com.revature.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.dao.AccountDao;
import com.revature.model.Account;

import com.revature.model.User;
import com.revature.util.ConnectionUtil;

/*******************************************
1. Get account ID by providing an userId
2. Get account data by providing an account id
3. Delete an account
4.Create an account
 *******************************************/

public class AccountDaoImpl implements AccountDao {

	//get Account Id by providing userId
	public int getUserAccountId(int userId) {
		String sql = "select account_id from accounts where userId = ?";
		int accountId = 0;

		
		try (Connection c = ConnectionUtil.getConnection();
				PreparedStatement ps = c.prepareStatement(sql)) {
				ps.setInt(1, userId);
				ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				 accountId = rs.getInt("account_id");
					}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return accountId;
		
	};
	
	//get account data by providing an account id
	@Override
	public Account getAccountById(int id) {
		// TODO Auto-generated method stub
		String sql = "select * from accounts where account_id = ?";
		Account a = null;
		
		try (Connection c = ConnectionUtil.getConnection();
				PreparedStatement ps = c.prepareStatement(sql)) {
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				int accountId = rs.getInt("account_id");
				String accType = rs.getString("account_type");
				double balance = rs.getDouble("balance");
				int userId = rs.getInt("user_id");
				a = new Account(accountId, accType, balance, userId);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return a;
	}
	
	//delete an account 
	@Override
	public int deleteAccount(Account a) {
		int rowsDeleted = 0;
		String sql = "delete from accounts where user_id = ?";
		
		try(Connection c = ConnectionUtil.getConnection();
				PreparedStatement ps = c.prepareStatement(sql)){
			ps.setInt(1, a.getUserId());
			rowsDeleted  = ps.executeUpdate();
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		return rowsDeleted;
}
	
	//create an account

	@Override
	public int createAccount(Account a) {
		String sql = "insert into Accounts (account_type, balance, user_id) values (?,?,?)";
		int accountCreated = 0;
		
		try(Connection c = ConnectionUtil.getConnection();
				PreparedStatement ps = c.prepareStatement(sql)){
			ps.setString(1, a.getType());
			ps.setDouble(2, a.getBalance());
			ps.setInt(3, a.getUserId());
			
			accountCreated = ps.executeUpdate();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return accountCreated;
	}
	
	
	//**************************************************************************

	@Override
	public int updateAccount(Account a) {
		// TODO Auto-generated method stub
		return 0;
	}


	

	@Override
	public void addMoney(Account a, double money) {
		// TODO Auto-generated method stub
		
	}


	
	@Override
	public List<Account> getAccounts() {
		String sql = "select * from Accounts";
		List<Account> accounts = new ArrayList<>();
		
		
		try (Connection c = ConnectionUtil.getConnection();
				Statement s = c.createStatement();
				ResultSet rs = s.executeQuery(sql))	{
			
			while(rs.next()) {
				int accountId = rs.getInt("account_id");
				String accounType = rs.getString("account_type");
				double balance = rs.getDouble("balance");
				int userId = rs.getInt("user_id");
				Account a = new Account(accountId, accounType, balance, userId);
				accounts.add(a);
				}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return accounts;
	}
	
	
	@Override
	public void withdrowMoney(Account a, double money) {
		// TODO Auto-generated method stub
		
	}

}
