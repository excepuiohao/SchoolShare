<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.zhaohao.schoolshare.bean.Notice"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>用户查看公告</title>
</head>
<body>
<%
List<Notice>list =new ArrayList<Notice>();
list=(List<Notice>)session.getAttribute("allNotice");
%>
<center>
<table>
<tr><td>公告内容</td>
<td>公告时间</td>
</tr>
<%for(int i=0;i<list.size();i++){ %>
<tr><td><%=list.get(i).getNoticeContext() %></td>
<td><%=list.get(i).getNoticetime()%></td>
</tr>
<%} %>

</table>


</center>

</body>
</html>