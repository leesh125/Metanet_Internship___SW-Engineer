package service;

import java.sql.Connection;
import java.sql.SQLException;

import dao.AccountDAO;
import db.JdbcUtil;
import dto.Account;

public class AccountService {

	public void makeAccount(Account acc) throws Exception {
		Connection conn = JdbcUtil.getConnection();
		AccountDAO dao = new AccountDAO();
		try {
			dao.insertAccount(conn, acc);
		}catch(Exception e) {
			throw e;
		} finally {
			JdbcUtil.close(conn);
		}
	}
	
	public Account accountInfo(String id) throws Exception {
		Connection conn = JdbcUtil.getConnection();
		AccountDAO dao = new AccountDAO();
		Account acc = null;
		try {
			acc = dao.selectAccount(conn, id);
			if(acc == null) throw new SQLException();
		}catch(SQLException e) {
			throw e;
		}finally {
			JdbcUtil.close(conn);
		}
		return acc;
	}

}
