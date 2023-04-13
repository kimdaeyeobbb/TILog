<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP 학습</title>    
</head>
<body>
<h2>include 지시자 태그 테스트</h2>
<hr>
<%--f - fragment--%>
<%--여러 JSP에 공통으로 들어가는 코드부분을 따로 구현하면 번거로우므로 독립된 파일로 만들어놓고 끌어오도록 하고싶음 -> 확장자를 jspf로 사용하도록 권장--%>
<%--이를 보고 다른 부분의 조각임을 알 수 있음--%>
<%--include를 사용한 위치에 포함시킴--%>
<%--JSP로서 구문에 위배되지 않는다면 뭐든 포함할 수 있음--%>
<%--JSP 안에 서블릿 소스를 포함하면 안됨. -> 또 서블릿 소스로 들어가야하므로 말이 안됨--%>
<%@  include  file="part1.jspf"  %>
<hr>
<%@  include  file="part2.jspf"  %>
<hr>
<h3>이 페이지에서 직접 출력하는 내용입니다.</h3>
</body>
</html>