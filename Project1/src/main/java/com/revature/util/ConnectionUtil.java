package com.revature.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {
	
	private static Connection connection;
	
	// DriverManager has a static method "getConnection" which we provide
	// database information/credentials to, in order to establish a 
	// connection to our database
	
public static Connection getConnection() throws SQLException {
	
		// Environment variables are used as a security measure
		// so my login credentials are not displayed in my code
	
	try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
		
			System.out.println("Class not found " + e);
		}
		
		String url = "jdbc:postgresql://"+System.getenv("jdbc_db_hostname") + ":5432/postgres";
		String username = System.getenv("jdbc_db_user");
		String password = System.getenv("jdbc_db_pass");
		
		if(connection == null || connection.isClosed()) {
			connection = DriverManager.getConnection(url, username, password);
			System.out.println("Connected to Postgresql.");
		}
		return connection;
	}

}
