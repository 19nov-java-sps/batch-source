package com.revature.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {

	private static Connection connection;

// grab connection to the database

public static Connection getConnection() throws SQLException {
	String url = "jdbc:postgresql://mydb.cctq2eginmnd.us-east-1.rds.amazonaws.com:5432/postgres";
	String username = "postgres";
	String password = "WXg48B0bvbdfpFIwjnue";

	if(connection == null || connection.isClosed()) {
		connection = DriverManager.getConnection(url, username, password);
	}

	return connection;
}
}
