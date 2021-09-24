package com.configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect {
	private static String url = "jdbc:mysql://localhost:3306/appraisal_hostory";
	private static String username = "root";
	private static String password = "root";

	public static Connection getConnection() {
		Connection connection = null;
 		try {

			connection = DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}

	public static void main(String[] args) {
		getConnection();
	}
}
