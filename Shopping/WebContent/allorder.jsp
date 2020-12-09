<%@ page language="java" import="data.getorder"%>
<%@ page language="java" import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Order</title>
<style type="text/css">
table {
	border-collapse: collapse;
	/*      font-family: Futura, Arial, sans-serif; */
	font-family: STXinwei;
}

table th {
	color: red;
}

caption {
	font-size: larger;
	margin: 1em auto;
}

th, td {
	padding: .65em;
}

th {
	background: #555 nonerepeat scroll 0 0;
	border: 1px solid #777;
	color: #fff;
}

td {
	border: 1px solid #777;
}
</style>
</head>
<body>
<h1>我的订单</h1>
	<a href="first.jsp">首页</a> >>
	<a href="first.jsp">商品列表</a>
	<hr>
	<center>
		<table>
			<tr>
		        <th>id</th>
				<th>收货人</th>
				<th>购买时间</th>
				<th>金额</th>
				<th>收货地址</th>
				<th>删除订单</th>
			</tr>
			<%
	getorder ww=new getorder();
    String brr[]=null;
	ArrayList<String> arr=ww.get_order();
	if(arr!=null&&arr.size()>0){
		for(int i=0;i<arr.size();i++){
			brr=arr.get(i).split(",");
// 			out.println(arr.get(i)+"<br/>");
		
	%>
			<tr>
			<td class="orderId" value=<%=brr[0] %>><%=brr[0] %></td>
				<td class="username"><%=brr[1] %></td>
				<td class="time"><%=brr[2] %></td>
				<td class="price"><%=brr[3] %></td>
				<td class="address"><%=brr[4] %></td>
				<td class="delete" style="text-align: center;"><a href="deleteorder.jsp?id=<%=brr[0] %>" style="text-decoration: none;">删除</a></td>
			</tr>
		
		<% }
	}%>
	</table>
	<%
	//System.out.println("订单这里的用户是"+(String)request.getSession().getAttribute("username"));
	%>
	<br>
	<br>
	<br>
	<a href="#" style="font-size: 25px;color: red">点击付费</a>
	</center>
</body>
</html>