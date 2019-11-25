package com.revature.jdbc.JDNCDemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Driver {

	public static void main(String[] args) throws SQLException {
		
		String driveName = ConnectionUtil.getConnection().getMetaData().getDriverName();
		System.out.println(driverName);
				
	}

}


String username = "postgres";
String password = "aspire5733Z";

Connection c = DriverManager.getConnection(url, username, password);
String driver = c.getMetaData().getDriverName();
System.out.println(driver);