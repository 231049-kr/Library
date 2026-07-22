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
    body {
        font-family: sans-serif;
        margin: 20px;
    }

    table {
        border-collapse: collapse;
        width: 100%;
        margin-top: 15px;
    }

    th, td {
        border: 1px solid #ccc;
        padding: 8px;
        text-align: left;
    }

    th {
        background-color: #f4f4f4;
    }

    .form-box {
        background: #f9f9f9;
        padding: 15px;
        border: 1px solid #ddd;
        margin-bottom: 20px;
    }
</style>

</head>
<body>

<h2>蔵書管理</h2>

<!-- 検索フォーム -->
<div class="form-box">

<h3>蔵書検索</h3>

<form action="BookServlet" method="get">

キーワード（タイトル/著者）：
<input type="text" name="keyword">

<input type="submit" value="検索">

<a href="">リセット</a>

</form>

</div>

<!-- 登録・更新フォーム -->
<div class="form-box">

<h3>図書情報の登録・更新</h3>

<form action="BookServlet" method="post">

<input type="hidden" name="action" value="save">

所蔵ID：
<input type="text" name="bookId" required>

タイトル：
<input type="text" name="title" required>

著者名：
<input type="text" name="author" required>

<input type="submit" value="保存">

</form>

</div>

<h3>蔵書一覧</h3>

<%
List<Book> books = (List<Book>)request.getAttribute("books");
%>

<table>

<tr>
    <th>所蔵ID</th>
    <th>タイトル</th>
    <th>著者名</th>
    <th>現在の状態</th>
    <th>状態変更</th>
</tr>

<%
if (books != null && !books.isEmpty()) {

    for (Book b : books) {
%>

<tr>

    <td><%= b.getBookId() %></td>

    <td><%= b.getTitle() %></td>

    <td><%= b.getAuthor() %></td>

    <td><strong><%= b.getStatus() %></strong></td>

    <td>

        <form action="" method="post">

            <input type="hidden" name="action" value="changeStatus">

            <input type="hidden"
                   name="bookId"
                   value="<%= b.getBookId() %>">

            <select name="status">

                <option value="貸出可能"
                <%= "貸出可能".equals(b.getStatus()) ? "selected" : "" %>>
                貸出可能
                </option>

                <option value="貸出中"
                <%= "貸出中".equals(b.getStatus()) ? "selected" : "" %>>
                貸出中
                </option>

                <option value="整理中"
                <%= "整理中".equals(b.getStatus()) ? "selected" : "" %>>
                整理中
                </option>

                <option value="廃棄"
                <%= "廃棄".equals(b.getStatus()) ? "selected" : "" %>>
                廃棄
                </option>

            </select>

            <input type="submit" value="更新">

        </form>

    </td>

</tr>

<%
    }

} else {
%>

<tr>
    <td colspan="5">
        該当する図書は見つかりませんでした。
    </td>
</tr>

<%
}
%>

</table>

</body>
</html>