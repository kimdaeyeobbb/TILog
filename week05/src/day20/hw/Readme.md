# 과제1 - calcForm.html

```html
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>calcForm</title>
</head>
<body>
<header>
    <h1>연산할 두 개의 숫자를 입력하고 연산자를 선택하시오</h1>
</header>
<hr />
<main>
    <form action="..." method="get">
        <input type="number" name="inputnumber1" placeholder="연산할 숫자1" />
        <!-- 드롭다운 메뉴 -->
        <select name="operator">
            <option value="plus">+</option>
            <option value="minus">-</option>
            <option value="multiplication">*</option>
            <option value="division">/</option>
        </select>
        <input type="number" name="inputnumber2" placeholder="연산할 숫자2" />
        <input type="submit"  value="계산하기" />
    </form>
</main>
<footer></footer>
</body>
</html>
```

- name속성은 필수로 사용할 것


- submit
  - value가 버튼의 label이 됨


# 과제2

- 테두리, 그림자, 박스 등의 컬러는 원하는 대로 설정
- `날씨`와 나머지 부분을 색상이 다르게 만들기

