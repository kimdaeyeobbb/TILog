<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP 학습</title>
</head>
<body>
<!--  HTML 주석 태그입니다. <%= java.time.LocalTime.now() %> -->
<%--실행결과가 브라우저에게 전송되면 브라우저가 얘를 무시함--%>
<%--HTML 파서가 HTML주석으로 된 애를 무시함--%>


<h2>JSP의 멤버 변수와 지역 변수</h2>
<hr>

<%--JSP는 서블릿으로 변환됨. 한번 객체 생성되면 그 객체는 서버가 죽거나 리로드될떄까지 계속 쓰임--%>
<%--따라서 멤버변수는 객체상태를 계속 유지하고 있는것임--%>
<%--세션객체는 일정시간이상 요청하지 않으면 사라짐. --%>
<%--서블릿 객체는 이와달리 서버가 유지되는 동안은 계쏙 존재함--%>
<%! int member_v = 0; // 멤버변수 선언%> <%-- 선언문태그 --%>
<% int local_v = 0;  /* 지역변수 선언 */%> <%-- 수행문태그 --%>
<%
	member_v++;
    local_v++;
%>
<h3>member_v : <%= member_v %></h3> 
<h3>local_v : <%= local_v %></h3>
<%-- <h3>이부분은 출력되지 않아요 : <%= local_v+member_v %></h3> --%>
<%-- 위의 코드는 jsp의 주석으로 묶인 내용이므로 무시됨--%>
<%--JSP 고유 주석이므로 자스퍼가 무시함.--%>

</body>
</html>








