package com.revature.delegates;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.Manager;
import com.revature.services.ManagerService;

public class ManagerDelegate {

	private ManagerService ms = new ManagerService();
	
	public void getManagers(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		String username = request.getParameter("username");
		
		if (username == null) {
			List<Manager> managers = ms.getManagers();
			
			try(PrintWriter pw = response.getWriter()) {
				pw.write(new ObjectMapper().writeValueAsString(managers));
			}
		} else {
			Manager m = ms.getManagerByUsername(username);
			
			if (m == null) {
				response.sendError(404);
			} else {
				try(PrintWriter pw = response.getWriter()) {
					pw.write(new ObjectMapper().writeValueAsString(m));
				}
			}
		}

	}
}

