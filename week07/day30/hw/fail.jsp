<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
    <style>
        p{
            font-size: 100px;
            color:red;
        }
    </style>
</head>
<body>
<div>
    <p>${ curTime.hour }시 ${ curTime.minute }분에 당첨 실패!! 아쉽아쉽</p>
    <img src="/mvc/images/fail.jpg"><br>
</div>
<a href="/mvc/lottoForm.html">로또응모링크</a>
</body>
</html>