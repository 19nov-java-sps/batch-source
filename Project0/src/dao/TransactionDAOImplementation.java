package dao;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import model.Account;
import model.Transaction;
import model.User;
import util.ConnectionUtil;

public class TransactionDAOImplementation implements TransactionDAO {

	@Override
	public List<Transaction> getAllTransactions() {
		List<Transaction> transactionList = new ArrayList<>();
		String sql = "select * from banktransaction";

		try (Connection con = ConnectionUtil.getConnection();
				Statement s = con.createStatement();
				ResultSet rs = s.executeQuery(sql); ) {
			while (rs.next()) {
				Transaction t = new Transaction();
				int id = rs.getInt("transaction_ID");
				Timestamp time = rs.getTimestamp("transaction_time");
				int accountId = rs.getInt("bankaccount_ID");
				String username = rs.getString("bank_username");
				String type = rs.getString("transaction_type");
				BigDecimal beforeBalance = rs.getBigDecimal("balance_before_transaction");
				BigDecimal afterBalance = rs.getBigDecimal("balance_after_transaction");

				AccountDAOImplementation ad = new AccountDAOImplementation();
				Account account = ad.getAccountById(accountId);

				UserDAOImplementation ud = new UserDAOImplementation();
				User user = ud.getUserById(username);

				t.setId(id);
				t.setTime(time);
				t.setAccount(account);
				t.setUser(user);
				t.setType(type);
				t.setBalanceBefore(beforeBalance);
				t.setBalanceAfter(afterBalance);

				transactionList.add(t);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return transactionList;
	}

	@Override
	public Transaction getTransactionById(int id) {
		Transaction t = null;
		String sql = "select * from banktransaction where bankaccount_id = ?";

		ResultSet rs = null;
		try (Connection con = ConnectionUtil.getConnection();
				PreparedStatement ps = con.prepareStatement(sql);) {
			ps.setInt(1, id);
			rs = ps.executeQuery();

			while (rs.next()) {
				int transactionId = rs.getInt("transaction_ID");
				Timestamp time = rs.getTimestamp("transaction_time");
				AccountDAOImplementation ad = new AccountDAOImplementation();
				Account account = ad.getAccountById(rs.getInt("bankaccount_ID"));

				UserDAOImplementation ud = new UserDAOImplementation();
				User user = ud.getUserById(rs.getString("bank_username"));

				String type = rs.getString("transaction_type");
				BigDecimal balanceBefore = rs.getBigDecimal("balance_before_transaction");
				BigDecimal balanceAfter = rs.getBigDecimal("balance_after_transaction");

				t = new Transaction(transactionId, time, account, user, type, balanceBefore, balanceAfter);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return t;
	}

	@Override
	public Transaction getTransactionById(Connection con, int id) {
		Transaction t = null;
		String sql = "select * from banktransaction where transaction_ID = ?";

		ResultSet rs = null;
		try (PreparedStatement ps = con.prepareStatement(sql);) {
			ps.setInt(1, id);
			rs = ps.executeQuery();

			while (rs.next()) {
				int transactionId = rs.getInt("transaction_ID");
				Timestamp time = rs.getTimestamp("transaction_time");
				AccountDAOImplementation ad = new AccountDAOImplementation();
				Account account = ad.getAccountById(rs.getInt("bankaccount_ID"));

				UserDAOImplementation ud = new UserDAOImplementation();
				User user = ud.getUserById(rs.getString("bank_username"));

				String type = rs.getString("transaction_type");
				BigDecimal balanceBefore = rs.getBigDecimal("balance_before_transaction");
				BigDecimal balanceAfter = rs.getBigDecimal("balance_after_transaction");

				t = new Transaction(transactionId, time, account, user, type, balanceBefore, balanceAfter);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return t;
	}

	@Override
	public int createTransaction(Transaction transaction) {
		int transactionsCreated = 0;
		String sql = "insert into banktransaction (transaction_id, transaction_time, bankaccount_id, bank_username, transaction_type, before_transaction_balance, after_transaction_balance) values (?, ?, ?, ?, ?, ?, ?)";
		try (Connection con = ConnectionUtil.getConnection();
				PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setInt(1, transaction.getId());
			ps.setTimestamp(2, transaction.getTime());
			ps.setInt(3, transaction.getAccount().getId());
			ps.setString(4, transaction.getUser().getUsername());
			ps.setString(5, transaction.getType());
			ps.setBigDecimal(6, transaction.getBalanceBefore());
			ps.setBigDecimal(7, transaction.getBalanceAfter());
			transactionsCreated = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return transactionsCreated;
	}

	@Override
	public int updateTransaction(Transaction transaction) {
		int transactionsUpdated = 0;
		String sql = "update banktransaction "
				+ "set transaction_id = ?, "
				+ "transaction_time = ?, "
				+ "bankaccount_id = ?, "
				+ "bank_username = ?, "
				+ "transaction_type = ?, "
				+ "before_transaction_balance = ?, "
				+ "after_transaction_balance = ? ";

		try (Connection con = ConnectionUtil.getConnection();
				PreparedStatement ps = con.prepareStatement(sql);) {
			con.setAutoCommit(false);
			ps.setInt(1, transaction.getId());
			ps.setTimestamp(2, transaction.getTime());
			ps.setInt(3, transaction.getAccount().getId());
			ps.setString(4, transaction.getUser().getUsername());
			ps.setString(5, transaction.getType());
			ps.setBigDecimal(6, transaction.getBalanceBefore());
			ps.setBigDecimal(7, transaction.getBalanceAfter());

			transactionsUpdated = ps.executeUpdate();
			con.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return transactionsUpdated;
	}

	@Override
	public int deleteTransaction(Transaction transaction) {
		int rowsDeleted = 0;
		String sql = "delete from banktransaction where transaction_id = ?";
		try (Connection con = ConnectionUtil.getConnection();
				PreparedStatement ps = con.prepareStatement(sql); ) {
			ps.setInt(1, transaction.getId());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rowsDeleted;
	}

	@Override
	public int deleteTransactionById(int id) {
		int rowsDeleted = 0;
		String sql = "delete from banktransaction where transaction_id = ?";
		try (Connection con = ConnectionUtil.getConnection();
				PreparedStatement ps = con.prepareStatement(sql); ) {
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rowsDeleted;
	}
}
