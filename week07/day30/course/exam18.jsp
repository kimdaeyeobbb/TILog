<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EL 테스트</title>
</head>
<body>
<h2>EL 변수</h2>
<hr>
<%--EL은 변수가 없었다고해서 에러가 나지 않음. 없으면 없는 대로 넘어감--%>
name 변수의 값 : ${name}<br>

<%--얘가 우리가 알고있는 '변수'. 듀크라는 이름으로 초기화되어 있음--%>
<% String name="듀크"; %>
name 변수의 값(표현식 태그) : <%= name %><br>

<%--EL로 출력하려고하니까 출력이 안됨--%>
<%--EL에서의 변수는 일반변수가 아니라 어딘가에 보관되어있는 객체의 이름임--%>
<%--name이라는 이름으로 보관된 객체를 찾아서 출력하라는 것--%>
name 변수의 값(EL) : ${name}<br>
<% pageContext.setAttribute("name", "자바");  %>
name 변수의 값 : ${name}<br>
pageScope.name 변수의 값 : ${pageScope.name}<br>
<hr>
<% pageContext.setAttribute("number", 100); %>
number 변수의 값 : ${number}<br>
pageScope.number 변수의 값 : ${pageScope.number}<br>
number 변수의 값에 23을 더한 값 : ${ number + 23 }
</body>
</html>