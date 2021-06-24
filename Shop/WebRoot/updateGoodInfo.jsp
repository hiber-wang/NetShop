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
    <s:set name="good" value="#request.good"></s:set>
    <s:form action="updateGood.action" method="post" enctype="multipart/form-data">
    	<table>
    		<tr>
    			<td>
    				<s:textfield name="good.goodid" value="%{#good.goodid}" label="商品编号"></s:textfield>
    			</td>
    		</tr>
    		<tr>
    			<td>
    				<s:textfield name="good.goodname" value="%{#good.goodname}" label="商品名"></s:textfield>
    			</td>
    		</tr>
    		<tr>
    			<td>
    				<s:textfield name="good.goodprice" value="%{#good.goodprice}" label="商品价格"/></textfield>
    			</td>
    		</tr>
    		<tr>
    			<select name="type.id">
   					<s:iterator id="type1" value="#session.typelist">
   						<option value="<s:property value="#type1.id"/>">
   							<s:property value="#type1.typename"/>
   						</option>
   					</s:iterator>
   				</select>
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
