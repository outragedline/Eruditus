package com.eruditus.infra;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
	private String url;
	private String user;
	private String password;

	public ConnectionManager(String url, String user, String password) {
		this.url = url;
		this.user = user;
		this.password = password;
	}

	public Connection getConnection() throws SQLException {
		return DriverManager.getConnection(url, user, password);
	}

	public void closeConnection(Connection conn) {
		try {
			if (conn != null && !conn.isClosed()) {
				conn.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
