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
    
    <title>My JSP 'userInsert.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="CSS/userInsert.css">

  </head>
  
  <body>
    <div id="userInsert">
    	<s:form action="userInsert.action" method="post" enctype="multipart/form-data">
	    	<table>
	    		<tr>
	    			<td>
	    				<img src="image/id.png"/>
	    			</td>
	    			<td>
	    				<input type="text" name="user.userid" class="userInfo"/>
	    			</td>
	    		</tr>
	    		<tr>
	    			<td>
	    				<img src="image/user.png"/>
	    			</td>
	    			<td>
	    				<input type="text" name="user.username" class="userInfo"/>
	    			</td>
	    		</tr>
	    		<tr>
	    			<td>
	    				<img src="image/pwd.png"/>
	    			</td>
	    			<td>
	    				<input type="password" name="pwd" class="userInfo"/>
	    			</td>
	    		</tr>
	
	    		<tr>
	    			<td>
	    				<img src="image/icon.png"/>
	    			</td>
	    			<td>
	    				<input type="file" name="zpFile"/>
	    			</td>
	    		</tr>
	    		
	    		<tr>
	    			<td>
	    				<img src="image/addr.png"/>
	    			</td>
	    			<td>
	    				<input type="text" name="user.addr" class="userInfo"/>
	    			</td>
	    		</tr>
	    		
	    		<tr>
	    			<td>
	    				<img src="image/sex.png"/>
	    			</td>
	    			<td>
	    				<input type="radio" name="sex" />男
	    				<input type="radio" name="sex"/>女
	    			</td>
	    		</tr>
	    		
	    		<tr>
	    			<td></td>
	    			<td>
	    				<input type="submit" value="注册" id="submit"/>
	    			</td>
		    	</tr>
	    	</table>
	    </s:form>
    </div>
  </body>
</html>
