<template>
  <h2>watch와 watchEffect 테스트</h2>
  <div>
    <h3>{{ num1 }}</h3>
    <button @click="num1++">increase num1</button>
    <h3>{{ num2 }}</h3>
    <button @click="num2++">increase num2</button>
  </div>
</template>

<script setup>
import { ref, watch, watchEffect } from 'vue';
const num1 = ref(10);
const num2 = ref(100);
// ref를 사용하면 script 코드 영역에서는 .value형태로 사용해야 함. (template 태그내에서는 .value 처럼 사용할 필요가 없음)


// watch : num1 값의 변경이 감지되어야 실행이됨.
// 화면에 렌더링될 떄 최초 1번은 무조건 수행됨
watch(num1, (after, previous) => {
  // 첫번쨰 인자: 감시할 대상. 현재 변경된 값
  // 두번쨰 인자: 변경이 감지되었을 때 실행될 콜백 함수. 이전 값
  console.log(`[W]현재값 : ${after}`);
  console.log(`[W]이전값 : ${previous}`);
});


// watchEffect: 등록된 함수에서 다루는 반응형 변수의 값이 변경될때마다 실행
// 최초로 랜더링될 때에도 실행됨
// 도중에 필요가 없는 경우(감시할 필요가 없어지면) 중단 시킬 수 있음
watchEffect(() => {
  // 블록 내에서 다루고 있는 반응형 변수
  console.log("num1 이나 num2 가 변경됨!!!");
  console.log(`[WE]num1 : ${num1.value}`);
  console.log(`[WE]num2 : ${num2.value}`);
});
</script>


