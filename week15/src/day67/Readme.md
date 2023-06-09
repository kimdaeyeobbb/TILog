# Vuex

## state

- 전역으로 관리할 상태 값들


## getters

- 밖으로 내보낼 값들 
<br> (실제 컴포넌트에서 가져가서 사용할 값들)

- state를 가져오기 위해서 사용함

- state를 변화시키지 않음


## mutations

- 실제 state(데이터)가 변화되는 곳

## actions

- mutations를 commit하는 곳

- state(데이터)가 변하지 않음 

- 컴포넌트에서는 actions를 사용함 


<br>

## vuex 사용예시

```js
import Vue from "vue";
import Vuex from "vuex";

Vue.use(Vuex);

export default new Vuex.Store({
    state: {  // 글로벌하게 관리될 상태 값
        counter: 0
    },
    getters: {  // state를 가져오기 위해서 사용 
        counter: state => state.counter
    },
    mutations: { // 실제 데이터 변화를 일으킴
        increment: state => (state.counter += 5),
        decrement: state => (state.counter -= 5)
    },
    actions: {
        addCounter: context => context.commit("increment"),
        subCounter: context => context.commit("decrement")
    }
})
```