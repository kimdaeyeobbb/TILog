<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>스크립팅 예제</title>
</head>
<body>

<%-- 쿼리문자열 포함하는 수행문 태그 --%>
<%
//    변수선언문은 표현식 태그에는 올 수 없음. 표현식 태그에는 표현하고자하는 식만 올 수 있음
String name = request.getParameter("name");
java.time.LocalTime lt = java.time.LocalTime.now();
%>
<h3> Hello <%= name == null ? "Guest" : name %>!
<%--    호출할 메서드가 여러개일 경우에 객체 생성 후 변수에 담아서 수행하는것이 효율적 --%>
방문 시간 : <%= lt.getHour()+ "시 " +lt.getMinute() +"분 " +lt.getSecond() +"초" %> </h3>
</body>
</html>