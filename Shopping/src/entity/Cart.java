package entity;

import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

import entity.Items;


//购物车类
public class Cart {

	//购买商品的集合
	private HashMap<Items,Integer> goods;
	
	//购物车金额
	private double totalPrice;

	
	//构造方法
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
	
	//添加商品进入购物车
	public boolean addGoodsIncart(Items item,int number) {
		if(goods.containsKey(item)) {
			goods.put(item,goods.get(item)+number);
		}
		else {
			goods.put(item, number);
		}
		calTotalPrice();//每次添加都要计算价格
		return true;
	}
	
	//删除商品的方法
		public boolean removeGoodsFromCart(Items item)
		{
			goods.remove(item);
			calTotalPrice(); //重新计算购物车的总金额
			return true;
		}
	
	//统计购物车总金额
	public double calTotalPrice() {
		double sum=0.0;
		Set<Items>keys=goods.keySet();//获得键的集合
		Iterator<Items> it= keys.iterator();//获得迭代器对象
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
//		//先创建两个商品对象
//		Items i1=new Items(1,"篮球鞋","温州",200,500,"001.jpg");
//		Items i2=new Items(2,"yidisjads","dssdds州",300,500,"005.jpg");
//		Items i3=new Items(1,"篮球鞋","温州",200,500,"001.jpg");
//		
//		Cart c=new Cart();
//		c.addGoodsIncart(i1, 1);
//		c.addGoodsIncart(i2, 2);
//		c.addGoodsIncart(i3, 3);//再次购买3双
//		
//		//变量购物商品的集合
//		Set<Map.Entry<Items,Integer>> items=c.getGoods().entrySet();
//		for(Map.Entry<Items,Integer> obj:items) {
//			System.out.println(obj);
//		}
//		System.out.println("Total price:   "+c.getTotalPrice());
//	}
}
