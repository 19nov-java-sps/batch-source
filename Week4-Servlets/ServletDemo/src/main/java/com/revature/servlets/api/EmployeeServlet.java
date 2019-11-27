package com.revature.servlets.api;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.Department;
import com.revature.models.Employee;
import com.revature.services.EmployeeService;

/**
 * Servlet implementation class EmployeeServlet
 */
public class EmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private EmployeeService employeeService = new EmployeeService();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
<<<<<<< HEAD
		List<Employee> employees = employeeService.getAll();	
		
		ObjectMapper om = new ObjectMapper();
		String employeeJSON = om.writeValueAsString(employees);
		
		try(PrintWriter pw = response.getWriter()){
			pw.write(employeeJSON);
=======
		ObjectMapper om = new ObjectMapper();
		
		String idStr = request.getParameter("id");
		
		if(idStr!=null) {
			if(idStr.matches("^\\d+$")) {
				int id = Integer.parseInt(idStr);
				Employee e = employeeService.getById(id);
				if(e==null) {
					response.sendError(404);
				} else {
					String employeeJSON = om.writeValueAsString(e);
					try(PrintWriter pw = response.getWriter()){
						pw.write(employeeJSON);
					}
				}
			} else {
				response.sendError(400);
			}
		} else {
			List<Employee> employees = employeeService.getAll();	
			
			String employeesJSON = om.writeValueAsString(employees);
			
			try(PrintWriter pw = response.getWriter()){
				pw.write(employeesJSON);
			}
>>>>>>> Carolyn_Rehm
		}
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String newName = request.getParameter("name");
		String newDeptId = request.getParameter("dept");
//		System.out.println(newName + " in dept "+newDeptId);
		
		Employee e = new Employee();
		e.setName(newName);
	
		Department d = new Department();
<<<<<<< HEAD
		//pls do more input validation than this vvvv
		d.setId(Integer.parseInt(newDeptId));
		e.setDepartment(d);
=======
		
		if(newDeptId!=null && newDeptId.matches("^\\d+$")) {
			d.setId(Integer.parseInt(newDeptId));
			e.setDepartment(d);
		}
>>>>>>> Carolyn_Rehm
		
		employeeService.create(e);
		
//		response.setStatus(201);
		response.sendRedirect("directory");
		
	}

}
