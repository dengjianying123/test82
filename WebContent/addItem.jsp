<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>新增商品</title>
</head>
<body>
<center>
	<h3>新增商品</h3>
	<form action="${pageContext.request.contextPath }/addItem" method="post">
		<table border="1" width="30%">
			<tr>
				<td>商品名称:</td>
				<td><input type="text" name="name"></td>
			</tr>
			<tr>
				<td>商品描述:</td>
				<td><input type="text" name="destr"></td>
			</tr>
			<tr>
				<td>库存数量:</td>
				<td><input type="text" name="num"></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input id="addBtn" type="submit" value="添加"></td>
			</tr>
		</table>
	</form>
</center>
</body>
<script type="text/javascript" src="${pageContext.request.contextPath }/static/js/jquery-1.11.0.min.js"></script>
<script type="text/javascript">
	/* $(function() {
		$("#addBtn").click(function(){
			
		});
	});  */
</script>
</html>