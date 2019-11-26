package com.revature.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {

	private static Connection connection;

	public static Connection getHardcodedConnection() throws SQLException {
		// for more information on formatting this url or connecting to the db:
		// https://jdbc.postgresql.org/documentation/80/connect.html
		String url = "jdbc:postgresql://[endpoint]:5432/postgres";
		String username = "user";
		String password = "pass";

		if (connection == null || connection.isClosed()) {
			connection = DriverManager.getConnection(url, username, password);
		}
		return connection;
	}

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
