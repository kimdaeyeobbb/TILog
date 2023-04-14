<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EL 테스트</title>
</head>
<body>
<h2>EL의 Query 문자열 추출</h2>
<hr>

<%--EL의 empty 연산자 => 연산자 뒤에오는 값의 대상이 비어있다면 true, 비어있지 않다면 false--%>
<%--message라는 이름으로 전달된 내용이 있는지 추출--%>
<%--여기서는 논리부정(!)연산자가 같이 쓰였음에 주목할 것--%>
전달된 메시지의 존재 여부 : ${ !empty param.message }<hr>
전달된 메시지의 내용은 ${param.message} 입니다.<br>
전달된 메시지의 내용은 ${param["message"]} 입니다.<br>
<hr>

<%--쿼리문자열로 전달된 내용을 출력하라는 것--%>
전달된 메시지의 내용은 <%= request.getParameter("message") %> 입니다.<br>
</body>
</html>