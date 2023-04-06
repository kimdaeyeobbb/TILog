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
