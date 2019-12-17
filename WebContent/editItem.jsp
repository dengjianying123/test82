<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<center>
	<h3>修改商品</h3>
	<form action="${pageContext.request.contextPath }/updateItem" method="post">
		<table border="1" width="30%">
			<tr>
				<td>商品名称:</td>
				<td>
					<input type="hidden" name="id" value="${im.id }">
					<input type="text" name="name" value="${im.name}">
				</td>
			</tr>
			<tr>
				<td>商品描述:</td>
				<td><input type="text" name="destr" value="${im.destr}"></td>
			</tr>
			<tr>
				<td>库存数量:</td>
				<td><input type="text" name="num" value="${im.num}"></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit" value="修改"></td>
			</tr>
		</table>
	</form>
</center>
</body>
</html>