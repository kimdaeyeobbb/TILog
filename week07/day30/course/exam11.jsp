<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>요청 방식에 따른 처리</title>
<style>
	input {
		margin : 3px;
	}
</style>
</head>
<body>
<%--요청방식 체크--%>
<%--jsp는 get,post 방식 둘다 지원함--%>
<%--request.getMethod() 메서드를 이용해서 클라이언트가 요청해온 방식을 체크--%>
<%--비교할 때에는 대문자로 비교해야함--%>

<%--서버단에서 처리해야하는 동적인 코드는 수행문 코드(%사용)로 작성함--%>
	<% if (request.getMethod().equals("GET")) { %>
		<h2>원하는 컬러와 날짜를 선택하세요</h2>
		<form method="post" action="/edu/jspexam/exam11.jsp">
			칼라 : <input type="color"  name="fcolor" ><br>
			날짜 : <input type="date"  name="fdate"><br>
			<input type="submit" value="전송">
		</form>
	<% } else { %>
<%--script부분은 브라우저에게 전송되어 브라우저에서 수행되는 클라이언트 사이드 코드임--%>
			<script>
<%--			jsp의표현식 태그를 이용해서 fcolor를 가져와서 칼라정보를 넣어줌--%>
<%--표현식 태그는 인용부호 내에서도 사용할 수 있음--%>
<%--표현식 태그가 쓰인 부분은 브라우저에서 확인해보면 코드가 바뀌어 있으므로 '소스보기'를 이용해서 변한것을 확인해볼 것 --%>
				document.body.style.backgroundColor = '<%= request.getParameter("fcolor") %>';
			</script>
			<h2>선택 날짜는 <%= request.getParameter("fdate") %> 이네요..</h2>
	<% } %>
</body>
</html>