<template>
  <div>
    <h2>provide와 inject</h2>
    <ProvideInjectChild />
  </div>
</template>
<script setup>
import ProvideInjectChild from './ProvideInjectChild';
import { provide, ref, reactive } from 'vue'

/* 반응성이 없는 데이터 */
provide('pmess', '안녕?');  // "안녕?"이라는 문자열 객체 전달
// 자손에게 전달하는 데이터가 꼭 반응성이 있어야하는 것은 아님 (그냥 값만을 전달해도 됨)
// 동적으로 전달하는 경우에 반응성있게 만들어서 전달하면 되는 것이다

/* ref */
const count = ref(10);  // 반응성 객체 전달
provide('pnum', count);

/* reactive */
const obj = reactive({
  name: "유니코",
  age: 20
});
provide('pobj', obj);
</script>