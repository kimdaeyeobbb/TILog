<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.time.*, java.util.Date" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>JSP의 page 지시자 태그 예제(1)</h2>
<hr>

<%--객체를 표현할 경우 객체가 가진 toString의 리턴값이 출력됨--%>
<h2><%= new Date() %></h2>
<h2><%= LocalDate.now() %></h2>
<h2><%= LocalTime.now() %></h2>
</body>
</html>