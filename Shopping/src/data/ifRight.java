package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import com.user.model.*;

public class ifRight {
	 /*public static void main(String[] args) {
		 boolean a=ifright("ly", "123");
	  System.out.println(a); }*/
	
	private static final String driver = "com.mysql.cj.jdbc.Driver";
	private static final String url = "jdbc:mysql://202.194.14.120:3306/webteach?useUnicode=true&characterEncoding=utf8";
	private static final String username = "webteach";
	private static final String password = "webteach";

	private static Connection conn = null;

	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public static Connection getConnection() throws Exception {
		//Class.forName("com.mysql.cj.jdbc.Driver");
		if (conn == null) {
			conn = DriverManager.getConnection(url, username, password);
			return conn;
		}
		return conn;
	}

	// 此处处理登录或者注册要求,应该连接数据库
	// private static Map<String, User> db=new HashMap<String,User>();
	public static boolean ifright(String username, String password) {

		
		// 准备连接数据库的变量

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			
			//测试语句
			
			
			
			String sql = "select password from LY_customer where loginName ='" + username + "'";
			conn = ifRight.getConnection();
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			if (rs.next()) {
				// System.out.println(rs.getString(1));
				if (password.equals(rs.getString(1))) {
					return true;
				} else {
					return false;
				}
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
//			try {
//				if (rs != null)
//					rs.close();
//				if (stmt != null)
//					stmt.close();
//				if (conn != null)
//					conn.close();
//			} catch (Exception e1) {
//				e1.printStackTrace();
//			} finally {
//
//			}
		}
		return false;

	}
	
	 
}
