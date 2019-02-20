<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>删除用户</title>
</head>
<body>
<center>
<img  src="exam.bmp">
<div style="border: solid silver 1px;width: 348px">
	<form action="DeleteUserServlet" method="get" style=" margin-top: 20px;">
		删除id：<input type="text" name="userId"><br><input type="submit" value="删除"> <input
			type="reset" value="重置">
	</form>
</div>
	</center>
</body>
</html>