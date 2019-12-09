package com.revature.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {

	

	private static Connection connection2;
	
	public static Connection getConnection() throws SQLException {
		try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found " + e);
        }
		String url="jdbc:postgresql://database-1.cwlgolqmd1cu.us-east-2.rds.amazonaws.com:5432/postgres";
		String username="postgres";
		String password="password";

	
		if(connection2 == null || connection2.isClosed()) {
			connection2 = DriverManager.getConnection(url, username, password);
		}
		return connection2;
	}
//	public static Connection getConnection() throws SQLException {
//		String url="jdbc:postgresql://"+System.getenv("path")+":5432/postgres";
//		String username=System.getenv("user");
//		String password=System.getenv("pass");
//		if(connection==null||connection.isClosed()) {
//			connection=DriverManager.getConnection(url,username,password);
//		}
//		return connection;
//	}
}