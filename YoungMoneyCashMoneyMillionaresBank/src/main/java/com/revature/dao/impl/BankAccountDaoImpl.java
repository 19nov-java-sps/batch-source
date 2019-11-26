package com.revature.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.dao.BankAccountDao;
import com.revature.model.BankAccount;
import com.revature.util.ConnectionUtil;

public class BankAccountDaoImpl implements BankAccountDao {

	@Override
	public List<BankAccount> getBankAccount() {
		List<BankAccount> bankaccount = new ArrayList<>();

		String sql = "select * from bankaccount";

		try (Connection c = ConnectionUtil.getConnection();
				Statement s = c.createStatement();
				ResultSet rs = s.executeQuery(sql)) {

			while (rs.next()) {
				int userId = rs.getInt("user_id");
				String firstName = rs.getString("first_name");
				String lastName = rs.getString("last_name");
				double budget = rs.getDouble("balance");
				BankAccount b = new BankAccount(userId, firstName, lastName, budget);
				bankaccount.add(b);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bankaccount;
	}

	@Override
	public BankAccount getBankById(int id) {
		String sql = "select * from bankaccount where user_id = ?";
		BankAccount b = null;

		try (Connection c = ConnectionUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				int userId = rs.getInt("user_id");
				String firstName = rs.getString("first_name");
				String lastName = rs.getString("last_name");
				double balance = rs.getDouble("balance");
				b = new BankAccount(userId, firstName, lastName, balance);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return b;
	}

	@Override
	public int createBankAccount(BankAccount b) {
		String sql = "insert into bankaccount (first_name, last_name, balance, user_id) values (?, ?, ?, ?)";

		int bankaccountCreated = 0;

		try (Connection c = ConnectionUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {

			ps.setString(1, b.getFirstName());
			ps.setString(2, b.getLastName());
			ps.setDouble(3, b.getBalance());
			ps.setInt(4, b.getUserId());

			bankaccountCreated = ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bankaccountCreated;
	}

	@Override
	
	
	public int updateBankAccount(BankAccount b) {
		String sql = "update bankaccount set user_id = ?, first_name = ?, last_name = ?, balance = ? where user_id = ?"; // i removed this bc too many params >>> ", where user_id = ?"
		int bankaccountUpdated = 0;

		try (Connection c = ConnectionUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
			ps.setInt(1, b.getUserId());
			ps.setString(2, b.getFirstName());
			ps.setString(3, b.getLastName());
			ps.setDouble(4, b.getBalance());
			ps.setInt(5, b.getUserId());

			bankaccountUpdated = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return bankaccountUpdated;
	}

	@Override
	public int deleteBankAccount(BankAccount b) {
		int rowsDeleted = 0;
		String sql = "delete from bankaccount where user_id = ?";

		try (Connection c = ConnectionUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
			ps.setInt(1, b.getUserId());
			rowsDeleted = ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rowsDeleted;
	}

	@Override
	public void deposit(BankAccount b, double increase) {
		String sql = "{ call deposit(?,?)}";

		try (Connection c = ConnectionUtil.getConnection(); CallableStatement cs = c.prepareCall(sql)) {
			cs.setDouble(1, increase);
			cs.setInt(2, b.getUserId());

			cs.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void withdraw(BankAccount b, double decrease) {
		String sql = "{ call withdraw(?,?)}";

		try (Connection c = ConnectionUtil.getConnection(); CallableStatement cs = c.prepareCall(sql)) {
			cs.setDouble(1, decrease);
			cs.setInt(2, b.getUserId());

			cs.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
