# Thymeleaf

- JSP를 대신하며 조금 더 HTML 친화적임

- Thymeleaf 파일은 일반 HTML 파일과 다를 것이 없음
  - 원하는 HTML 태그에 `th` 라는 prefix를 사용하기 위해 최상위 태그인 `<HTML>` 태그에 정해진 네임스페이스만 추가하면됨

- `th` 속성을 사용해서 간단하게 텍스트 값을 출력하는 예시
```html
<!DOCTYPE HTML>
<HTML xmlns:th="http://www.Thymeleaf.org"> 
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
    <p><span th:text="${say}">Hi</span>Thymeleaf</p>
</body>
</HTML>
```

## Thymeleaf vs JSP

- Thymeleaf
    - `th:value`에 의해 추출되는 값이 있으면 그 값이 출력되고, 추출된 값이 없다면 unico가 출력됨

```html
<input type="text" name="userName" value="unico" th:value="${user.name}">
```


- JSP
```html
<input type="text" name="userName" value="${user.name}">
```


## Thymeleaf 문법

- 단지 컨트롤러가 수행한 결과를 받아서 사용자에게 보여주는것에 특화됨 => 이러한 부분을 정의하고 있음


- Spring EL
  - Spring Expression Language
  - 런타임시 메서드 호출 및 기본 문자열 템플릿 등의 기능을 제공함
  - JSP EL과 유사


### :one: ${...} 표현식

- 변수 표현식
- EL변수를 뜻함 (그냥 변수와 다름)
  - 변수이름으로 표현되는 객체를 꺼내서 표현함
  - 객체이름을 주면됨
  - `${msg}`: msg라는 이름으로 표현되는 객체를 꺼내어 표현

- 호출하고 싶은 getter 메서드의 property명을 추가할 수 있ㅇ므

- `th:속성명`으로 시작되는 곳에서만 사용해야 함

- 기존표현: `<img src="...">` 
  - 컨트롤러가 정하는 것을 동적으로 표현하기 위해 `<img th:src="${...}>`꼴로 나타남
  - `<img th:src="@{...}">`


- 기존표현: `<a href="...">` 
  - 컨트롤러에서 보관하고 있는 페이지의 링크를 그때그때 나타내기 위해 `<a th:href="@{...}">`


### :two: @{...} 표현식

- URL 표현식

- 앞에 `/context path`를 만들어서 붙여줌

- @{...} 표현식은 서버의 contextPath를 추가한 URI로 변경됨


- @{/}
  - "/contextPath/"


- @{/images/1.png}
  - "/contextPath/images/1.png"



- `@{/vdelete(id=${vo.id})}`
  - "/contextPath/vdelete?id=2"
  - getId를 호출하라는 것



### :three: 문자 합치기

- 합치고 싶은 문자열을 "|" 으로 감싸거나 + 연산자를 이용해 문자를 합칠 수 있음

```html
<div th:text="|My name is ${info.name} !! |"></div>
```


```html
<div th:text="'My name is '+ ${info.name} + ' !! '"></div>
```

### :four: 비교 연산자

- thymeleaf의 속성값으로 표현식을 나타냄
- 비교 연산식의 결과를 출력

```html
<!-- 이항 연산자 -->
<!--info 라는 이름으로 전달된 도메인 객체의 name이 kim이 아니면 true, kim이면 false 출력-->
<div th:text="${info.name != 'kim'}"></div> 
<!--get age의 결과가 30이상이면 true, 아니면 false가 출력-->
<div th:text="${info.age >= 30}"></div>

<!-- 삼항 연산자 -->
<!--name이 kim이면 ok 아니면 no를 출력-->
<div th:text="${info.name == 'kim' ? 'ok' : 'no'}"></div>
```


### :five: HTML 태그의 content 설정


- `th:text`

```html
<div th:text="${info.name}">유니코</div>
```



### :six: HTML 태그의 value 속성의 값 설정 - th:value


```html
<input type='text' th:value="${info.name}" value="둘리" >
```


### :seven: th:if, th:unless


- 조건을 확인하여 참이면`<th:if>` 그리고 거짓이면 `<th:unless>` 컨텐트를 표현함

