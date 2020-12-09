<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=utf-8"%>
<%@ page import="entity.Cart"%>
<%@ page import="entity.Items"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<%--     <base href="<%=basePath%>"> --%>

<title>My JSP 'cart.jsp' starting page</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<link type="text/css" rel="stylesheet" href="css/style1.css" />
<script language="javascript">
    function selflog_delete(id)
    { 
    	alert("商品删除成功");
       window.location.href="<%=path%>"+"/servlet/CartServlet?id="+id+"&action=delete";
        
    }
	    function delcfm() {
	        if (!confirm("确认要删除？")) {
	            window.event.returnValue = false;
	        }
	    }
   </script>
</head>

<body>
<%
String username=request.getParameter("username");
request.getSession().setAttribute("username", username);
double totalprice=0.0;
%>

	<h1>我的购物车</h1>
	<a href="../first.jsp">首页</a> >>
	<a href="../first.jsp">商品列表</a>
	<hr>
	<center>
	<div id="shopping">
		<form action="" method="">
			<table>
				<tr>
				    <th>商品图片</th>
					<th>商品名称</th>
					<th>商品单价</th>
					<th>商品价格</th>
					<th>购买数量</th>
					<th>操作</th>
				</tr>
				<% 
				   //首先判断session中是否有购物车对象
				   if(request.getSession().getAttribute("cart")!=null)
				   {
				%>
				<!-- 循环的开始 -->
				<% 
				         Cart cart = (Cart)request.getSession().getAttribute("cart");
				         totalprice=(double)cart.getTotalPrice();
				         HashMap<Items,Integer> goods = cart.getGoods();
				         Set<Items> items = goods.keySet();
				         Iterator<Items> it = items.iterator();
				         
				         while(it.hasNext())
				         {
				            Items i = it.next();
				     %>
				<tr name="products" id="product_id_1">
					<td class="picture"><img src="../images/<%=i.getPicture()%>" width="115" height="90" /></td>
					<td class="name"><a href=""><%=i.getName() %></a></td>
					<td class="number"><%=i.getPrice() %></td>
					<td class="price" id="price_id_1"><span><%=i.getPrice()*goods.get(i) %></span>
						<input type="hidden" value="" /></td>
					<td class="number"><%=goods.get(i)%></td>
					<td class="delete"><a
						href="javascript:selflog_delete(<%=i.getId()%>)">删除</a> 
						<%--<a href="/servlet/CartServlet?action=delete&id=<%=i.getId()%>" onclick="delcfm();">删除</a>					                     --%>
					</td>
				</tr>
				<% 
				         }
				     %>
				<!--循环的结束-->

			</table>
			<div class="total">
				<span id="total">总计：<%=cart.getTotalPrice() %>￥
				</span>
			</div>
			<% 
			    }
			 %>
			 <br>
			  <br>
			   <br> <br>
			<div class="button">
			
				<a href="../userinfo.jsp?username=<%=username%>&totalpirce=<%=totalprice%>">我要下单</a>
				&nbsp;&nbsp;&nbsp;&nbsp;
			    <a href="../allorder.jsp">查看订单</a>
			</div>
		</form>
	</div>
	</center>
</body>
</html>
