package com.revature;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.daoimpl.EmployeeDaoImpl;
import com.revature.daoimpl.ReimbursementDaoImpl;
import com.revature.models.Employee;

/**
 * Servlet implementation class TestServlet
 */
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		ObjectMapper om = new ObjectMapper();
//		Employee e = new Employee();
//		response.getWriter().append(om.writeValueAsString(e));
		ObjectMapper om = new ObjectMapper();
		EmployeeDaoImpl edi = new EmployeeDaoImpl();
//		ReimbursementDaoImpl rdi = new ReimbursementDaoImpl();
		response.getWriter().append(om.writeValueAsString(edi));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
