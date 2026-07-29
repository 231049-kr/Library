<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.util.List" %>
<%@ page import="model.User" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>利用者管理</title>

<style>

body{
    font-family: Arial, sans-serif;
    background:#f2f2f2;
    margin:20px;
}

.container{
    width:1000px;
    margin:auto;
}

.box{
    background:white;
    padding:20px;
    margin-bottom:20px;
    border:1px solid #ccc;
    border-radius:5px;
}

table{
    width:100%;
    border-collapse:collapse;
}

th,td{
    border:1px solid #ccc;
    padding:10px;
    text-align:center;
}

th{
    background:#eeeeee;
}

input[type=text]{
    padding:5px;
}

input[type=submit]{
    padding:6px 15px;
    cursor:pointer;
}

</style>

</head>
<body>

<div class="container">

<h1>利用者管理</h1>

<!-- 検索 -->
<div class="box">

<h2>利用者検索</h2>

<form action="" method="get">

利用者ID
<input type="text" name="userId">

氏名
<input type="text" name="name">

<input type="submit" value="検索">

</form>

</div>

<!-- 新規登録 -->
<div class="box">

<h2>新規利用者登録</h2>

<form action="UserManagementServlet" method="post">

<input type="hidden" name="action" value="insert">

氏名
<input type="text" name="name">

パスワード
<input type="password" name="password">

<input type="submit" value="登録">

</form>

</div>

<!-- 一覧 -->

<div class="box">

<h2>利用者一覧</h2>

<%
List<User> users=(List<User>)request.getAttribute("users");
%>

<table>

<tr>

<th>利用者ID</th>
<th>氏名</th>
<th>更新</th>
<th>削除</th>

</tr>

<%

if(users!=null && !users.isEmpty()){

for(User user : users){

%>

<tr>

<td><%= user.getId() %></td>

<td><%= user.getName() %></td>

<td>

<form action="UserManagementServlet" method="post">

<input type="hidden" name="action" value="update">

<input type="hidden"
name="userId"
value="<%= user.getId() %>">

<input type="text"
name="name"
value="<%= user.getName() %>">

<input type="text"
name="password"
value="<%= user.getPass() %>">

<input type="submit" value="更新">

</form>

</td>

<td>

<form action="UserManagementServlet" method="post">

<input type="hidden" name="action" value="delete">

<input type="hidden"
name="userId"
value="<%= user.getUserId() %>">

<input type="submit"
value="削除"
onclick="return confirm('削除しますか？');">

</form>

</td>

</tr>

<%

}

}else{

%>

<tr>

<td colspan="5">

利用者が登録されていません。

</td>

</tr>

<%

}

%>

</table>

</div>

</div>

</body>
</html>