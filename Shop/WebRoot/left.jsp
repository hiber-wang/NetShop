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
  		<%
  			if((Integer)session.getAttribute("authority") == 0) {
  		 %>
  		<li>
  			<a href="userInfo.action" target="right">个人信息</a>
  		</li>
  		<li>
  			<a href="getAllGoods.action?pageNow=1" target="right">商品信息</a>
  		</li>
  		<li>
  			<a href="getBuyGoods.action" target="right">购物车</a>
  		</li>
  		<li>
  			<a href="deleteUser.action" target="_top" onClick="if(!confirm('您确定要注销用户吗？'))return false;else return true;">注销用户</a>
  		</li>
  		<%}else{ %>
  			<li>
  				<a href="getAllUser.action" target="right">用户管理</a>
  			</li>
	  		<li>
	  			<a href="getAllGoods.action?pageNow=1" target="right">商品管理</a>
	  		</li>
  		<%} %>
  		<li>
  			<a href="logout.action" target="_top">退出</a>
  		</li>
  	</ul>
  </body>
</html>
