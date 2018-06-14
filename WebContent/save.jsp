<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>添加商品功能</title>
	</head>
	<body>
	<form action="/test611/ProductServlet" method="post" >
		商品名：<input type="text" name="name" /><br/>
		价格：<input type="text" name="price" /><br/>
		备注：<textarea rows="5" cols="30" name="remark"></textarea><br/>
		提交：<button type="submit" >提交</button><br/>
		<input type="hidden" name="type"  value="save" /> 
	</form>
	</body>
</html>