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
		<h2><font color="green">如果已注册可直接登录，否则请进行注册</font></h2><hr color="red"/>
		<h2>请用户注册!</h2>
		<form action="${pageContext.request.contextPath }/user/register" method="post">
			<table>
				<tr>
					<td colspan="2"><input type="hidden" name="flag" value="register"/></td>
				</tr>
				<tr>
					<td>用户名:</td>
					<td><input type="text" name="username"/></td>
				</tr>
				<tr>
					<td>密码:</td>
					<td><input type="password" name="password"/></td>
				</tr>
				<tr>
					<td>年龄:</td>
					<td>
						<input type="text" name="age"/>
						<font color="red">请输入合法的整数</font>
					</td>
				</tr>
				<tr>
					<td><input type="submit" value="提交"/></td>
					<td><input type="reset" value="重置"/></td>
				</tr>
			</table>
		</form>
		<hr color="purple"/>
		<h2>请用户登录!</h2>
		<form action="${pageContext.request.contextPath }/user/login" method="post">
			<table>
				<tr>
					<td colspan="2"><input type="hidden" name="flag" value="login"/></td>
				</tr>
				<tr>
					<td>用户名:</td>
					<td><input type="text" name="username"/></td>
				</tr>
				<tr>
					<td>密码:</td>
					<td><input type="password" name="password"/></td>
				</tr>
				<tr>
					<td><input type="submit" value="提交"/></td>
					<td><input type="reset" value="重置"/></td>
				</tr>
			</table>
		</form>
		<hr color="orange"/>
		<a href="${pageContext.servletContext.contextPath }/index.jsp">回到首页</a>
	</center>
</body>
</html>