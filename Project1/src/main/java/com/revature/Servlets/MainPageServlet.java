//package com.revature.Servlets;
//
//import java.io.IOException;
//import java.io.PrintWriter;
//
//import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletConfig;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//public class MainPageServlet extends HttpServlet {
//
//	/**
//	 * 
//	 */
//	private static final long serialVersionUID = 1L;
//	
//	public void init(ServletConfig config) {
//		System.out.println("init was called");
//	}
//	
//	protected void service(HttpServletRequest req, HttpServletResponse res) throws 
//	IOException,ServletException {
//		System.out.println("service request was called "+ req.getMethod()+ " to "+ 
//				req.getRequestURI());
//		if("DELETE".equals(req.getMethod())) {
//			res.setStatus(405);
//		} else if ("POST".equals(req.getMethod())) {
//			res.setStatus(201);
//		} else {
//			//says u want html element
//			res.setContentType("text/html;charset=UTF-8");
//			
//			//forward to html file
//			RequestDispatcher rd=  req.getRequestDispatcher("Views/MainPage.html");
//			rd.forward(req, res);
//			
//			
////			pw.close();
//		}
//		String button1 = req.getParameter("act");
//		String button2=req.getParameter("gridRadios");
//		if(button1.equals("Signin") && (button2.equals("option1"))){
//			RequestDispatcher xd=  req.getRequestDispatcher("Views/EmpLog.html");
//			xd.forward(req, res);
//		} else {
//			return;
//		}
//		
//	}
//		protected void doPost(HttpServletRequest req, HttpServletResponse res) throws 
//		IOException,ServletException {
//			System.out.println("ppp");
//		}
//		
//		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//			
//			request.getRequestDispatcher("Views/MainPage.html");
//		}
//		
//		
//		
//		
//	
//	
//	public void destroy() {
//		System.out.println("destroy was called");
//	}
//
//}
