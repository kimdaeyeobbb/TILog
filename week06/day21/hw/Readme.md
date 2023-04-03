# 실습2

## 문제1

```js
var num = window.prompt("숫자를 한 개 입력하세요.. ");
document.write("<h1>" + {num*10} + "</h1>");
console.log(num-10);
```

- `<script>`태그를 만나면 HTML 파서가 동작하지 못하고 자바스크립트 엔진이 script 태그 내용을 모두 처리할 떄까지 대기상태로 전환

## 문제2

```js
var num;
while(true){
    num = window.prompt("1부터 9사이의 숫자를 한개 입력하세요.. ");
    if(num>=1 && num<=9){
        break;
    }
}
console.log(typeof num);

document.write("<h1>" + num + " 단입니다.</h1>");
document.write("<hr>");
for(let i=1; i<=9; i++){
    document.write("<h3>" + num + " x " + i + " = " + {num*i} + "</h3>");
}
```
