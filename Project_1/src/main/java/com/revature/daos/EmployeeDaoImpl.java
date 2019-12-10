package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.Employee;
import com.revature.util.ConnectionUtil;

public class EmployeeDaoImpl implements EmployeeDao {

	@Override
	public List<Employee> getEmployees() {
		
		String sql = "select * from emp_table";
		List<Employee> employees = new ArrayList<>();
		
		try(Connection c = ConnectionUtil.getConnection();
						Statement s = c.createStatement();
						ResultSet rs = s.executeQuery(sql)) {

			while(rs.next()) {
				
				Employee e = new Employee();
				e.setfName(rs.getString("first_name"));
				e.setlName(rs.getString("last_name"));
				e.setUsername(rs.getString("user_name"));
				e.setPassword(rs.getString("pass_word"));
				e.setEmp_id(rs.getInt("emp_id"));
				
				employees.add(e);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return employees;
	}

	@Override
	public Employee getEmployeeByUsername(String username) {
		
		String sql = "select * from emp_table where user_name = ?";
		Employee em = new Employee();
		
		try(Connection c = ConnectionUtil.getConnection();
					PreparedStatement ps = c.prepareStatement(sql)) {
			
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				em.setfName(rs.getString("first_name"));
				em.setlName(rs.getString("last_name"));
				em.setUsername(rs.getString("user_name"));
				em.setPassword(rs.getString("pass_word"));
				em.setEmp_id(rs.getInt("emp_id"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return em;
	}

	@Override
	public int updateEmployee(String fName, String lName, int emp_id) {
		
		String sql = "update emp_table set first_name = ?, last_name = ? where emp_id = ?";
		int employeeUpdated = 0;
		
		try(Connection c = ConnectionUtil.getConnection();
					PreparedStatement ps = c.prepareStatement(sql)) {
			
			ps.setString(1, fName);
			ps.setString(2, lName);
			ps.setInt(3, emp_id);
			employeeUpdated = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return employeeUpdated;
	}
	
}
