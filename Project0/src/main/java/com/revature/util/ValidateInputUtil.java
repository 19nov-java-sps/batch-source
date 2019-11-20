package com.revature.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ValidateInputUtil {

	public static boolean validateInput(String userName, String password, String rePass, String firstName, String lastName, String email, String phone) {
		
		boolean validateSuccess = true;
		
		if (userName.length() < 5 || userName.length() > 12) {
			System.out.println("Username Must Be 5-12 Characters long");
			validateSuccess = false;
		}
		if (userName.matches("^[a-zA-z0-9]+$") == false) {
			System.out.println("Username Cannot Contains Special Character");
			validateSuccess = false;
		}
		
		if (password.length() < 8 || password.length() > 16) {
			System.out.println("Password Must Be 8-16 Characters Longs");
			validateSuccess = false;
		}
		if (password.equals(rePass) == false) {
			System.out.println("Passwords You Enter Are Different");
			validateSuccess = false;
		}
		
		if (firstName.length() < 1 || firstName.length() > 30) {
			System.out.println("Please Enter Your First Name");
			validateSuccess = false;
		}
		if (lastName.length() < 1 || lastName.length() > 30) {
			System.out.println("Please Enter Your Last Name");
			validateSuccess = false;
		}
		
		if (email.matches("^(.+)@(.+)$") == false) {
			System.out.println("Invalid Email");
			validateSuccess = false;
		}
		
		if (phone.length() != 10) {
			System.out.println("Invalid Phone Number");
			validateSuccess = false;
		}
		
		return validateSuccess;
	}
	
	public static boolean validateInput(String password, String rePass, String email, String phone) {
		
		boolean validateSuccess = true;
		
		if (password.equals("") == false) {
			if (password.length() < 8 || password.length() > 16) {
				System.out.println("Password Must Be 8-16 Characters Long");
				validateSuccess = false;
			}
			if (password.equals(rePass) == false) {
				System.out.println("Passwords You Enter Are Different");
				validateSuccess = false;
			}
		}
		
		if (email.equals("") == false) {
			if (email.matches("^(.+)@(.+)$") == false) {
				System.out.println("Invalid Email");
				validateSuccess = false;
			}
		}
		
		if (phone.equals("") == false) {
			if (phone.length() != 10) {
				System.out.println("Invalid Phone Number");
				validateSuccess = false;
			}
		}

		return validateSuccess;
	}
	
	public static boolean checkUserName(String userName) {
		
		String sql = "select \"UserId\" from \"User\" where \"UserName\" = ?";
		
		try(Connection c = ConnectionUtil.getConnection();
				PreparedStatement ps = c.prepareStatement(sql)) {
			
			ps.setString(1, userName); 	       
			ResultSet rs = ps.executeQuery();
			
        	if (rs.next()) {
        		System.out.println("Username Already Exist. Please try again!");
        		return false;
        	}
        	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return true;
	}
	
	public static boolean checkEmail(String email) {
		
		String sql = "select \"UserId\" from \"User\" where \"Email\" = ?";
		
		try(Connection c = ConnectionUtil.getConnection();
				PreparedStatement ps = c.prepareStatement(sql)) {
			
			ps.setString(1, email); 	       
			ResultSet rs = ps.executeQuery();
			
        	if (rs.next()) {
        		System.out.println("Email Already Exist. Please try again!");
        		return false;
        	}
        	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return true;
	}
	
	public static boolean checkPhoneNum(String phone) {
		
		String sql = "select \"UserId\" from \"User\" where \"Phone\" = ?";
		
		try(Connection c = ConnectionUtil.getConnection();
				PreparedStatement ps = c.prepareStatement(sql)) {
			
			ps.setString(1, phone); 	       
			ResultSet rs = ps.executeQuery();
			
        	if (rs.next()) {
        		System.out.println("Phone Number Already Exist. Please try again!");
        		return false;
        	}
        	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return true;
	}
	
}
