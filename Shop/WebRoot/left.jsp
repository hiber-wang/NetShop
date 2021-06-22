<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'left.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="CSS/left.css">

  </head>
  
  <body>
  	<ul>
  		<li>
  			<a href="userInfo.action" target="right">个人信息</a>
  		</li>
  		<li>
  			<a href="getAllGoods.action" target="right">商品信息</a>
  		</li>
  		<li>
  			<a href="userInfo.action" target="right">购物车</a>
  		</li>
  	</ul>
  </body>
</html>
