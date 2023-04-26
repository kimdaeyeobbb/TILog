# Spring MVC

## RequestMapping

- GET 방식만 지원하는 컨트롤러 메서드

```java
@RequestMapping(value="/select1.do", method=RequestMethod.GET) 
public String select() { }
```



- POST 방식만 지원하는 컨트롤러 메서드 

```java
@RequestMapping(value="/insert1.do", method=RequestMethod.POST) 
public String insert() { }
```


## @PathVariable

- URL의 특정부분을 변수화하는 기능을 지원함

```java
@RestController
public class HomeController {
    @RequestMapping("/{name}")
    public String home(@PathVariable String name) {
        return "Hello, " + name;
    }
}
```
`/`뒤에 전달된 내용을 (쿼리문자열이 아닌) 요청 path에 담긴 문자열을 전달 받겠다는 것
<br>


```java
/board/list_controller/1/test/듀크 
@RequestMapping(value="/board/list_controller/{currentPage}/test/{name}")
public String getAllBoards(@PathVariable(value="currentPage") int currentPage,
    @PathVariable(value="name") String name, Model model){
    :
    return "view페이지";
}
```

3번쨰 path(currentPage)와 5번쨰 path(name)동적 path 이므로 뭐가 오든 상관없다는 것<br>
동적 path를 매개변수에 사용함


## @RestController

- `@Controller`를 상속하여  `@Controller`과 `@ResponseBody`를 합쳐놓은 것
- response body를 붙여야하는 경우가 있다면 `@Controller`를 사용해야 함
- 메서드마다 responsebody annotation주는것이나, 클래스에 @RestController 지정하는 것은 동일함


## @RequestBody

- POST 방식일 때 클라이언트에게서 전송되는 요청 파라미터를 스프링이 알아서 파싱해서 전달해주지만,
컨트롤러 메서드에서 RequestBody를 내가 원하는 대로받기 위해 사용
- `@RequestBody` 설정시, post 방식일때 name value쌍으로 전달받음

- 컨트롤러 메서드의 헤더
```java
String test2(@RequestBody String param) 
PersonVO test3(@RequestBody PersonVO vo)
// PersonVO 객체를 통해 RequestBody를 받겠다는 것        
        
Map test4(@RequestBody Map<String,String> map) 
// Map 객체로 Reqeust body를 받겠다는 것
```

-  @RequestBody를 지정해주면 원하는 형식으로 읽을 수 있음

<br>

## log API

- log API를 사용하면 남기고 싶은 메시지가 어떤 메시지인지 (에러 메시지인지, 디버그용 메시지인지, 정보를 제공하기 위한 메시지인지에 따라 log가 나뉨)
에 대한 정보를 제공하는 메서드

### log4j

- log4j가 대중적임 (보안에 치명적)
    - 일정버전 이상만 사용해야 함
    - log4j는 log4j version1임
    - 해커들이 남아있는 정보를 가지고 DB에 침범할 수 있음


### LogBack

- log4j 이후에 등장
- 스프링부트가 채택


### log4j2

- log4j의 version2