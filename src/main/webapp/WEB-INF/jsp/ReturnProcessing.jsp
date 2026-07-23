<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>返却処理</title>

<style>

    body {
        font-family: Arial, sans-serif;
        background-color: #f2f2f2;
        text-align: center;
    }

    .return-box {
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

<div class="return-box">

    <h1>返却処理</h1>

    <form action="ReturnServlet" method="post">

        書籍ID：
        <br>
        <input type="text" name="bookId">
        <br><br>

        <input type="submit" value="返却">

    </form>

</div>

</body>
</html>