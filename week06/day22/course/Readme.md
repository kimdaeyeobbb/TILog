# JavaScript

## 함수 구조

- 함수는 입력, 출력, 기능을 하나로 묶어 재사용할 수 있도록 만드는 것
- 자바스크립트는 실행 코드들이 들어 있는 `독립 블록 단위`의 `객체`인 함수를 사용할 수 있음
  <br> (객체 - 데이터와 그 데이터를 포함한 모든 동작)

```js
<p id = "ex"></p>
<script>
function myFunc1(x, y){ // 함수의 정의
    z = x+y;  // 함수의 기능
    return z;   // 함수의 결과값
}
document.getElementById("ex").innerHTML = myFunc1(4,3);  // 함수의 호출
</script>
```

### 함수를 왜 사용하는가

1. 재사용성이 좋아짐
2. 유지보수가 용이해짐
3. 구조 파악이 용이함

### 1. 함수의 인자에 따른 반환값

```js
function 함수1(a, b, c) {
  return a + b + c;
}

// 필요 이상의 아규먼트를 넣었을 때
함수1(10, 20, 30, 40); // Error를 뿜지 않습니다. 60

// 필요 이하의 아규먼트를 넣었을 때
함수1(10, 20); // '30undefined'
```

### 2. 구조분해할당을 이용한 인자 처리

```js
function 함수2(a, b, ...c) {
  console.log(c);
  return Math.max(...c);
}

함수2("hello", "world", 10, 20, 30, 40);
// [10,20,30,40]
// 40

function 함수2([a, b], ...c) {
  console.log(a);
  console.log(b);
  console.log(c);
}

함수2([1, 2], 10, 20, 30, 40);
// 1
// 2
// [10,20,30,40]
```

### 3. 함수에서 객체를 argument로 전달받는 방법

```js
////// 아규먼트 없이 호출 가능 //////
function 함수({ a = 2, b = 1, c = 3 } = {}) {
  console.log(a, b, c);
  return a + b + c;
}
console.log(함수({ a: 20, b: 30, c: 10 }));
함수(); // 아규먼트 없이 호출 가능

// 20 30 10
// 60
// 2 1 3
// 6
```

```js
function 함수(a = 10, b = 20, c = 30) {
  return a + b + c;
}
함수();

// 60
```

```js
function 함수({ a = 10, b = 20, c = 30 }) {
  return a + b + c;
}
함수();

// error
```

```js
/* 위의 코드는 이 코드를 축소한 것 */
function 함수({ a = 10, b = 20, c = 30 }) {
  return a + b + c;
}
함수({});
// 60
```

<br>

## 함수 정의 방법

### 1. 선언적(명시적) 함수 정의 방법

```js
function myFunc1(param1, param2,...){
    // 수행문
}
```

### 2. 표현식(믹명) 함수 정의 방법

```js
var myFunc1 = function(param1, param2,...){
    // 수행문
|
```

<br>

## util.js

- 독립적으로 작성된 js 소스
- html에 만들어진 코드처럼 사용가능

```js
function write(content, tag) {
  document.write("<" + tag + ">" + content + "</" + tag + ">");
}
function hr() {
  document.write("<hr>");
}
function writeColor(content, tag, color) {
  document.write(
    "<" + tag + " style='color:" + color + "'>" + content + "</" + tag + ">"
  );
}
function writeNewLine(content) {
  document.write(content + "<br>");
}
```

<br>

## 지역 변수와 전역 변수

```js
let z = 10; // 전역 변수

function sum(x) {
  // x: 매개변수이면서 지역변수

  let y = 5; // y는 지역변수
  z = y + z;
  return x + y;
}
```

- 함수가 종료되면 함수 내부에서 선언된 변수는 휘발됨

```js
function xplus() {
  let a = 100;
  a = a + 10;
}

xplus();
console.log(a); // Error
```

<br>

## 함수 선언문과 함수 표현식

