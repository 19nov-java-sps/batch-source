package com.revature.dao;


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
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.query.Query;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;


import com.revature.util.HibernateUtil;

import com.revature.model.Employees;





public class EmployeeDaoImpl implements EmployeeDao {
	private static Logger log = Logger.getRootLogger();
	
	public List<Employees> getEmployees() {
		List<Employees> employee = null;
		try(Session s = HibernateUtil.getSession()){
			CriteriaBuilder cb = s.getCriteriaBuilder();
			CriteriaQuery<Employees> cq = cb.createQuery(Employees.class);
			
			cq.select(cq.from(Employees.class));
			
			Query<Employees> query = s.createQuery(cq);
			employee = query.list();
			log.info("Getting all Employees");
		}
		return employee;
	}
	
	public Employees getEmployeeById(int id) {
		
		try(Session s= HibernateUtil.getSession()){
			Query q=s.createQuery("from Employees where id=id");
			List<Employees> employee =q.list();
			return employee.get(0);
		}
	
	}


		
		
		
			/*
			
			
			
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

	@Override
	public com.revature.model.Employee getEmployeeById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean createEmployee(com.revature.model.Employee e) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public com.revature.model.Employee Login(String email, String password) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateEmployee(com.revature.model.Employee e) throws SQLException {
		// TODO Auto-generated method stub
		
	}
		
		
		
		*/

/*

	@Override
	public boolean createEmployee(Employees e) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int deleteEmployee(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Employees Login(String email, String password) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateEmployee(Employees e) throws SQLException {
		// TODO Auto-generated method stub
		
	}
		
		
		
	*/	
		
		
	}
	
	






