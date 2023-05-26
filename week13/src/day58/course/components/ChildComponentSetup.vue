<template>
  <div>저는 Composition API를 사용한 자식 컴포넌트입니당.. 콘솔창에서 결과 보세요..</div>
</template>
<script setup>
// setup함수는 없지만 setup이라는 속성이 존재함
// setup속성을 정의해서 간략하게 함수를 구현 -> definedEmits함수를 사용해야함.
// definedEmits ->
import { onMounted, defineEmits } from 'vue';
const emit = defineEmits(["send-message"]);
// 이벤트를 날릴 수 있는 기능의 함수를 리턴해서 emit이라는 변수에 담음
// js는 리턴값으로 함수를 받아올 수도 있음

const msg = 'Composition Setup API를 사용한 자식 컴포넌트로부터 보내는 메시지';
onMounted(() => {
  emit('send-message', msg)
// -> onMOunted에 send-message를 발생시키는 함수를 호출시킴
  // 자식에서 조상에게 임의의 커스텀 이벤트를 발생시켜서 msg를 전달할 수 있다
})
</script>