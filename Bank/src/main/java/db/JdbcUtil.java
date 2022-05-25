package db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class JdbcUtil {
	private JdbcUtil() {}
	public static Connection getConnection() {
		Connection conn = null;
		try {
			Context context = new InitialContext();
			DataSource ds = (DataSource)context.lookup("java:comp/env/oracleDB");
			conn = ds.getConnection();
		} catch(SQLException e) {
			e.printStackTrace();
		} catch(NamingException e) {
			e.printStackTrace();
		} 
		return conn;
	}
	
	public static boolean isConnected(Connection conn) {
		boolean validateConnection = true;
		try {
			if(conn == null || conn.isClosed()) {
				validateConnection = false;
			} 
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return validateConnection;
	}
	
	public static void close(Connection conn) {
		try {
			if(conn != null) {
				conn.close();
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void close(Statement stmt) {
		try {
			if(stmt != null) {
				stmt.close();
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void close(ResultSet resert) {
		try {
			if(resert != null) {
				resert.close();
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
