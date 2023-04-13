<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"  trimDirectiveWhitespaces="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP 학습</title>
</head>
<body>
<h2>선언문 태그 학습</h2>
<hr>

<%--웹 서버를 만들고자 하면 JSP에서는 반드시 선언문 태그 내에 작성해야 함--%>
<%--JSP를 브라우저에서 URL입력해서 직접 요청하는 것 -> GET방식--%>
<%--FORM 태그를 가지고 요청하는데 POST일 경우에만 POST 방식--%>
<%--JSP는 GET, POST 모두를 지원함--%>
<%--서비스 메서드가 오버라이딩 됨 -> GET/POST를 구분하지 않겠다는 것--%>
<%--JSP는 기본적으로 요청 방식을 구분하지 않는다--%>
<%--선언문 태그 내의 자바 코드는 서블릿의 멤버가 됨. --%>

<%!
	char getKorDay() {
	    char result=' ';
		int day = new java.util.GregorianCalendar().get(java.util.Calendar.DAY_OF_WEEK);
		switch(day) {
		case 1 : result = '일'; break;
		case 2 : result = '월'; break;
		case 3 : result = '화'; break;
		case 4 : result = '수'; break;
		case 5 : result = '목'; break;
		case 6 : result = '금'; break;
		case 7 : result = '토'; 
		}
	    return result;	
   }
%>

<%--이자리에 결과가 출력되도록 표현식 태그 사용--%>
<h2>오늘은 <%=  getKorDay() %>요일입니다.</h2>
<h3>오늘은 <%=  getKorDay() %>요일입니다.</h3>
<h4>오늘은 <%=  getKorDay() %>요일입니다.</h4>
</body>
</html>















