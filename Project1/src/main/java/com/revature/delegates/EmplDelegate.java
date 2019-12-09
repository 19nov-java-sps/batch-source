package com.revature.delegates;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.dao.EmployeeDao;
import com.revature.daoimpl.EmployeeDaoImpl;
import com.revature.model.Employee;

public class EmplDelegate {
	
	
	private EmployeeDao emplDao = new EmployeeDaoImpl();
	
	public void getEmpl(HttpServletRequest request, HttpServletResponse response) throws IOException {
		System.out.println("I am in EmplDeligate getEmpl method");
		String idStr = request.getParameter("id");
		System.out.println("idStr from UserDeligate = " + idStr);
		if(idStr == null) {
			System.out.println ("idStr from emplDeligate = 0");
			List<Employee> employees = emplDao.getAllEmployee();
			try(PrintWriter pw = response.getWriter();){
				System.out.println ("I use PrintWriter in try from emplDeligate if idStr=0");
				pw.write(new ObjectMapper().writeValueAsString(employees));
			}
		}else {
			if(idStr.matches("^\\d+$")) {
				System.out.println("I am in emplDeligate if idStr.mathces..\"^\\\\d+$\"");
				System.out.println("idStr from emplDeligate = " + idStr);
				Employee e = emplDao.getEmployeeById(Integer.parseInt(idStr));
				if(e==null) {
					response.sendError(404, "No employee with given ID");
				}else {
					try(PrintWriter pw = response.getWriter()){
						System.out.println ("I use PrintWriter in try from emplDeligate if idStr!=0");
						pw.write(new ObjectMapper().writeValueAsString(e));
					}
				}
			}else {
				response.sendError(400, "Invalid ID param");
			}
		}
	}

	public void getAllEmpl(HttpServletRequest request, HttpServletResponse response) throws JsonProcessingException {
		List<Employee> employees = emplDao.getAllEmployee();
		ObjectMapper om = new ObjectMapper();
		String employeesJSON = om.writeValueAsString(employees);
		System.out.println ("All employees " + employees);
		System.out.println ("All employees " + employeesJSON);
		try(PrintWriter pw = response.getWriter();){
			pw.write(employeesJSON);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
