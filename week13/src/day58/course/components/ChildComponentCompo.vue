<template>
  <div>저는 Composition API를 사용한 자식 컴포넌트입니당.. 콘솔창에서 결과 보세요..</div>
</template>
<script>
import { onMounted } from 'vue'
export default {
  emits: ['send-message'],    // 발생시키고자 하는 이벤트 이름을 먼저 등록 해주어야 함 -> 이벤트 여러개를 배열 형식으로 등록 할 수 있음
  setup(props, context) {
    // 컴포지션API는 코드 영역에 setup함수가 있어야 함
    // setup함수를 정의할 때 매개변수를 정의할 수 있음
    const msg = 'Composition API를 사용한 자식 컴포넌트로부터 보내는 메시지';
    const { emit } = context;  // 구조분해할당 -> context 가 가진 멤버들중 emit만 담아서 할당
    onMounted(() => {
      // 컴포넌트가 마운트 된 후 호출될 콜백을 등록함
      // 내부에 emit함수를 내장하고 있음
      emit('send-message', msg)
      // emit호출 -> emit은 조상 컴포넌트한테 발생시킴 -> send-message를 발생시키면서 msg를 전달하라는 것
    })
  }
}
</script>