package com.revature.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.dao.EmployeeDao;
import com.revature.util.ConnectionUtil;
import com.revauture.model.Employee;

public class EmployeeDaoImpl implements EmployeeDao{

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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int createEmployee(Employee e) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateEmployee(Employee e) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteEmployee(Employee e) {
		// TODO Auto-generated method stub
		return 0;
	}

}
