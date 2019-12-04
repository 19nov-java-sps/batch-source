package com.revature.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.dao.EmployeesDao;
import com.revature.model.Employees;

import com.revature.util.ConnectionUtil;

public class EmployeesDaoImpl implements EmployeesDao {

	public List<Employees> employees = new ArrayList<>();

	public EmployeesDaoImpl() {
		employees.add(new Employees(1, "pnguye17", "12", "Peter Nguyen", true));
	}

	@Override
	public List<Employees> getAllDummies() {
		// TODO Auto-generated method stub
		return new ArrayList<>(employees);
	}

	@Override
	public Employees getDummiesById(int id) {
		for (Employees e : employees) {
			if (e.getEmployeeID() == id) {
				return e;
			}
		}
		return null;
	}

	@Override
	public List<Employees> getAllEmployees() {
		List<Employees> employees = new ArrayList<>();
		String sql = "select * from employees";

		try (Connection con = ConnectionUtil.getConnection();
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {
			while (rs.next()) {
				int employeeID = rs.getInt("emp_id");
				String userName = rs.getString("user_name");
				String passWord = rs.getString("pass_word");
				String fullName = rs.getString("full_name");
				boolean isManager = rs.getBoolean("isManager");

				Employees emp = new Employees(employeeID, userName, passWord, fullName, isManager);
				employees.add(emp);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return employees;
	}

	@Override
	public Employees getEmployeesById(int id) {
		String sql = "select * from employees where emp_id = ?";
		Employees e = null;

		try (Connection con = ConnectionUtil.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				int employeeID = rs.getInt("emp_id");
				String userName = rs.getString("user_name");
				String passWord = rs.getString("pass_word");
				String fullName = rs.getString("full_name");
				boolean isManager = rs.getBoolean("isManager");
				e = new Employees(employeeID, userName, passWord, fullName, isManager);
			}
		} catch (SQLException error) {
			error.printStackTrace();
		}
		return e;
	}

	@Override
	public Employees getUserByUsernameAndPassword(String username, String password) {
		String sql = "select * from employees where user_name = ? and pass_word = ?";
		try (Connection c = ConnectionUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				int employeeID = rs.getInt("emp_id");
				String userName = rs.getString("user_name");
				String passWord = rs.getString("pass_word");
				String fullName = rs.getString("full_name");
				boolean isManager = rs.getBoolean("isManager");

				Employees e = new Employees(employeeID, userName, passWord, fullName, isManager);
				return e;
			}

		} catch (SQLException error) {
			error.printStackTrace();
		}

		return null;
	}

	@Override
	public int createEmployee(Employees e) {
		String sql = "insert into employees (emp_id, user_name, pass_word, full_name, isManager) values (?,?,?,?,?)";
		int employeesCreated = 0;

		try (Connection con = ConnectionUtil.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {

			ps.setInt(1, e.getEmployeeID());
			ps.setString(2, e.getUserName());
			ps.setString(3, e.getPassWord());
			ps.setString(4, e.getFullName());
			ps.setBoolean(5, e.getisManager());

			employeesCreated = ps.executeUpdate();

		} catch (SQLException error) {
			error.printStackTrace();
		}
		return employeesCreated;
	}

	@Override
	public int updateEmployee(Employees e) {
		String sql = "insert into employees (emp_id, user_name, pass_word, full_name, isManager) values (?,?,?,?,?)";
		int employeeUpdated = 0;

		try (Connection con = ConnectionUtil.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {

			ps.setInt(1, e.getEmployeeID());
			ps.setString(2, e.getUserName());
			ps.setString(3, e.getPassWord());
			ps.setString(4, e.getFullName());
			ps.setBoolean(5, e.getisManager());

			employeeUpdated = ps.executeUpdate();

		} catch (SQLException error) {
			error.printStackTrace();
		}
		return employeeUpdated;
	}

	@Override
	public int deleteEmployee(Employees e) {
		String sql = "delete from employees where emp_id = ?";
		int employeeDeleted = 0;

		try (Connection con = ConnectionUtil.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setInt(1, e.getEmployeeID());
			employeeDeleted = ps.executeUpdate();

		} catch (SQLException error) {
			error.printStackTrace();
		}
		return employeeDeleted;
	}

}
