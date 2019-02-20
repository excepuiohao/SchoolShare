<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>管理员登录界面</title>
</head>
<!-- 登录界面  form表单  输入姓名密码登录判断 -->
<body>
<center>
<img  src="exam.bmp">
<div style="border: solid silver 1px;width: 348px">
	<form action="AdminLoginServlet" method="get" style=" margin-top: 20px;">
		个人号码：<input type="text" name="adminId"><br> 密&nbsp;&nbsp;码：<input type="password"
			name="adminPassword"><br> <input type="submit" value="登录"> <input
			type="reset" value="重置">
	</form>
		<a href="UserLogin.jsp">进入前台</a>
			
</div>
	</center>
	
</body>
</html>