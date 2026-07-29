<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>貸出・返却処理</title>

<style>

body{
    font-family: Arial, sans-serif;
    background-color:#f2f2f2;
    text-align:center;
}

.loan-box{
    width:400px;
    margin:80px auto;
    padding:30px;
    background:white;
    border:1px solid #ddd;
    border-radius:10px;
}

h1{
    margin-bottom:30px;
}

input[type="text"]{
    width:220px;
    padding:8px;
    margin:10px 0;
}

.button-area{
    margin-top:20px;
}

.button-area input{
    width:100px;
    padding:10px;
    margin:0 10px;
    cursor:pointer;
}

</style>

</head>
<body>

<div class="loan-box">

<h1>貸出・返却処理</h1>

<form method="post">

利用者ID
<br>
<input type="text" name="userId">

<br><br>

書籍ID
<br>
<input type="text" name="bookId">

<div class="button-area">

<input type="submit"
       value="貸出"
       formaction="">

<input type="submit"
       value="返却"
       formaction="">

</div>

</form>

</div>

</body>
</html>