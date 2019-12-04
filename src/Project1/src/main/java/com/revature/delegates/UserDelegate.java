package com.revature.delegates;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.daos.UserAccDao;

import com.revature.daos.impls.UserAccDaoImpl;

import com.revature.models.UserAcc;

public class UserDelegate {
	
	private UserAccDao uad = new UserAccDaoImpl();
	
	public void getUsers(HttpServletRequest request, HttpServletResponse response) throws IOException{
		String idStr = request.getParameter("id");
		if(idStr == null) {
			List<UserAcc> users = uad.getAll();
			try(PrintWriter pw = response.getWriter();){
				pw.write(new ObjectMapper().writeValueAsString(users));
			}	
		} else {
			if(idStr.matches("^\\d+$")) {
				UserAcc ua = uad.getUserById(Integer.parseInt(idStr));
				if(ua==null) {
					response.sendError(404, "No user with given ID");
				} else {
					try(PrintWriter pw = response.getWriter()){
						pw.write(new ObjectMapper().writeValueAsString(ua));
					}
				}
			} else {
				response.sendError(400, "Invalid ID param");
			}
		}
	}

}
