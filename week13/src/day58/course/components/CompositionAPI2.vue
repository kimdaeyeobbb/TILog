<template>
  <div>
    <h3>Calculator2-computed 사용</h3>
    <div>
      <input type="text" v-model="state.num1" />
      <span> + </span>
      <input type="text" v-model="state.num2" />
      <span> = </span>
      <span>{{ state.result }}</span>
    </div>
  </div>
</template>
<script>
import { reactive, computed } from "vue";
export default {
  // export default -> 컴포넌트 객체를 내보냄
  // eslint-disable-next-line vue/multi-word-component-names
  name: "calculator",
  setup() {
    let state = reactive({
      num1: 0,
      num2: 0,
      // computed를 이용해서 num1, num2가 변경이 일어나면 즉시 result로 더한 값을 반환
      result: computed(() => parseInt(state.num1) + parseInt(state.num2))
      // computed 함수는 의존하는 값들을 감지하고, 값이 변경될 때마다 연산을 수행함 여기서는 state.num1과 state.num2를 파싱하여 더한값을 반환함

      // 변수의 값이 바뀔떄마다 computed에 지정된 변수가 자동으로 호출됨
    });
    return {
      state,
    };
  },
};
</script>
