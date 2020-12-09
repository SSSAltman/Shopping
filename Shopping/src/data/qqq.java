package data;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import com.user.model.*;

public class qqq {
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
		if (conn == null) {
			conn = DriverManager.getConnection(url, username, password);
			return conn;
		}
		return conn;
	}
	//此处处理登录或者注册要求,应该连接数据库
	//private static Map<String, User> db=new HashMap<String,User>();
	public static boolean ifright(String username,String password) {
		
		//准备连接数据库的变量
		Connection conn=null;
		Connection newconn=null;
		java.sql.Statement smt = null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		
		
try {
	    String sql="select password from LY_customer where loginName ='"+username+"'";
	    conn=qqq.getConnection();
	    stmt=conn.prepareStatement(sql);
		  rs = stmt.executeQuery();
	    if(rs.next()) {
	    	//System.out.println(rs.getString(1));
	    	if(password.equals(rs.getString(1))) {
	    		return true;
	    	}
	    	else{
	    		return false;
	    	}
	    }
	    
	}catch (Exception e) {
		// TODO Auto-generated catch block	
		e.printStackTrace();
	}
	finally {
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	return false;
//public static User verfyAccount(String username,String password) {
//	if(db.containsKey(username)) {
//		User user=db.get(username);
//		if(user.getPassword().equals(password)) {
//			return user;
//		}
//		else {
//			return null;
//		}
//	}
//	return null;
//}	
}
//	public static void main(String[]args) {
//		boolean a=ifright("ly", "123");
//		System.out.println(a);
//	}
}
