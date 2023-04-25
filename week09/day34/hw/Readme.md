# 과제 리뷰

- EduController.java

```java
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EduController {
    @RequestMapping(value = "/educontroller", method = RequestMethod.POST)
    public String myPost(int avgScore){ // 리턴타입 String -> 뷰이름만 리턴
        // 컨트롤러가 전달한 뷰 객체가 따로 없으므로 무조건적으로 modelAndView를 쓸필요가 없음
        String viewName;
       
        if (avgScore>= 90){
            viewName = "gradeA";
        } else if (avgScore >= 80){
            viewName = "gradeB";
        } else if (avgScore >= 70){
            viewName = "gradeC";
        } else {
            viewName = "gradeD";
        }
        return viewName;
    }
}
```


- gradeA.html

```html
<!DOCTYPE html>
<html lang="ko" xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
    <h1>[[${ (param.name) }]]님은 A등급입니다. 우수한 성적이네요(^^)</h1>
    <a th:href='${#request.getHeader("referer")}'>성적 입력 화면으로</a>
</body>
</html>
```



# 과제리뷰2

- CalcController.java

```java
package com.example.springedu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CalcController {
    @RequestMapping("/calc")  // value 생략하고 매핑정보만 전달
    public ModelAndView proc(int firstNum,
                             String operator,
                             int secondNum){
        ModelAndView mav = new ModelAndView();
        String view;
        
        if (operator.equals("divide") && secondNum == 0){
            view = "errorResult";
            mav.addObject("data", "나눗셈 연산시 두 번째 숫자는 0일 수 없습니다!");
        } else {
            int result;
            if (operator.equals("plus")) result = firstNum+secondNum;
            else if (operator.equals("minus")) result = firstNum-secondNum;
            else if (operator.equals("multiply")) result = firstNum*secondNum;
            else result = firstNum/secondNum;
            view = "calcResult";
            mav.addObject('data', result);
        }
        mav.setViewName(view);
        
    }
}

```


- errorResult.html

```html
<!DOCTYPE html>
<html lang="ko" xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="UTF-8">
    <title>연산 오류</title>
</head>
<body>
<h1>요청을 처리하는 동안 오류가 발생했어요...</h1>
<!--data라는 변수 표현식 사용-->
<h2>오류의 원인: <span style="color:lightpink">[[${data}]]</span></h2>
<a th:href='${#request.getHeader("referer")}'>입력화면</a>
</body>
</html>
```


- calcResult.html

```html
<!DOCTYPE html>
<html lang="ko" xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="UTF-8">
    <title>연산 결과</title>
</head>
<body>
<h1>연산 요쳥 결과</h1>
<hr>
<p>결과 : <span style="color:red">[[${data}]]</span></p>
<a th:href='${#request.getHeader("referer")}'>입력화면</a>
</body>
</html>
```