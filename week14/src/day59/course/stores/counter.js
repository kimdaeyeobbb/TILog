// stores/counter.js
import { defineStore } from 'pinia'

export const useCounterStore = defineStore('counter', {
  // store 객체 생성
  // 리턴한게 함수

  /* option API 형식 */
  state: () => {
    // pinia의 state 객체는 자동적으로 반응성을 가짐
    // state 객체 => count와 name을 가짐
    return { count: 0, name: '김정현' }
  },

  // could also be defined as
  // state: () => ({ count: 0 })
  getters: {
    getName: (state) => state.name+"!!",
    // 인자로 state를 받아서 속성 정보를 리턴
  },
  actions: {
    increment() {
      this.count++
    },
  },
})
