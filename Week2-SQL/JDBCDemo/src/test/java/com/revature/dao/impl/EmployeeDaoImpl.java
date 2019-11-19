package com.revature.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.dao.EmployeeDao;
import com.revature.model.Department;
import com.revature.model.Employee;
import com.revature.util.ConnectionUtil;

public class EmployeeDaoImpl implements EmployeeDao {

	@Override
	public List<Employee> getEmployees() {
		List<Employee> employees = new ArrayList<>();
		
		String sql = "select * from {oj employee left outer join department on (employee.dept_id=department.dept_id)} ";
		
		try(Connection c = ConnectionUtil.getConnection();
				PreparedStatement ps = c.prepareStatement(sql);
				ResultSet rs = ps.executeQuery()){
			
//			for(int i=0; i<rs.getMetaData().getColumnCount(); i++) {
//				System.out.println(rs.getMetaData().getColumnName(i+1));
//			}
			
			while(rs.next()) {
				Employee e = new Employee();
				e.setId(rs.getInt("empl_id"));
				e.setName(rs.getString("empl_name"));
				e.setMonthlySalary(rs.getDouble("monthly_salary"));
				e.setPosition(rs.getString("empl_position"));
				e.setManagerId(rs.getInt("manager_id"));
				
				int deptId = rs.getInt("dept_id");
				if(deptId!=0) {
					Department d = new Department(deptId);
					d.setName(rs.getString("dept_name"));
					d.setmonthlyBudget(rs.getDouble("monthly_budget"));
					e.setDepartment(d);
				}
				employees.add(e);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return employees;
	}

	@Override
	public Employee getEmployeeById(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public int updateEmployee(Employee e) {
		return 0;
	}

}