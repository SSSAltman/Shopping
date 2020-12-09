<%@ page language="java" import="data.getorder"%>
<%@ page language="java" import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
<%
String id=request.getParameter("id");
getorder aa=new getorder();
boolean yes=aa.delete_order(id);
if(yes){request.getRequestDispatcher("allorder.jsp").forward(request, response);}
else{request.getRequestDispatcher("allorder.jsp").forward(request, response);}
%>
</body>
</html>