# Spring REST API

## REST

- `RE`presentatinal `S`tate `T`ransfer
- 과거 웹(HTTP) 설계의 우수성에 비해 제대로 사용되지 못하였을 때, 웹의 장점을 최대한 활용하기 위한 아키텍처로서 `REST`가 등장 (웹 기반의 처리 구조)
- 자원을 정의하고 자원에 대한 주소를 지정하는 전반적인 방법인 `네트워크 아키텍처 원리`의 모음
- Client와 Server 사이의 통신 방식
- `웹의 기존 기술과 HTTP 프로토콜을 그대로 활용`하므로 `웹의 장점을 최대한 활용`할 수 있는 아키텍처 스타일
- 자원 기반의 주소 (ROA, Resource Oriented Architecture) 설계의 중심에 Resource가 있고 HTTP method를 통해 Resource를 처리하도록 설계된 아키텍처

- 웹 사이트의 이미지, 텍스트, DB 내용 등 모든 자원에 고유한 ID인 HTTP URI를 부여함

| CRUD   | Operation |
|:-------|:----------|
| Create | POST (생성) |
| Read   | GET (조회)  |
| Update | PUT (수정)  |
|Partial Update| PATCH (부분 수정)|
|Delete| DELETE (삭제)|
|HEAD| header 정보 조회 (HEAD)|

- 즉 REST란, `자원을 표현하는 이름으로 구분하여 해당 자원의 상태를 주고 받는 모든 것`을 뜻함

![img.png](img.png)

- 4개의 URL은 모두 같으나 get,post,put인지 등에 따라 여떠한 방식의 요청을 하는지가 달라짐


### RESTful
- 필딩의 REST의 원리를 따르는 시스템

<br>

### REST는 왜 필요한가?

- 애플리케이션의 분리 및 통합
- 웹을 기반으로 하는 C&S환경의 다양한 프로그램 개발
- 다양한 클라이언트의 등장 (스마트폰 등)

![img_1.png](img_1.png)

- 웹 기반의 통신을 할 경우 REST를 사용하는 것이 좋다
- 요기요, 배달의 민족등은 웹앱으로 구현
  - 필요한 부분만 받아서 사용함을 알 수 있음 -> REST


<br>

### REST의 특징

#### :one: Server-Client (서버-클라이언트 구조)

- `Server`: 자원이 있는 쪽
- `REST Server`: API를 제공하고 비즈니스 로직 처리 및 저장을 책임짐
- `Client`
    - 자원을 요청하는 쪽
    - 사용자 인증 및 context(세션, 로그인 정보)등을 직접 관리하고 책임짐


#### :two: Stateless (무상태)

- HTTP 프로토콜은 stateless 프로토콜이므로 REST 또한 무상태성을 가짐
- `Client`의 context를 서버에 저장하지 않음
<br> (세션과 쿠키와 같은 context 정보를 신경쓰지 않아도 되므로 구현이 단순해짐)
- `Server`는 각각의 요청을 완전히 별개의 것으로 인식하고 처리함
  - 각 API 서버는 클라이언트의 요청만을 처리함
  <BR> (이전 요청이 다음 요청의 처리에 관련되어서는 안됨. 단, 이전 요청이 DB를 수정하여 DB에 의해 바뀌는 것은 허용함)
  - 서버의 처리방식에 일관성을 부여하므로 부담이 줄어들고 서비스의 자유도가 높아짐


#### :three: Cacheable (캐시 처리 기능)

- 웹 표준 HTTP protocol을 그대로 사용하므로 웹에서 사용하는 기존의 인프라를 그대로 활용할 수 있음
<br> (HTTP가 가진 가장 강력한 특징 중 하나인 캐싱 기능을 적용할 수 있음)
  - HTTP protocol 표준에서 사용하는 Last-Modified 태그나 E-Tag를 이용하면 캐싱 구현이 가능함


- 대량의 요청을 효율적으로 처리하기 위해 캐시가 요구됨
- 캐시 사용을 통해 응답시간이 빨라지고 REST Server 트랜잭션이 발생하지 않기 때문에 전체 응답시간, 성능, 서버의 자원 이용률을 향상시킬 수 있음

<br>


#### :four: Layered System (계층화)

- 클라이언트는 REST API Server만 호출함
- REST Server는 다중 계층으로 구성될 수 있음
  - API Server는 순수 비즈니스 로직을 수행하고 그 앞단에 보안, 로드밸런싱, 암호화, 사용자 인증 등을 추가하여 구조상의 유연성을 줄 수 있음
  - 또한 로그밸런싱, 공유 캐시 등을 통해 확장성과 보안성을 향상시킬 수 있음

- PROXY, 게이트웨이 같은 네트워크 기반의 중간 매체를 사용할 수 있음


#### :five: Code-On-Demand (optional)

- 서버로부터 스크립트를 받아서 클라이언트에서 실행함
- 자바스크립트 코드가 전달되어 사용됨
- 반드시 충족할 필요는 없음

#### :six: Uniform Interface (인터페이스 일관성)

- URI로 지정한 Resource에 대한 조작을 통일되고 한정적인 인터페이스로 수행
- HTTP 표준 프로토콜에 따르는 모든 플랫폼에서 사용이 가능함
- 특정 언어나 기술에 종속되지 않음


1. 리소스가 URI로 식별되게 함
2. 리소스를 만들거나 업데이트를 하거나 삭제를 할 때 등 REST Message에 표현을 담아서 전송하고 처리함 <br> (representation 전송을 통한 resource 조작)
3. Self-descriptive message (자체 표현 구조)


<br>


## Talend 실습

![img_2.png](img_2.png)

- 응답내용
  - `안녕하세요?`
- desciption
  - url에 대한정보
- response header
  - default값이 text/plain
  - html을 html로 처리하기를 원한다면 설정을 바꾸어야 함
- content-length
  - 바이트수. 문자하나가 2바이트. (안+녕+하+세+요+? = 16 바이트)
- 응답 상태코드를 바꾸고 싶거나 응답 헤더에 뭔가를 추가하고 싶으면 `response entity`를 사용할 것


- 컨트롤러가 클라이언트로부터 요청 받을 떄 데이터를 받는 방법
  - 쿼리문자열로 받기
  - request path로 받기 (path variable)
  ```java
    @GetMapping(value = "/var1/{variable}")   // path variable이용해서 지정한 내용 테스트
    public String getVariable1(@PathVariable String variable) {
        log.info("@PathVariable을 통해 들어온 값 : {}", variable);
        return variable;
    }
  
  // http://localhost:8088/restapi/var1/danny 꼴로 확인
  ```
  


