<template>
  <div>
    {{ date1 }}
  </div>
  <div>
    {{ date2 }}
  </div>
  </template>

<script>
export default {
  // Composition API
  setup() { // 컴포지션은 setup에 모든것을 구현함
    const date1 = Date().toString()

    // 해당 변수나 함수, computed 함수등을 적용해서 호출 -> 템플릿 영역에서도 사용할 수 있도록 만들기 위해 객체로 만들어서 리턴
    return {
      date1,
    }
  },

  // Option API
  data() {

    // 객체로 만들어서 리턴 
    return {
      date2: Date().toString(),
    }
  },
}
</script>

