package edu.eurasia.untils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class JdbcConn {

	static {
		try {

			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static Connection getConnection() {
		Connection conn = null;
		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		String username = "scott";
		String password = "123";
		try {
			conn = DriverManager.getConnection(url, username, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}

	public static void close(Connection conn, PreparedStatement prepa, ResultSet rs) {
		try {
			conn.close();
			prepa.close();
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void close(Connection conn, PreparedStatement prepa) {
		try {
			conn.close();
			prepa.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
