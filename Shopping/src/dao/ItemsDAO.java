package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import entity.Items;
import util.DBHelper;

//��Ʒ��ҵ���߼���
public class ItemsDAO {

	// ��ȡ��Ʒ��������Ϣ
	public ArrayList<Items> getAllItems() {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		ArrayList<Items> list = new ArrayList<Items>();
		try {
			conn = DBHelper.getConnection();
			String sql = "select * from 201800301190_SP";

			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			//System.out.println("Try");
			while (rs.next()) {

				//System.out.println("Not null");
				
				Items item = new Items();
				item.setId(rs.getInt("id"));
				// System.out.println(rs.getInt("id"));

				item.setNumber(rs.getInt("number"));
				// System.out.println(rs.getInt("number"));

				item.setPrice(rs.getInt("price"));
				// System.out.println(rs.getInt("price"));

				item.setCity(rs.getString("city"));
				// System.out.println(rs.getString("city"));

				item.setName(rs.getString("name"));
				// System.out.println(rs.getString("name"));

				item.setPicture(rs.getString("picture"));
				// System.out.println(rs.getString("picture"));

				list.add(item);
			}
			return list;
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		} finally {
			if (rs != null)
				try {
					rs.close();
					rs = null;
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			if (stmt != null)
				try {
					stmt.close();
					stmt = null;
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}

//������Ʒ��Ż�ȡ��Ʒ����
	public Items getItemsById(int id) {

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		ArrayList<Items> list = new ArrayList<Items>();
		try {
			conn = DBHelper.getConnection();
			String sql = "select * from 201800301190_SP where id=?";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, id);
			rs = stmt.executeQuery();
			//System.out.println("Try");
			if (rs.next()) {

				//System.out.println("Not null");

				Items item = new Items();
				item.setId(rs.getInt("id"));
				// System.out.println(rs.getInt("id"));

				item.setNumber(rs.getInt("number"));
				// System.out.println(rs.getInt("number"));

				item.setPrice(rs.getInt("price"));
				// System.out.println(rs.getInt("price"));

				item.setCity(rs.getString("city"));
				// System.out.println(rs.getString("city"));

				item.setName(rs.getString("name"));
				// System.out.println(rs.getString("name"));

				item.setPicture(rs.getString("picture"));
				// System.out.println(rs.getString("picture"));

				return item;
			} else {
				return null;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		} finally {
			if (rs != null)
				try {
					rs.close();
					rs = null;
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			if (stmt != null)
				try {
					stmt.close();
					stmt = null;
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}
	
	//�����������ǰ������Ʒ��Ϣ
	public ArrayList<Items> getViewList(String list){
		ArrayList<Items> itemlist=new ArrayList<Items>();
		int iCount=5;//ÿ�η���ǰ������¼
		if(list!=null&&list.length()>0) {
			String arr[]=list.split(",");
			//�����Ʒ��¼���ڵ���5��
			if(arr.length>=5) {
			for(int i=arr.length-1;i>=arr.length-iCount;i--) {
				itemlist.add(getItemsById(Integer.parseInt(arr[i])));
			}
			}
			else {
				for(int i=arr.length-1;i>=0;i--) {
					itemlist.add(getItemsById(Integer.parseInt(arr[i])));
				}
			}
			return itemlist;
		}
		else {
			return null;
		}
	}

}
