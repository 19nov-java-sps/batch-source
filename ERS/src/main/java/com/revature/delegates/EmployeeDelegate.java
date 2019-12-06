package com.revature.delegates;

import java.io.Console;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.dao.EmployeeDao;
import com.revature.daoimpl.EmployeeDaoImpl;
import com.revature.models.Employee;

public class EmployeeDelegate {

	private EmployeeDao employeeDao = new EmployeeDaoImpl();

	public void getEmployees(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String path = request.getServletPath();
		System.out.println(path);
		String idStr = request.getParameter("id");
		String boolStr = request.getHeader("Authorization").split(":")[1];
		if (idStr == null) {
			List<Employee> employee = employeeDao.getAllEmployees();
			try (PrintWriter pw = response.getWriter();) {
				pw.write(new ObjectMapper().writeValueAsString(employee));

			}
		} else {
			if (idStr.matches("^\\d+$")) {
				Employee e = employeeDao.getEmployeeById(Integer.parseInt(idStr));
				if (e == null) {
					response.sendError(404, "No user with given ID");
				} else {
					try (PrintWriter pw = response.getWriter()) {
						pw.write(new ObjectMapper().writeValueAsString(e));
					}
				}
			} else {
				response.sendError(400, "Invalid ID param");
			}
		}

	}

	public void updateEmployee(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String fullName = request.getParameter("fullName");
		String userName = request.getParameter("userName");
		String passWord = request.getParameter("passWord");
		String employeeID = request.getParameter("employeeID");
		
		int update;
		update = employeeDao.updateEmployee(fullName, userName, passWord, Integer.parseInt(employeeID));
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	public void updateEmployee(HttpServletRequest request, HttpServletResponse response)
//			throws IOException, SQLException {
//		String path = request.getServletPath();
//		System.out.println(path);
//		String fullname = request.getParameter("fullname");
//		String username = request.getParameter("username");
//		String password = request.getParameter("password");
//		String id = request.getParameter("id");
//		int newId = Integer.parseInt(id);
//
//		Employee e = employeeDao.getEmployeeById(newId);
//
//		if (fullname != "" && fullname != null) {
//			e.setFullName(fullname);
//		} else {
//			e.setFullName(e.getFullName());
//		}
//
//		if (username != "" && username != null) {
//
//			e.setUserName(username);
//
//		} else {
//			e.setUserName(e.getUserName());
//		}
//
//		if (password != "" && password != null) {
//
//			e.setPassWord(password);
//
//		} else {
//			e.setPassWord(e.getPassWord());
//		}
//
//		employeeDao.updateEmployee(e);
//
//	}

//	public void allEmployees(HttpServletRequest request, HttpServletResponse response) throws IOException {
//		List<Employee> employee = employeeDao.getAllEmployees();
//		try (PrintWriter pw = response.getWriter();) {
//			pw.write(new ObjectMapper().writeValueAsString(employee));
//			pw.close();
//		}
//	}

//
//public void getEmployeeById(HttpServletRequest request, HttpServletResponse response) throws IOException {
//	
//	Employee employee = employeeDao.getEmployeeById(1);
//	try (PrintWriter pw = response.getWriter();) {
//		pw.write(new ObjectMapper().writeValueAsString(employee));
//		pw.close();
//	}
//}

}
