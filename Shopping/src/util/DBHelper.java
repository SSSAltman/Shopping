package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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

	//单列模式返回数据库连接对象
	public static Connection getConnection() throws Exception {
		if (conn == null) {
			conn = DriverManager.getConnection(url, username, password);
			return conn;
		}
		return conn;
	}

//	public static void main(String[] args) {
//		try {
//			PreparedStatement stmt=null;
//			ResultSet rs=null;
//			Connection conn = DBHelper.getConnection();
//			
//			
//			
//			if (conn != null) {
//				System.out.println("Get database");
//			} else {
//				System.out.println("NO NONONONO");
//			}
//			
//			
//            String sql="select * from 201800301190_SP";
//			stmt=conn.prepareStatement(sql);
//			rs=stmt.executeQuery();
//			System.out.println("Try");
//			if(rs==null) {
//				System.out.println("NULL");
//			}
//			while(rs.next()) {
//				System.out.println(rs.getString(1));
//			}
//			
//			
//			
//			
//			
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		finally {
//			try {
//				if(conn != null) conn.close();
//				
//			}catch(Exception e1) {
//				e1.printStackTrace();
//			}finally {	
//				
//			}
//		}
//	}

}
