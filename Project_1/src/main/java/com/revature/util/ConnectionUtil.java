package com.revature.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {
	
	private static Connection connection;
	
	public static Connection getConnection() throws SQLException {
		
		String url = "jdbc:postgresql://"+System.getenv("Db_Url")+":5432/postgres";
		String username = System.getenv("Db_User");
		String password = System.getenv("Db_Pass");
		
		if(connection == null || connection.isClosed()) {
			try {
				Class.forName("org.postgresql.Driver"); // was getting a SQLException: no suitable driver found, this lines fixes that.
			} catch (ClassNotFoundException e) { 
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
			connection = DriverManager.getConnection(url, username, password);
		}
		
		return connection;
	}
}
