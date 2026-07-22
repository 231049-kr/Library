<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>貸出処理</title>

<style>

    body {
        font-family: Arial, sans-serif;
        background-color: #f2f2f2;
        text-align: center;
    }

    .loan-box {
        width: 400px;
        margin: 100px auto;
        padding: 30px;
        background-color: white;
        border: 1px solid #ddd;
        border-radius: 10px;
    }

    h1 {
        margin-bottom: 30px;
    }

    input[type="text"] {
        width: 220px;
        padding: 8px;
        margin: 10px 0;
    }

    input[type="submit"] {
        padding: 10px 30px;
        margin-top: 20px;
        cursor: pointer;
    }

</style>

</head>

<body>

<div class="loan-box">

    <h1>貸出処理</h1>

    <form action="LoanServlet" method="post">

        利用者ID：
        <br>
        <input type="text" name="userId">
        <br><br>

        書籍ID：
        <br>
        <input type="text" name="bookId">
        <br><br>

        <input type="submit" value="貸出">

    </form>

</div>

</body>
</html>