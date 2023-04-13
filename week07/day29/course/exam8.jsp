<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"  errorPage="errorPage.jsp"%>

<%--페이지 지시자 태그를 이용해서 에러 페이지를 지정.--%>
<%--에러가 발생하면 에러 페이지가 대신 응답하게끔 만듦--%>
<%--errorPage.jsp -> 에러 페이지를 내보내는 전용 JSP--%>
<%--해당 페이지 내에서는 exception이라는 내장 객체를 사용할 수 있음--%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>errorPage 속성 테스트</h2>
<hr>

에러메시지는 개발자에게는 필요하지만 일반 사용자에게는 보이면 좋지 않음

<%
     String name = request.getParameter("guestName"); 
%>
<h3>당신의 이름은 <%= name %> 이고 이름의 길이는
           <%= name.length() %> 입니다.</h3>

<%--name.length부분에서 null이 들어와서 에러 발생--%>

</body>
</html>















