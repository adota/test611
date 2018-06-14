<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>查询商品功能</title>
	</head>
	<body>
	<form action="<%=request.getContextPath() %>/ProductServlet" method="get" >
		<input type="text" name="keyword" />
		<button type="submit" >查询</button>
		<input type="hidden" name="type"  value="query" /> 
	</form>
	<table width="500px" border="1px">
	<tr>
	<th>编号</th>
	<th>商品</th>
	<th>价格</th>
	<th>备注</th>
	<th>日期</th>
	</tr>
	<c:forEach items="${requestScope.proList}"  var="p">
	<tr>
	<td>${p.id}</td>
	<td>${p.name}</td>
	<td>${p.price}</td>
	<td>${p.remark}</td>
	<td>${p.date}</td>
	<td><a href="<%=request.getContextPath()%>/ProductServlet?id=${p.id}&type=delete">删除</a> | 
		<a href="<%=request.getContextPath()%>/ProductServlet?id=${p.id}&type=getById">更新</a></td>
	</tr>
	</c:forEach>
	</table>
	</body>
</html>