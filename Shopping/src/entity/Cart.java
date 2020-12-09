package entity;

import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

import entity.Items;


//���ﳵ��
public class Cart {

	//������Ʒ�ļ���
	private HashMap<Items,Integer> goods;
	
	//���ﳵ���
	private double totalPrice;

	
	//���췽��
	public Cart() {
		goods=new HashMap<Items,Integer>();
		totalPrice=0.0;
	}
	
	
	
	public HashMap<Items, Integer> getGoods() {
		return goods;
	}

	public void setGoods(HashMap<Items, Integer> goods) {
		this.goods = goods;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	
	//�����Ʒ���빺�ﳵ
	public boolean addGoodsIncart(Items item,int number) {
		if(goods.containsKey(item)) {
			goods.put(item,goods.get(item)+number);
		}
		else {
			goods.put(item, number);
		}
		calTotalPrice();//ÿ����Ӷ�Ҫ����۸�
		return true;
	}
	
	//ɾ����Ʒ�ķ���
		public boolean removeGoodsFromCart(Items item)
		{
			goods.remove(item);
			calTotalPrice(); //���¼��㹺�ﳵ���ܽ��
			return true;
		}
	
	//ͳ�ƹ��ﳵ�ܽ��
	public double calTotalPrice() {
		double sum=0.0;
		Set<Items>keys=goods.keySet();//��ü��ļ���
		Iterator<Items> it= keys.iterator();//��õ���������
		while(it.hasNext()) {
			Items i=it.next();
			sum+=i.getPrice()*goods.get(i);
		}
		this.setTotalPrice(sum);
		return this.getTotalPrice();
	}
	
//	public static void main(String[] args) {
//		
//		
//		//�ȴ���������Ʒ����
//		Items i1=new Items(1,"����Ь","����",200,500,"001.jpg");
//		Items i2=new Items(2,"yidisjads","dssdds��",300,500,"005.jpg");
//		Items i3=new Items(1,"����Ь","����",200,500,"001.jpg");
//		
//		Cart c=new Cart();
//		c.addGoodsIncart(i1, 1);
//		c.addGoodsIncart(i2, 2);
//		c.addGoodsIncart(i3, 3);//�ٴι���3˫
//		
//		//����������Ʒ�ļ���
//		Set<Map.Entry<Items,Integer>> items=c.getGoods().entrySet();
//		for(Map.Entry<Items,Integer> obj:items) {
//			System.out.println(obj);
//		}
//		System.out.println("Total price:   "+c.getTotalPrice());
//	}
}
