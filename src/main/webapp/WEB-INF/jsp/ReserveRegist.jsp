<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>予約登録</title>

<style>

    body {
        font-family: Arial, sans-serif;
        background-color: #f2f2f2;
        text-align: center;
    }

    .reserve-box {
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

    p {
        margin-bottom: 30px;
    }

    input[type="submit"] {
        padding: 10px 30px;
        cursor: pointer;
    }

</style>

</head>
<body>

<div class="reserve-box">

    <h1>予約登録</h1>


    <p>予約を登録しますか？</p>

   <form action="ReserveCompServlet" method="post">


	<input type="hidden" name="id" value"${memo.memoId}">
	<input type="hidden" name="title" value"${memo.title}">

	<input type="submit" value="登録">

</form>

</div>

</body>
</html>