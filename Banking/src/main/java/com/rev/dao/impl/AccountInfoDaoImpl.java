package com.rev.dao.impl;

import com.rev.util.*;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.rev.dao.AccountInfoDao;
import com.rev.model.AccountInfo;


public class AccountInfoDaoImpl implements AccountInfoDao {

	public List<AccountInfo> getAccountInfo() {
		String sql = "select * from AccountInfo";
		List<AccountInfo> accounts = new ArrayList<>();
		
		try (Connection c = ConnectionUtil.getConnection();
				Statement s = c.createStatement();
				ResultSet rs = s.executeQuery(sql)) {
			
			while(rs.next()) {
				int account_id = rs.getInt("AccountID");
				float account_balance = rs.getFloat("AccountBalance");
				int user_id = rs.getInt("UserID");
				AccountInfo a = new AccountInfo(account_id, account_balance, user_id);
				accounts.add(a);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return accounts;
	}
	

	public int withdrawal(AccountInfo a, double amount) {
		int accntPostWithdrawal=0;
		try(Connection c = ConnectionUtil.getConnection();
			CallableStatement call = c.prepareCall("{call withdraw(?,?)}")){
			call.setDouble(1, amount);
			call.setInt(2, a.getAccount_id());
				
			accntPostWithdrawal=call.executeUpdate();
				
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return accntPostWithdrawal;
		
	}

	public int deposit(AccountInfo a, double amount) {
		int accntPostDeposit=0;
		try(Connection c = ConnectionUtil.getConnection();
			CallableStatement call = c.prepareCall("{call deposit(?,?)}")){
			call.setDouble(1, amount);
			call.setInt(2, a.getAccount_id());
				
			accntPostDeposit=call.executeUpdate();
				
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return accntPostDeposit;
		
	}



	public int createAccount(AccountInfo a) {
		String sql = "insert into accountinfo (accountbalance,userid) values (?, ?)";
		int AccntsCreated = 0;
		
		try(Connection c = ConnectionUtil.getConnection();
				PreparedStatement ps = c.prepareStatement(sql)){
			ps.setDouble(1, a.getAccount_balance());
			ps.setInt(2, a.getAccount_id());
			
			AccntsCreated = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return AccntsCreated;
	}

	public int updateAccount(AccountInfo a) {
		int accntsUpdated = 0;
		String sql = "update accountinfo set accountbalance = ? where accountid = ?";
		
		try(Connection c = ConnectionUtil.getConnection();
				PreparedStatement ps = c.prepareStatement(sql)){
			
			ps.setDouble(1, a.getAccount_balance());
			ps.setInt(2,a.getAccount_id());
			accntsUpdated = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return accntsUpdated;
	}

	public int deleteAccount(AccountInfo a) {
		int accntsDeleted = 0;
		String sql = "delete from accountinfo where accountid = ?";
		
		try(Connection c = ConnectionUtil.getConnection();
				PreparedStatement ps = c.prepareStatement(sql)){
			ps.setInt(1,a.getAccount_id());
			accntsDeleted = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return accntsDeleted;
	}

	public AccountInfo getAccountById(int id) {
		String sql = "select * from accountinfo where accountid = ?";
		AccountInfo a = null;
		
		try (Connection c = ConnectionUtil.getConnection();
				PreparedStatement ps = c.prepareStatement(sql)) {
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				int account_id = rs.getInt("AccountID");
				float account_balance = rs.getFloat("AccountBalance");
				int user_id = rs.getInt("UserID");
				a = new AccountInfo(account_id, account_balance, user_id);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return a;
	}
	

	
}
