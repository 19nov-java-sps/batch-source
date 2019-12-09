package com.revature.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {
	
	private static Connection connection;
	
	
	public static Connection getConnection() throws SQLException {
		
		
		  String url =
		  "jdbc:postgresql://revature-java.cewikdzl16ea.us-east-2.rds.amazonaws.com:5432/postgres";
		  String user = "postgres"; String password = "aspire5733Z";
		 

		 
		
		
		/*
		 * String url =
		 * "jdbc:postgresql://"+System.getenv("jdbc_db_host")+":5432/postgres";
		 * 
		 * 
		 * String user = System.getenv("jdbc_db_pass"); String password =
		 * System.getenv("jdbc_db_pass");
		 */
		  try {
				Class.forName("org.postgresql.Driver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		
		if(connection == null || connection.isClosed()) {
			connection = DriverManager.getConnection(url, user, password);
		}
		
		return connection;
	}

}
