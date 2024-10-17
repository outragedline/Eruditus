package com.eruditus.infra;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
	private String url;

	public ConnectionManager(String url) {
		this.url = url;
	}

	public Connection getConnection() throws SQLException {
		return DriverManager.getConnection(url);
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
