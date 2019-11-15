package com.revature;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Driver {

	public static void main(String[] args) throws SQLException {
		String path = "jdbc:postgresql://" +System.getenv("db_host")+ ":5432:postgres";
		String usernameString = System.getenv("db_user");
		String passwordString = System.getenv("db_password");
		

		Connection c = DriverManager.getConnection(path, usernameString, passwordString);
		
		String messageString = c.getMetaData().getDriverName();
		System.out.println(messageString);
	}

}
