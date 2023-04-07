# exercise12 풀이

```html
<!DOCTYPE html>
<html lang="ko">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>exercise12</title>
    <style>
      body {
        text-align: center;
      }
    </style>
  </head>
  <body>
    <h1 onclick="location.href='https://ko.wikipedia.org/wiki/구구단'">
      구구단
    </h1>
    <hr />
    <div>
      <button>1단</button>
      <button>2단</button>
      <button>3단</button>
      <button>4단</button>
      <button>5단</button>
      <button>6단</button>
      <button>7단</button>
      <button>8단</button>
      <button>9단</button>
    </div>
    <div id="gugu"></div>
    <script>
      let btn = [];
      function gugudan (num){
          let text = '';
          let ggdan = document.getElementById("ggdan");
          for (let i=1; i<10; i++){
              text += `${num} X ${i} = ${num*i} <br>`
          }
          ggdan.innerHTML = text;
      }

      /* 버튼 생성 */
      for (let i=1; i<10; i++){
          write(`${i}단`, 'button');
          btn.push(document.getElementsByTagName("button")[i-1]));
          btn[i-1].addEventListener("click", function(){
              gugudan(i);
          })
      }
    </script>
    <div id="ggdan"></div>
  </body>
</html>
```

# exercise13 풀이

- 요구사항을 충족 시키기 위해서 공통 부모에 이벤트를 등록해야 함

## 1번

```html
<body>
<h1>이벤트 처리 실습</h1>
<hr>
<div>
    <button>맑음</button>
    <button>흐림</button>
    <button>비</button>
</div>
<hr>
<img src="">
<script>
    var dom1 = document.getElementByTagName("body")[0];
    var dom2 = document.getElementsByTageName("img")[0];
    
    function changImg(e){
        if(e.target.nodeName === "BUTTON"){
            if(e.target.textContent === '맑음'){
                dom2.src = "/edu/images/sun.png";
            } else if (e.target.textContent === '흐림'){
                dom2.src = "/edu/images/cloud.png";
            } else {
                dom2.src = "../../images/rain.png;
            }
        }
    }
</script>
</body>
```


## 2번

```html
<header>
    <h1>이벤트 처리 실습</h1>
</header>
<section id="select-weather">
    <div id="btn-container">
        <button class="btn" value="sun">맑음</button>
        <button class="btn" value="cloud">흐림</button>
        <button class="btn" value="rain">비</button>
    </div>
</section>
<section id = "show-weather">
    <div id="img-container"></div>
</section>
<script>
    function showWeather(e){
        if(e.target.tagName !== "BUTTON"){
            return;
        }
        let showWeather = document.getElementsById('show-weather');
        showWeather.innerHTML = `<img src= "../../images/${e.target.value}.png`"/>;
    }
    let ~
    ~
</script>
```

- 태그를 붙였다 떼었다 하는것보다 속성을 바꾸는게 효율이 좋다
