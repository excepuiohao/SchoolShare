<%@page import="java.sql.ResultSet"%>
<%@page import="com.zhaohao.schoolshare.bean.User"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>用户更改信息</title>
</head>
<body>
	<%
		ResultSet rs = (ResultSet) session.getAttribute("userGoods");
	%>
	<%
		
	%>
	<center>
		<%
			while (rs.next()) {
		%>
		<img src="exam.bmp">
		<div style="border: solid silver 1px; width: 348px">
			<form action="UserUpdateGoods" method="get" style="margin-top: 20px;">
				物品id：<input type="text" name="goodsId" value=<%=rs.getString(1)%>
					readonly="readonly"> <br> 物品名&nbsp;：<input type="text"
					name="goodsName" placeholder="<%=rs.getString(2) %>"><br> 最低信用：<input type="text"
					name="goodsCredit" placeholder="<%=rs.getString(3) %>"><br>最低积分：<input type="text"
					name="goodsIntegral" placeholder="<%=rs.getString(4) %>"><br>物品类别：<input type="text"
					name="goodsTypeiId" placeholder="<%=rs.getString(5) %>"><br> 物品状态：<input type="text"
					name="goodsStatus" value=<%=rs.getString(6)%> readonly="readonly" ><br>
				用户id：<input type="text" name="userId" value=<%=rs.getString(7)%>
					readonly="readonly"><br> <input type="submit"
					value="修改"> <input type="reset" value="重置">
			</form>
			<a href="AdminLogin.jsp">进入后台</a>
		</div>
		<%
			}
		%>
	</center>
</body>
</html>