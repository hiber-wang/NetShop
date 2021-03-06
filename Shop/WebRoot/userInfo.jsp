<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'userInfo.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="CSS/userinfo.css">
	

  </head>
  
  <body>
  	<s:set value="#request.user" name="user"></s:set>
  	<div id="userinfo">
  		<div id="photo">
  			<img src="getImage.action?user.userid=<s:property value="#user.userid"/>" width="150"/>
  		</div>
  		<div id="info">
  			<div id="nameAndSex">
  				<font size="5px"><s:property value="#user.username"/></font>
  				<s:if test="#user.sex==1"><img src="image/male.png" class="sex"/></s:if> <s:else><img src="image/female.png" class="sex"/></s:else>
  				<a href="updateUserInfo.action"><img src="image/change.png" id="changeInfo"/></a>
  			</div>
  			<div id="otherInfo">
  				<div class="oi">
  					账号id:<s:property value="#user.userid"/>
  				</div>
  				<div class="oi">
  					注册时间：<s:date name="#user.date" format="yyyy-MM-dd"/>
  				</div>
  				<div class="oi">
  					收货地址：<s:property value="#user.addr" />
  				</div>
  			</div>
  		</div>
  	</div>
  	<div id="userGoodInfo">
		<% 
 		List list = (List)request.getAttribute("paylist"); 
 		System.out.println(list.size()); 
 		if(list.size() > 0) {
  	 	%>
  	 <div class="goodInfos">
  	 	<s:iterator value="#request.goodlist" id="good">
			<s:iterator value="#request.paylist" id="paygood">
				<s:if test="#good.goodid == #paygood.goodid">
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
					<div>
						时间：<s:date name="#paygood.date" format="yyyy-MM-dd"></s:date>
					</div>
					<div class="buy">
						<a href="deletePayGoods.action?pay.id=<s:property value="#paygood.id"/>"><img src="image/delete.png"/></a>
					</div>
				</div>
			</div>
			</s:if>
			</s:iterator>
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
