<template>
    <h1 @click="updateMessage()">{{ message }}</h1>
</template>

<!--템플릿 태그에 mount될떄, mount 되기 전 등. 각 시점에 자동으로 호출되는 처리결과를 점검하기 위한 예제-->
<!--각 시점에 필요한것이 있으면 호출. 아니면 생략.-->
<script>
  import { onBeforeMount, onMounted, onBeforeUpdate, onUpdated, ref } from 'vue'

  export default {
    setup() {
      const message = ref("클릭하면 변경되는 내용");
      onBeforeMount(() => {
        console.log("beforeMount");
      })
      onMounted(() => {
        console.log("mounted");
      })
      onBeforeUpdate(() => {
        console.log("beforeUpdate");
      })
      onUpdated(() => {
        console.log("updated");
      })
      const updateMessage = () => {
        message.value = "변경 완료";
      }
      return {
        message,
        updateMessage
      }
    }}
</script>
