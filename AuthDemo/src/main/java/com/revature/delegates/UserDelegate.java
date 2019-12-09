package com.revature.delegates;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.daos.PendingDao;
import com.revature.daos.PendingDaoImpl;
import com.revature.daos.ResolvedDao;
import com.revature.daos.ResolvedDaoImpl;
import com.revature.daos.UserDao;
import com.revature.daos.UserDaoImpl;
import com.revature.models.User;
import javax.servlet.ServletException;

public class UserDelegate {
	public void getUserInfo(User currentUser, HttpServletRequest request, HttpServletResponse response) throws IOException{
		try(PrintWriter pw = response.getWriter()){
			pw.write(new ObjectMapper().writeValueAsString(currentUser));
		}
	}
	public void getAllUsers(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		UserDao userDao = UserDaoImpl.getInstance();
		try(PrintWriter pw = response.getWriter();){
			pw.write(new ObjectMapper().writeValueAsString(userDao.getAll()));
		}
	}
	public void getAllPending(User currentUser, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		PendingDao pendingDao = PendingDaoImpl.getInstance();
		try(PrintWriter pw = response.getWriter();){
			if(currentUser.getUserRole().equals( "manager" ) ) {
				pw.write(new ObjectMapper().writeValueAsString(pendingDao.getAll()));
			} else {
				pw.write(new ObjectMapper().writeValueAsString(pendingDao.getAll(currentUser.getUsername())));
			}
		}
	}
	public void getAllResolved(User currentUser, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		ResolvedDao resolvedDao = ResolvedDaoImpl.getInstance();
		try(PrintWriter pw = response.getWriter();){
			if(currentUser.getUserRole().equals( "manager" ) ) {
				pw.write(new ObjectMapper().writeValueAsString(resolvedDao.getAll()));
			} else {
				pw.write(new ObjectMapper().writeValueAsString(resolvedDao.getAll(currentUser.getUsername())));
			}
		}
	}
	public void addReimbursment( User currentUser, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String reason = request.getParameter("reason");
		int amount = Integer.parseInt( request.getParameter("amount") );
		PendingDaoImpl.getInstance().createPending( currentUser.getUsername(), reason, amount);
		response.sendRedirect( "/AuthDemo/home");
		// request.getRequestDispatcher("/static/Home.html").forward(request, response);
	}
	public void changeInfo( User currentUser, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String password = request.getParameter("newpassword");
		UserDaoImpl.getInstance().updateUser(currentUser.getUsername(), currentUser.getUserRole(), password, currentUser.getId() );
		response.sendRedirect( "/AuthDemo/home");
		// .re getRequestDispatcher("/static/Home.html").forward(request, response);
	}
	public void approveReimbursment( User currentUser, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		if(currentUser.getUserRole().equals( "manager" ) ) {
			int reimbursentId = Integer.parseInt( request.getParameter("id") );
			ResolvedDaoImpl.getInstance().createResolvedDeletePending( reimbursentId, "Approved", currentUser.getUsername()  );
		}
	}
	public void denyReimbursment( User currentUser, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		if(currentUser.getUserRole().equals( "manager" ) ) {
			int reimbursentId = Integer.parseInt( request.getParameter("id") );
			ResolvedDaoImpl.getInstance().createResolvedDeletePending( reimbursentId, "Denied", currentUser.getUsername() );
		}
	}
}
