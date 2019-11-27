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
import com.revature.services.DepartmentService;

/**
 * Servlet implementation class DepartmentServlet
 */
public class DepartmentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private DepartmentService departmentService = new DepartmentService();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DepartmentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Department> departmentList = departmentService.getAll();
		ObjectMapper om = new ObjectMapper();
		String deptJSON = om.writeValueAsString(departmentList);
		try(PrintWriter pw = response.getWriter()){
			pw.write(deptJSON);
		}
		
		
	}

}
