<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>用户注册</title>
</head>
<body>
<center>
<img  src="exam.bmp">
<div style="border: solid silver 1px;width: 348px">
	<form action="UserRegisterServlet" method="get" style=" margin-top: 20px;">
		个人号码：<input type="text" name="userId"><br> 密&nbsp;&nbsp;码：<input type="password"
			name="userPassword"><br> 姓&nbsp;&nbsp;名：<input type="text"
			name="userName"><br><input type="submit" value="注册"> <input
			type="reset" value="重置">
	</form>
		<a href="AdminLogin.jsp">进入前台</a>
</div>
	</center>
</body>
</html>