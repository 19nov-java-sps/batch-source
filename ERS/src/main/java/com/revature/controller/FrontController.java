package com.revature.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.catalina.servlets.DefaultServlet;

public class FrontController extends DefaultServlet {
	private static final long serialVersionUID = 1L;

	private RequestHelper requestHelper = new RequestHelper();

	public FrontController() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path = request.getServletPath();
		if (path.startsWith("/static/")) {
			super.doGet(request, response);
		} else {
			try {
				requestHelper.processGet(request, response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			requestHelper.processPost(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
