package com.revature.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.dao.BankAccDao;
import com.revature.model.BankAcc;
import com.revature.util.ConnectionUtil;

public class BankAccDaoImpl implements BankAccDao{

	@Override
	public int createBankAcc(BankAcc ba) {
		// TODO Auto-generated method stub
		String sql = "insert into bank_acc (user_id, balance) values (?,?)";
		int bankCreated = 0;
		try(Connection c = ConnectionUtil.getConnection();
				PreparedStatement ps = c.prepareStatement(sql);){
			ps.setInt(1, ba.getUserID());
			ps.setInt(2, ba.getBalance());	
			bankCreated = ps.executeUpdate();
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		return bankCreated;
	}

	@Override
	public void depositStatement(int increase, int bankid) {
		// TODO Auto-generated method stub
		String sql = "{call deposit (?,?)}";

		try(Connection c = ConnectionUtil.getConnection();
				CallableStatement cs = c.prepareCall(sql);){

			cs.setInt(1, increase);
			cs.setInt(2, bankid);

			cs.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void withdrawStatement(int decrease, int bankid) {
		// TODO Auto-generated method stub
		String sql = "{call withdraw (?,?)}";
		try(Connection c = ConnectionUtil.getConnection();
				CallableStatement cs = c.prepareCall(sql);){

			cs.setInt(1, decrease);
			cs.setInt(2, bankid);

			cs.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public BankAcc findBankAcc(int id) {
		// TODO Auto-generated method stub
		String sql = "select * from bank_acc where user_id = ?";
		BankAcc ba = null;
		
		try(Connection c = ConnectionUtil.getConnection();
				PreparedStatement ps = c.prepareStatement(sql);){
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				int bankid = rs.getInt("bank_id");
				int userid = rs.getInt("user_id");
				int balance = rs.getInt("balance");
				ba = new BankAcc(bankid, userid, balance);
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return ba;
	}

	@Override
	public List<BankAcc> getBankAcc(int id) {
		// TODO Auto-generated method stub
		String sql = "select * from bank_acc where user_id = ?";
		List<BankAcc> bank = new ArrayList<>();
		
		
		try(Connection c = ConnectionUtil.getConnection();
				PreparedStatement ps = c.prepareStatement(sql)){
			
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				int bankid = rs.getInt("bank_id");
				int userid = rs.getInt("user_id");
				int balance = rs.getInt("balance");
				BankAcc ba = new BankAcc(bankid, userid, balance);
				bank.add(ba);
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return bank;
	}

	@Override
	public int getBalance(int bankid) {
		String sql = "select * from bank_acc where bank_id = ?";
		int balance = 0;
		try(Connection c = ConnectionUtil.getConnection();
				PreparedStatement ps = c.prepareStatement(sql);){
			ps.setInt(1, bankid);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				balance = rs.getInt("balance");
			}
		} 
		catch(SQLException e){
			
		}
		return balance;
	}

	
}
