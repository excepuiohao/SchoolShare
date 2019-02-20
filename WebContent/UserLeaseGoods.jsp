<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>用户租赁商品</title>
</head>
<body>
	<%
		ResultSet rs = null;
		rs = (ResultSet) session.getAttribute("userGoods");
	%>
	<center>
		<table>
			<tr>
				<td>物品id</td>
				<td>物品名</td>
				<td>最低信用</td>
				<td>最低分值</td>
				<td>物品状态</td>
				<td>物品类别</td>
				<td>操作</td>
			</tr>
			<%
				while (rs.next()) {
			%>
			<tr>
				<td><%=rs.getString(1)%></td>
				<td><%=rs.getString(2)%></td>
				<td><%=rs.getString(3)%></td>
				<td><%=rs.getString(4)%></td>
				<td><%=rs.getString(6)%></td>
				<td><%=rs.getString(5)%></td>
				<%
					if (rs.getString(6).equals("F")) {
				%>
				<td><a
					href="UserLeaseGoodsByGoodsId?goodsid=<%=rs.getString(1)%>">借用</a>||<a
					href="UserFindCredit?userId=<%=rs.getString(7)%>">查看信用</a></td>
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