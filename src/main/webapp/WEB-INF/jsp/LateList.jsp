<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.util.List" %>
<%@ page import="model.Loan" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>延滞一覧</title>

<style>

    body {
        font-family: Arial, sans-serif;
        background-color: #f2f2f2;
        text-align: center;
    }

    .delay-box {
        width: 900px;
        margin: 50px auto;
        padding: 30px;
        background-color: white;
        border: 1px solid #ddd;
        border-radius: 10px;
    }

    table {
        width: 100%;
        border-collapse: collapse;
        margin-top: 20px;
    }

    th, td {
        border: 1px solid #ccc;
        padding: 10px;
        text-align: center;
    }

    th {
        background-color: #eeeeee;
    }

    a {
        display: inline-block;
        margin-top: 20px;
        padding: 10px 20px;
        background-color: #eeeeee;
        text-decoration: none;
        color: black;
        border-radius: 5px;
    }

    a:hover {
        background-color: #dddddd;
    }

</style>

</head>
<body>

<div class="delay-box">

<h1>延滞一覧</h1>

<%
List<Loan> loanList = (List<Loan>)request.getAttribute("loanList");
%>

<table>

<tr>
    <th>利用者ID</th>
    <th>氏名</th>
    <th>書籍ID</th>
    <th>書名</th>
    <th>貸出日</th>
    <th>返却期限</th>
</tr>

<%
if (loanList != null && !loanList.isEmpty()) {

    for (Loan loan : loanList) {
%>

<tr>

    <td><%= loan.getUserId() %></td>
    <td><%= loan.getUserName() %></td>
    <td><%= loan.getBookId() %></td>
    <td><%= loan.getBookTitle() %></td>
    <td><%= loan.getLoanDate() %></td>
    <td><%= loan.getReturnDate() %></td>

</tr>

<%
    }

} else {
%>

<tr>
    <td colspan="6">延滞している利用者はいません。</td>
</tr>

<%
}
%>

</table>

<br>

<a href="LibrarianMenuServlet">メニューへ戻る</a>

</div>

</body>
</html>