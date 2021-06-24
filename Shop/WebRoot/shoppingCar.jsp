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
    
    <title>My JSP 'shoppingCar.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="CSS/shoppingCar.css">

  </head>
  
  <body>
   	<div id="userGoodInfo">
		<% 
 		Set list = (Set)request.getAttribute("buylist"); 
 		System.out.println(list.size()); 
 		if(list.size() > 0) {  
  	 	%>
  	 <div class="goodInfos">
  	 	<s:iterator value="#request.buylist" id="good">
			<div class="goodInfo">
				<div class="photo">
					<img src="getGoodImage.action?good.goodid=<s:property value="#good.goodid"/>" width="150"/>
				</div>
				<div class="info">
					<div class="goodname">
						<s:property value="#good.goodname"/>
					</div>
					<div>
						价格：<s:property value="#good.goodprice"/>
					</div>
					<div>
						分类：<s:property value="#good.type.typename"/>
					</div>
					<div class="buy">
						<a href="payGoods.action?good.goodid=<s:property value="#good.goodid"/>"><img src="image/buynow.png"/></a>
						<a href="deleteGoods.action?good.goodid=<s:property value="#good.goodid"/>"><img src="image/cancel.png"/></a>
					</div>
				</div>
			</div>
		</s:iterator>
  	 </div>
  	 <%}else{ %>
  	 <center>
  	 	<div>
	  	 	<img src="image/userGoodsZero.png"/>
	  	 </div>
  	 </center>
  	 <%} %>
	</div>
  </body>
</html>
