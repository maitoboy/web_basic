<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8"/>
<title>Jsonデータ作成</title>
</head>
<body>
<div style="text-align:center">

            <h2 style="text-align:center">登録データ入力画面</h2>

            <hr style="height:3; background-color:#0000ff" />

            <br>

            登録する情報を入力してください。

            <form method="post" action="<%=request.getContextPath() %>/Filewrite">
                <table style="margin:0 auto">
                    <tr>
                        <td style="width:60">ID</td>
                        <td ><input type=text size="30" name="id"></input></td>
                    </tr>
                    
                  <tr>
                        <td style="width:70">従業員id</td>
                        <td ><input type=text size="30" name="staffid"></input></td>
                    </tr>

                    <tr>
                        <td style="width:70">氏名</td>
                        <td ><input type=text size="30" name="name"></input></td>
                    </tr>

                    
                    <tr>
                        <td colspan=2 style="text-align:center">
                            <button type="submit">保存</button>
                        </td>
                    </tr>

                </table>

            </form>
			

			<a href="/JavaFile/Fileread">一覧</a>
		</div>
</body>
</html>