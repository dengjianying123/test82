<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>商品列表</h2>
	<a href="${pageContext.request.contextPath }/addItem.jsp">新增商品</a>
	<table border="1">
		<tr>
			<th>序号</th>
			<th>商品名称</th>
			<th>描述</th>
			<th>库存数量</th>
			<th>操作</th>
		</tr>
		<c:if test="${not empty items }">
			<c:forEach items="${items }" var="im" varStatus="vs">
				<tr>
					<td>${vs.count}</td>
					<td>${im.name }</td>
					<td>${im.destr }</td>
					<td>${im.num }</td>
					<td>
					  <a href="${pageContext.request.contextPath }/getItemById?id=${im.id}">修改</a>
					  <%-- <a href="${pageContext.request.contextPath }/editItem.jsp?id=${im.id}&name=${im.name}&destr=${im.destr}&num=${im.num}">修改</a> --%>
					  &nbsp;&nbsp;
					||<a href="${pageContext.request.contextPath }/delItem?id=${im.id}">删除</a></td>
				</tr>
			</c:forEach>
		</c:if>
		<c:if test="${empty items }">
			<tr>
				<td colspan="5" align="center">没有数据</td>
			</tr>
		</c:if>
	</table>
</body>
</html>