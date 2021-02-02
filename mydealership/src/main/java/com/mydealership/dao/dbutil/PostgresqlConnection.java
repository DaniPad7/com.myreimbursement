package com.mydealership.dao.dbutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.log4j.Logger;

public class PostgresqlConnection {
	public static Connection connection;
	
	public static Logger log = Logger.getLogger(PostgresqlConnection.class);
	
	private PostgresqlConnection() {
		
	}
	
	public static Connection getConnection() throws SQLException, ClassNotFoundException {
		
			Class.forName("org.postgresql.Driver");
			String url = "jdbc:postgresql://localhost:5432/postgres";
			String username = "postgres";
			String password = "Heix#394";
			connection = DriverManager.getConnection(url, username, password);
			return connection;
			
		
	}
}
