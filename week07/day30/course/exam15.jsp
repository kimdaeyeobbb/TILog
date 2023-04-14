<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<!DOCTYpE html>
<html>
<head>
<meta charset="UTF-8">
<title>include 액션태그 예제</title>
<%--   greeting.jsp 결과가 여기에 담겨져서 나올 것임 --%>
<%--   액션 태그를 사용해서 독립적으로 실행시키고 결과만 넘겨줌--%>
</head>
<body>
<h3>include 액션태그 예제</h3>
<h4>각 나라의 감사 인사말입니다.</h4>
<p>
한국어 : 
<jsp:include page="greeting.jsp">
   <jsp:param name="country" value="korea" />
</jsp:include>
</p>
<p>
영어 :
<jsp:include page="greeting.jsp">
   <jsp:param name="country" value="english" />
</jsp:include>
</p>
<p>
일본어 :
<jsp:include page="greeting.jsp">
   <jsp:param name="country" value="japan" />
</jsp:include>
</p>
</body>
</html>