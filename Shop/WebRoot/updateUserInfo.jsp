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
    
    <title>学生选课系统</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <s:set name="user" value="#request.user"></s:set>
    <s:form action="updateUser.action" method="post" enctype="multipart/form-data">
    	<table>
    		<tr>
    			<td>账号:</td>
    			<td>
    				<input type="text" name="user.userid" value="<s:property value="#user.userid"/>" readOnly/>
    			</td>
    		</tr>
    		<tr>
    			<td>姓名：</td>
    			<td>
    				<input type="text" name="user.username" value="<s:property value="#user.username"/>"/>
    			</td>
    		</tr>
    		<tr>
    			<s:radio list="#{1:'男', 0:'女'}" value="#user.sex" label="性别" name="user.sex"></s:radio>
    		</tr>
    		<tr>
    			<td>收货地址：</td>
    			<td>
    				<input type="text" name="user.addr" value="<s:property value="#user.addr"/>"/>
    			</td>
    		</tr>
    		<tr>
    			<td>照片:</td>
    			<td>
    				<input type="file" name="zpFile"/>
    			</td>
    		</tr>
    		<tr>
    			<td>
    				<input type="submit" value="修改"/>
    			</td>
    		</tr>
    	</table>
    </s:form>
  </body>
</html>
