package com.revature.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {
	
	private static Connection connection;

	// grab connection to the database
	
	public static Connection getConnection() throws SQLException {
		String url = "jdbc:postgresql://" + System.getenv("JDBC_URL") +":5432/postgres";
		String username = System.getenv("User");
		String password = System.getenv("Pass");
		
		if(connection == null || connection.isClosed()) {
			connection = DriverManager.getConnection(url, username, password);
		}
		
		return connection;
	}
}
