package com.rev.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {
	//establish connection
	static Connection connection;
//	public static Connection getHardCodedConnection() throws SQLException {
//		String url="jdbc:postgresql://database-1.cwlgolqmd1cu.us-east-2.rds.amazonaws.com:5432/postgres";
//		String username="postgres";
//		String password="password";
//		if(connection==null||connection.isClosed()) {
//			connection=DriverManager.getConnection(url,username,password);
//		}
//		return connection;
//	}
	public static Connection getConnection() throws SQLException {
		String url="jdbc:postgresql://"+System.getenv("path")+":5432/postgres";
		String username=System.getenv("user");
		String password=System.getenv("pass");
		if(connection==null||connection.isClosed()) {
			connection=DriverManager.getConnection(url,username,password);
		}
		return connection;
	}
}


