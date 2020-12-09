package data;
import java.beans.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Calendar;

import data.DBHelper;

public class onloadOrder {

	public boolean onload(String username,int price,String address) {
		Connection conn=null;
		java.sql.Statement stmt=null;
		
		//获取时间
		Calendar cal=Calendar.getInstance();
		String y=cal.get(Calendar.YEAR)+".";      
		String m=cal.get(Calendar.MONTH)+".";      
		String d=cal.get(Calendar.DATE)+".";      
		String h=cal.get(Calendar.HOUR_OF_DAY)+".";      
		String mi=cal.get(Calendar.MINUTE)+"";      
		String time=y+m+d+h+mi;
		try {
			conn=DBHelper.getConnection();
			stmt = conn.createStatement();
			String sql="INSERT INTO 201800301190_order (username,orderTime,orderprice,orderaddress) "
					+ "VALUES('"+username+"','"+time+"',"+price+",'"+address+"')";
			stmt.executeUpdate(sql);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public static void main(String[] args) {
		onloadOrder a=new onloadOrder();
		System.out.println(a.onload("ly",5000,"山东大学"));
	}
	
}
