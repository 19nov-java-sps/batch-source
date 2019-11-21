package dao;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import model.Account;
import model.User;
import util.ConnectionUtil;

public class UserDAOImplementation implements UserDAO {

	@Override
	public List<User> getAllUsers() {
		List<User> userList = new ArrayList<>();
		String sql = "select * from bankuser";

		// ok to use statement because we're not taking any user input
		try (Connection con = ConnectionUtil.getConnection();
				Statement s = con.createStatement();
				ResultSet rs = s.executeQuery(sql); ) {
			while (rs.next()) {
				User u = new User();
				String username = rs.getString("bank_username");
				String password = rs.getString("bank_password");
				String firstname = rs.getString("firstname");
				String lastname = rs.getString("lastname");

				u.setUsername(username);
				u.setPassword(password);
				u.setFirstname(firstname);
				u.setLastname(lastname);

				userList.add(u);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return userList;
	}

	public List<Account> getAcounts(String userId) {
		List<Account> userAccounts = new ArrayList<>();
		// ok to use statement because we're not taking any user input
		String sql = "{call get_user_accounts(?)}";
		try (Connection con = ConnectionUtil.getConnection();
			CallableStatement cs = con.prepareCall(sql); ) {
			ResultSet rs = cs.getResultSet();
			while (rs.next()) {
				Account a = new Account();

				int id = rs.getInt("bankaccount_ID");
				BigDecimal balance = rs.getBigDecimal("bankaccount_balance");
				String type = rs.getString("checking_or_savings");
				boolean isJoint = rs.getString("single_or_joint").equals("joint");

				a.setId(id);
				a.setBalance(balance);
				a.setType(type);
				a.setJoint(isJoint);

				userAccounts.add(a);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return userAccounts;
	}

	@Override
	public User getUserById(String id) {
		User u = null;
		String sql = "select * from bankuser where bank_username = ?";

		ResultSet rs = null;
		try (Connection con = ConnectionUtil.getConnection();
				PreparedStatement ps = con.prepareStatement(sql);) {
			ps.setString(1, id);
			rs = ps.executeQuery();

			while (rs.next()) {
				String username = rs.getString("bank_username");
				String password = rs.getString("bank_password");
				String firstname = rs.getString("firstname");
				String lastname = rs.getString("lastname");

				u = new User(username, password, firstname, lastname);
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
		return u;
	}

	@Override
	public User getUserById(Connection con, String id) {
		User u = null;
		String sql = "select * from deparment where dept_id = ?";

		ResultSet rs = null;
		try(PreparedStatement ps = con.prepareStatement(sql);) {
			ps.setString(1, id);
			rs = ps.executeQuery();

			while (rs.next()) {
				String username = rs.getString("bank_username");
				String password = rs.getString("bank_password");
				String firstname = rs.getString("firstname");
				String lastname = rs.getString("lastname");

				u = new User(username, password, firstname, lastname);
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
		return u;
	}

	@Override
	public int createUser(User user) {
		int usersCreated = 0;
		String sql = "insert into bankuser (bank_username, bank_password, firstname, lastname) values (?, ?, ?, ?)";
		try (Connection con = ConnectionUtil.getConnection();
				PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			ps.setString(3, user.getFirstname());
			ps.setString(4, user.getLastname());
			usersCreated = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return usersCreated;
	}

	@Override
	public int updateUser(User user) {
		int usersUpdated = 0;
		String sql = "update bankuser "
				+ "set bank_username = ?, "
				+ "bank_password = ?, "
				+ "firstname = ?, "
				+ "lastname = ? ";

		try (Connection con = ConnectionUtil.getConnection();
				PreparedStatement ps = con.prepareStatement(sql);) {
			con.setAutoCommit(false);
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			ps.setString(3, user.getFirstname());
			ps.setString(4, user.getLastname());

			usersUpdated = ps.executeUpdate();
			con.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return usersUpdated;
	}

	@Override
	public int deleteUser(User user) {
		int rowsDeleted = 0;
		String sql = "delete from bankuser where bank_username = ?";
		try (Connection con = ConnectionUtil.getConnection();
				PreparedStatement ps = con.prepareStatement(sql); ) {
			ps.setString(1, user.getUsername());
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
	public int deleteUserById(String id) {
		int rowsDeleted = 0;
		String sql = "delete from bankuser where bank_username = ?";
		try (Connection con = ConnectionUtil.getConnection();
				PreparedStatement ps = con.prepareStatement(sql); ) {
			ps.setString(1, id);
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
