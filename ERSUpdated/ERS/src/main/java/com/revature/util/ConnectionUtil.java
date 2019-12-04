package com.revature.util;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
 * 	 * 
	 * Setting up environment variables:
	 * --- (Option 1) In your system's environment variables ---
	 * 
	 * --- (Option 2) In STS ---
	 * 1. Right click on the project folder in the "Package Explorer"
	 * 		go to "Run As" and "Run Configurations"
	 * 2. Click on the "Environment" tab and configure your name value pairs
	 * 
	 * 
	 * Using System.getenv("key") returns the value of the environment 
	 * 	variable, whether set in the system or in STS
	 * 		
	 * 
 */

public class ConnectionUtil {
	
	private static Connection connection;
	
	public static Connection getHardcodedConnection() throws SQLException {
		// for more information on formatting this url or connecting to the db:
		// https://jdbc.postgresql.org/documentation/80/connect.html
		String url = "jdbc:postgresql://[endpoint]:5432/postgres";
		String username = "user";
		String password = "pass";
		
		if(connection == null || connection.isClosed()) {
		
			connection = DriverManager.getConnection(url, username, password);
		}
		return connection;
	}
	
	public static Connection getConnection() throws SQLException {
		String url = "jdbc:postgresql://"+System.getenv("jdbc_db_host")+":5432/postgres";
		String username = System.getenv("jdbc_db_user");
		String password = System.getenv("jdbc_db_pass");
	
		if(connection == null || connection.isClosed()) {
	
			connection = DriverManager.getConnection(url, username, password);
		}
		return connection;
	}
	
	
	
	
	

}
