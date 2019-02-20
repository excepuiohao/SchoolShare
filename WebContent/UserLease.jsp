<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>用户租赁信息</title>
</head>
<body>
	<%
		ResultSet rs = null;
		rs = (ResultSet) session.getAttribute("userLease");
	%>
	<center>
		<table>
			<tr>
				<td>用户id</td>
				<td>物品id</td>
				<td>物品状态</td>
				<td>物品名</td>
				<td>操作</td>
			</tr>
			<%
				while (rs.next()) {
			%>
			<tr>
				<td><%=rs.getString(2)%></td>
				<td><%=rs.getString(3)%></td>
				<td><%=rs.getString(4)%></td>
				<td><%=rs.getString(5)%></td>
				<%
					if (rs.getString(4).equals("F")) {
				%>
				<td><a
					href="UserReturnGoodsByGoodsId?goodsId=<%=rs.getString(3)%>">归还</a></td>
				<%
					}
				%>
			</tr>
			<%
				}
			%>

		</table>


	</center>

</body>
</html>