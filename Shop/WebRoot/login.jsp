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
    
    <title>My JSP 'login.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="CSS/login.css">

  </head>
  
  <body background="image/bg.jpg">
    <div id="infotable">
    	<div>
    		<s:form action="login.action" method="post">
		    	<table>
		    		<caption>
		    			<p>
		    				<font size="8px">Welcom Back</font><br>
		    			<font color="grey">Please Login with your username and password</font>
		    			</p>
		    		</caption>
		    		<tr>
		    			<s:textfield name="login.userid" cssClass="info"></s:textfield>
		    			<s:password name="login.pwd" cssClass="info"></s:password>
		    		</tr>
		    		<tr>
		    			<td></td>
		    			<td>
		    				<input type="submit" value="登录" id="submit"/>
		    			</td>
		    		</tr>
		    		<tr>
		    			<td></td>
		    			<td>
		    				<center>
		    					Without an account? Please <a href="userInsert.jsp" id="joinUs">join us</a>
		    				</center>
		    			</td>
		    		</tr>
		    	</table>
		    </s:form>
    	</div>
    </div>
  </body>
</html>
