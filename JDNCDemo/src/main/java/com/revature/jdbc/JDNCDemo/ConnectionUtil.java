package com.revature.jdbc.JDNCDemo;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionUtil {
	
	private static Connection connection;
	
	public static Connection getHardcodedConnection() {
		String url = "jdbc:postgresql://revature-java.cewikdzl16ea.us-east-2.rds.amazonaws.com:5432/postgres";
		String username = "postgres";
		String password = "aspire5733Z";
		
		if(connection == null || connection.isClosed()) {
			connection = DriverManager.getConnection(url, username, password);
		}
		
		
		return connection;
		

		
	}
	
	public static Connection getConnection() {
		String url = "jdbc:postgresql://"+System.getenv("jdbc_db_host")+"5432/postgres";
		String username = System.out.println()
	}
	
	Connection c = DriverManager.getConnection(url, username, password);
	String driver = c.getMetaData().getDriverName();
	System.out.println(driver);

}
