<%@page import="com.zhaohao.schoolshare.bean.User"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>用户发布物品</title>
</head>
<body>
<center>
<img  src="exam.bmp">
<div style="border: solid silver 1px;width: 348px">
	<form action="UserReleaseGoods" method="get" style=" margin-top: 20px;">
		物品名&nbsp;&nbsp;&nbsp;：<input type="text" name="goodsName"><br> 物品信用：<input type="text"
			name="goodsCredit"><br> 物品积分：<input type="text"
			name="goodsIntegral"><br> 物品类别：<input type="text"
			name="goodsTypeId"><br> <input type="submit" value="发布"> <input
			type="reset" value="重置">
	</form>
			
</div>
	</center>
</body>
</html>