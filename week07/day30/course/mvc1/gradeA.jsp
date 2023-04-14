<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%--name이라는 이름으로 전달된 쿼리문자열을 꺼내서 전달하고 있음--%>
<h2>${ param.name } 님은 A등급입니다. 우수한 성적이네요(^^)</h2>
<hr>
<%--referer--%>
<%--헤더라는 el 내장객체 이용--%>
<a href="${ header.referer }">성적 입력 화면으로</a>
</body>
</html>






