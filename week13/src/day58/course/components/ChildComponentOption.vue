<template>
  <div>저는 Option API를 사용한 자식 컴포넌트입니당.. 콘솔창에서 결과 보세요..</div>
</template>
<script>
// Option API는 자식 컴포넌트를 사용하는 부분에서 자식 컴포넌트에서 이벤트가 발생하면 이벤트 핸들러를 부모에서 구현해야함
export default {
  data() {
    return {
      msg: 'Option API를 사용한 자식 컴포넌트로부터 보내는 메시지'
    };
  },
  mounted() {
    // $를 사용한 방법은 CompositionAPI에서는 사용할 수 없음
    this.$emit('send-message', this.msg)
    // 첫번째 인자: 발생시킬 이벤트
    // 부모에게 send-message라는 이벤트를 발생시키겠다는 것
    // 두번쨰 인자: 이벤트를 발생시키면서 전달할 데이터
  }
}
</script>