<template>
  <h4>자손도 받았어요.. {{ message }}</h4>
  <h4>자손도 받았어요.. {{ number }}</h4>
  <h4>자손도 받았어요.. {{ obj.name }}</h4>
  <h4>자손도 받았어요.. {{ obj.age }}</h4>
</template>
<script setup>
import { inject } from 'vue'

/* inject */
const message = inject('pmess');  // 조상이 준것을 자손이 그대로 받음
const number = inject('pnum');  // 조상이 준것을 자식 부분에서 갱신하였고 이를 자손이 받음
const obj = inject('pobj');  // 조상이 준것을 자손이 그대로 받음
</script>