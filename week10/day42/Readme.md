# 개인 학습 내용

## Spring MVC & `<form>`

### 예제1

```java
package com.example.springedu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.springedu.domain.UserVO;

@Controller 
public class UserController {

	@ModelAttribute("popularFruit") 
	public String[] refPopularFruit() {
		System.out.println("popularFruit 명으로 보관될 문자열 배열객체 생성과 보관");
		return new String[] { "망고", "멜론", "수박", "참외" };
	}
    
	@RequestMapping(value = "/userForm", method = RequestMethod.GET) 
	public String userForm() {
		System.out.println("----- UserController.userForm() : GET -----");
		return "userForm";  
	}

	@RequestMapping(value = "/userSave", method = RequestMethod.POST)
	public String userSave(UserVO userVo, Model model) {
		System.out.println("----- UserController.userSave() : POST -----");
		System.out.println("userInfo : " + userVo.toString());
		model.addAttribute("msg", "SUCCESS");  
		return "userInfo";  
	}
}
```

- `@RequestMapping(value= "/userForm", method = RequestMethod.GET)`
  -  `http://localhost:8088/userForm` 를 브라우저에 직접 입력하는 것은 `GET`방식의 요청임
  - userForm() 메서드는 `/userForm` 경로로 GET 요청이 들어왔을 때 userForm 메서드가 호출되도록 함.


```html
<!--userForm.html-->
<form action="/userSave" method="post">
```

action: 전송될 데이터가 전달될 URL<BR>
method: 전송 방식을 지정하는 방식<br>


## 스코프

### request scope

- 웹 브라우저로부터 WAS가 요청을 받은 후, forward 되는 동안 유지하고 싶은 정보가 있는 경우
request scope를 사용함

- http request를 WAS가 받아서 웹 브라우저에게 응답할 때까지 변수값을 유지하고자 할 경우 사용함

- 서블릿에서는 HttpServletRequest 객체를 사용함
- JSP에서는 request 내장 변수를 사용함
- forward 하기전에 request 객체의 setAttribute() 메서드로 값을 설정한 다음
서블릿이나 JSP에게 결과를 전달하여 값을 출력하도록 하면 포워드 되는 동안 값이 유지된다.
<BR> => 이것은 Request Scope를 이용했다고 볼 수 있다


### Session scope

- 접속한 웹 브라우저별로 정보 및 변수를 관리하고 싶을 경우에 사용

- 웹 브라우저간의 탭간에는 세션정보가 공유되므로 각각의 탭에서는 같은 세션정보를 사용할 수 있음
- HttpSession 인터페이스를 구현한 객체를 사용함
- JSP에서는 session 내장 변수를 사용함
- 서블릿에서는 HttpServletRequest의 getSession() 메서드를 이용하여 session 객체를 얻음
- 값을 저장할 때에는 `setAttribte()` 메서드를 사용함
- 값을 읽어 들일 때에는 session 객체의 `getAttribute()` 메서드를 사용함
- 장바구니와 같이 사용자별로 유지가 되어야 할 정보가 존재하는 경우 사용함


<br>

## session

- `#` 기호 없이 사용할 수 있는 내장 객체
- session이라는 이름으로 보관된 객체는 hash map 객체임

```html
<h3>Objects stored in count1 names :
    <span th:text="${ session.count1 } ? '있음' : '없음'"></span>
</h3>
<h3>Objects stored in count2 names :
    <span th:text="${ session.count2 } ? '있음' : '없음'"></span>
</h3>
```
session 뒤에 오는 count1 같은 것들이 map 객체 안에 보관된 객체의 id 값으로 쓰임
<br>
즉, http session 안에서 sesssion 객체 안에 들어있는 count1이라는 이름으로 보관된 객체를 꺼내 달라는 것

<br>

## `@RestController`

- RESTful 웹 서비스를 개발할 때 사용되는 컨트롤러
- JSON, XML 등과 같은 데이터 형식으로 데이터를 반환함
- `@RestController`를 사용하면 메서드가 반환하는 값은 HTTP response 본문에 직접 작성되어 반환됨
<br> => 따라서 별도의 View가 필요하지 않으며, 주로 데이터만을 처리하는 API 개발에 사용됨

<br>

- `@Controller`
  - JSP와 같은 뷰 템플릿을 이용하여 HTML 페이지를 생성하고 반환하는 경우에 사용됨
  - `@Controller`를 사용하면 메서드가 반환하는 값은 View의 이름이 되며, 실제 View는 ViewResolver를 이용해서 찾아지게 됨


<br>

## `@RequestMapping`

- HTTP 요청 메서드(GET, POST, PUT, DELETE 등)에 상관없이 모든 요청에 대해 처리할 수 있는 메서드를 정의할 때 사용됨
- 메서드에서 처리해야 할 URL 경로를 지정할 때는 value 또는 path 속성을 사용함

```java
@RequestMapping(value = "/users/{userId}", method = RequestMethod.GET)
public User getUserById(@PathVariable Long userId){
    User user = userService.getUserById(userId);
    return user;
}
```

<br>


## `@GetMapping`

- HTTP GET 요청에 대해서만 처리할 수 있는 메서드를 정의할 때 사용함
- 따라서 @RequestMapping의 value 또는 path 속성 대신에 URL 경로만을 정의함

```java
@GetMapping("/users{userId}")
public User getUserById(@PathVariable Long userId){
    User user = userService.getUserById(userId);
    return user;
}
```


