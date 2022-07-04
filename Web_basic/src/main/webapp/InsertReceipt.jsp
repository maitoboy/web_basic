<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
Integer count = (Integer)request.getAttribute("count");
String error = (String)request.getAttribute("error");
%>

<html>
	<head>
 		<title>データを登録する</title>
 	</head>
 	<body>
 		<div style="text-align:center">
 			<h2 style="text-align:center">検索ID結果画面</h2>
 			<hr style="height:3; background-color:#0000ff" />
 			<br>
 			<%= error %>
 			<% if(count != null){ %>
 				<%= count%>件のデータを登録しました。
 			<% } %>
 			<br>
 		</div>
 	</body>
 </html>