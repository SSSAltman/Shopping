//package servlet;
//
//import java.io.IOException;
//import java.io.PrintWriter;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import dao.ItemsDAO;
//import entity.Cart;
//import entity.Items;
//
///**
// * Servlet implementation class CartServlet
// */
//@WebServlet(asyncSupported = true, description = "This is the description of my J2EE component", urlPatterns = { "/CartServlet" })
//public class CartServlet extends HttpServlet {
//	private String action;//��ʾ���ﳵ�Ķ���
//	private ItemsDAO idao=new ItemsDAO();//��Ʒҵ���߼���Ķ���
//	
//	
//    public CartServlet() {
//        super();
//        // TODO Auto-generated constructor stub
//    }
//
//	/**
//	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		doPost(request, response);
//	}
//
//	/**
//	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		response.setContentType("text/html;charset=utf-8");
//		PrintWriter out = response.getWriter();
//		
//		
//		if(request.getParameter("action")!=null) {
//			this.action=request.getParameter("action");
//			if(action.equals("add")) {//�����Ʒ��ӽ����ﳵ
//				if(addToCart(request,response)) {
//					System.out.println("���빺�ﳵ�ɹ�");
//					request.getRequestDispatcher("/success.jsp").forward(request, response);
//				}else {
//					request.getRequestDispatcher("/failure.jsp").forward(request, response);
//				}
//			}
//			if(action.equals("show")) {//�����Ʒ��ʾ���ﳵ
//				showCart(request,response);
//			}
//		}
////		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
////		out.println("<HTML>");
////		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
////		out.println("  <BODY>");
////		out.println("   This is");
////		out.println(this.getClass());
////		out.println("  </BODY>");
////		out.println("</HTML>");
////		out.flush();
////		out.close();
//	}
//
//	private void showCart(HttpServletRequest request, HttpServletResponse response) {
//		
//	}
//
//	//�����Ʒ�����ﳵ
//	private boolean addToCart(HttpServletRequest request, HttpServletResponse response) {
//		String id=request.getParameter("id");
//		String number=request.getParameter("num");
//		Items item=idao.getItemsById(Integer.parseInt(id));
//		
//		//�Ƿ��ǵ�һ�������Ʒ,��session�д���һ���µĹ��ﳵ����
//		if(request.getSession().getAttribute("cart")==null) {
//			Cart cart=new Cart();
//			request.getSession().setAttribute("cart", cart);
//		}
//		Cart cart=(Cart)request.getSession().getAttribute("cart");
//		if(cart.addGoodsIncart(item, Integer.parseInt(number))) {
//			return true;
//		}
//		else {
//			return false;
//		}
//		
//	}
//
//}
package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.cj.Session;

import dao.ItemsDAO;
import entity.Cart;
import entity.Items;

public class CartServlet extends HttpServlet {

	private String username; //��ʾ�ͻ�������
	private String action ; //��ʾ���ﳵ�Ķ��� ,add,show,delete
	//��Ʒҵ���߼���Ķ���
	private ItemsDAO idao = new ItemsDAO();
	
	
	public CartServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		
		
		
		doPost(request,response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
//		this.username=request.getParameter("username");
		this.username=(String) request.getSession().getAttribute("username");
		//System.out.println("what   "+username);������sessionûɶ����
		
		
		
		if(request.getParameter("action")!=null)
		{
			this.action = request.getParameter("action");
			if(action.equals("add")) //����������Ʒ�����ﳵ
			{
				if(addToCart(request,response))
				{
//					request.setAttribute("username", username);
					request.getRequestDispatcher("/success.jsp").forward(request, response);
				}
				else
				{
					request.getRequestDispatcher("/failure.jsp").forward(request, response);
				}
			}
			if(action.equals("show"))//�������ʾ���ﳵ
			{
				
				request.getRequestDispatcher("/cart.jsp").forward(request, response);
			}
			if(action.equals("delete")) //�����ִ��ɾ�����ﳵ�е���Ʒ
			{
			if(deleteFromCart(request,response))
				{
					request.getRequestDispatcher("/cart.jsp").forward(request, response);
				}
				else
				{
					request.getRequestDispatcher("/cart.jsp").forward(request, response);
				}
			}
		}
		
	}

	//�����Ʒ�����ﳵ�ķ���
	private boolean addToCart(HttpServletRequest request, HttpServletResponse response)
	{
		String id = request.getParameter("id");
		String number = request.getParameter("num");
		Items item = idao.getItemsById(Integer.parseInt(id));
		
		//�Ƿ��ǵ�һ�θ����ﳵ�����Ʒ,��Ҫ��session�д���һ���µĹ��ﳵ����
		if(request.getSession().getAttribute("cart")==null)
		{
			Cart cart = new Cart();
			request.getSession().setAttribute("cart",cart);
		}
		Cart cart = (Cart)request.getSession().getAttribute("cart");
		if(cart.addGoodsIncart(item, Integer.parseInt(number)))
		{
			return true;
		}
		else
		{
			return false;
		}
		
	}
	
	//�ӹ��ﳵ��ɾ����Ʒ
	private boolean deleteFromCart(HttpServletRequest request, HttpServletResponse response)
	{
		String id = request.getParameter("id");
		Cart cart = (Cart)request.getSession().getAttribute("cart");
	    Items item = idao.getItemsById(Integer.parseInt(id));
	    if(cart.removeGoodsFromCart(item))
	    {
	    	return true;
	    }
	    else
	    {
	    	return false;
	    }
	}
	
	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}

