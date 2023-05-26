<template>
  <button @mouseover="sendMessage">부모버튼</button>
<!--  // 자식영역의 특정 컴포넌트에서 이벤트가 발생하게 만들거나, 자식 컴포넌트의 함수를 호출하거나, 자식 컴포넌트의 변수에 접근할 경우에는-->
<!--  자식 컴포넌트 영역에 접근하기 위해 ref를 이용하여 자식 컴포넌트에 고유한 이름을 부여해야함 -->
  <child-component ref="child1" />
</template>
<script>
import ChildComponent from './ChildComponent';
export default {
  components: { ChildComponent },
  methods: {
    sendMessage: function () {
      this.$refs.child1.$refs.btn.click();  // 자식 DOM 객체에 이벤트 발생
      // $refs => compositionAPI에서는 undefined. optionsAPI에서는 아님
      // $refs.child1 => 자식 컴포넌트 객체에 접근
      // btn -> 자식 컴포넌트에 ref="btn"꼴로 정의되어 있을 것임
    }
  }
};
</script>