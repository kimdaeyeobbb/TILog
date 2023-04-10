<%@ page language="java" contentType="application/json; charset=UTF-8"%>
<%--json 형식으로 전달--%>
<% String news[] = { "뉴스이야기1",
		"뉴스이야기2",
		"뉴스이야기3",
  	    "뉴스이야기4",
		"뉴스이야기5",
		"뉴스이야기6",
		"뉴스이야기7"}; %>
<% response.setHeader("Cache-Control", "no-cache"); %>
<% int num = (int)(Math.random() * 7);%>

<%--실제 응답된 내용--%>
{ 
	"news" : "<%= news[num] %>"
}