```html
<p th:if="${info.age > 18}">입장 가능</p>
<p th:unless="${info.age <= 18}">입장 가능</p>

<!--p태그와 hr태그들을 묶는 부모 태그를 만들어서 거기에 if속성을 작성-->
<!--부모 태그가 필요하지 않을 때에 블록 태그를 사용함-->
<!--조건이 참이면 블록 태그 내용을 랜더링-->
<!--html의 block이 아닌 thymeleaf에서 제공하는 태그-->
<th:block th:if="${info.age > 18}"><hr><p>입장 가능</p><hr></th:block>
<th:block th:unless="${info.age <= 18}"><hr><p>입장 가능</p><hr></th:block>
```

### :eight: th:switch, th:case

- th:case 속성에 지정된 값과 동일한 서브 태그를 표현함

```html
<th:block th:switch="${info.name}">
    <div th:case="올라프">겨울왕국</div>
    <div th:case="또치">아기공룡둘리</div>
</th:block>
```

### :nine: th:each

- for 반복문과 같은 기능 수행
- each 속성에 의해 몇번 반복되는지를 결정
- each 태그는 block 태그로 묶어서 서브 태그가 몇번 반복될지를 결정 (반드시 block태그와 each 태그를 같이 써야하는것은 아님)
```html
<th:block th:each="data:${datas}">
  <h1 th:text="${data}"></h1>
</th:block>
```



- 변수명 앞에 status 변수를 추가해 row에 대한 추가정보를 얻을 수 있음
  - data처럼 변수명 하나만 주면 를 받겠다는 것
  - data, status처럼 변수명 2개주면 뒤에는 status 객체를 주겠다는 것

```html
<th:block th:each="data,status:${datas}">
    <h1 th:text="|${status.count} ${data}|"></h1>
</th:block>
```


### :one::zero: 링크될 대상 URL : th:href="@{}"

- 쿼리문자열 구성시 용이
- context path 구성시 용이

```html
<a th:href="@{/vdelete(id=${vo.id})}">
```


### :one::one: th:with="${}"

- 컨트롤러가 보내온 객체의 이름이 길때 특정이름으로 바꾸는데 사용

- 변수형태의 값을 재정의하는 속성
- `th:with`를 이용하여 새로운 변수값을 생성할 수 있음

```html
<div th:with=”userId=${number}” th:text=”${usesrId}”>
```


#### Thymeleaf 문법 사용 예시

```html
<!--list라는 이름으로 모델 객체가 전달된 경우 아래의 내용을 처리하곘다는 것-->
<th:block th:if="${ list }" >
    <h1 onclick="location.href='/meeting'">미팅 스케쥴</h1> 
    <hr>
    <table>
<!--    tr태그에 each 속성 사용 -> tr이 끝나는 지점까지 반복-->
        <tr th:each="vo : ${list}">
            <td th:class="${vo.id}">[[${ vo.name }]]</td>
            <td th:class="${vo.id}" th:onclick="|displayReply(${vo.id})|" >[[${ vo.title }]]</td>
            <td th:class="${vo.id}">[[${ vo.meetingDate }]]</td>
            <td><a th:href ="@{/meeting/delete(id=${vo.id})}"><img src = "/images/delete.png" width ='20'></a></td>
            <td><img th:onclick="|displayUpdateForm(${vo.id})|" src="/images/edit.png" width ='20'></td>
            <td><img th:onclick="|insertReply(${vo.id})|" src="/images/comment.png" width ='25'></td>
        </tr>
    </table> 
</th:block>
```


<br>

## StringBuffer vs StringBuilder

- 문자열을 편집할 때 사용
- API 사용 방법: 거의 동일


- StringBuffer
  - ThreadSafe (다중스레드에 대비가 되어있음)


- StringBuilder
  - ThreadUnsafe ()


- 페이지 소스보기 -> 서버단에서 처리된 결과가 남아있음

<br>


## 컨트롤러 메서드의 리턴 타입

### @RequestBody & @ResponseBody

#### @RequestBody

- HTTP request body를 전달 방식 그대로 또는 자바 객체로 변환하여 전달받는 데 사용함

```java
String test2(@RequestBody String param) 
PersonVO test3(@RequestBody PersonVO vo)
Map test4(@RequestBody Map<String,String> map
```


#### @ResponseBody

- `@ResponseBody`를 이용하면 자바 객체를 HTTP response body로 전송할 수 있음
- 이 때는 view를 거치지 않고 컨트롤러가 직접 응답하므로 응답 형식을 설정해야 함

```java
@RequestMapping(value = "/body/json/{id}", produces = "application/json; charset=utf-8") 
@RequestMapping(value = "/body/xml/{id}", produces = "text/xml; charset=utf-8")
```