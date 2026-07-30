<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>司書メニュー</title>

<style>

body{
    font-family: sans-serif;
    background-color:#f2f2f2;
    margin:20px;
}

.menu-box{
    width:400px;
    margin:50px auto;
    background:#f9f9f9;
    border:1px solid #ddd;
    padding:30px;
    text-align:center;
}

h2{
    margin-bottom:30px;
}

a{
    display:block;
    margin:15px auto;
    padding:12px;
    width:220px;
    text-decoration:none;
    color:black;
    background:#e6e6e6;
    border:1px solid #ccc;
    border-radius:5px;
}

a:hover{
    background:#d9d9d9;
}

</style>

</head>
<body>

<div class="menu-box">

<h2>司書メニュー</h2>

<a href="LibraryManagementServlet">蔵書管理</a>

<a href="LoanServlet">貸出処理</a>

<a href="ReturnServlet">返却処理</a>

<a href="DelayListServlet">延滞一覧</a>

<a href="LoginServlet">ログアウト</a>

</div>

</body>
</html>