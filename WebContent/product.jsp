<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href="${pageContext.servletContext.contextPath }/product/detail">查看所有商品</a>
	
	<center>
		<h1><font color="pink">商品管理后台</font></h1><br>
		<h2>添加产品!</h2>
		<form action="${pageContext.request.contextPath }/product/add" method="post">
			<table>
				<tr>
					<td colspan="2"><input type="hidden" name="flag" value="add"/></td>
				</tr>
				<tr>
					<td>产品名:</td>
					<td>
						<input type="text" name="name"/>
						<font color="red">必填</font>
					</td>
				</tr>
				<tr>
					<td>产品价格:</td>
					<td>
						<input type="text" name="price"/>
						<font color="red">必填,请输入有效数字</font>
					</td>
				</tr>
				<tr>
					<td>产品库存:</td>
					<td>
						<input type="text" name="stock"/>
						<font color="red">必填,请输入有效数字</font>
					</td>
				</tr>
				<tr>
					<td>产品描述:</td>
					<td>
						<input type="text" name="desc"/>
						<font color="red">必填</font>
					</td>
				</tr>
				<tr>
					<td><input type="submit" value="提交"/></td>
					<td><input type="reset" value="重置"/></td>
				</tr>
			</table>
		</form><br>
		
		<h2>根据产品id查询商品</h2>
		<form action="${pageContext.request.contextPath }/product/get" method="post">
			<table>
				<tr>
					<td colspan="2"><input type="hidden" name="flag" value="get"/></td>
				</tr>
				<tr>
					<td>请输入产品id:</td>
					<td>
						<input type="text" name="id"/>
						<font color="red">必填,请输入合法的整数</font>
					</td>
				</tr>
				
				<tr>
					<td><input type="submit" value="提交"/></td>
					<td><input type="reset" value="重置"/></td>
				</tr>
			</table>
		</form>
	</center><br>
	<a href="${pageContext.servletContext.contextPath }/login.jsp">回到登录页面</a>
</body>
</html>