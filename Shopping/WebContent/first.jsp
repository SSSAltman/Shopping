<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=utf-8"%>
<%@ page import="entity.Items"%>
<%@ page import="dao.ItemsDAO"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<style type="text/css">
* {
	font-size: 20px;
	font-family: Times New Roman;
	color: #828282;
}
body{
	background: url(photo/5.jpeg) top left; 
	background-size: 100vw 100vh;
}
a:link {
	color: blue;
	text-decoration-skip: box-decoration
}</style>
<base href="<%=basePath%>">

<title>My JSP 'index.jsp' starting page</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style type="text/css">
div {
	float: left;
	margin: 10px;
}

div dd {
	margin: 0px;
	font-size: 10pt;
}

div dd.dd_name {
	color: blue;
}

div dd.dd_city {
	color: #000;
}
</style>
</head>

<body>
<%
//得到提交上来的用户名密码
String username=request.getParameter("username");
String password=request.getParameter("password");
session.setAttribute("username", username);
%>
	<h1>商品展示</h1>
	<hr>
	<center>
		<table width="750" height="60" cellpadding="0" cellspacing="0"
			border="0">
			<tr>
				<td>
					<!-- 商品循环开始 --> <% 
               ItemsDAO itemsDao = new ItemsDAO(); 
               ArrayList<Items> list = itemsDao.getAllItems();
               if(list!=null&&list.size()>0)
               {
	               for(int i=0;i<list.size();i++)
	               {
	                  Items item = list.get(i);
           %>
					<div>
						<dl>
							<dt>
								<a href="details.jsp?id=<%=item.getId()%>&username=<%=username%>"><img
									src="images/<%=item.getPicture()%>" width="120" height="90"
									border="1" /></a>
							</dt>
							<dd class="dd_name"><%=item.getName() %></dd>
							<dd class="dd_city">
								产地:<%=item.getCity() %>&nbsp;&nbsp;价格:￥
								<%=item.getPrice() %></dd>
							<%--                <dd><a href="buy_do.jsp?id=<%=item.getId()%>"><strong>加入购物车</strong></a></dd> --%>
						</dl>

					</div> <!-- 商品循环结束 --> <%
                   }
              } 
          %>
				</td>
			</tr>
		</table>
	</center>
</body>
</html>
