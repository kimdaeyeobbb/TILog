<template>
  <div>
    <h2>Vuex의 store 를 사용하여 출력하는 내용</h2>
    <h3>{{ counter }}</h3>
    <h3>getter 호출 : {{ test }}</h3>
    <button @click="inc">mutation 호출결과</button>
    <button @click="asyncinc">action 호출결과</button>
  </div>
</template>
<script>
import { computed } from "vue";
import { useStore } from "vuex";
export default {
  setup() {  // setup함수 사용 => composition API기반
    const store = useStore();  // vuex 4버전에서는 store 객체를 만들어서 사용
    console.log(store)

    const counter = computed(() => store.state.counter);
    // 직접 접근

    const test = computed(() => store.getters);
    // getter 호출

    const inc = () => store.commit("setCounter", counter.value + 1);
    // mutation에 있는 애를 호출하려면 commit을 통해서 호출해야 함
    const asyncinc = () => store.dispatch("setLayzCounter");
    // dispatch 호출 => action에 등록된 함수를 호출 (dispatch 메서드를 통해서 호출)

    return { counter, inc, test, asyncinc };
  }
};
</script>