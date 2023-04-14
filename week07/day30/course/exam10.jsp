<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.Date"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP의 내장 객체들</title>
</head>
<body>
<h2>JSP의 내장 객체들 점검</h2>
[ request ]<br>

<%--요청 방식 체크할 때 사용--%>
getMethod() : <%=  request.getMethod()  %><br>

<%--uri부분만 추출할 때 사용하는 메서드--%>
getRequestURI() : <%=  request.getRequestURI()  %><br>

<%--자바스크립트에서 이를 다룬 예제가 있음. 클라이언트가 어떤 환경 (모바일 등)인지 등 브라우저가 어떤 환경인지 서버에게 알림--%>
getHeader("user-agent") : <%=  request.getHeader("user-agent")  %><br>

<%--내장객체 변수명 - application => 서블릿 컨텍스트 객체. 하나의 웹 프로젝트. 하나의 컨텍스트를 뜻함 --%>
[ application ]<br>
getContextPath() : <%=  application.getContextPath()  %><br>
getServletContextName() : <%=  application.getServletContextName()  %><br>

<%--서버의 이름을 얻어냄--%>
getServerInfo() : <%=  application.getServerInfo()  %><br>

<%--서버가 지원하는 서블릿의 메이저 버전이 몇버전인지 알려줌 -> 지금은 버전 4--%>
getMajorVersion() : <%=  application.getMajorVersion()  %><br>

<%--컨텍스트 환경에서 사용하는 세션 타임아웃. 클라이언트가 마지막으로 요청하고 나서 어느정도 시간이 지나고도 요청을 또 하지 않으면(기본: 30분) 세션이 자동 종료--%>
getSessionTimeout() : <%=  application.getSessionTimeout()  %><br>


[ session ]<br>
getId() : <%=  session.getId()  %><br>
getCreationTime() : <%=  new Date(session.getCreationTime())  %><br>


[ response ]<br>

<%--200이 디폴트--%>
getStatus() : <%=  response.getStatus() %><br>

<%--기본으로 서버가 클라이언트를 출력할 떄 사용하는 것이 8kbyte--%>
getBufferSize() : <%=  response.getBufferSize() %><br>
getContentType() : <%=  response.getContentType() %>
<H4>Web Application(/edu) 디렉토리의 파일 리스트 </H4>


<%--webapp 폴더가 최상위 폴더임. 실행결과를 보면 webapp 폴더의 파일리스트가 보여짐--%>
<%--우리가 테스트하는 edu라는 웹 프로젝트에서 톰캣이 edu를 바라봤을 때 인식하는 최상위 폴더는 webapp임--%>
<%--first.html은 우리가 만들녀석임. getResourcePaths("/")하면 톰캣이 edu라는 플젝에서 최상위 폴더에 대한 정보를 리턴함. 내부의 파일 리스트를 추출--%>
<%
java.util.Set<String> list = application.getResourcePaths("/");
if (list != null) {
   Object obj[] = list.toArray();
   for(int i=0; i < obj.length; i++) {
      out.print(obj[i]+", ");
//      jsp에 out객체가 존재
   }
}
%>
</body>
</html>