package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import db.JdbcUtil;
import dto.Account;

public class AccountDAO {
	public void insertAccount(Connection conn, Account acc) throws SQLException {
		String sql = "insert into account (id,name,balance) values(?,?,?)";
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setNString(1, acc.getID());
			pstmt.setNString(2, acc.getName());
			pstmt.setInt(3, acc.getBalance());
			pstmt.executeUpdate();
		} catch(SQLException e) {
			throw e;
		} finally {
			JdbcUtil.close(pstmt);
		}
	}
	
	public Account accountInfo(Connection conn, String id) {
		String sql = "select * from account where id=?";
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setNString(1, id);
		}
	}

	public Account selectAccount(Connection conn, String id) {
		// TODO Auto-generated method stub
		return null;
	}
}
