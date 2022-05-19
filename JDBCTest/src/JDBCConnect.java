import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCConnect {
	static Connection conn = null;
	static PreparedStatement stmt = null;
	static ResultSet rs = null;
	static Statement statement = null;
	public static void insertAccount(String id, String name, int balance) {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
			String insertSql = "insert into account values(?,?,?)";
			stmt = conn.prepareStatement(insertSql);
			stmt.setNString(1,id);
			stmt.setNString(2,name);
			stmt.setInt(3,balance);
			int cnt = stmt.executeUpdate();
			System.out.println(cnt + "���� ���ԵǾ����ϴ�.");
		}catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(conn != null) conn.close();
			} catch(SQLException e) {}
		}
	}

	public static void updateAccount(String id, int money) {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
			String updateSql = "update account set balance=balance+? where id=?";
			stmt = conn.prepareStatement(updateSql);
			stmt.setInt(1,money);
			stmt.setNString(2,id);
			int cnt = stmt.executeUpdate();
			System.out.println(cnt + "���� ����Ǿ����ϴ�.");
		}catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(conn != null) conn.close();
			} catch(SQLException e) {}
		}
	}
	
	public static void deleteAccount(String id) {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
			String deleteSql = "delete from account where id=?";
			stmt = conn.prepareStatement(deleteSql);
			stmt.setNString(1,id);
			int cnt = stmt.executeUpdate();
			System.out.println(cnt + "���� �����Ǿ����ϴ�.");
		}catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(conn != null) conn.close();
			} catch(SQLException e) {}
		}
	}
	
	public static void transferAccount(String sid, String rid, int money) {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
			conn.setAutoCommit(false); // ��ü Ʈ������� ���� �ڵ�Ŀ�� ó������ �ʰ� ó��
			// ������
			String sendSql = "update account set balance=balance-? where id = ?";
			stmt = conn.prepareStatement(sendSql);
			stmt.setInt(1,money);
			stmt.setNString(2,sid);
			int cnt = stmt.executeUpdate();
			if(cnt == 0) {
				throw new SQLException();
			}
			stmt.close();
			// �ޱ�
			String receiveSql = "update account set balance=balance+? where id = ?";
			stmt = conn.prepareStatement(receiveSql);
			stmt.setInt(1,money);
			stmt.setNString(2,rid);
			cnt = stmt.executeUpdate();
			if(cnt == 0) {
				throw new SQLException();
			}
			conn.commit(); // ������, �ޱ� ��� ���� �� Ŀ��ó��
			System.out.println("��ü ����");
		}catch(Exception e) {
			e.printStackTrace();
			try {
				conn.rollback();
			}catch(SQLException e2) {}
		} finally {
			try {
				if(conn != null) conn.close();
			} catch(SQLException e) {}
		}
	}
	
	public static void selectAccount(String id) {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
			String selectSql = "select * from account where id=?";
			stmt = conn.prepareStatement(selectSql);
			stmt.setNString(1,id);
			rs = stmt.executeQuery();
			if(rs.next()) {
				String qid = rs.getNString("id");
				String qname = rs.getNString("name");
				int qbalance = rs.getInt("balance");
				System.out.println("���¹�ȣ: " + qid + ", �̸�: " + qname + ", �ܾ�: " + qbalance);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(stmt != null)  stmt.close();
				if(conn != null) conn.close();
			} catch(SQLException e) {}
		}
	}

	public static void selectAccountList() {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
			String selectAllSql = "select * from account order by 1";
			statement = conn.createStatement();
			rs = statement.executeQuery(selectAllSql);
			while(rs.next()){
				String qid = rs.getNString("id");
				String qname = rs.getNString("name");
				int qbalance = rs.getInt("balance");
				System.out.println("���¹�ȣ: " + qid + ", �̸�: " + qname + ", �ܾ�: " + qbalance);
			}			
		}catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) rs.close();
				if(statement != null) statement.close();
				if(conn != null) conn.close();
			} catch(SQLException e) {}
		}
	}
	
	public static void main(String[] args) {
		//insertAccount("10004", "song", 30000);
		//insertAccount("10005", "sing", 30000);
		//updateAccount("10004",10000);
		//deleteAccount("10004");
		//transferAccount("10004", "10003", 20000);
		//selectAccount("10004");
		selectAccountList();
	}

	

}
