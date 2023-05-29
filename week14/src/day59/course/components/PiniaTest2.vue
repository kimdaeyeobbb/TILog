<template>
  <h3>Option API 스타일의 스토아</h3>
  <div>num1: {{ num1 }}</div>
  <div>num2: {{ num2 }}</div>
  <div>num2: {{ store1.count }}</div>
  <button @click="store1.count++">1 증가(연산식)</button>
  <button @click="store1.increment">1 증가(action 호출)</button>
  <div>현재 값: {{ store1.count }}</div>
  <hr />
  <h3>Composition API 스타일의 스토아</h3>
  <div>친구 이름: {{ name }}</div>

  <!--  구조분해할당시 반응성을 유지해서 할당하였으므로 바뀐 값이 바로 반영됨-->
  <div>친구 나이 : {{ age }}</div>
  <!--        <div>친구 나이(반응성을 잃은 경우 - 메서드 호출없이 할당): {{ age }}</div>-->
  <button @click="store2.updateAge(5)">친구나이변경</button>
  <button @click="age++">+</button>
</template>

<script setup>
import { useCounterStore } from '@/stores/counter'
import { useFriendStore } from '@/stores/friendstore'
import { storeToRefs } from 'pinia'

const store1 = useCounterStore();
let num1 = store1.count;  // 반응성이 없음 (값을 꺼내어서 일반변수에 담았으므로)
store1.increment();

console.log("piniaTest2에서의 increment 이후 store의 count값: " + store1.count)

let num2 = store1.count  // 반응성이 없음 (값을 꺼내어서 일반변수에 담았으므로)


const store2 = useFriendStore()
console.log("piniaTest2에서의 새로운 store: " + store2)
console.log("piniaTest2에서의 새로운 store의 count값: " + store2.count)

/* 구조분해할당으로 인해 반응성을 잃은 케이스 */
// const { name, age } = store2;

/* 구조분해할당을 한 이후에도 반응성을 유지하는 케이스 */
const { name, age } = storeToRefs(store2)
// 그냥 구조분해할당만하면 반응성을 잃는다.
// 따라서 반응성을 잃지 않게 하기 위해 storeToRefs를 사용함

// 필터링해서 꺼낼 떄에는 getter를 사용하면됨
</script>