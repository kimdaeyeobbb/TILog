<template>
  <!--  ref => 컴포지션 API를 사용함을 추축할 수 있음  -->
  <child-component3 @send-message="sendMessage" ref="child3" />
  <button type="button" @click="changeChildData">자식 컴포넌트 반응형 변수의 값을 변경해 보자</button>
</template>
<script>
import ChildComponent3 from './ChildComponent3';

export default {
  components: { ChildComponent3 },
  methods: {
    changeChildData: function () {
      this.$refs.child3.msg = "부모 컴포넌트(ParentComponent3)가 변경한 데이터";
      // this.$refs.child3 => 자식 컴포넌트에 해당 되는 DOM객체를 추출
      // .msg => 해당 자식 컴포넌트의 변수에 접근
    }
  }
}
</script>
