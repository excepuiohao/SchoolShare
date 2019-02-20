<%@page import="com.zhaohao.schoolshare.bean.User"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>用户信用</title>
</head>
<body>
<%User user=(User)session.getAttribute("user");%>
<% %>
<center>
<img  src="exam.bmp">
<div style="border: solid silver 1px;width: 348px">
	<form action="AdminUpdateUserIntegral" method="get" style=" margin-top: 20px;">
		个人号码：<input type="text" name="userId" value=<%=user.getUserId() %> readonly="readonly"> <br> 密&nbsp;&nbsp;码：<input type="text"
			name="userPassword" value=<%=user.getUserPassword() %> readonly="readonly"><br> 用户信用：<input type="text"
			name="userCredit" value=<%=user.getUserIntegral()%> readonly="readonly"><br>用户积分：<input type="text"
			name="userIntegral" ><br>姓&nbsp;&nbsp;名：<input type="text"
			name="userName" value=<%=user.getUserName() %> readonly="readonly"><br>
			
			
			<input type="submit" value="修改"> <input
			type="reset" value="重置">
	</form>
		<a href="AdminLogin.jsp">进入后台</a>
</div>
	</center>
</body>
</html>