# Vue


## Data

- 그 자체로 함수이자 메서드임

## methods

- methods를 사용하면 버튼 클릭 등과 같은 사용자 이벤트가 발생했을 때 실행할 함수를 정의할 수 있음
- methods에는 js 객체를 전달함
- methods는 메서드 및 함수로 만들어진 객체를 가짐


## this

```js
const app = Vue.createApp({
    data(){
        return {
            courseGoalA: "A선택!",
            courseGoalB: "B선택!",
        }
    }
})
```


- vue는 data 객체에서 반환하는 데이터 전체를 가져다가 데이터를 병합해서 전역 vue 인스턴스 객체를 만듦
<br> (Vue.createaApp 객체로 만든다고 볼 수 있음)

<br>




## 네비게이션 가드

- 뷰 라우터로 특정 URL에 접근할 때 해당 URL의 접근을 막는 방법
- ex) 사용자의 인증 정보가 없으면 특정 페이지에 접근하지 못하게 할 때 사용하는 기술

### 전역 가드

- 애플리케이션 전역에서 동작함
- 라우터 인스턴스를 참조하는 객체로 설정할 수 있음

#### 전역 가드 설정 

1. 라우터 인스턴스 생성
```js
var router = new VueRouter();
```

2. `router`변수에 `.beforeEach()`API를 호출

```js
router.beforeEach(function(to, from, next){
    // to: 이동할 url
    // from: 현재 url
    // next: to에서 지정한 url로 이동하기 위해 호출해야하는 함수
})
```

- to
  - 이동할 url 정보를 담고 있는 라우터 객체


- from
  - 현재 url 정보가 담긴 라우터 객체

- next
  - to에서 지정한 url로 이동하기 위해 꼭 호출해야 하는 함수







### 라우터 가드

- 특정 URL에서만 동작함

### 컴포넌트 가드

- 라우터 컴포넌트 안에 정의함


<br>

## vuex

### vuex의 흐름

#### :one: state

- 전역으로 관리할 상태 값들

#### :two: getters

- 밖으로 내보낼 값들 (실제 컴포넌트가 가져가서 사용할 값)
- state를 가져오기 위해서 getters를 이용

#### :three: mutations

- 실제 state가 변화되는 곳


#### :four: actions

- mutations를 일으키는 곳
- state에 변화를 주기 위해 actions를 이용


### store 정의

```js
import vue from "vue";
import Vuex from "vuex";

Vue.use(Vuex);
export default new Vuex.store({
  state: {
      // 전역으로 관리할 상태 값
      counter: 0
  },
  getters: {
      // state를 가져옴
    counter: state => state.counter
  },
  mutations: {
      // 실제 데이터의 변화가 일어나는 곳
    increment: state => (state.counter += 1),
    decrement: state => (state.counter -= 1)
  },
  actions:{
    // mutations를 일으킴
    addCounter: context => context.commit("increment"),
    subCounter: context => context.commit("decrement")
  }
})
``` 

