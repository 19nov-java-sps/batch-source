package com.daoimpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.dao.CustomerDao;
import com.model.Customer;
import com.util.ConnectionUtil;

public class CustomerDaoImpl implements CustomerDao {

	//this is where I auto-generated user ids with Math.random so there wouldn't be an issue with duplicate key constraints
	protected static final int ACCOUNT_STARTING_ID_NUMBER = (int) (Math.random() * 1000 + 0);
	protected static final int ACCOUNT_ID_INCREMENT = 1;
	protected static int currentAvailableAccountID = ACCOUNT_STARTING_ID_NUMBER;
	Scanner sc = new Scanner(System.in);

	@Override
	public int generateCustomerId() {
		currentAvailableAccountID = currentAvailableAccountID + ACCOUNT_ID_INCREMENT;
		Customer.customerId = (int) Math.ceil(Math.random() + currentAvailableAccountID);
		return Customer.customerId;

	}

	@Override
	public List<Customer> getCustomer() {
		List<Customer> customer = new ArrayList<>();
		String sql = "select * from bankuser";

		try (Connection con = ConnectionUtil.getConnection();
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {
			while (rs.next()) {
				int customerId = rs.getInt("customer_id");
				double balance = rs.getDouble("balance");
				String userName = rs.getString("user_name");
				String passWord = rs.getString("pass_word");
				String firstName = rs.getString("first_name");
				String lastName = rs.getString("last_name");

				Customer c = new Customer(customerId, balance, userName, passWord, firstName, lastName);
				customer.add(c);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return customer;
	}

	// getting user information based on customer_id
	@Override
	public Customer getCustomerId(int id) {
		String sql = "select * from bankuser where customer_id = ?";
		Customer c = null;

		try (Connection con = ConnectionUtil.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				int customerId = rs.getInt("customer_id");
				double balance = rs.getDouble("balance");
				String userName = rs.getString("user_name");
				String passWord = rs.getString("pass_word");
				String firstName = rs.getString("first_name");
				String lastName = rs.getString("last_name");
				c = new Customer(customerId, balance, userName, passWord, firstName, lastName);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return c;
	}

	// getting user information based on user name and it can be used later for
	// validation
	@Override
	public Customer getUserPass(String username) {
		String sql = "select * from bankuser where user_name = ?";
		Customer c = null;

		try (Connection con = ConnectionUtil.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				int customerId = rs.getInt("customer_id");
				double balance = rs.getDouble("balance");
				String userName = rs.getString("user_name");
				String passWord = rs.getString("pass_word");
				String firstName = rs.getString("first_name");
				String lastName = rs.getString("last_name");
				c = new Customer(customerId, balance, userName, passWord, firstName, lastName);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return c;
	}

	@Override
	public int createCustomer(Customer c) {
		String sql = "insert into bankuser (customer_id, balance, user_name, pass_word, first_name, last_name) values (?,?,?,?,?,?)";
		int customerCreated = 0;

		try (Connection con = ConnectionUtil.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {

			ps.setInt(1, c.getCustomerId());
			ps.setDouble(2, c.getBalance());
			ps.setString(3, c.getUserName());
			ps.setString(4, c.getPassWord());
			ps.setString(5, c.getFirstName());
			ps.setString(6, c.getLastName());

			customerCreated = ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return customerCreated;

	}

	@Override
	public int updateCustomer(Customer c) {
		String sql = "update bankuser set customer_id = ?, balance = ?, user_name = ?, pass_word = ?, first_name = ?, last_name = ? where customer_id = ?";
		int customerUpdated = 0;

		try (Connection con = ConnectionUtil.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {

			ps.setInt(1, c.getCustomerId());
			ps.setDouble(2, c.getBalance());
			ps.setString(3, c.getUserName());
			ps.setString(4, c.getPassWord());
			ps.setString(5, c.getFirstName());
			ps.setString(6, c.getLastName());
			ps.setInt(7, c.getCustomerId());

			customerUpdated = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return customerUpdated;
	}

	@Override
	public int deleteCustomer(Customer c) {
		String sql = "delete from bankuser where customer_id = ?";
		int userDeleted = 0;

		try (Connection con = ConnectionUtil.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setInt(1, c.getCustomerId());
			userDeleted = ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return userDeleted;
	}

	@Override
	public void depositFunds(Customer c, double increase) {
		String sql = "{ call deposit(?, ?) }";

		try (Connection con = ConnectionUtil.getConnection(); CallableStatement cs = con.prepareCall(sql)) {
			cs.setDouble(1, increase);
			cs.setInt(2, c.getCustomerId());

			cs.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void withdrawFunds(Customer c, double decrease) {
		String sql = "{ call withdraw(?, ?) }";

		try (Connection con = ConnectionUtil.getConnection(); CallableStatement cs = con.prepareCall(sql)) {
			cs.setDouble(1, decrease);
			cs.setInt(2, c.getCustomerId());
			cs.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
