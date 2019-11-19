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

public class AccountDaoImpl implements AccountDao {

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
	public Account getAccountById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	/*@Override
	public int createAccount(Account a) {
		String sql = "insert into Accounts (account_type, balance, user_id) values (?, ?, ?, ?)";
		
		int accountCreated = 0;
		
		try {
			Connection c = ConnectionUtil.getConnection();
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(2, a.getType());
			ps.setDouble(3, a.getBalance());
			ps.setInt(4, a.getUser());
			
			
			accountCreated = ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return accountCreated;
	}*/

	@Override
	public int updateAccount(Account a) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteAccount(Account a) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void addMoney(Account a, double money) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void withdrowMoney(Account a, double money) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int createAccount(Account a) {
		// TODO Auto-generated method stub
		return 0;
	}

}
