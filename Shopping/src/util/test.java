package util;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import entity.Items;
import util.DBHelper;

//商品的业务逻辑类
public class test {

	
	//获取商品的所有信息
	public static void getAllItems(){
		Connection conn=null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		ArrayList<Items> list=new ArrayList<Items>();
		try {
			conn=DBHelper.getConnection();
			String sql="select city from 201800301190_SP where name='ADIDAS_TSHIRT'";
			
			stmt=conn.prepareStatement(sql);
			rs=stmt.executeQuery();
			System.out.println("Try");
			while(rs.next()) {
				System.out.println(rs.getString(1));
			}
			
		}
		catch(Exception ex){
			ex.printStackTrace();
			
		}
		finally {
			if(rs!=null)
				try {
					rs.close();
					rs=null;
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			if(stmt!=null)
				try {
					stmt.close();
					stmt=null;
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}
	public static void main(String[]args) {
		test.getAllItems();
	}
}
