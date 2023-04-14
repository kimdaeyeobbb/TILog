<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>forward 액션 태그를 이용한 분기 예제  </title>
</head>
<body>
<% if(request.getParameter("type")==null || 
           request.getParameter("type").equals("admin") ){ %>

<%--태그로 forward 기능 수행--%>
<%--jsp에게 쿼리문자열을 뭘 주는지 혹은 주지 않는지에 따라 포워드가 일어나는 행위가 달라짐--%>
  <jsp:forward page="adminPage.jsp">

<%--    param을 이용해서 파라미터를 전달--%>
<%--    param을 이용해서 포워드 될 대상에게 name & value쌍을 전달할 수 있음--%>
  <jsp:param name="message" value="Hi! Administrator" />
  </jsp:forward>
<% } else  {%>
  <jsp:forward page="userPage.jsp">
  <jsp:param name="message" value="Hi! User" />
  </jsp:forward>
<%} %> 
</body>
</html>
