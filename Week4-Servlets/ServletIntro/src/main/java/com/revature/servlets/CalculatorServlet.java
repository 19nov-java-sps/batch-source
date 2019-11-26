package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.services.CalculatorService;

public class CalculatorServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	private CalculatorService calculatorService = new CalculatorService();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
//		response.setContentType("text/html;charset=UTF-8");
//		PrintWriter pw = response.getWriter();
//		pw.write("<h2> My Calculator </h2>");
//		pw.close();	
		
		// forward to calculator html file 
		RequestDispatcher rd = request.getRequestDispatcher("Calculator.html");
		rd.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		/* When we have request parameters with a get request, those parameters will be in the url.
		 * When we have request parameters with other requests, the key value pairs will be found 
		 * 		in the request body.
		 * When we submit form input, we can get the values of these key value pairs using 
		 * 		request.getParameter("key"); (always a string)
		 */
//		System.out.println("Post request made to calculator with the following query: "+request.getReader().readLine());
	
		String operation = request.getParameter("operation");
		String n1 = request.getParameter("n1");
		String n2 = request.getParameter("n2");
		System.out.println(operation+ " on "+ n1 + " and "+ n2);
		

		try {
			int num1 = Integer.parseInt(n1);
			int num2 = Integer.parseInt(n2);
			
			int result = calculatorService.calculate(num1, num2, operation);
			
			response.getWriter().write("<p>Here is some text from my calculator servlet</p>");
		
			request.setAttribute("answerAttribute", result);
			request.getRequestDispatcher("answer").include(request, response);
//			response.sendRedirect("answer");
			
			
		} catch (NumberFormatException e) {
			response.sendError(400);
		}
		
		
	}
}
