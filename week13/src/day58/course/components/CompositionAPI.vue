<template>
  <div>
    <h3>Calculator-이벤트처리</h3>
    <div>
<!--      keyup 이벤트 처리-->
<!--      v-model="state.num1" => 양방향 데이터 바인딩을 사용하여 state 객체의 num1 속성과 input 요소를 바인딩함-->
<!--      사용자가 입력한 텍스트는 state.num1에 자동으로 업데이트되고, state.num1의 값이 변경되면 input 요소에도 해당 값이 표시됨-->
<!--      @keyup="plusNumbers" => @keyup은 뷰의 이벤트 리스너 디렉티브. 해당 요소에서 키보드키를 눌렀을 때 실행될 메서드를 지정함-->
      <input type="text" v-model="state.num1" @keyup="plusNumbers" />
      <span> + </span>
      <input type="text" v-model="state.num2" @keyup="plusNumbers" />
      <span> = </span>
      <span>{{ state.result }}</span>
    </div>
  </div>
</template>
<script>
import { reactive, defineComponent } from 'vue';

export default defineComponent({
  // 컴포넌트를 정의하는 함수. 객체를 인자로 받고, 해당 객체에 컴포넌트 설정을 정의함
  setup() {
    let state = reactive({
      // 자바스크립트 객체를 반응형으로 변환하여 반환함
      // 반환된 객체는 뷰의 반응성 시스템에 의해 추적되며, 객체의 속성이 변경될 때 자동으로 UI가 업데이트 됨
      // 이를 통해 뷰 컴포넌트 내에서 상태 관리를 쉽게 할 수 있음
      // reactive 함수를 이용하여 state객체가 생성되었으며 state객체는 반응형으로 변환됨.
      // 또한 num1, num2와 같은 속성을 가지고 초기값을 할당할 수 있음
      // 이후에 state객체의 속성값을 읽거나 수정하면, 뷰는 해당 속성에 대한 의존성을 추적하고 의존하는 컴포넌트를 자동으로 업데이트 함
      // 예를 들어 state.num1 의 값이 변경되면 이를 사용하는 템플릿의 해당 부분이 업데이트 됨
      // reactive 함수는 중첩된 객체와 배열을 반응형으로 만들 수 있음
      // 즉, 객체나 배열 내부의 속성 또는 요소에 변경이 발생하면 관련된 부분만 업데이트 함
      // 이를 통해 복잡한 상태를 구조화하고 관리할 수 있음
      num1: 0,
      num2: 0,
      result: 0
    });
    function plusNumbers() {
      state.result = parseInt(state.num1) + parseInt(state.num2);
    }
    return {  // setup함수는 객체를 리턴해야함.
      // 반환된 객체에는 템플릿에서 사용될 함수와 데이터를 포함해야함
      plusNumbers, state
    }
  }
})
</script>