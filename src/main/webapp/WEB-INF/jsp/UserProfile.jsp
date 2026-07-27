<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="model.User" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>利用者情報</title>

<style>

body{
    font-family: Arial, sans-serif;
    background-color:#f2f2f2;
    text-align:center;
}

.user-box{
    width:500px;
    margin:80px auto;
    padding:30px;
    background:white;
    border:1px solid #ddd;
    border-radius:10px;
}

table{
    width:100%;
    border-collapse:collapse;
    margin-top:20px;
}

th,td{
    border:1px solid #ccc;
    padding:10px;
}

th{
    width:150px;
    background:#eeeeee;
    text-align:left;
}

td{
    text-align:left;
}

a{
    display:inline-block;
    margin-top:20px;
    padding:10px 20px;
    background:#eeeeee;
    color:black;
    text-decoration:none;
    border-radius:5px;
}

a:hover{
    background:#dddddd;
}

</style>

</head>

<body>

<div class="user-box">

<h1>利用者情報</h1>

<%
User user = (User)request.getAttribute("user");
%>

<table>

<tr>
    <th>利用者ID</th>
    <td><%= user.getUserId() %></td>
</tr>

<tr>
    <th>氏名</th>
    <td><%= user.getName() %></td>
</tr>

<tr>
    <th>メールアドレス</th>
    <td><%= user.getEmail() %></td>
</tr>


</table>

<a href="UserMenuServlet">メニューへ戻る</a>

</div>

</body>
</html>