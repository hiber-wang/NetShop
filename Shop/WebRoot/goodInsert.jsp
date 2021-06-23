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
    
    <title>My JSP 'goodInsert.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="CSS/goodInsert.css">

  </head>
  
  <body>
    <div id="goodInsert">
    	<s:form action="goodInsert.action" method="post" enctype="multipart/form-data">
	    	<table>
	    		<tr>
	    			<td>
	    				<img src="image/goodname.png"/>
	    			</td>
	    			<td>
	    				<input type="text" name="good.goodname" class="goodInfo"/>
	    			</td>
	    		</tr>
	    		<tr>
	    			<td>
	    				<img src="image/price.png"/>
	    			</td>
	    			<td>
	    				<input type="text" name="good.goodprice" class="goodInfo"/>
	    			</td>
	    		</tr>
	    		<tr>
	    			<td>
	    				<img src="image/classify.png"/>
	    			</td>
	    			<td>
	    				<select name="type.id">
	    					<s:iterator id="type1" value="#session.typelist">
	    						<option value="<s:property value="#type1.id"/>">
	    							<s:property value="#type1.typename"/>
	    						</option>
	    					</s:iterator>
	    				</select>
	    			</td>
	    		</tr>
	    		
	    		<tr>
	    			<td>
	    				<img src="image/photo.png"/>
	    			</td>
	    			<td>
	    				<input type="file" name="zpFile"/>
	    			</td>
	    		</tr>
	    		
	    		<tr>
	    			<td></td>
	    			<td>
	    				<input type="submit" value="发布" id="submit"/>
	    			</td>
		    	</tr>
	    	</table>
	    </s:form>
    </div>
  </body>
</html>
