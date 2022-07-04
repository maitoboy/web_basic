<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@page contentType="text/html; charset=UTF-8"%>
<%@page import="java.util.ArrayList,ch13.Accountinfo"%>
<%
ArrayList<Accountinfo> list = (ArrayList<Accountinfo>)request.getAttribute("list");
String error = (String)request.getAttribute("error");
%>
<html>
	<head>
		<title>絞込みデータを表示する</title>
	</head>
	<body>
		<div style="text-align:center">
			<h2 style="text-align:center">絞込みデータを表示する</h2>
			<hr style="height:3; background-color:#0000ff" />
			<br>
			<%= error %>
			<table style="margin:0 auto">
				<tr>
					<th style="background-color:#6666FF; width:100">ID</th>
					<th style="background-color:#6666FF; width:100">従業員ID</th>
					<th style="background-color:#6666FF; width:250">氏名</th>
				</tr>
				<%
				if(list != null){
					for(int i=0;i<list.size();i++){
				%>
				<tr>
					<td style="text-align:center; width:100">
						<A href="<%=request.getContextPath() %>/SelectServlet3?id=<%=list.get(i).getId()%>">
						<%= list.get(i).getId() %></A>
					</td>
					<td style="text-align:center; width:100"><%= list.get(i).getStaffid() %></td>
					<td style="text-align:center; width:250"><%= list.get(i).getName() %></td>
					
				</tr>
				<%
					}
				}
				%>
			</table>
			<br>
		</div>
	</body>
</html>