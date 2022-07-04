<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<title>データを削除する</title>
	</head>
	<body>
		<div style="text-align:center">
			<h2 style="text-align:center">削除ID入力画面</h2>
 			<hr style="height:3; background-color:#0000ff" />
 			<br>
 			削除するIDを入力してください。
 			<form method="post" action="<%=request.getContextPath() %>/User_Servlet">
 				<input type="text" name="id">
 				<input type="submit"name="delete">
 			</form>
 			<br>
 		</div>
 	</body>
 </html>