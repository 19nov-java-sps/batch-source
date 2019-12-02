package com.revature.dao.impl;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.dao.EmployeeDao;
import com.revature.util.ConnectionUtil;
import com.revauture.model.Employee;

public class EmployeeDaoImpl implements EmployeeDao{
//	
//	public List<Employee> dummyList = new ArrayList<>();
//	
//	public EmployeeDaoImpl() {
//		dummyList.add(new Employee(1, "p3t3rpark3r", "12345", "Peter Nguyen", true));
//		dummyList.add(new Employee(2, "ryan", "12345", "Ryan Cars", false));
//	}
//	
//	@Override
//	public List<Employee> dummyEmployeesList() {
//		return new ArrayList<>(dummyList);
//	}
//
//	@Override
//	public Employee dummyEmployee(int id) {
//		for(Employee employee : dummyList) {
//			if (employee.getUserId() == id) {
//				return employee;
//			}
//		}
//		return null;
//	}

	

	@Override
	public List<Employee> getEmployees() {
		String sqlString =  "select * from Employee";
		List<Employee> emp = new ArrayList<>();
		
		try (Connection connection = ConnectionUtil.getConnection();
				Statement statement = connection.createStatement();
				ResultSet  rSet = statement.executeQuery(sqlString)) {
			
			while(rSet.next()) {
				int userId = rSet.getInt("user_id");
				String username = rSet.getString("username");
				String password = rSet.getString("passwordString");
				String fullname = rSet.getString("full_name");
				Boolean isManager = rSet.getBoolean("isManager");
				Employee employee = new Employee(userId, username, password, fullname, isManager);
				emp.add(employee);
			}
			
		} catch (SQLException error) {
			error.printStackTrace();
		}
		
		return emp;
	}

	@Override
	public Employee getEmployeeById(int id) {
		String sqlString =  "select * from Employee where Employee.user_id = ?";
		Employee employee = null;
		
		
		try (Connection connection = ConnectionUtil.getConnection();
				PreparedStatement pStatement = connection.prepareStatement(sqlString)){
			
			pStatement.setInt(1, id);
			ResultSet rSet = pStatement.executeQuery();
			
			while  (rSet.next()) {
				int userId = rSet.getInt("user_id");
				String username = rSet.getString("username");
				String password = rSet.getString("passwordString");
				String fullname = rSet.getString("full_name");
				Boolean isManager = rSet.getBoolean("isManager");
				employee = new Employee(userId, username, password, fullname, isManager);	
			}
		} catch (SQLException error) {
			error.printStackTrace();
		}
		return employee;
	}

	@Override
	public int createEmployee(Employee e) {
		String sqString = "insert into Employee (username, passwordString, full_name, isManager) values (?,?,?,?)";
		int success = 0;
		
		try (Connection connection = ConnectionUtil.getConnection();
				PreparedStatement pStatement = connection.prepareStatement(sqString)){
			pStatement.setString(1, e.getUsername());
			pStatement.setString(2, e.getPassword());
			pStatement.setString(3, e.getFullname());
			pStatement.setBoolean(4, e.isManager());
			success = pStatement.executeUpdate();
		
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return success;
	}

	@Override
	public int updateEmployee(Employee e) {
		String sqlString = "update * from Employee set user_id = ?, username = ?, passwordString = ?, full_name = ?, isManager = ? where Employee.user_id =  ?";
		int updatedemployee = 0;
		
		try (Connection connection = ConnectionUtil.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(sqlString)){
			preparedStatement.setInt(1, e.getUserId());
			preparedStatement.setString(2, e.getUsername());
			preparedStatement.setString(3, e.getPassword());
			preparedStatement.setString(4, e.getFullname());
			preparedStatement.setBoolean(5, e.isManager());
			updatedemployee = preparedStatement.executeUpdate();
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return updatedemployee;
	}

	@Override
	public int deleteEmployee(Employee e) {
		String sqString = "delete from Employee where Employee.user_id = ?";
		int deletedEmployee = 0;
		
		try (Connection connection = ConnectionUtil.getConnection();
				PreparedStatement pStatement =  connection.prepareStatement(sqString)){
			pStatement.setInt(1, e.getUserId());
			deletedEmployee =  pStatement.executeUpdate();
		} catch (SQLException error) {
			error.printStackTrace();
		}
		return deletedEmployee;
	}


	@Override
	public Employee getUserByUsernameAndPassword(String username, String password) {
		String sqlString =  "select * from Employee where Employee.username = ? AND Employee.passwordString = ?";
		Employee employeeFound = null;
		
		try (Connection connection = ConnectionUtil.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(sqlString)){
			preparedStatement.setString(1, username);
			preparedStatement.setString(2, password);
			ResultSet rSet = preparedStatement.executeQuery();
			
			while (rSet.next()) {
				int userId = rSet.getInt("user_id");
				String userName = rSet.getString("username");
				String passWord = rSet.getString("passwordString");
				String fullname = rSet.getString("full_name");
				Boolean isManager = rSet.getBoolean("isManager");
				employeeFound = new Employee(userId, userName, passWord, fullname, isManager);	
				System.out.println(employeeFound.toString());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return employeeFound;
	} 

}
