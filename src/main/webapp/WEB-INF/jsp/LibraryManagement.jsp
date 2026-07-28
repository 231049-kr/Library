<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.util.List" %>
<%@ page import="model.Book" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>蔵書管理</title>

<style>

body{
    font-family: Arial, sans-serif;
    background-color:#f2f2f2;
    margin:20px;
}

.container{
    width:900px;
    margin:auto;
}

.box{
    background:white;
    border:1px solid #ccc;
    padding:20px;
    margin-bottom:20px;
    border-radius:5px;
}

h1{
    text-align:center;
}

h2{
    border-left:5px solid #4CAF50;
    padding-left:10px;
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
    padding:6px;
    width:180px;
}

select{
    padding:6px;
}

input[type=submit]{
    padding:8px 20px;
    cursor:pointer;
}

</style>

</head>

<body>

<div class="container">

<h1>蔵書管理</h1>

<!-- 検索 -->
<div class="box">

<h2>図書検索</h2>

<form action="t" method="get">

キーワード：
<input type="text" name="keyword">

<input type="submit" value="検索">

</form>

</div>

<!-- 登録 -->
<div class="box">

<h2>図書登録</h2>

<form action="BookServlet" method="post">

<input type="hidden" name="action" value="insert">

<table>

<tr>
<td>書籍ID</td>
<td><input type="text" name="bookId"></td>
</tr>

<tr>
<td>タイトル</td>
<td><input type="text" name="title"></td>
</tr>

<tr>
<td>著者</td>
<td><input type="text" name="author"></td>
</tr>

<tr>
<td>出版社</td>
<td><input type="text" name="publisher"></td>
</tr>

<tr>
<td>状態</td>
<td>
<select name="status">
<option value="貸出可能">貸出可能</option>
<option value="貸出中">貸出中</option>
<option value="整理中">整理中</option>
<option value="廃棄">廃棄</option>
</select>
</td>
</tr>

</table>

<br>

<input type="submit" value="登録">

</form>

</div>

<!-- 一覧 -->

<div class="box">

<h2>蔵書一覧</h2>

<%
List<Book> books = (List<Book>)request.getAttribute("books");
%>

<table>

<tr>
<th>書籍ID</th>
<th>タイトル</th>
<th>著者</th>
<th>出版社</th>
<th>状態</th>
<th>更新</th>
</tr>

<%
if(books != null && !books.isEmpty()){

for(Book book : books){
%>

<tr>

<td><%= book.getBookId() %></td>

<td><%= book.getTitle() %></td>

<td><%= book.getAuthor() %></td>

<td><%= book.getPublisher() %></td>

<td><%= book.getStatus() %></td>

<td>

<form action="BookServlet" method="post">

<input type="hidden" name="action" value="update">

<input type="hidden"
name="bookId"
value="<%= book.getBookId() %>">

<select name="status">

<option value="貸出可能">貸出可能</option>

<option value="貸出中">貸出中</option>

<option value="整理中">整理中</option>

<option value="廃棄">廃棄</option>

</select>

<input type="submit" value="変更">

</form>

</td>

</tr>

<%
}

}else{
%>

<tr>

<td colspan="6">

蔵書は登録されていません。

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