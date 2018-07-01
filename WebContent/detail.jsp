<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<center>
		<c:if test="${sessionScope.result != null }">
		<table border="1" cellpadding="10" cellspacing="0" bordercolor="pink">
			<thead>
				<tr>
					<th>商品id</th>
					<th>商品名</th>
					<th>商品价格</th>
					<th>商品描述</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${sessionScope.result }" var="product">
					<tr>
						<td>${product.id }</td>
						<td>${product.name }</td>
						<td>${product.price }</td>
						<td>${product.description }</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</c:if>
	</center><br>
	
	<a href="${pageContext.servletContext.contextPath }/product.jsp">回到管理页面</a>
	
</body>
</html>