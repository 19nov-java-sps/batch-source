package com.revature.delegates;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.daos.UserProfileDao;
import com.revature.daos.impls.UserProfileDaoImpl;
import com.revature.models.UserProfile;

public class ProfileDelegate {

	UserProfileDao upd = new UserProfileDaoImpl();
	
	public void getProfile(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String profileID = request.getParameter("USERID");
		int newProfileID = 0;
		newProfileID = Integer.parseInt(profileID);
		List<UserProfile> myUserProfile = upd.getOne(newProfileID);
		ObjectMapper om = new ObjectMapper();
		String profileJSON = om.writeValueAsString(myUserProfile);
		try (PrintWriter pw = response.getWriter()){
			pw.write(profileJSON);
		}

	}
	
	public void updateProfile(HttpServletRequest request, HttpServletResponse response) {
		String userID = request.getParameter("USERID");
		String address = request.getParameter("ADDRESS");
		String phonenumber = request.getParameter("PHONENUMBER");
		
		int newUserID = Integer.parseInt(userID);
		int newPhoneNumber = Integer.parseInt(phonenumber);
		
		upd.updateProfile(address, newPhoneNumber, newUserID);
		
	}
}
