<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>予約確認</title>

<style>

body {
    font-family: Arial, sans-serif;
    background-color: #f2f2f2;
    margin: 0;
}

.container {
    width: 500px;
    margin: 80px auto;
    background-color: #ffffff;
    padding: 30px;
    border: 1px solid #ddd;
    border-radius: 10px;
    text-align: center;
}

h1 {
    margin-bottom: 30px;
    color: #333;
}

table {
    width: 100%;
    border-collapse: collapse;
    margin-top: 20px;
}

th, td {
    padding: 10px;
}

td:first-child {
    width: 120px;
    text-align: right;
    font-weight: bold;
}

input[type="text"] {
    width: 250px;
    padding: 8px;
    border: 1px solid #ccc;
    border-radius: 4px;
}

button {
    margin-top: 20px;
    padding: 10px 30px;
    background-color: #4CAF50;
    color: white;
    border: none;
    border-radius: 5px;
    cursor: pointer;
}

button:hover {
    background-color: #45a049;
}

a {
    display: inline-block;
    margin-top: 20px;
    color: #0066cc;
    text-decoration: none;
}

a:hover {
    text-decoration: underline;
}

</style>

</head>

<body>

<div class="container">

<h1>図書検索</h1>

<form action="ReserveRegist" method="post">

<table>

<tr>
    <td>書籍ID</td>
    <td><input type="text" name="book_id"></td>
</tr>

<tr>
    <td>書名</td>
    <td><input type="text" name="title"></td>
</tr>

<tr>
    <td>著者</td>
    <td><input type="text" name="author"></td>
</tr>

<tr>
    <td>カテゴリ</td>
    <td><input type="text" name="category"></td>
</tr>

<tr>
    <td>出版社</td>
    <td><input type="text" name="publisher"></td>
</tr>

</table>

<button type="submit">検索</button>

</form>

<a href="UserMenuServlet">メニューに戻る</a>

</div>

</body>
</html>