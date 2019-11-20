package com.revature.dao.impl;

import java.sql.*;
import java.util.*;

import com.revature.dao.BalanceDao;
import com.revature.model.Balance;
import com.revature.model.Users;
import com.revature.util.ConnectionUtil;

public class BalanceDaoImpl implements BalanceDao {

	@Override
	public Balance getBalanceById(int id) {
		String sql = "select * from Balance where id = ?";
		Balance b = null;
		
		try (Connection c = ConnectionUtil.getConnection();
			PreparedStatement ps = c.prepareStatement(sql)) {
				
				ps.setInt(1, id);
				ResultSet idSame = ps.executeQuery();
			
			while(idSame.next()) {
				int idNumber = idSame.getInt("id");
				double balance = idSame.getDouble("balance");
				b = new Balance(idNumber, balance);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return b;
	}

	@Override
	public int createBalance(Balance b) {
		String sql = "insert into Balance (id, balance) values (?, ?)";
		int balCreate = 0;
		
		try(Connection c = ConnectionUtil.getConnection();
				PreparedStatement ps = c.prepareStatement(sql)){
			
			ps.setInt(1, b.getId());
			ps.setDouble(2, b.getBalance());
			balCreate = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
				
		return balCreate;
	}

	@Override
	public void withdraw(int id, double amount) {
		String sql = "update balance set balance=balance-? where id=?";
		
		try(Connection c = ConnectionUtil.getConnection();
			CallableStatement cs = c.prepareCall(sql)){
			
			cs.setDouble(1, amount);
			cs.setInt(2, id);	

			
			cs.execute();
        	
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deposit(int id, double amount) {
		String sql = "update balance set balance=balance+? where id=?";
		
		try(Connection c = ConnectionUtil.getConnection();
			CallableStatement cs = c.prepareCall(sql)){
			
			cs.setDouble(1, amount);
			cs.setInt(2, id);	

			
			cs.execute();
        	
		
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public List<Balance> getBalance() {
		String sql = "select * from Balance";
		List<Balance> balances = new ArrayList<>();
		
		try (Connection c = ConnectionUtil.getConnection();
				Statement s = c.createStatement();
				ResultSet rs = s.executeQuery(sql)) {
			
			while(rs.next()) {
				int idNumber = rs.getInt("id");
				double balance = rs.getDouble("balance");
				Balance b = new Balance(idNumber, balance);
				balances.add(b);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return balances;
	}

	}

