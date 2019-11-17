package com.revature;

import com.revature.service.UserService;

public class Driver {
	
	private static boolean isLogin = false;
	
    public static boolean isLogin() {
		return isLogin;
	}

	public static void setLogin(boolean isLogin) {
		Driver.isLogin = isLogin;
	}

	public static void main( String[] args ) {
    	
    	UserService us = new UserService();
        
    	us.startService();

    }
}



