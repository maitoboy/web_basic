<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@page contentType="text/html; charset=UTF-8"%>
<html>
	<head>
		<title>絞込みデータを表示する</title>
	</head>
	<body>
		<div style="text-align:center">
			<h2 style="text-align:center">検索ID入力画面</h2>
			<hr style="height:3; background-color:#0000ff" />
			<br>
			IDに含まれる文字を入力してください。
			<form method="POST" action="<%=request.getContextPath() %>/User_Servlet">
				<input type="text" name="id">
				<input type="submit" name="select">
			</form>
			<br>
		</div>
	</body>
</html>