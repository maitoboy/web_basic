<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<title>データを更新する</title>
	</head>
	<body>
		<div style="text-align:center">
			<h2 style="text-align:center">更新データ入力画面</h2>
 			<hr style="height:3; background-color:#0000ff" />
 			<br>
 			<form id="update"action="<%=request.getContextPath() %>/User_Servlet" method="post">
 				更新するIDを入力してください。
 				<table style="margin:0 auto">
 					<tr>
 						<td style="width:60">ID</td>
 						<td ><input type=text size="30" name="id"></input></td>
 					</tr>
 				</table>
 				<hr style="height:3; background-color:#0000ff" />
 				<br>
 				更新後の情報を入力してください。
 				<table style="margin:0 auto">
 					<tr>
 						<td style="width:60">名前</td>
 						<td ><input type=text size="30" name="name"></input></td>
 					</tr>
 					<tr>
 						<td style="width:70">従業員ID</td>
 						<td ><input type=text size="30" name="staffid"></input></td>
 					</tr>
 					<tr>
 						<td colspan=2 style="text-align:center">
 							<input type="submit" name="update">
 						</td>
 					</tr>
 				</table>
 			</form>
 			<br>
 		</div>
 	</body>
 </html>