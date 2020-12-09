<%@ page language="java" import="java.util.*,java.text.*" contentType="text/html; charset=utf-8"%>
<%@ page language="java" import="data.onloadOrder"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'userinfo.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
    <style type="text/css">
	 .title{
		 width: 30%;	
		 background-color: #CCC;
		 font-weight: bold;
	 }
	 .content{
	     width:70%;
	     background-color: #CBCFE5;
	 }
	 
   </style>  
  </head>
  
  <body>
  <%
  onloadOrder a=new onloadOrder();
  String username=(String)request.getSession().getAttribute("username");
  String pp=(String)request.getParameter("totalpirce");
  String totalprice=pp;
  double dprice=Double.parseDouble(pp);
  int iprice=(int)dprice;
  //int price=Integer.parseInt(pp);
  //String totalprice=(String)request.getParameter("totalpirce");
  a.onload("ly", iprice, "山东大学");
  %>
    <h1>用户信息</h1>
    <a href=first.jsp>首页</a>>> <a href="first.jsp">商品列表</a>
    <hr>
    <hr>
    <center>
     <table width="600" cellpadding="0" cellspacing="0" border="1">
        <tr>
          <td class="title">用户名：</td>
          <td class="content">&nbsp;<%="ly" %></td>
        </tr>
        <tr>
          <td class="title">电话号码</td>
          <td class="content">&nbsp;10086</td>
        </tr>
        <tr>
          <td class="title">性别：</td>
          <td class="content">&nbsp;&nbsp;♂</td>
        </tr>
        <tr>
          <td class="title">金额：</td>
          <td class="content">&nbsp;<%=totalprice %></td>
        </tr>
        <tr>
          <td class="title">E-mail：</td>
          <td class="content">&nbsp;&nbsp;10086.163.com</td>
        </tr>
        <tr>
          <td class="title">配送地址:：</td>
          <td class="content">&nbsp;
            &nbsp;山东大学
          </td>
<!--         </tr> -->
<!--         <tr> -->
<!--           <td class="title">爱好：</td> -->
<!--           <td class="content">&nbsp; -->
<!--             &nbsp;sss -->
<!--           </td> -->
<!--         </tr> -->
<!--         <tr> -->
<!--           <td class="title">自我介绍：</td> -->
<!--           <td class="content">&nbsp;sss</td> -->
<!--         </tr> -->
<!--         <tr> -->
<!--           <td class="title">是否介绍协议：</td> -->
<!--           <td class="content">&nbsp;sss</td> -->
<!--         </tr> -->
     </table>
     <a href="first.jsp?username=<%=username%>">感谢您的购买，为了方便您的回购，我们会为您保留购物车内容</a>
    </center>
    
  </body>
</html>
