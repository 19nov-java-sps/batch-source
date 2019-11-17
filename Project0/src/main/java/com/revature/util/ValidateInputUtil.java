package com.revature.util;

public class ValidateInputUtil {

	public static boolean validateInput(String userName, String password, String rePass, String firstName, String lastName, String email, String phone) {
		
		boolean validateSuccess = true;
		
		if (userName.length() < 5 || userName.length() > 12) {
			System.out.println("Username Must Between 5 To 12 Characters!");
			validateSuccess = false;
		}
		if (userName.matches("^[a-zA-z0-9]+$") == false) {
			System.out.println("Username Cannot Contains Special Character!");
			validateSuccess = false;
		}
		
		if (password.length() < 8 || password.length() > 16) {
			System.out.println("Password Must Between 5 To 12 Characters!");
			validateSuccess = false;
		}
		if (password.equals(rePass) == false) {
			System.out.println("Passwords You Enter Are Different!");
			validateSuccess = false;
		}
		
		if (firstName.length() < 1 || firstName.length() > 30) {
			System.out.println("Please Enter Your First Name!");
			validateSuccess = false;
		}
		if (lastName.length() < 1 || lastName.length() > 30) {
			System.out.println("Please Enter Your Last Name!");
			validateSuccess = false;
		}
		
		if (email.matches("^(.+)@(.+)$") == false) {
			System.out.println("Invalid Email!");
			validateSuccess = false;
		}
		
		if (phone.length() != 10) {
			System.out.println("Invalid Phone Number!");
			validateSuccess = false;
		}
		
		System.out.println("validate complete");
		return validateSuccess;
	}
	
	public static boolean validateInput(String password, String rePass, String firstName, String lastName, String email, String phone) {
		
		boolean validateSuccess = true;
		
		if (password.length() < 8 || password.length() > 16) {
			System.out.println("Password Must Between 5 To 12 Characters!");
			validateSuccess = false;
		}
		if (password.equals(rePass) == false) {
			System.out.println("Passwords You Enter Are Different!");
			validateSuccess = false;
		}
		
		if (firstName.length() < 1 || firstName.length() > 30) {
			System.out.println("Please Enter Your First Name!");
			validateSuccess = false;
		}
		if (lastName.length() < 1 || lastName.length() > 30) {
			System.out.println("Please Enter Your Last Name!");
			validateSuccess = false;
		}
		
		if (email.matches("^(.+)@(.+)$") == false) {
			System.out.println("Invalid Email!");
			validateSuccess = false;
		}
		
		if (phone.length() != 10) {
			System.out.println("Invalid Phone Number!");
			validateSuccess = false;
		}
				
		return validateSuccess;
	}

}
