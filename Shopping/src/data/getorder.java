package data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class getorder {

	public ArrayList<String> get_order(){
		Connection conn=null;
		ResultSet rs=null;
		PreparedStatement stmt=null;
		ArrayList<String> arr=new ArrayList<String>();
		try {
			conn=DBHelper.getConnection();
			String sql="select * from 201800301190_order";
			
			stmt=conn.prepareStatement(sql);
			rs=stmt.executeQuery();
			while(rs.next()) {
				arr.add(rs.getString("orderId")+","+rs.getString("username")+","+rs.getString("orderTime")+","+rs.getString("orderprice")+","+rs.getString("orderaddress"));
			}
			return arr;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public boolean delete_order(String id) {
		Connection conn=null;
		ResultSet rs=null;
		PreparedStatement stmt=null;
		
		try {
			conn=DBHelper.getConnection();
			String sql="DELETE FROM 201800301190_order WHERE orderId='"+id+"'";
			
			stmt=conn.prepareStatement(sql);
			stmt.executeUpdate(sql);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
}
