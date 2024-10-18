package com.eruditus.infra;

public class ConnectionManagerSingleton {
	public static ConnectionManager instance;

	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("Failed to load MySQL JDBC driver.", e);
		}
	}

	public static synchronized ConnectionManager getInstance() {
		// TODO treat excepetions
		String url = System.getProperty("jdbc.url");
		String user = System.getProperty("jdbc.user");
		String password = System.getProperty("jdbc.password");
		if (instance == null) {
			instance = new ConnectionManager(url, user, password);
		}
		return instance;
	}
}
