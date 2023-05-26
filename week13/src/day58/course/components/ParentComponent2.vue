<template>
  <child-component2 @send-message="sendMessage" ref="child2">
    이건 slot 기능 테스트용 컨텐트~~
  </child-component2>
</template>
<script>
import ChildComponent2 from './ChildComponent2';
export default {
  components: { ChildComponent2 },
  mounted() {
    this.$refs.child2.callFromParent();   // (StudyView3가 포함하는 얘네가 mounted될 떄) 자식 컴포넌트의 함수 호출
  }
}
</script>