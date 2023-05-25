<template>
  <div>
  <p>
<!--    v-bind가 생략된 것 -->
    <span :title="message">
      마우스를 올려 놓으면 잠시후 "둘리도우너또치"라는 툴팁이 출력됩니다.
    </span>
  </p>
  <p :class="{ red: isRed }" @click="toggleRed">
    빨간색 백그라운드 칼라가 토글~~~
  </p>

  <!-- style bindings also support object and arrays -->
  <p :style="{ color }" @click="toggleColor">
    클릭할 때마다 그린과 블루가 토글~~~
  </p>
</div>
</template>

<script>
import { ref } from 'vue'

export default {
  setup() {

    // ref함수로 프록시 되어있는 데이터는 .value로 접근가능
    const message = ref('둘리또치도우너')
    const isRed = ref(true)
    const color = ref('green')

    function toggleRed() {
      isRed.value = !isRed.value
    }

    function toggleColor() {
      color.value = color.value === 'green' ? 'blue' : 'green'
    }

    // 객체로 만들어서 리턴 -> setup함수 내에서 만들어진것이 템플릿 태그 내에서 사용되기를 원하면 객체로 리턴.
    return {
      message,
      isRed,
      color,
      toggleRed,
      toggleColor
    }
  }
}
</script>

<style>
  .red {
    background-color : red;
  }
</style>
