package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBHelper {
	private static final String driver = "com.mysql.cj.jdbc.Driver";
	private static final String url = "jdbc:mysql://202.194.14.120:3306/webteach?useUnicode=true&characterEncoding=utf8";
	private static final String username = "webteach";
	private static final String password = "webteach";

	private static Connection conn = null;

	static {
		try {
			Class.forName(driver);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

//鍗曞垪妯″紡杩斿洖鏁版嵁搴撹繛鎺ュ璞�
	public static Connection getConnection() throws Exception {
		if (conn == null) {
			conn = DriverManager.getConnection(url, username, password);
			return conn;
		}
		return conn;
	}

	public static void main(String[] args) {
		try {
			Connection conn = DBHelper.getConnection();
			if (conn != null) {
				System.out.println("馃懘杩炰笂鏁版嵁搴撲簡");
			} else {
				System.out.println("浣犻珮鍏村暐鍛紝鍑戝紵寮�");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
