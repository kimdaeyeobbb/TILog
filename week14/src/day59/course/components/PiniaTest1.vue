<template>
  <!-- Access the state directly from the store -->
  <div>현재 값: {{ counter.count }}</div>
  여기서 counter는 store에 해당됨
</template>

<script setup>
import { useCounterStore } from '@/stores/counter'
// @ => src 폴더를 alliance 시킨 것

const counter = useCounterStore() // store를 리턴
console.log("pinia의 스토어값: " +counter);
console.log("pinia의 스토어의 count: " + counter.count)
counter.count++
// with autocompletion ✨
counter.$patch({ count: counter.count + 1 })
// or using an action instead

console.log("patch 이후의 pinia의 스토어의 count: " + counter.count)


counter.increment()

console.log("increment() 이후의 pinia의 스토어의 count: " + counter.count)

</script>

