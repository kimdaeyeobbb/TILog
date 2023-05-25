<template>
  <h2>그동안 뭐 한거지? ㅎㅎ</h2>
  <div>
     {{ date3 }}
  </div>
</template>

<!-- 변수 선언한게 전부이지만 결과는 EduComp1.vue와 동일 -->
<!--스크립트 자체가 setup함수가 되므로 setup함수를 호출할 필요가 없음 -->
<script setup>
//템플릿 태그 내에서 사용할 변수 하나만 선언하면 사용할 수 있음.
// 여기서는 이 구문 자체가 setup함수에 해당됨.
   const date3 = Date().toString()
</script>
