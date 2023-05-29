import { defineStore } from 'pinia'
import { ref } from 'vue'

/* Composition API */
export const useFriendStore = defineStore('friend', () => {
/* Composition API이므로 얘네 자체가 setup함수임 */
  // 기능에 맞춰서 자동으로 적용됨
  const age = ref(10)
  const name = ref('둘리')
  function updateAge(n) {
    age.value+=n;
  }
  return { age, name, updateAge }
})