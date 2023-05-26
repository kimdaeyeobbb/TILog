<template>
  <h3>자식컴포넌트</h3>
  <!--  slot -> 뭔가를 내보낼 구멍-->
  <slot></slot>
</template>
<script>
export default {
  setup() {
    function callFromParent() {
      alert('부모 컴포넌트(ParentComponent2)에서 직접 호출한 함수');
    }
    return {
      callFromParent  // 자식 컴포넌트의 함수
    }
  }
}
</script>

