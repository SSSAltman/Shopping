<%@ page language="java" import="data.ifRight" %>
<%@ page import="java.sql.*" %>
<%@ page language="java" import="com.user.model.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
//得到提交上来的用户名密码
String username=request.getParameter("username");
String password=request.getParameter("password");

boolean user=ifRight.ifright(username, password);
if(user){
	//out.println("登陆成功! ");
		//session.setAttribute("user", user);
		request.setAttribute("user", username);
		request.getRequestDispatcher("first.jsp").forward(request, response);
	
}
else{
	out.println("登陆失败，用户名或者密码错误 ");
	request.setAttribute("message", "<font color='red'>登陆失败，用户名或密码错误</font>");
	request.getRequestDispatcher("index.jsp").forward(request, response);
}
%>
</body>
</html>