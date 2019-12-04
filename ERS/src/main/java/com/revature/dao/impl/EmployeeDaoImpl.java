package com.revature.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import com.revature.models.Employee;
import com.revature.services.EmployeeService;
import com.revature.util.ConnectionUtil;

import com.revature.daos.EmployeeDao;
import com.revature.models.Employee;

import com.revature.services.EmployeeService;
import com.revature.util.ConnectionUtil;

public class EmployeeDaoImpl implements EmployeeDao {
	

	public List<Employee> getEmployees() {
		String sql = "select * from employees";
		List<Employee>employees= new ArrayList<>();
		
		try (Connection c = ConnectionUtil.getConnection();
				Statement s = c.createStatement();
				ResultSet rs = s.executeQuery(sql)) {
			
			while(rs.next()) {
				int userId = rs.getInt("employeeid");
				String firstName = rs.getString("firstname");
				String lastName = rs.getString("lastname");
				String email= rs.getString("emailaddress");
				String password=rs.getString("pass");
				String employeeType=rs.getString("employeetype");
				Employee d= new Employee(userId,firstName,lastName,email,password, employeeType);
				employees.add(d);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return employees;
	}

	@Override
	public Employee getEmployeeById(int id) {
		
		String sql = "Select * from Employees where EmployeeId=?";
		List<Employee>employees= new ArrayList<>();
		try (Connection c = ConnectionUtil.getConnection();
				PreparedStatement ps = c.prepareStatement(sql)) {
		
			ps.setInt(1, id);

		
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				int userId = rs.getInt("EmployeeId");
				String firstName = rs.getString("firstName");
				String lastName = rs.getString("lastName");
				String email= rs.getString("emailAddress");
				String password=rs.getString("pass");
				String employeeType=rs.getString("EmployeeType");
				Employee d= new Employee(userId,firstName,lastName,email,password, employeeType);
				employees.add(d);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return employees.get(0);
	}
	
		
		
		
			
			
			
			
	@Override
	public boolean createEmployee(Employee e) throws SQLException {
		String sql = "insert into employees (employeeid,firstname,lastname,emailaddress,pass,employeetype) VALUES (? ,? ,?,?,?,?)";
		int count=0;
		try (Connection c = ConnectionUtil.getConnection();
				PreparedStatement ps = c.prepareStatement(sql)) {
			
			ps.setInt(1,  e.getId());
			ps.setString(2,  e.getFirstName());
			ps.setString(3, e.getLastName());
			ps.setString(4, e.getEmailAddress());
			ps.setString(5, e.getPassword());
			ps.setString(6, e.getEmployeeType());
			
			count=ps.executeUpdate();
		
		}
		
	
		return true;


	}

	
	
/*
	@Override/*
	public boolean updateEmployee(Employee e) {
		String sql = "insert into Employees (balance,userid,typeofacct,pin) VALUES (? ,? ,?,?)";
		int count=0;
		try (Connection c = ConnectionUtil.getConnection();
				PreparedStatement ps = c.prepareStatement(sql)) {
			
			ps.setDouble(1,  acct.getBalance());
			ps.setInt(2,  acct.getUserId());
			ps.setString(3, acct.getAccountType());
			ps.setInt(4, acct.getAccountpin());
			count=ps.executeUpdate();
		
		}
		
	
		return "You have successfully created a" + " " +  acct.getAccountType() + " " + "account";


	}

	
		
	}
*/
	@Override
	public int deleteEmployee(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Employee Login(String email, String password) throws SQLException {
		String sql = "Select * from employees where emailaddress=?";
		List<Employee>employees= new ArrayList<>();
		try (Connection c = ConnectionUtil.getConnection();
				PreparedStatement ps = c.prepareStatement(sql)) {
		
			ps.setString(1, email);

		
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				int userId = rs.getInt("EmployeeId");
				String firstName = rs.getString("firstName");
				String lastName = rs.getString("lastName");
				String email1= rs.getString("emailAddress");
				String password1=rs.getString("pass");
				String employeeType1=rs.getString("EmployeeType");
				Employee d= new Employee(userId,firstName,lastName,email1,password1, employeeType1);
				employees.add(d);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return employees.get(0);
	}

	@Override
	public void updateEmployee(Employee e) throws SQLException {
		String sql = "update employees set firstname =?, lastname=?, emailaddress=?, pass=? where employeeid=?";
		
		try (Connection c = ConnectionUtil.getConnection();
				PreparedStatement ps = c.prepareStatement(sql)) {
			
			ps.setString(1,  e.getFirstName());
			ps.setString(2,  e.getLastName());
			ps.setString(3, e.getEmailAddress());
			ps.setString(4, e.getPassword());
			ps.setInt(5, e.getId());
			
			ps.executeUpdate();
		
		}
		
	
		


	}
		
		
		
		
		
		
		
		
		
		
	}
	
	






