<%--다음 결과가 출력되도록 success.jsp 를 생성한다.
(CSS 를 이용하여 다양하게 효과를 준다)
“xx시 xx분에 당첨!! 추카추카”
축하이미지 출력--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
    <style>
        p{
            font-size: 100px;
            color: blue;
        }
    </style>
</head>
<body>
<div>
    <p>${ curTime.hour }시 ${ curTime.minute }분에 당첨!! 추카추카~~</p>
    <img src="/mvc/images/success.png"><br>
</div>
</body>
</html>