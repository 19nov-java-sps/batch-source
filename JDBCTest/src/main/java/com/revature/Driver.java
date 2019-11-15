package com.revature;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Driver {

	public static void main(String[] args) throws SQLException {
		String url = "jdbc:postgresql://" +System.getenv("jdbc_host")+ ":5432/postgres";
		String username = System.getenv("jdbc_user");
		String password = System.getenv("jdbc_pass");
		
		Connection c = DriverManager.getConnection(url, username, password);
		String driver = c.getMetaData().getDriverName();
		System.out.println(driver);

	}

}