```js
/* 함수 선언문 */
function sum(x, y) {
  return x + y;
}

/* 함수 표현식 */
let sumXY = function (x, y) {
  return x + y;
};

sumXY(10, 20); // 30
```

<br>

## 콜백함수

- 파라미터를 함수로 전달받아서 함수 내부에서 실행하는 함수

```js
function sum(x, y, 콜백함수) {
  콜백함수(x + y);
  return x + y;
}

function documentWriter(s) {
  document.write("콜백함수", s);
}

sum(10, 20, documentWriter); // 30
```

```JS
let arr = [1, 2, 3, 4, 5];
arr.map(제곱)

function 제곱(x){
  return x ** 2
}

arr.map(x => x ** 2)  // [1, 4, 9, 16, 25]
```

<br>

## 함수의 호이스팅

- `호이스팅`은 코드가 실행되기 전에 `변수선언 및 함수선언`이 해당 스코프의 최상단으로
  끌어올려진 것 같은 현상을 뜻함
  <br> (코드가 실행되기 전 변수선언 및 함수선언이 해당 스코프의 최상단으로 끌어올려지는 것이 아님)

- JS엔진은 코드를 실행하기 전에 실행 컨텍스트 과정(실행 가능한 코드를 형상화하고 구분하는 과정)을 거침
- JS엔진은 코드를 실행하기 전에 실행 컨텍스트를 위한 과정에서 모든 선언(var, let, const, function, class)을 스코프에 등록함

- 코드 실행 전 이미 `변수선언 및 함수선언`이 저장되어 있으므로 선언문보다 참조 및 호출이 먼저 나오더라도
  오류가 없이 동작함
  <br> (var 키워드로 선언한 변수와 함수 선언문일 경우 오류없이 동작함!)
  <br> (이를 통해 선언이 파일 맨 위로 끌어올려진 것처럼 보이게 함)

- JS의 모든 선언은 호이스팅(선언이 먼저 메모리에 저장)이 일어남
- 그러나 let, const, class를 이용한 선언문은 호이스팅이 되었지만 안된것처럼 동작함
  <br> (이러한 현상은 TDZ에 빠지기 때문에 발생)

```js
foo1(); // 함수 선언문에서는 호이스팅 일어난다.
foo2(); // 함수 표현식이라서 호이스팅 안된다.

/* 함수 선언문 */
function foo1() {
  console.log("Hello");
}

/* 함수 표현식 */
var foo2 = function () {
  console.log("world");
};
```

