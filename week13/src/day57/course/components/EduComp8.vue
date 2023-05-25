<template>
  메인보드의 가격: <input type="text" v-on:input="price = $event.target.value" v-bind:value="price">
</template>

<script>
import { ref, watch } from 'vue'

export default {
  setup() {
    const price = ref(112053)

    /* watch 구현 */
    // 속성의 변화 감지
    // 첫인자: 감시하고자 하는 객체. 여기서는 price.  감시하고 싶은 데이터가 여러개인경우 배열 형식으로 지정할 수도 있음.
    // 두번째 인자: cur-> 변경된 값. prev -> 이전 값
    watch(price, (cur, prev) => {  // prev는 undefined된 값부터 시작
        console.log('price의 변경된 값 :', cur)
        console.log('price의 변경되기 전의 값 :', prev)
      },
      { // 추가로 적용하고자하는 속성정보를 객체로 줄 수 있음
        immediate: true,  // 얘가 없으면 변화되었을 떄만 수행. 얘가 있으니까 즉시 수행.
      }
    )

    return {
      price,
    }
  },
}
</script>
