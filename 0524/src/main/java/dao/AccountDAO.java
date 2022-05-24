package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import dto.Account;

public class AccountDAO {
	private static Connection conn = null;
	public static Connection getConnection() {
		try {
			Context initContext = new InitialContext();
			DataSource ds = (DataSource)initContext.lookup("java:comp/env/oracleDB");
			conn=ds.getConnection();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	public static void close(Connection conn) {
		try {
			if(conn!=null) {
				conn.close();
				conn = null;
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void close(Statement conn) {
		try {
			if(conn!=null) {
				conn.close();
				conn = null;
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void close(ResultSet conn) {
		try {
			if(conn!=null) {
				conn.close();
				conn = null;
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<Account> accountList(Connection conn){
		Statement stmt = null;
		ResultSet rs = null;
		List<Account> accs = new ArrayList<>();
		String sql = "select * from account";
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				accs.add(new Account(rs.getNString(1), rs.getNString(2),rs.getInt(3)));
			}
		}catch(Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(stmt);
		}
		return accs;
	}
}
