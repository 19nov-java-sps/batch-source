package com.revature.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.dao.EmployeeDao;
import com.revature.model.Employee;
import com.revature.util.ConnectionUtil;

public class EmployeeDaoImpl implements EmployeeDao {

	@Override
	public List<Employee> getAllEmployee() {
		String sql = "select * from p1employees pe\r\n" + 
				"join p1reimb re\r\n" + 
				"on pe.id = re.id";
		List<Employee>	employees = new ArrayList<>();
		
		try (Connection c = ConnectionUtil.getConnection();
				Statement s = c.createStatement();
				ResultSet rs = s.executeQuery(sql)){
			
			while(rs.next())	{
				int emplId = rs.getInt("id");
				String fName = rs.getString("first_name");
				String lName = rs.getString(3);
				String dept = rs.getString(4);
				int respTo = rs.getInt(5);
				String strNumber = rs.getString(6);
				String strName = rs.getString(7);
				String city = rs.getString(8);
				String state = rs.getString(9);
				String zip = rs.getString(10);
				String phone = rs.getString(11);
				String email = rs.getString(12);
				String userName = rs.getString(13);
				String userPass = rs.getString(14);
				int rId = rs.getInt(15);
				String descr = rs.getString(16);
				double sum = rs.getDouble(17);
				String date = rs.getString(18);
				String status = rs.getString(19);
				
				Employee e = new Employee(emplId, fName, lName, dept, respTo, strNumber, 
						strName, city, state,zip, phone, email, userName, userPass,
						rId, descr, sum, date, status);
					
				employees.add(e);
				
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		return employees;
	}
	


	@Override
	public Employee getEmployeeById(int id) {
		String sql = "select * from p1employees pe join p1reimb pr on pe.id = pr.id where pe.id = ?";
		Employee e = null;
		
		try(Connection c = ConnectionUtil.getConnection();
				PreparedStatement ps = c.prepareStatement(sql)){
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
			
			while(rs.next())	{
				int emplId = rs.getInt(1);
				String fName = rs.getString(2);
				String lName = rs.getString(3);
				String dept = rs.getString(4);
				int respTo = rs.getInt(5);
				String strNumber = rs.getString(6);
				String strName = rs.getString(7);
				String city = rs.getString(8);
				String state = rs.getString(9);
				String zip = rs.getString(10);
				String phone = rs.getString(11);
				String email = rs.getString(12);
				String empName = rs.getString(13);
				String empPass = rs.getString(14);
				int rId = rs.getInt(15);
				String descr = rs.getString(16);
				double sum = rs.getDouble(17);
				String date = rs.getString(18);
				String status = rs.getString(19);
				
				e = new Employee(emplId, fName, lName, dept, respTo, strNumber, 
						strName, city, state,zip, phone, email, empName, empPass,
						rId, descr, sum, date, status);
			}
				
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return e;
	}

	@Override
	public int createNewEmployee(Employee e) {
		
		String sql = "insert into p1employees (id, first_name, "
				+ "last_name, dept, responce_to, street_number, street_name, city, "
				+ "state, zip, phone, email, user_name, pass_word)"
				+ "values (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		int empCreated = 0;
		
		try(Connection c = ConnectionUtil.getConnection();
				PreparedStatement ps = c.prepareStatement(sql)){
			ps.setInt(1, e.getEmplId());
			ps.setString(2, e.getFirstName());
			ps.setString(3, e.getLastName());
			ps.setString(4, e.getDepart());
			ps.setInt(5, e.getReportTo());
			ps.setString(6, e.getStrNum());
			ps.setString(7, e.getStreet());
			ps.setString(8, e.getCity());
			ps.setString(9, e.getState());
			ps.setString(10, e.getZip());
			ps.setString(11, e.getPhone());
			ps.setString(12, e.getEmail());
			ps.setString(13, e.getUserName());
			ps.setString(14, e.getPassWord());
			
			empCreated = ps.executeUpdate();
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return empCreated;
	}



	@Override
	public int deleteEmployee(Employee e) {
		String sql = "delete from p1employees where id = ?";
		int rowsDeleted = 0;
		
		try(Connection c = ConnectionUtil.getConnection();
				PreparedStatement ps = c.prepareStatement(sql)){
			ps.setInt(1, e.getEmplId());
			rowsDeleted = ps.executeUpdate();
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		return rowsDeleted;
	}



	@Override
	public int updateEmployee(Employee e) {
		int employeesUpdate = 0;
		String sql = "update p1employees set id = ?, first_name = ?" + 
				"last_name = ?, dept = ?, responce_to = ?, street_number = ?"+
				"street_name = ?, city = ?, state = ?, zip = ?, phone = ?," +
				"email = ?, user_name = ?, pass_word = ?";
		
		try(Connection c = ConnectionUtil.getConnection();
				PreparedStatement ps = c.prepareStatement(sql)){
			ps.setInt(1, e.getEmplId());
			ps.setString(2, e.getFirstName());
			ps.setString(3, e.getLastName());
			ps.setString(4, e.getDepart());
			ps.setInt(5, e.getReportTo());
			ps.setString(6, e.getStrNum());
			ps.setString(7, e.getStreet());
			ps.setString(8, e.getCity());
			ps.setString(9, e.getState());
			ps.setString(10, e.getZip());
			ps.setString(11, e.getPhone());
			ps.setString(12, e.getEmail());
			ps.setString(13, e.getUserName());
			ps.setString(14, e.getPassWord());
			
			employeesUpdate = ps.executeUpdate();
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return employeesUpdate;
	}



	@Override
	public Employee getEmployeeByUserNameAndPassWord(String username, String password) {
		EmployeeDao ed = new EmployeeDaoImpl();
		List<Employee> empl = ed.getAllEmployee();
	
		 for(Employee e: empl){
			 if(e.getPassWord()!= null && e.getUserName().equals(username)) {
				 if(e.getPassWord() !=null && e.getPassWord().equals(password)) {
					 return e;
				 }
			 }
		 };
		

		return null;
	}


}
