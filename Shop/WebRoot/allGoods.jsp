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
	<link rel="stylesheet" type="text/css" href="CSS/allGoods.css">

  </head>
  
  <body>
	<s:form action="searchGoods.action" method="post">
		<div id="searchBar">
			<div id="search">
				<input type="text" name="searchContext" id="searchContext"/>
				<select name="type.id" id="type">
					<option value="0">全部</option>
   					<s:iterator id="type1" value="#session.typelist">
   						<option value="<s:property value="#type1.id"/>">
   							<s:property value="#type1.typename"/>
   						</option>
   					</s:iterator>
   				</select>
				<input type="submit" id="submit" value="搜索"/>
			</div>
			<a href="goodInsert.jsp"><img src="image/publish.png" id="publish"/></a>
		</div>
	</s:form>
	<div class="classify">
		<s:iterator id="type1" value="#session.typelist">
	    	<s:if test="#type1.id == #request.typeid">
	    		<div class="chosenType">
	    			<s:property value="#type1.typename"/>
	    		</div>
	    	</s:if>
	    	<s:else>
	    		<div class="oneType">
	    			<s:property value="#type1.typename"/>
	    		</div>
	    	</s:else>
	    </s:iterator>
	</div>
	<div id="goodlist">
		<s:iterator value="#request.list" id="good">
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
					<a href="buyGoods.action?good.goodid=<s:property value="#good.goodid"/>"><img src="image/shoppingCar.png"/></a>
				</div>
			</div>
		</div>
	</s:iterator>
	</div>
	<div class="footer">
		<s:iterator id="pageNum" value="#request.pageNum">
			<a href="getAllGoods.action?pageNow=<s:property value="#pageNum"/>"><s:property value="#pageNum"/></a>
		</s:iterator>
	</div>
  </body>
</html>
