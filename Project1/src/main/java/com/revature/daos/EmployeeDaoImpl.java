package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.Department;
import com.revature.models.Employee;
import com.revature.services.DepartmentService;
import com.revature.util.ConnectionUtil;

public class EmployeeDaoImpl implements EmployeeDao {
	
	DepartmentService ds = new DepartmentService();

	@Override
	public List<Employee> getAllEmpl() {
		
		List<Employee> employees = new ArrayList<>();
		String sql = "select * from Employee order by isManager desc";

		try (Connection c = ConnectionUtil.getConnection();
				Statement s = c.createStatement();
				ResultSet rs = s.executeQuery(sql)){
			
			while (rs.next()) {
				int emplId = rs.getInt("emplId");
				String firstName = rs.getString("firstName");
				String lastName = rs.getString("lastName");
				String email = rs.getString("email");
				String phone = rs.getString("phone");
				String password = rs.getString("pass");
				int managerId = rs.getInt("managerId");
				int isManager = rs.getInt("isManager");
				int deptId = rs.getInt("deptId");
				String position = rs.getString("emplPosition");
				
				Department department = ds.getDeptById(deptId);
				
				Employee e = new Employee(emplId, firstName, lastName, email, phone, password, managerId, isManager, department, position);
				employees.add(e);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return employees;
	}

	@Override
	public Employee emplLogin(String email, String password) {
		
		String sql = "select * from Employee where email = ? and pass = ?";
		try(Connection c = ConnectionUtil.getConnection();
        		PreparedStatement ps = c.prepareStatement(sql)) {
        	ps.setString(1, email);
        	ps.setString(2, password);
        	ResultSet rs = ps.executeQuery();
        	
        	if (rs.next()) {
        		int emplId = rs.getInt("emplId");
				String firstName = rs.getString("firstName");
				String lastName = rs.getString("lastName");
				String phone = rs.getString("phone");
				int managerId = rs.getInt("managerId");
				int isManager = rs.getInt("isManager");
				int deptId = rs.getInt("deptId");
				String position = rs.getString("emplPosition");
				
				Department department = ds.getDeptById(deptId);
				
				Employee e = new Employee(emplId, firstName, lastName, email, phone, password, managerId, isManager, department, position);
				return e;
        	}
        	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public Employee getEmplById(int id) {
		String sql = "select * from Employee where emplId = ?";
		
		try(Connection c = ConnectionUtil.getConnection();
        		PreparedStatement ps = c.prepareStatement(sql)) {
        	
        	ps.setInt(1, id);
        	ResultSet rs = ps.executeQuery();
        	
        	if (rs.next()) {
        		int emplId = rs.getInt("emplId");
				String firstName = rs.getString("firstName");
				String lastName = rs.getString("lastName");
				String phone = rs.getString("phone");
				String email = rs.getString("email");
				String password = rs.getString("pass");
				int managerId = rs.getInt("managerId");
				int isManager = rs.getInt("isManager");
				int deptId = rs.getInt("deptId");
				String position = rs.getString("emplPosition");
				
				Department department = ds.getDeptById(deptId);
				
				Employee e = new Employee(emplId, firstName, lastName, email, phone, password, managerId, isManager, department, position);
				return e;
        	}
        	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public int createEmpl(Employee e) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateEmpl(int emplId, String password, String email, String phone) {
		int emplUpdated = 0;
		String sql = "update Employee set pass = ?, email = ?, phone = ? where emplId = ?";
		
		try(Connection c = ConnectionUtil.getConnection();
				PreparedStatement ps = c.prepareStatement(sql)){
			
			ps.setString(1, password);
			ps.setString(2, email);
			ps.setString(4, phone);
			ps.setInt(6, emplId);
			
			emplUpdated = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return emplUpdated;
	}

}
