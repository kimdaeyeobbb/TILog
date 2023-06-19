const el = document.getElementById("div-03");
console.log(`el: ${el}`);

// ID가 "div-02"인 가장 가까운 조상
document.write(el.closest("#div-02")); // <div id="div-02">

// div 안에 놓인 div인 가장 가까운 조상
console.log(el.closest("div div")); // <div id="div-03">

// div면서 article을 부모로 둔 가장 가까운 조상
console.log(el.closest("article > div")); // <div id="div-01">

// div가 아닌 가장 가까운 조상
console.log(el.closest(":not(div)")); // <article>
