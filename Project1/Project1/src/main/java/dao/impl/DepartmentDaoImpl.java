package dao.impl;

import java.util.List;

import dao.DepartmentDao;
import models.Department;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dao.DepartmentDao;
import models.Department;
import util.ConnectionUtil;

public class DepartmentDaoImpl implements DepartmentDao{

	@Override
	public List<Department> getAllDept() {
		
		List<Department> departments = new ArrayList<>();
		String sql = "select * from Department";
		
		try (Connection c = ConnectionUtil.getConnection();
				Statement s = c.createStatement();
				ResultSet rs = s.executeQuery(sql)){
			
			while (rs.next()) {
				int deptId = rs.getInt("deptId");
				String deptName = rs.getString("deptName");
				
				Department d = new Department(deptId, deptName);
				departments.add(d);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return departments;
	}

	@Override
	public Department getDeptById(int id) {
		
		String sql = "select * from Department where deptId = ?";
		
		try(Connection c = ConnectionUtil.getConnection();
        		PreparedStatement ps = c.prepareStatement(sql)) {
        	
        	ps.setInt(1, id);
        	ResultSet rs = ps.executeQuery();
        	
        	if (rs.next()) {
        		int deptId = rs.getInt("deptId");
				String deptName = rs.getString("deptName");
				
				Department d = new Department(deptId, deptName);
				return d;
        	}
        	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

}
