<template>
  <div> count: {{ store1.count }}</div>
  <div> name: {{ store1.name }}</div>
  <div> age: {{ store1.age }}</div>
</template>

<script setup>
import { useMyStore } from '@/stores/mystore'

const store1 = useMyStore();

console.log("useMyStore() 객체 : " + store1)
console.log("userMyStore() 객체의 count: " +store1.count);

store1.increment();
console.log("useMyStore() 객체의 count 증가 이후의 count: " +store1.count)

console.log("useMyStore()객체의 정보: "+ store1.name +", "+ store1.age);

store1.patchNameAndAge("크크크", 23)

console.log("이름 및 나이 변경 이후: " +store1.name+", "+ store1.age )


//
// export default {
//   name: "PiniaTest3"
// }
</script>