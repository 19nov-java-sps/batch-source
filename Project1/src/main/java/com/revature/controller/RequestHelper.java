package com.revature.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.delegates.AuthDelegate;
import com.revature.delegates.EmplDelegate;
import com.revature.delegates.ReimbDeligate;
import com.revature.delegates.ViewDelegate;

public class RequestHelper {


		private ViewDelegate viewDelegate = new ViewDelegate();
		private AuthDelegate authDelegate = new AuthDelegate();
		private EmplDelegate emplDelegate = new EmplDelegate();
		private ReimbDeligate reimbDelegate = new ReimbDeligate();
		
		
		public void processGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		System.out.println("I am in RequestHelper processGet method");
			String path = request.getServletPath();
			System.out.println("The path is " + path);
			if(path.startsWith("/api/")) {
				System.out.println("I am in RequestHelper processGet method in if /api/ part");
				
				if(!authDelegate.isAuthorized(request)) {
					System.out.println("I am in RequestHelper NOT isAuthorized");
					response.sendError(401);
					return;
				}
				System.out.println("I am in RequestHelper /api/ isAuthorized");
				System.out.println("The path us " + path);
				String record = path.substring(5);
				System.out.println("The recorf is " + record);
				switch(record) {
				case "empl":
		//			SSystem.out.println(" I am in RequestHelper isAuthorized /users");
					emplDelegate.getEmpl(request, response);
					break;
				case "empls":
					emplDelegate.getAllEmpl(request, response);  
					break;

				default:
					System.out.println("RequestHelper /api/ default");
					response.sendError(404, "Request Record(s) Not Found");
				}
			}else {
				System.out.println("I am going to ViewDeligate.returnView method");
				viewDelegate.returnView(request, response);
				
			}
		}

		public void processPost (HttpServletRequest request, HttpServletResponse response) throws IOException {
			System.out.println("I am in RequestHelper processPost method");
			String path = request.getServletPath();
			System.out.println("The path us " + path);
			switch(path) {
			case "/login":
				System.out.println("I am in RequestHelper /login/ processPost");
				authDelegate.authenticate(request, response);
				break;
			case "/reimb":
				reimbDelegate.createReimbursement(request, response);
				break;
			default:
		//		System.out.println("RequestHelper peocessPost /405");
				response.sendError(405);
			}

		}

}
