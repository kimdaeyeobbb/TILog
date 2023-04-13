<%--페이지 지시자 태그--%>
<%--contentType이 중요, language => 서버상에서 수행되는 코드. default가 자바--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP 테스트</title>
</head>
<body>

<%-- JSP를 구성 하는 코드 중 서버상에서 수행되지 않고 클라이언트에게 그냥 전송되는 코드 이므로 정적 컨텐츠--%>
<h1>첫 번째 JSP 태스트 예제</h1>
<%-- JSP를 구성 하는 코드 중 서버상에서 수행되지 않고 클라이언트에게 그냥 전송되는 코드 이므로 정적 컨텐츠--%>
<hr>

<%-- <%= %>java.,time.LocalDate.now() %> => 서버에서 수행해야할 컨텐츠 이므로 동적 컨텐츠. 표현식 태그임. 내부의 식을 수행하고 결과를 이 자리에 출력 --%>
<h3>오늘 날짜 : <%= java.time.LocalDate.now() %></h3>
</body>
</html>