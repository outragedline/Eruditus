package com.eruditus.infra;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.jupiter.api.Test;

public class ConnectionManagerTest {
	@Test
	void getConnection() {
		Connection conn = null;
		try {
			conn = ConnectionManagerSingleton.getInstance().getConnection();
		} catch (SQLException e) {
			fail("Could not get connection");
			e.printStackTrace();
		}
		assertNotNull(conn);
	}

}
