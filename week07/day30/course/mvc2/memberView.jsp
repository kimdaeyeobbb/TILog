<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ page import="model.domain.MemberVO" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Insert title here</title>
</head>
<body>
<h2>회원 정보</h2>
<hr>

<%--HttpServletRequest 객체에 담아서 넘김--%>
<%
  MemberVO vo =(MemberVO)request.getAttribute("mem");
%>
<ul>
  <li>회원 이름 : <%= vo.getName() %>
  <li>회원 계정 : <%= vo.getId() %>
  <li>회원 암호 : <%= vo.getPwd() %>
  <li>회원 전화번호 : <%= vo.getPhone() %>
</ul>
<hr>
<ul>

  <%--  scope.뒤에 어디에 보관된 객체를 꺼낼것인지가 명시되어 있음--%>
  <%--  el이 꺼내온 객체는 일반 자바 객체--%>
  <%--  .name을 이용해서 getName을 꺼내옴--%>
  <%--  mem.id => getid--%>
  <%--  mem.pwd => getPwd--%>
  <%--  mem.phone => getPhone--%>
  <%--  프러퍼티명 -> getter 메서드의 get을 뺀 나머지를 소문자로 바꾼 것--%>
  <%--  첫글자는 반드시 소문자로 바꿈--%>
  <li>회원 이름 : ${requestScope.mem.name}
  <li>회원 계정 : ${requestScope.mem.id}
  <li>회원 암호 : ${requestScope.mem.pwd}
  <li>회원 전화번호 : ${requestScope.mem.phone}
</ul>
<hr>
<ul>
  <li>회원 이름 : ${mem.name}
  <li>회원 계정 : ${mem.id}
  <li>회원 암호 : ${mem.pwd}
  <li>회원 전화번호 : ${mem.phone}
</ul>
<hr>
<a href='<%= request.getHeader("referer") %>' style='text-decoration:none'>입력폼으로</a>
</body>
</html>



