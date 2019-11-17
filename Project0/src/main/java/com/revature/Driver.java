package com.revature;

import com.revature.service.UserService;

public class Driver {
	
	private static String account = null;
	
    public static String getAccount() {
		return account;
	}

	public static void setAccount(String account) {
		Driver.account = account;
	}

	public static void main( String[] args ) {
    	
    	UserService us = new UserService();
        
    	us.startService();

    }
}



