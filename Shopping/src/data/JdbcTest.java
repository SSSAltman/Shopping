package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcTest {

	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static Connection getConnection() {
		Connection conn = null;
		do {
			try {
				conn = DriverManager.getConnection(
						"jdbc:mysql://202.194.14.120:3306/webteach?useUnicode=true&characterEncoding=utf8", "webteach",
						"webteach");
				if (conn != null) {
					System.out.println("👴连上数据库了");
				} else {
					System.out.println("你高兴啥呢，凑弟弟");
				}
			} catch (SQLException sqle) {
				sqle.printStackTrace();
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
					System.out.println("鏁版嵁搴撻敊璇�");
				}
			}
		} while (conn == null);
		return conn;
	}

	public static void closeDb(Connection conn) {
		if (conn == null)
			return;
		try {
			conn.close();
		} catch (Exception ex) {
		}
	}

	public static void dataSynchroGrade() {
		Connection conn = getConnection();
		if (conn == null)
			return;
		Statement stmt;
		ResultSet rs;
		String sql;
		String loginName, password;
		try {
			stmt = conn.createStatement();
			sql = " select loginName, password from comm_sys_user ";
			rs = stmt.executeQuery(sql);
			int i = 0;
			while (rs.next()) {
				loginName = rs.getString(1);
				password = rs.getString(2);
				System.out.println(loginName + "-" + password);
			}
			stmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		closeDb(conn);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// dataSynchroGrade();
		System.out.println("I m Alive");
		try {
			Connection conn = JdbcTest.getConnection();
			System.out.println("I m Alive");
			if (conn != null) {
				System.out.println("👴连上数据库了");
			} else {
				System.out.println("你高兴啥呢，凑弟弟");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
