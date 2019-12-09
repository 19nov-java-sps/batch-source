package util;


import java.io.IOException; 

import java.sql.*; 
 

public class ConnectionUtil {
	private static Connection connection; 
	
	public static Connection getConnection() throws IOException, SQLException {
		
		String url = "jdbc:postgresql://" + System.getenv("host") + ":5432/postgres";
		String username = "postgres"; 
		String password = "tootsyroll"; 
		
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		if (connection == null || connection.isClosed()) {
			connection = DriverManager.getConnection(url, username, password); 
		}
		
		return connection; 
	}
	
}
