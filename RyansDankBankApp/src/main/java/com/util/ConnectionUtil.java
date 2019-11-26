package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {

	private static Connection connection;

	// This is how to hard-code the connection and setting up my environment variables
	public static Connection getHardcodedConnection() throws SQLException {
		String url = "jdbc:postgresql://[endpoint]:5432/postgres";
		String username = "user";
		String password = "pass";

		if (connection == null || connection.isClosed()) {
			connection = DriverManager.getConnection(url, username, password);
		}
		return connection;
	}

	// This is the environment variables I auto-generated
	public static Connection getConnection() throws SQLException {
		String url = "jdbc:postgresql://" + System.getenv("jdbc_db_host") + ":5432/postgres";
		String username = System.getenv("jdbc_db_user");
		String password = System.getenv("jdbc_db_pass");

		if (connection == null || connection.isClosed()) {
			connection = DriverManager.getConnection(url, username, password);
		}
		return connection;
	}
}
