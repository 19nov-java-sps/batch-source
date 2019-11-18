package com.revature.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {
	
	private static Connection connection;
	
	// Use the getConnection static method to give the database credentials in order to connect to it.
	public static Connection getConnection() throws SQLException {
		// Using environment variables in order to stay secure by not displaying my credentials in the code.
		String url = "jdbc:postgresql://"+System.getenv("Db_Url")+":5432/postgres";
		String username = System.getenv("Db_User");
		String password = System.getenv("Db_Pass");
	
		if(connection == null || connection.isClosed()) {
			connection = DriverManager.getConnection(url, username, password);
		}
		
		return connection;
	}
}
