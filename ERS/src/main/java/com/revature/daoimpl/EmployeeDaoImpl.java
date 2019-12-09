package com.revature.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.dao.EmployeeDao;
import com.revature.models.Employee;
import com.revature.util.ConnectionUtil;

public class EmployeeDaoImpl implements EmployeeDao {

	@Override
	public List<Employee> getAllEmployees() {
		List<Employee> employee = new ArrayList<>();
		String sql = "select * from employee";

		try (Connection con = ConnectionUtil.getConnection();
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {
			while (rs.next()) {
				int employeeID = rs.getInt("emp_id");
				String userName = rs.getString("user_name");
				String passWord = rs.getString("pass_word");
				String fullName = rs.getString("full_name");
				boolean isManager = rs.getBoolean("ismanager");

				Employee e = new Employee(employeeID, userName, passWord, fullName, isManager);
				employee.add(e);
			}

		} catch (SQLException error) {
			error.printStackTrace();
		}
		return employee;
	}

	@Override
	public Employee getEmployeeById(int id) {
		String sql = "select * from employee where emp_id = ?";
		Employee e = null;

		try (Connection con = ConnectionUtil.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				int employeeID = rs.getInt("emp_id");
				String userName = rs.getString("user_name");
				String passWord = rs.getString("pass_word");
				String fullName = rs.getString("full_name");
				boolean isManager = rs.getBoolean("ismanager");
				e = new Employee(employeeID, userName, passWord, fullName, isManager);
			}
		} catch (SQLException error) {
			error.printStackTrace();
		}
		return e;
	}

	@Override
	public Employee getEmployeeByUsernameAndPassword(String username, String password) {
		String sql = "select * from employee where user_name = ? and pass_word = ?";
		try (Connection c = ConnectionUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				int employeeID = rs.getInt("emp_id");
				String userName = rs.getString("user_name");
				String passWord = rs.getString("pass_word");
				String fullName = rs.getString("full_name");
				boolean isManager = rs.getBoolean("ismanager");

				Employee e = new Employee(employeeID, userName, passWord, fullName, isManager);
				return e;
			}

		} catch (SQLException error) {
			error.printStackTrace();
		}

		return null;
	}

	@Override
	public int createEmployee(Employee e) {
		String sql = "insert into employee (emp_id, user_name, pass_word, full_name, ismanager) values (?,?,?,?,?)";
		int employeeCreated = 0;

		try (Connection con = ConnectionUtil.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {

			ps.setInt(1, e.getEmployeeID());
			ps.setString(2, e.getUserName());
			ps.setString(3, e.getPassWord());
			ps.setString(4, e.getFullName());
			ps.setBoolean(5, e.getisManager());

			employeeCreated = ps.executeUpdate();

		} catch (SQLException error) {
			error.printStackTrace();
		}
		return employeeCreated;
	}

	public int updateEmployee(Employee e) throws SQLException {
		String sql = "update employee set full_name =?, user_name =?, pass_word =?, isManager =? where emp_id =?";
		int employeeUpdated = 0;

		try (Connection con = ConnectionUtil.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {

			ps.setString(1, e.getFullName());
			ps.setString(2, e.getUserName());
			ps.setString(3, e.getPassWord());
			ps.setBoolean(4, e.getisManager());
			ps.setInt(5, e.getEmployeeID());

			ps.executeUpdate();

		} catch (SQLException error) {
			error.printStackTrace();
		}
		System.out.println(employeeUpdated);
		return employeeUpdated;

	}

	@Override
	public int deleteEmployee(Employee e) {
		String sql = "delete from employee where emp_id = ?";
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
