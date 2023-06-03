# ResponseEntity

- ResponseEntity 선언구조

```java
public class ResponseEntity extends HttpEntity {

  private final Object status;
}

```
Status 만 필드 값으로 가지고 있음<br>
=> 이는 ResponseEntity 에서 직접적으로 Status Code 를 지정할 수 있다는 것을 의미함<br>
=> 나머지 부분은 HttpEntity 에 구현이 되어있는데, 이는 RequestEntity 와 여러 설정들을 공유하기 때문


- HttpEntity 구현부

```java
public class HttpEntity<T> {
    public static final HttpEntity<?> EMPTY = new HttpEntity<>();
  
  
    private final HttpHeaders headers;
  
    @Nullable
    private final T body;
}
```

ResponseEntity 는 HttpEntity 를 상속하여 구현<br>
HttpEntity 에서는 Generic 타입으로 Body 가 될 필드 값을 가질 수 있음<br>
=> Generic 타입으로 인하여 바깥에서 Wrapping 될 타입을 지정할 수 있게 됨
<br>
Wrapping 된 객체들은 자동으로 HTTP 규격에서 Body 에 들어갈 수 있도록 변환이 됨<br>
<br>
또한, 필드 타입으로 HttpHeaders 를 가지고 있는데, 이는 ResponseBody 와 다르게 객체 안에서 Header 를 설정해 줄 수 있음을 암시함


<br>

# Vue

## v-bind

- HTML 속성에 대해 Vue가 관리하는 데이터를 해당 값으로 설정해야하는 경우에는
`v-bind`를 이용하면 됨


## `<script setup>`

- `<script setup>`에서 변수를 사용하기 위해서는 `ref`를 사용해서 변수를 감싸야함
- 이렇게 하면 변수가 reactive 상태가 되어 Vue의 반응성 시스템에 등록됨


<br>

## Vue 프로젝트 파일 구조


- `node_modules`
  - npm으로 설치된 패키지 파일들이 모여있는 디렉토리


- `public`
  - 웹팩을 통해 관리되지 않는 정적 리소스가 모여 있는 디렉토리


- `src/assests`
  - 이미지, css, 폰트 등을 관리하는 디렉토리


- `src/components`
  - Vue 컴포넌트 파일이 모여 있는 디렉토리


- `App.vue`
  - 최상위 컴포넌트


- `main.js`
  - 가장 먼저 실행되는 자바스크립트 파일
  - Vue 인스턴스를 생성하는 역할


- `package.json`
  - 프로젝트에 필요한 package를 정의하고 관리하는 파일


- `package-lock.json`
  - 설치된 package의 dependency 정보를 관리하는 파일


<br>

## Vue Router

```javascript
const routes = [
  {
      path: "/",
    name: "home",
    component: Home
  }
]
```

- path
  - 브라우저에서 접속하는 url 주소


- component
  - 지정된 path로 들어왔을 때 보여줄 vue 컴포넌트
  - 구현한 vue 파일을 연결하고 해당 파일을 실행시킴


<br>

## Lazy Load 적용하기

- Vue CLI를 통해 빌드를 하면 소스 코드가 하나의 파일로 합쳐진다
<br> 큰 프로젝트일 경우, 전체 소스 코드가 하나로 합쳐지면서 파일 용량이 매우 커진다
<br> 이 때문에 사용자가 웹 사이트에 처음 접속할 경우 한번에 큰 파일을 다운로드 받느라 초기 렌더링 시간이 오래걸린다
<br> (페이지가 한번 로드되고 나서는 페이지 전환이 매우 빠르다. 하지만 사용자가 이용하는 페이지가 별로 없다면
사용하지도 않을 전체 페이지 코드를 다운로드 받음으로써 생기는 이점이 없다)


### Lazy Load

- 리소스를 컴포넌트 단위로 분리하여 컴포넌트나 라우트 단위로 필요한 것들만 그때 그때 다운받을 수 있게 하는 방법
- 라우터에서 Lazy Load로 컴포넌트를 import 하는 것은 내부적으로 Vue CLI의 prefetch 기능이 사용되는 것임


#### prefetch

- vue cli에서 prefetch 기본값: `true`

- 미래에 사용될 수 있는 리소스 (비동기 컴포넌트 등)를 캐시에 저장함으로써 
사용자가 접속했을 때 굉장히 빠르게 리소스를 내려줄 수 있음


- 유용하지만 비동기 컴포넌트로 정의된 모든 리소스를 당장 사용하지 않더라도 캐시에 담는 비용이 발생함
  <br>(별도로 분리된 chunk 파일 각각에 대한 request가 일어나고, 각각의 파일을 다운로드 받아서 캐시에 저장함)


- prefetch 기능을 사용하면 request 요청 수가 증가함
<br> (비동기 컴포넌트로 정의된 모든 리소스를 캐시에 담으므로 요청수가 많아지게 됨)


- prefetch 기능을 사용하지 않으면 라우터가 이동될 때마다 해당 라우터에서 필요한 리소스를 그때그때 가져오게 됨
<br> (한번 가져온 리소스는 다시 요청하지 않음)


- 사용자의 접속 빈도가 낮은 컴포넌트는 prefetch를 적용하거나, 사용자 접속 시점에 리소스를 다운로드 받게해서 전체 애플리케이션에 대한
리소스를 내려받는 시점을 분리함