- [참고자료](https://hanamon.kr/javascript-%ED%98%B8%EC%9D%B4%EC%8A%A4%ED%8C%85%EC%9D%B4%EB%9E%80-hoisting/)

### 실행 컨텍스트

- 실행 가능한 코드가 실행되기 위해 필요한 환경을 뜻함
- 실행 되기 전 실행 컨텍스트 과정(코드를 구분하는 과정)을 거침

<br>

## 즉시 실행함수

- 즉시 실행하고 외부에서 컨트롤 할 필요가 없는 함수
- 메모리를 효율적으로 관리하기 위해 바로 실행해야하는 것들을 `즉시 실행함수`로 관리함

```js
/* 익명 즉시 실행함수 */
(function () {
  let a = 10;
  let b = 20;
  return a + b;
})();

/* 기명 즉시 실행함수 */
(function func1() {
  let a = 50;
  let b = 70;
  return a * b;
})();

func1(); // ReferenceError: func1 is not defined
```

<br>

## call by value

- 자바스크립트는 `call by value`만 존재함
- 참조타입을 넘기면 주소가 넘어가는 것이 아니라 주소값을 복사한 `주소값 복사본`이 넘어감
- 해당되는 자료형: Objcet, Array, function

```js
/* 다른 언어에서는 call by reference */
let array = [100, 200, 300];

function test(a) {
  a[0] = 1000;
}

test(array);
array; // [1000, 200, 300]
```

- 다른언어에서 call by value인것은 js에서도 call by value
- 재할당되는 순간에는 다른 값을 가리킴
- 해당 자료형: Number, String, Boolean, null, undefined

```js
/* 다른 언어에서 call by value */
let a = 10;
function test(num) {
  num = 20;
}

test(a);
a; // 10
```

<br>

## 클로저

- 폐쇄된 공간 내부의 데이터에 접근하기 위한 테크닉
- 내부 함수의 외부 함수 접근(권한) 테크닉
- `변수 은닉`, `메모리 효율`, `코드 효율(또는 완전성)`을 극대화하기 위해 사용

```js
function makeAdder(x) {
  var y = 1;
  return function (z) {
    y = 100;
    return x + y + z;
  };
}

var add5 = makeAdder(5);
var add10 = makeAdder(10);
//클로저에 x와 y의 환경이 저장됨

console.log(add5(2)); // 107 (x:5 + y:100 + z:2)
console.log(add10(2)); // 112 (x:10 + y:100 + z:2)
//함수 실행 시 클로저에 저장된 x, y값에 접근하여 값을 계산
//지역스코프에서 값을 찾고, 없으면 그 밖에 있는 스코프에서 찾고, 계속해서 찾아 올라가 전역 스코프까지 찾아보는 것을 스코프체이닝
//어려운 얘기로는 내부 렉시컬 환경에서 찾고 없으면 전역 렉시컬 환경에서 찾는다 얘기함.
//함수가 수행된 이후에도 상위함수의 렉시컬 환경에 접근 가능
```

<br>

## 생성자 함수

- 생성자 함수를 이용하면 유사한 객체를 여러 개 만들 수 있음
  <br>(복수의 사용자, 메뉴 내 다양한 아이템을 객체로 표현하는 케이스 등)

- 함수명 첫글자는 대문자로 시작함
- 반드시 `new`연산자를 붙여서 실행함

```js
function User(name) {
  this.name = name;
  this.isAdmin = false;
}

let user = new User("보라");
let user2 = new User("사자");
let user3 = new User("호랑이", true);

console.log(user.name); // 보라
console.log(user.isAdmin); // false

console.log(user2.name); // 사자
console.log(user2.isAdmin); // false

console.log(user3.name); // 호랑이
console.log(user3.isAdmin); // false

/* 실행 순서 */
function User(name) {
  // this = {};   // 1. 빈 객체가 암시적으로 만들어짐 (빈 객체를 만들어서 this에 할당)

  // 2. 새로운 프로퍼티를 this에 추가해서 this를 수정함
  this.name = name;
  this.isAdmin = false;

  // return this;  // 3. this가 암시적으로 반환됨
}
```

- 생성자 함수를 사용하면
  - 동일한 프로퍼티를 가지는 객체를 생성할 수 있음 (재사용할 수 있는 객체 생성 코드 구현)
  - prototype을 이용해서 메모리 효율을 높일 수 있음

<br>

## JS 배열

### 배열 생성방법

1. [10,20,30]
2. new Array(3)
   <br>(생성자 함수 사용)

<br>

### spread 연산자

- [참고자료](https://developer.mozilla.org/ko/docs/Web/JavaScript/Reference/Operators/Spread_syntax)
- [참고자료2](https://learnjs.vlpt.us/useful/07-spread-and-rest.html)


<br>

## JS 예외처리


<br>

## JS 이벤트

- `이벤트`는 시스템에서 발생하는 작업 또는 사건을 뜻함
- 특정 버튼을 클릭하거나 DOM 로드가 완료되는 등의 이벤트가 발생하면 브라우저는 이벤트 감지를 할 수 있음
- 시스템은 이벤트가 발생할 때 일종의 신호를 생성하고 작성된 코드를 실행시킴
  - EX) 사용자가 키보드의 키를 눌렀을 때 함수를 호출해서 어떤 로직을 처리하고 싶은 경우
  <BR> => 브라우저는 사용자가 키보드를 누른것을 감지하여 이벤트를 발생시킬 수 있음
  <BR> => 그래서 이 특정 키를 눌렀을 때 이벤트가 발생하면 특정 함수를 호출하도록 브라우저에 위임할 수 있음
  