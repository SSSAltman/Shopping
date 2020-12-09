package util;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import util.DBHelper;

public class createtable {

	private static final String driver = "com.mysql.jdbc.Driver";
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
	
	public static Connection getConnection() throws Exception {
		if (conn == null) {
			conn = DriverManager.getConnection(url, username, password);
			return conn;
		}
		return conn;
	}
	
	public static void main(String []args) {
		Connection conn=null;
		Connection newconn=null;
		java.sql.Statement smt = null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		try {
		  conn=createtable.getConnection();
		  newconn=createtable.getConnection();
		  String sql="select password from comm_student where id='1'";
		  String sql0="CREATE TABLE  `webteach`.`LY_customer` (\r\n" + 
		  		"  `userId` int(11) NOT NULL AUTO_INCREMENT,\r\n" + 
		  		"  `loginName` varchar(40) NOT NULL DEFAULT '',\r\n" + 
		  		"  `password` varchar(40) NOT NULL DEFAULT '',\r\n" + 
		  		"  PRIMARY KEY (`userId`)\r\n" + 
		  		") ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;";
		 
		  String tableSql2="CREATE TABLE  `webteach`.`201800301190_order` ("+
				  "`orderId` int(11) NOT NULL AUTO_INCREMENT,"+
				  "`username` varchar(20) NOT NULL DEFAULT '',"+
				  "`orderTime` varchar(20) DEFAULT NULL,"+
				  "`orderprice` int(11) DEFAULT NULL,"+
				  "`orderaddress` varchar(20) DEFAULT NULL,"+
				  "PRIMARY KEY (`orderId`)"+
				") ENGINE=InnoDB DEFAULT CHARSET=utf8;";
		  
		  String tableSql0="CREATE TABLE  `webteach`.`201800301190_SP` ("+
				  "`id` int(11) NOT NULL AUTO_INCREMENT,"+
				  "`name` varchar(30) DEFAULT NULL,"+
				  "`city` varchar(20) DEFAULT NULL,"+
				  "`number` int(11) DEFAULT NULL,"+
				  "`price` float DEFAULT NULL,"+
				  "`picture` varchar(30) DEFAULT NULL,"+
				  "PRIMARY KEY (`id`)"+
				") ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;";
		  
		  
		  String tableSql = "CREATE TABLE  `webteach`.`LY_customer` (\r\n" + 
			  		"  `userId` int(11) NOT NULL AUTO_INCREMENT,\r\n" + 
			  		"  `loginName` varchar(40) NOT NULL DEFAULT '',\r\n" + 
			  		"  `password` varchar(40) NOT NULL DEFAULT '',\r\n" + 
			  		"  PRIMARY KEY (`userId`)\r\n" + 
			  		") ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;";
				  //String databaseSql = "create database " + database;
				   //conn = DriverManager.getConnection(url, username, password);
				   smt = conn.createStatement();
				  if (conn != null) {    
				    System.out.println("数据库连接成功！");
				    //smt.executeUpdate(databaseSql);
				    //newConn = DriverManager.getConnection(newUrl + database,username,password);
				   //if (newConn != null) { 
				     //System.out.println("已经连接到新创建的数据库：" +database);
				     java.sql.Statement newSmt = conn.createStatement(); 
				     int i = newSmt.executeUpdate(tableSql2);//DDL语句返回值为0;  
				      if (i == 0) {      
				       System.out.println(tableSql + "表已经创建成功！");
				      }
				     //}
				    }
		  
		  
		  
		} catch (Exception e) {
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
	}
	
}
