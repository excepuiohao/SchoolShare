<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>按照类别查询</title>
</head>
<body>
<center>
<img  src="exam.bmp">
<div style="border: solid silver 1px;width: 348px">
	<form action="AdminFindGoodsByType" method="get" style=" margin-top: 20px;">
		类别：<input type="text" name="categoryName"><br> <input type="submit" value="查询"> <input
			type="reset" value="重置">
	</form>
</div>
	</center>
</body>
</html>