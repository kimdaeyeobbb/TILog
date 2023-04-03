# CSS

# JavaScript 진행 순서

## :one: 구문

## :two: 기본 API

- API (Application Programming Interface)
  - 응용 프로그램 인터페이스
  - OS나 프로그래밍 언어가 제공하는 기능을 제어할 수 있게 해주는 인터페이스(시스템간 연결 및 소통을 위한 매개체)

### 1. 표준 API

### 2. BOM

### 3. DOM

## :three: Map API

- Kakao API

  - Document가 잘 되어 있음

- Google API

## :four: HTML5 API

### 1. Drag & Drop

### 2. Storage

- [스토리지 참고자료1](https://developer.mozilla.org/ko/docs/Web/API/Web_Storage_API/Using_the_Web_Storage_API)
- [스토리지 참고자료2](https://ko.javascript.info/localstorage)
- [스토리지 참고자료3](https://www.zerocho.com/category/HTML&DOM/post/5918515b1ed39f00182d3048)

## :five: Ajax 프로그래밍

## :six: ECMA Script6 추가 구문

<br>

# JavaScript

- 웹 브라우저가 해석해서 실행할 수 있는 유일한 프로그래밍 언어
- 사용자의 이벤트를 받아서 내장 객체들을 이용한 CSS 및 태그의 스타일 관련 속성/날짜/텍스트 등을 조작할 수 있음

## 자바스크립트 런타임

- 개발자가 작성한 자바스크립트 코드를 해석하고 실행시켜주는 프로그램(혹은 인터프리터)
- 자바스크립트 런타임에는 자바스크립트 엔진(V8-크롬, 스파이더 몽키-파이어폭스, ...)이 필수적으로 필요함

### Node.js

- Node.js는 V8엔진으로 빌드되며, JS가 브라우저외 환경에서도 동작할 수 있도록 JS 엔진을 브라우저로부터
  독립시켜서 서버측에서 실행됨

- Node.js는 Serever Side Application 개발에 필요한 모듈, HTTP, 파일 시스템과 같은 내장 API를 제공함
  <BR>(이 모든 모듈의 설치나 업데이트/제거/수정 등의 작업을 자동화하여 관리해주는 기능을 가진 툴 - Package Manager (ex. npm, yarn))

## 자바스크립트 주요 문법

## 변수

- 변수명은 `$`, `_`을 제외한 공백, 특수문자, 구두점(글의 여러가지 경계를 구분하기 위해 사용되는 반점(,), 온점(.), 물음표(?) 등...)은 사용할 수 없음

- 첫 글자는 숫자가 될 수 없음

- 대소문자를 구별함

- 예약어가 쓰일 수 없음

- 변수 선언시 var, const, let 키워드를 사용함 (변수 선언시 1번만 사용)

- var, let 키워드는 변수를 나타내고 const 키워드는 상수(변경될 수 없는 수)를 의미함

- var 키워드는 초기화가 필요 없고 재할당이 가능함

- let, const 키워드는 블록레벨 선언이므로 선언된 코드 블록 밖에서 접근할 수 없고 재정의가 불가능함
  <br>(const는 초기화가 필요함)

## 데이터 타입

### Number

```js
let num = 10;
num/3;   // 3.333...
1/0;   // Infinity
"문자열"/2;   // NaN
10000.toLocaleString();    // 10,000
Number('10 '); // 10. Number(' 10 ')과 Number(' 10')과도 동일
Number('10 20');  // NaN
Number('hello');   // NaN
Number('');   // 0
Number(' ');   // 0
10000.123123123.toFixed(3);  // 10000.123
parseInt(10,000,000, 10);   // 10. ,가 문자열이므로 ,뒤의 숫자들은 모두 무시됨
```

### String

- 자바스크립트상 `''`와 `""`는 동일

```js
slice(시작인덱스, 종료인덱스)  // 시작인덱스 ~ 종료인덱스-1 까지를 반환
substr(시작위치, 길이)  // 시작인덱스부터 길이만큼 반환
replace()  // 어떤 패턴에 일치하는 부분 또는 모든 부분이 교체된 새로운 문자열을 반환
arr.includes(탐색할 요소, 요소를 검색할 위치);  // 반환값: boolean. includes: 배열이 특정 요소를 포함하고 있는지를 판별
str.stratsWith(문자열의 시작지점에서 탐색할 문자열, 탐색할 위치)  // 반환값: boolean
str.endsWith(문자열의 끝이 특정 문자열로 끝나는지를 찾기 원하는 문자열, 찾고자하는 문자열의 위치) // 반환값: boolean
```

```js
false == "0"; // true
false === "false"; // false
0 == ""; // true
```

### Boolean

### Object

### Array

- 대괄호로 여러개의 값을 리스트 형태로 나열한 자료구조
- 인덱스로 참조되는 요소들의 집합
- 배열의 요소에는 여러가지 자료형이 들어갈 수 있음

```js
const example = [1114, "cafe", false, function cafe() {}, null, undefined, NaN];
```

- 자바스크립트상 배열은 객체 타입 (배열 타입이 아님!)

- `Array.메서드`: Array는 문자 그대로의 Array

- `Array.prototype.메서드`: `배열.메서드` 형태로 사용. 여기서 배열은 정의된 배열을 뜻함. 예를 들어 [1,2,3].pop()

<br>

#### unshift

`Array.prototype.unshift()`<br>

- 배열의 맨 앞에 1개 이상의 요소를 추가함
- 배열의 새로운 길이를 반환함

```js
const cafe = ["coffee", "cake", "tea", "cookie"];
const count = cafe.unshift("bread");

count;
// expected output: 5
cafe;
// expected output: ['bread', 'coffee', 'cake', 'tea', 'cookie']
```

#### shift

`Array.prototype.shift()`<br>

- 배열 내에서 0번째 인덱스에 오는 첫번째 요소를 제거해서 나머지 값의 위치를 한 칸씩 앞으로 오게 만듦
- 매개변수가 없으며 제거된 첫번째 원소를 반환할 수 있음
- 빈 배열에서 사용하거나 배열의 길이가 0인 경우 `undefined`를 반환함

```js
const cafe = ["coffee", "cake", "tea", "cookie"];
const firstElement = cafe.shift();

firstElement;
// expected output: 'coffee'
cafe;
// expected output: ['cake', 'tea', 'cookie']
```

#### push

`Array.prototype.push() 메서드`<br>

- 배열의 맨 끝에 1개 이상의 요소를 추가 & 배열의 새로운 길이 반환

#### pop

`Array.prototype.pop()` 메서드<br>

- 배열 내에 존재하는 요소의 맨 마지막 요소를 제거하고 해당 요소를 호출자에게 반환함
- 빈 배열에서 사용할 경우 `undefined`를 반환

#### splice

`Array.prototype.splice()` 메서드<br>

- 특정한 인덱스를 요소에 위치시킬 때 사용

```js
배열.splice(요소를 위치시키고자 하는 인덱스, 제거할 요소의 개수, 배열에 추가할 요소);
// 첫번째 매개변수: 넣고 싶은 요소를 위치시키고자하는 인덱스
// 두번째 매개변수: 첫번째 매개변수의 인덱스로부터 제거할 요소의 개수 (0: 아무것도 지우지 않음)
// 세번째 매개변수: 입력하고자 하는 요소
```

#### slice

`Array.prototype.slice()` 메서드<br>

- 원본을 변경하는 메소드가 아니며, 원본 배열 요소의 얕은 복사본을 반환함

```js
const cafe = ["coffee", "cake", "tea", "cookie"];

cafe.slice(1, 3);
//expected output: ['cake', 'tea']

cafe.slice(2);
//expected output: ['tea', 'cookie']

cafe.slice(-2, -1);
//expected output: ['tea']

cafe.slice(0, -2);
//expected output: ['coffee', 'cake']
```

- 첫 번째 매개변수는 잘라낼 배열의 시작점의 인덱스를 의미
- 두 번째 매개변수는 잘라낼 배열의 종료지점 인덱스

#### flat

`Array.prototype.flat()` 메서드<br>

- 배열을 원하는 깊이로 평탄화할 때 사용
- 배열 구조 내에 또 다른 배열 요소를 지정한 깊이까지 이어 붙인 새로운 배열을 생성함
- 기본값은 1이며 괄호 안에 들어간 숫자 만큼의 차원을 평탄화해주는 메소드
- 매개변수에 infinity를 넣고 사용하면 하위배열이 없을 때 까지 평탄화가 이루어짐
- 빈 요소가 있을 경우 무시됨

```js
let arr = [
  [1, 2, 3],
  [4, 5, 6],
  [7, 8, [9, [10, 11]]],
];

arr.flat();
//expected output: [1, 2, 3, 4, 5, 6, 7, 8, [9, [10, 11]]]

arr.flat(1);
//expected output: [1, 2, 3, 4, 5, 6, 7, 8, [9, [10, 11]]]

arr.flat(2);
//expected output: [1, 2, 3, 4, 5, 6, 7, 8, 9, [10, 11]]

arr.flat(3);
//expected output: [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11]

arr.flat(Infinity);
//expected output: [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11]
```

#### find

`Array.prototype.find()` 메서드<br>

- 배열에서 특정 조건에 부합하는 1개의 값을 찾아서 반환
- 하나의 요소라도 조건을 만족하는지 확인할 때 사용함
- 단 하나의 값만 찾으므로 `Array.prototype.filter()`보다 성능이 우수함
- 어떤 요소도 특정 조건에 부합하지 않으면 `undefined`를 반환함

```js
const arr = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10];

arr.find((i) => i > 5);
//expected output: 6
```

#### filter

`Array.prototype.filter()` 메서드<br>

- 모든 요소가 조건을 만족하는지 확인할 때 사용
- 배열에서 특정 조건에 부합하는 값을 찾고 그 값들로 이루어진 새로운 배열을 만들어서 출력함
- 어떠한 요소도 특정 조건에 부합하지 않으면 빈 배열을 반환함
- 콜백함수의 반환값이 `true`인 모든 요소를 새로운 배열로 만들어 출력하며 `true`가 아닌 요소들은 건너뛰고 새로운 배열에 포함하지 않음
  <br>(`json`같은 객체를 사용해서 true값 판별 가능)

```js
const arr = [
  {
    name: "title1",
    contents: "contents1",
    dataNum: 1,
  },
  {
    name: "title2",
    contents: "contents2",
    dataNum: 2,
  },
  {
    name: "title3",
    contents: "contents3",
    dataNum: 3,
  },
  {
    name: "title4",
    contents: "contents4",
    dataNum: 4,
  },
  {
    name: "title5",
    contents: "contents5",
    dataNum: 5,
  },
];

arr.filter((i) => i.dataNum > 3);
//expected output:
[
  {
    name: "title4",
    contents: "contents4",
    dataNum: 4,
  },
  {
    name: "title5",
    contents: "contents5",
    dataNum: 5,
  },
];
```

#### map

`Array.prototype.map()` 메서드<br>

- 배열 내에 있는 요소에 오름차순으로 접근해서 주어진 함수를 호출한 결과를 모아 새로운 배열을 반환함
- 해당 메서드를 이용해서 새로운 형태의 값을 정의할 수 있음
- `객체`나 `json` 형태의 데이터를 탐색하는 용도로 사용할 수 있으며 이 과정에서 새로운 형태의 값을 정의할 수 있음

```js
const arr = [
  {
    name: "title1",
    contents: "contents1",
    dataNum: 1,
    data: [1, 2, 3],
  },
  {
    name: "title2",
    contents: "contents2",
    dataNum: 2,
    data: [1, 2, 3],
  },
  {
    name: "title3",
    contents: "contents3",
    dataNum: 3,
    data: [1, 2, 100],
  },
  {
    name: "title4",
    contents: "contents4",
    dataNum: 4,
    data: [1, 2, 3],
  },
  {
    name: "title5",
    contents: "contents5",
    dataNum: 5,
    data: [1, 2, 100],
  },
];

arr.map((i) => i.name);
//expected output: ['title1', 'title2', 'title3', 'title4', 'title5']

arr.map((i) => i.name).indexOf("title3");
//expected output: 2
```

#### forEach()

`Array.prototype.forEach()` 메서드<br>

- 각각의 요소를 실행하고 싶을 떄 사용
- 배열의 각 요소에 콜백을 1회씩 실행함
- 콜백은 요소 값, 요소 인덱스, 순회 중인 배열과 같은 세 인수와 함께 호출됨
- `Array.prototype.map()`과 달리 순회만 함 (map은 새로운 배열을 생성)

```js
const arr = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10];

arr.forEach((i) => console.log(i));
// expected output: 1
// expected output: 2
// expected output: 3
// expected output: 4
// expected output: 5
// expected output: 6
// expected output: 7
// expected output: 8
// expected output: 9
// expected output: 10
```

#### reduce()

`Array.prototype.reduce()` 메서드<br>

- 배열 내의 각 요소에 주어진 reducer 함수를 실행하고, 단 1개의 결과값을 반환함
- 각 요소에 누적하면서 실행하고 싶을 때 사용
- 해당 메서드는 4개의 매개변수를 가짐
  <br>(바로 직전의 콜백함수의 반환값을 누적하는 누적값, 순회를 돌고 있는 현재값, 현재 돌고 있는 요소의 index, array 전체)
  <br>(보통 index, array를 생략하고 많이 사용함)

  ```js
  arr.reduce((누적값, 현재값, index, array) => {
    console.log(누적값);
    console.log(현재값);
    console.log(index);
    console.table(array);
    return 누적값 + 현재값;
  });
  ```

#### Array.from()

`Array.from()` 메서드<br>

- 배열, 문자열 등 반복이 가능한 객체(Iterable object) 혹은 유사 배열을 받아 새로운 배열 객체를 만듦
- 유사 배열 객체를 배열로 만들 때 사용
- 여러 객체를 배열로 만들 때 주로 사용되며 객체 내의 모든 요소를 새로운 배열로 얕은 복사를 함

<br>

## 반복문

### do-while

```js
do {
  실행문;
} while (조건문);
```

- 조건문 이전에 실행문이 있으므로 do문의 코드가 반드시 1번은 실행됨

### continue

- break와는 다르게 반복문 다음 반복으로 이동함

```js
for (let i = 0; i < 20; i++) {
  if (i < 13) continue;
  console.log(i + "살은 청소년입니다.");
}
```

### 레이블

- 식별자로서 코드 블록의 `네임태그`역할을 함
- 반복문 앞에 레이블을 붙여서 break & continue와 함꼐 사용하면 반복문을 다루기가 용이함
- 레이블을 붙여서 중첩 반복문을 사용하면 레이블이 붙은 반복문을 한번에 종료시킬 수 있음

```js
timestable: for (let x = 2; x < 10; x++) {
  for (let y = 1; y < 10; y++) {
    if (x === 4) break timestable;
    console.log(`${x} X ${y} = ${x * y}`);
  }
}
```

- 유의사항
  - 레이블은 반드시 break문 혹은 continue문 위에 있어야함
  - break문은 모든 레이블에서 사용할 수 있음
  - continue문은 반복문에서만 사용 가능함

### 객체 반복문 - for in

- 객체에 포함된 모든 프로퍼티에 대해 반복문을 수행함
- 일반적으로 객체 리터럴은 반복 가능한(iterable) 객체로 인식되지 않음
- 반복 가능한 객체가 아니라면 `for of`문을 쓸 수 없음
- 이러한 경우, 객체 리터럴에 쓸 수 있는 방법은 `for in`문임

```js
const pocketmons = {
  피카츄: 1,
  라이츄: 2,
  파이리: 3,
  꼬부기: 4,
  버터플: 5,
  야도란: 6,
  피죤투: 7,
  또가스: 8,
  메타몽: 9,
};

console.table(pocketmons);

// key 값 출력
for (let pocketmon in pocketmons) {
  console.log(pocketmon);
}

// value 값 출력
for (let pocketmon in pocketmons) {
  console.log(`${pocketmons[pocketmon]}`);
}
```

- `for in`문은 기본적으로 키값만 출력함
- 그러므로 value를 출력하기 위해서는 템플릿 리터럴을 활용하면 좋음

<br>

## 조건문

### &&

```js
a && b; // 조건식 && 조건식이 참일 때 수행하려는 식
```

### ||

```js
a || b; // 조건식 || 조건식이 거짓일 때 수행하려는 식
```

### switch문

```js
switch (값) {
  case 값1:
    // 실행시킬 코드
    break;
  case 값2:
    // 실행시킬 코드
    break;
  case 값3:
    // 실행시킬 코드
    break;
  case 값4:
    // 실행시킬 코드
    break;
  default:
    // 일치하는 경우가 없을 때 실행시킬 코드
    break;
}
```

- switch 뒤에 오는 표현식들의 값에 따라 실행시킬 코드가 있는 곳으로 실행을 옮겨감
- 코드실행을 한 뒤, break에 의해서 조건문을 빠져나오게 됨
- 표현식이 case와 일치하는 경우가 없다면 default 문으로 이동하게 됨
- default 문은 선택사항임
- break가 없다면 switch문을 탈출하지 않고 모든 코드들을 실행시킴
- switch문은 참이냐 거짓이냐를 판별하는 상황보다는 다양한 값을 받아오는 상황에서 코드 실행을 결정할 때 사용함

### falsy

- 타입 변환이 되었을 때 false가 되는 값들을 거짓으로 평가되는 값인 `falsy`값이라 함
- 조건식에 아래의 값이 들어오면 코드가 실행되지 않고 다음 else if문이나 else문으로 넘어가게 됨

  - 0
  - false
  - undefined
  - null
  - "" (빈 문자열)
  - NaN

- 주의) 빈 배열과 빈 객체는 falsy값이 아님

### truthy

- 타입 변환이 되었을 때 true가 되는 값들을 참으로 평가되는 값인 `truthy`값이라 함
- falsy 값들을 제외한 모든 값들이 truthy 값임

```js
let coffeeList = []; // truthy
```


<br>


## 브라우저 객체 모델 (BOM. Browser Object Model)

- 브라우저에 접근하고 브라우저의 기능들을 조작할 수 있도록 제공하는 API
- 자바스크립트를 통해 브라우저에서 제공하는 기능들을 사용할 수 있도록 도와주는 역할을 함
- `window`객체가 브라우저의 최상위 객체이며 `window`객체 내에 다음과 같은 도구들이 존재함

```js
window.alert();   // 브라우저에 메시지 알림창을 띄움
window.prompt();   // 브라우저에 사용자의 데이터를 입력받을 수 있는 입력창을 띄움
window.confirm();   // true 혹은 false 값을 반환하는 알림창을 띄움
```

```js
console.log();   // 콘솔창에 로그 메시지를 보여줌
console.error();   // 콘솔창에 에러 메시지를 보여줌
console.table();   // 콘솔창에 데이터를 테이블 형태로 제공함
```


- 문서 객체 모델(DOM)과는 달리 W3C의 표준 객체 모델은 아님
<BR>=> 하지만 JS가 브라우저의 기능적인 요소들을 직접 제어하고 관리할 방법을 제공함
<BR>=> JS는 이러한 BOM 객체들을 전역 객체(global object)로 사용할 수 있음



### window 객체

- 웹 브라우저의 창(window)를 나타내는 객체이며 대부분의 웹 브라우저에서 지원됨
- js의 모든 객체, 전역 함수, 전역 변수들을 자동으로 window객체의 프로퍼티가 됨
- widndow 객체의 메서드느는 전역 함수이며, window 객체의 프로퍼티는 전역 변수가 됨
- 문서 객체 모델(DOM)의 요소들도 모두 window 객체의 프로퍼티가 됨
- window 객체의 innerHeight와 innerWidth 프로퍼티를 이용해서 브라우처 창 크기(웹 브라우저의 뷰포트. 브라우저의 툴바나 스크롤바는 포함되지 않음)를 설정할 수 있음
- window 객체의 모든 메서드나 프로퍼티를 사용할 때에는 접두사 `window`를 생략할 수 있음
<br>(자바스크립트의 모든 전역 객체, 전역 함수, 전역 변수를 사용할 때에는 window 접두사를 생략할 수 있음)

```js
window.alert() // alert()와 동일 
window.document.write()  // document.write()와 동일
```



<br>


## var, let, const

| 키워드 | 중복선언 |재할당|스코프|호이스틍|전역 객체 프로퍼티|
|:---:|:----:|:---:|:---:|:---:|:---:|
| var |  가능  | 가능|함수레벨 스코프|호이스팅시 undefined로 변수 초기화|할당|
|let|불가능|가능|블록레벨 스코프|선언 단계-TDZ-초기화 단계-할당 단계로 분리되어 진행|undefined|
|const|불가능|불가능|블록레벨 스코프|초기화 이전에 접근시 ReferenceError 발생|undefined|

