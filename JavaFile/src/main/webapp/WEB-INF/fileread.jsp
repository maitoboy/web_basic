<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8"/>
<title>JavaFile</title>
</head>
<body>
<a href="/JavaFile/Filewrite">書く</a>
<pre>  <strong>id | 従業員id |  氏名</strong>  </pre>
<p id ="id">
<script type="text/javascript">
let jsondata = '<%=request.getAttribute("lines") %>';
//オブジェクトデータの形式に変換
let object = JSON.parse(jsondata);
console.log(object);
var text = ' | ';
// 表示したいデータを指定
var getData = document.getElementById('id');
for (var i = 0; i < object.length; i++) {
    var arrayId = document.createTextNode(object[i].id);
    // 要素を指定し、その要素の子要素としてデータを表示
    getData.appendChild(arrayId);
    getData.append(text);
   
    // 従業員idを表示
    var arrayStaffid = document.createTextNode(object[i].staffid);
    getData.appendChild(arrayStaffid);
    getData.append(text);
    // 次に、nameを表示
    
    var arrayName = document.createTextNode(object[i].name);
    getData.appendChild(arrayName);
    getData.append(document.createElement("br"));
}
</script>




</body>
</html>