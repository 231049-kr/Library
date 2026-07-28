<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<title>ユーザー登録</title>
</head>
<body>

<h1>ユーザー登録</h1>

<form action="UserRegistServlet" method="post">
<p>
    氏名：
    <input type="text" name="name">
</p>

<p>
    パスワード：
    <input type="password" name="password">
</p>

<p>
	権限：
	<select name="role">
		<option value="1">管理者</option>
		<option value="2">司書</option>
		<option value="3">利用者</option>
	</select>
<input type="submit" value="登録">
</form>

</body>
</html>
