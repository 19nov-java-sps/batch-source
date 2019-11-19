package com.revature.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.dao.BankAcctDao;
import com.revature.model.BankAcct;
import com.revature.util.ConnectionUtil;

public class BankAcctDaoImpl implements BankAcctDao {

	public List<BankAcct> getBankAcct() {
		String sql = "select * from bankacct";
		List<BankAcct> bankAcct = new ArrayList<>();
		
		try (Connection c = ConnectionUtil.getConnection();
				Statement s = c.createStatement();
				ResultSet rs = s.executeQuery(sql)) {
			
			while(rs.next()) {
				int userId = rs.getInt("user_id");
				String firstName = rs.getString("first_name");
				String lastName = rs.getString("last_name");
				double balance = rs.getDouble("balance");
				BankAcct acct = new BankAcct(firstName, lastName, balance, userId);
				bankAcct.add(acct);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return bankAcct;
	}

	@Override
	public BankAcct getBankAcctByUserId(int id) {
		String sql = "select * from bankacct where user_id = ?";
		BankAcct b = null;
		
		try (Connection c = ConnectionUtil.getConnection();
				PreparedStatement ps = c.prepareStatement(sql)) {
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				int userId = rs.getInt("user_id");
				String firstName = rs.getString("first_name");
				String lastName = rs.getString("last_name");
				double balance = rs.getDouble("balance");
				b = new BankAcct(firstName, lastName, balance, userId);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return b;
	}


	@Override
	public int createBankAcct(BankAcct b) {
		String sql = "insert into bankacct (firstName, lastName, balance, userId ) values (?, ?, ?, ?)";
		int bankAcctsCreated = 0;
		
		try(Connection c = ConnectionUtil.getConnection();
				PreparedStatement ps = c.prepareStatement(sql)){
			ps.setString(1, b.getFirstName());
			ps.setString(2, b.getLastName());
			ps.setDouble(3, b.getBalance());
			ps.setInt(4, b.getUserId());
			
			bankAcctsCreated = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return bankAcctsCreated;
	}

	@Override
	public int updateBankAcct(BankAcct b) {
		String sql = "update bankacct set firstName = ?, lastName = ?, balance = ?, userId = ?";
		int bankAcctsUpdated = 0;
		
		try(Connection c = ConnectionUtil.getConnection();
				PreparedStatement ps = c.prepareStatement(sql)){
			ps.setString(1, b.getFirstName());
			ps.setString(2, b.getLastName());
			ps.setDouble(3, b.getBalance());
			ps.setInt(4, b.getUserId());
			
			bankAcctsUpdated = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return bankAcctsUpdated;
	}

	@Override
	public int deletBankAcct(BankAcct b) {
		String sql = "delete from bankacct where user_id = ?";
		int bankAcctsDeleted = 0;
		
		try(Connection c = ConnectionUtil.getConnection();
				PreparedStatement ps = c.prepareStatement(sql)){
			ps.setInt(1, b.getUserId());
			
			bankAcctsDeleted = ps.executeUpdate();
			this.getBankAcct();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return bankAcctsDeleted;
	}

}