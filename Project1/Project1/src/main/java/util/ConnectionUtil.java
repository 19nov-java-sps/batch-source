package util;

import java.sql.Connection; 
import java.sql.DriverManager; 
import java.sql.SQLException; 

public class ConnectionUtil {
	private static Connection connection; 
	
	public static Connection getConnection() throws SQLException {
		try {
			Class.forName("org.postgresql.Driver"); 
		} catch (ClassNotFoundException e) {
			System.out.println(e); 
		}
		
		String url = "jdbc:postgresql://" + System.getenv("jdbc_db_host") + ":5432/postgres"; 
		String username = System.getenv("jdbc_db_user"); 
		String password = System.getenv("jdbc_db_pass"); 
		
		if (connection == null || connection.isClosed()) {
			connection = DriverManager.getConnection(url, username, password); 
		}
		
		return connection; 
	}
	
}
