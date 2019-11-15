package com.revature;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.revature.util.ConnectionUtil;

public class Driver {

	public static void main(String[] args){
		try {
			String newConnection = ConnectionUtil.getConnection().getMetaData().getDriverName();
			System.out.println(newConnection);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		

	}

}
