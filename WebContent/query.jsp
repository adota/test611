<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>查询商品功能</title>
	</head>
	<body>
	<form action="/test611/ProductServlet" method="get" >
		查询关键字:<input type="text" name="keyword" >
			<button type="submit" >查询</button>
	</form>
	<%=request.getAttribute("proList") %>
	<table width="500px" border="1">
	<tr>
	<th>编号</th>
	<th>名称</th>
	<th>价格</th>
	<th>备注</th>
	<th>日期</th>
	<th>操作</th>	
	</tr>
	
	<c:forEach items="${requestScope.proList}" var="p">
	<tr>
		<td>${p.id}</td>
		<td>${p.name}</td>
		<td>${p.price}</td>
		<td>${p.remark}</td>
		<td>${p.date}</td>
		<td>更新|删除</td>
		</tr>		
	</c:forEach>
	
	</table>
	</body>
</html>