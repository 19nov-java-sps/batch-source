package com.revature.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.dao.BankAcctDao;
import com.revature.model.BankAcct;
import com.revature.model.Client;
import com.revature.util.ConnectionUtil;


public class BankAcctDaoImpl implements BankAcctDao{

	@Override
	public List<BankAcct> getBankAcct() {
		String sql = "select * from BankAcct";
		List<BankAcct> acct = new ArrayList<>();
		
		try (Connection c = ConnectionUtil.getConnection();
				Statement s = c.createStatement();
				ResultSet rs = s.executeQuery(sql)) {
			
			while(rs.next()) {
				int userId = rs.getInt("user_id");
				String firstName = rs.getString("firstName");
				String lastName = rs.getString("lastName");
				double balance = rs.getDouble("balance");
				BankAcct b = new BankAcct(firstName, lastName, balance, userId);
				acct.add(b);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return acct;
	}
	


	@Override
	public int createBankAcct(BankAcct b) {
		String sql = "insert into BankAcct (firstName, lastName,  balance, user_id) values (?,?,?,?)";
		int acctCreated = 0;
		
		try(Connection c = ConnectionUtil.getConnection();
				PreparedStatement ps = c.prepareStatement(sql)){
			ps.setString(1, b.getFirstName());
			ps.setString(2,b.getLastName());
			ps.setDouble(3, b.getBalance());
			ps.setInt(4, b.getUserId());
			acctCreated = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return acctCreated;
	}

	@Override
	public int updateBankAcct(BankAcct b) {
		int updateBankAcct = 0;
		String sql = "update BankAcct set firstName = ?, lastName = ?, balance = ? where user_id = ?";
		
		try(Connection c = ConnectionUtil.getConnection();
				PreparedStatement ps = c.prepareStatement(sql)){
			
			ps.setString(1, b.getFirstName());
			ps.setString(2, b.getLastName());
			ps.setDouble(3, b.getBalance());
			ps.setInt(4,  b.getUserId());
			updateBankAcct = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return updateBankAcct;
	}

	@Override
	public int deleteBankAcct(BankAcct b) {
		int rowsDeleted = 0;
		String sql = "delete from BankAct where user_id = ? ";
		
		try(Connection c = ConnectionUtil.getConnection();
				PreparedStatement ps = c.prepareStatement(sql)){
			ps.setInt(1, b.getUserId());
			rowsDeleted = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return rowsDeleted;
	}

	@Override
	public BankAcct getBankAcctByUserId(int id) {
		String sql = "select * from BankAcct where user_id = ?";
		BankAcct ba = null;
		
		try (Connection c = ConnectionUtil.getConnection();
				PreparedStatement ps = c.prepareStatement(sql)) {
			ps.setInt(1, id);
			ResultSet acctLocated = ps.executeQuery();
			
			while(acctLocated.next()) {
				int userId = acctLocated.getInt("user_id");
				String firstName = acctLocated.getString("firstName");
				String lastName = acctLocated.getString("lastName");
				double balance = acctLocated.getDouble("balance");
				ba = new BankAcct(firstName, lastName, balance, userId);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return ba;
	}



	@Override
	public void withdraw(BankAcct b, double withdrawAmount) {
		String sql = "{ call Withdraw(?,?)}";
		
		try(Connection c = ConnectionUtil.getConnection();
				CallableStatement cs = c.prepareCall(sql)){
			cs.setDouble(1, withdrawAmount);
			cs.setInt(2, b.getUserId());
			
			cs.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}



	@Override
	public void deposit(BankAcct b, double depositAmount) {
		String sql = "{ call Deposit(?,?)}";
		
		try(Connection c = ConnectionUtil.getConnection();
				CallableStatement cs = c.prepareCall(sql)){
			cs.setDouble(1, depositAmount);
			cs.setInt(2, b.getUserId());
			
			cs.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}



//	@Override
//	public int createBankAcctWithClient(Client c) {
//		String sql = "insert into BankAcct (firstName, lastName,  balance, user_id) values (?,?,?,?)";
//		int acctCreated = 0;
//		
//		try(Connection c = ConnectionUtil.getConnection();
//				PreparedStatement ps = c.prepareStatement(sql)){
//			ps.setString(1, c.);
//			ps.setString(2,b.getLastName());
//			ps.setDouble(3, b.getBalance());
//			ps.setInt(4, b.getUserId());
//			acctCreated = ps.executeUpdate();
//			
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		
//		
//		return acctCreated;
//	}


}
