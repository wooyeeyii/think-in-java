package com.chapter6.P276;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public enum MyObject {
	connectionFactory;
	private Connection connection;
	
	private MyObject() {
		try {
			System.out.println("调用了Myboject的构造");
			String url = "jdbc:sqlserver://lcoalhost:3306;databaseName=mysql_test";
			String username = "root";
			String password = "feixun*123";
			String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
			Class.forName(driverName);
			connection = DriverManager.getConnection(url, username, password); 
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Connection getConnection() {
		return connection;
	}

}
