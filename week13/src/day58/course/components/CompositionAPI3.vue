<template>
  <div>
    <h3>Calculator3-외부 함수에 정의된 computed</h3>
    <div>
      <input type="text" v-model="num1" />
      <span> + </span>
      <input type="text" v-model="num2" />
      <span> = </span>
      <span>{{ result }}</span>
    </div>
  </div>
</template>
<script>
import { reactive, computed, toRefs } from "vue"; //toRefs 추가

function plusCalculator() {
  // 외장 함수 생성
  let state = reactive({
    // reactive를 이용하여 반응성 부여
    // 3개의 멤버로 구성된 자바스크립트 객체 정의
    num1: 0,
    num2: 0,
    result: computed(() => parseInt(state.num1) + parseInt(state.num2)),
  });
  return state;
}
export default {

  // eslint-disable-next-line vue/multi-word-component-names
  name: "calculator",
  setup() {
    // 아무리 reactive 객체를 받아와도 구조분해 할당을 하면 반응성을 잃어버림
    // 구조분해할당을 하면 각 요소는 반응성을 잃은 상태에서 대입이 됨.
    // 따라서 반응성을 유지하면서 구조분해 할당하려면 toRefs()를 호출한 결과로 할당함 (각 멤버마다 proxy 객체의 성격을 유지하게 만들어줌)
    let { num1, num2, result } = toRefs(plusCalculator()); //외부 function
    return {
      num1,
      num2,
      result,
    };
  },
};
</script>
