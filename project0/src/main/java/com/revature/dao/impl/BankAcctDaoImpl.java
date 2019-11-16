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
		
		return 0;
	}

	@Override
	public int deleteBankAcct(BankAcct b) {
		// TODO Auto-generated method stub
		return 0;
	}


}
