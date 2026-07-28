<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.util.List" %>
<%@ page import="model.Book" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>蔵書検索結果</title>

<style>

body{
    font-family: Arial, sans-serif;
    background-color:#f2f2f2;
    margin:20px;
}

.container{
    width:900px;
    margin:auto;
    background:white;
    padding:20px;
    border:1px solid #ccc;
    border-radius:5px;
}

h1{
    text-align:center;
}

table{
    width:100%;
    border-collapse:collapse;
    margin-top:20px;
}

th,td{
    border:1px solid #ccc;
    padding:10px;
    text-align:center;
}

th{
    background:#eeeeee;
}

input[type=submit]{
    padding:5px 15px;
    cursor:pointer;
}

a{
    display:inline-block;
    margin-top:20px;
    text-decoration:none;
}

</style>

</head>
<body>

<div class="container">

<h1>蔵書検索結果</h1>

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

<input type="hidden" name="action" value="changeStatus">

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

検索結果はありません。

</td>

</tr>

<%
}
%>

</table>

<br>

<a href="">蔵書管理へ戻る</a>

</div>

</body>
</html>