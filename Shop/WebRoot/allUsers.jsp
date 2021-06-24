<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'allGoods.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="CSS/allUsers.css">

  </head>
  
  <body>
	<div id="userlist">
		<s:iterator value="#session.userlist" id="user">
		<div class="userInfo">
			<div class="photo">
				<img src="getImage.action?user.userid=<s:property value="#user.userid"/>" width="150"/>
			</div>
			<div class="info">
				<div class="username">
					<s:property value="#user.username"/>
				</div>
				<div>
					账号：<s:property value="#user.userid"/>
				</div>
				<div>
					注册时间：<s:property value="#user.date"/>
				</div>
				<div class="change">
					<a href="updateUserInfo.action?user.userid=<s:property value="#user.userid"/>"><img src="image/change.png"/></a>
					<a href="AdeleteUser.action?user.userid=<s:property value="#user.userid"/>"><img src="image/cancel.png"/></a>
				</div>
			</div>
		</div>
	</s:iterator>
	</div>
  </body>
</html>
