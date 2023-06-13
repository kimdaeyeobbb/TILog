# e.preventDefault

- Event 인터페이스의 `preventDefault()`메서드는 특정 이벤트를 명시적으로 처리하지 않은 경우, 해당 이벤트에 대한 사용자 에이전트(웹에서는 `브라우저`)의 기본동작을 실행하지 않도록 지정함


- form 내부에서 


<br>

# watch

- [참고자료](https://joshua1988.github.io/vue-camp/syntax/watch.html#watch-%E1%84%8F%E1%85%A9%E1%84%83%E1%85%B3-%E1%84%92%E1%85%A7%E1%86%BC%E1%84%89%E1%85%B5%E1%86%A8)


<br>

# ref vs reactive

- [참고자료](https://ko.vuejs.org/guide/extras/reactivity-transform.html#refs-vs-reactive-variables)

- [참고자료](https://joshua1988.github.io/vue-camp/vue3.html#ref)

<br>

# v-if vs v-show

- [참고자료](https://ko.vuejs.org/guide/essentials/conditional.html#v-show)


<br>


# 스프링 컨텍스트 (JWTAuthFilter)


<br>


# Vuex

- 전역 상태를 관리하기 위한 라이브러리

## Vuex의 특징

### :one: Vuex store는 반응형

- 뷰 컴포넌트는 state를 검색할 때 저장소의 상태가 변경되는 효율적으로 대응하고 업데이트함

### :two: 저장소의 상태를 직접 변경할 수 없음


- mutations를 커밋함으로써 저장소의 상태를 명시적으로 변경할 수 있음
- 이를 통해 모든 state에 대한 추적이 가능한 기록이 남음

```js
const store = new Vuex.Store({
  state:{
      count: 0
  },
  mutations: {
      increment (state){
          state.count++;
      }
  }
})

store.commit('increment')  // store.commit 메서드로 상태 변경을 trigger
console.log(store.state.count) // 1
```

`store.state.count`를 직접 바꾸는 대신 `mutation`을 커밋함으로써 명시적으로 이를 추적할 수 있음<br>
=> 이에 따라 상태 변화를 더 잘 지켜볼 수 있음



<br>


## 상태 (state)

- 상태는 데이터로 변환될 수 있음
<br> (데이터: 애플리케이션이 필요로 하는 데이터, 사용자가 화면에서 무엇을 보는지에 영향을 주는 데이터)

- 상태는 일종의 반응형 데이터임

- 상태는 변경될 수 있으며 변경함으로써 화면상의 무언가를 trigger하는 데이터임


### :one: Local State

- 하나의 컴포넌트 내부에서 관리되는 데이터
- 해당 컴포넌트에만 영향을 미치며, 프로퍼티를 통해 간접적으로 자식 컴포넌트에도 영향을 미침


- 예시
  - 입력 요소에 입력된 사용자 입력값
  - 어떤 컨테이너를 표시하거나 숨기는 버튼

    

### :two: Global State

- 여러 컴포넌트 혹은 앱 전체에 걸쳐 영향을 주는 데이터
- 다양한 위치에서 필요로 함


- 예시
  - 사용자 로그인 여부를 알리는 사용자 인증 상태
  - 앱의 다른 부분에서 표시될 수 있는 장바구니 항목

<br>

## mutations

- 명확하게 정의된 메서드로서 `상태를 업데이트`하는 로직을 가지고 있음

- 이는 컴포넌트 내부에 있으며, 직접 상태를 바꾸는 대신에 state를 manipulate하게 됨

```js
const store = createStore({
  state() {
      return {
          counter: 0
      };
  },
  mutations: {
      increment() {
          
      }
  }
})
```

mutations에 존재하는 메서드는 자동으로 state를 인수로 받음<br>
(vuex는 mutations의 메서드가 호출될 때 state를 인수로 넣어주는 것을 보장함)<br>

<br>

## payload

- mutation에 전달되는 추가 데이터


### payload commit 방법

1. commit시 값을 집어넣음

```js
this.$store.commit('increase', { value: 10 });
```


2. commit을 호출하여 객체를 전달
  <br> (추가로 원하는만큼의 프로퍼티를 넣을 수 있음)
```js
this.$store.commit({
  type: 'increase',
  value: 10,
});

// 이 객체는 increase mutation의 payload로 제공됨
```

컴포넌트 내부에서 mutation을 commit하여 컴포넌트 내부에 직접 state를 추가하는것은 좋지 않다.
<br> 대신 mutation을 사용하는 것이 좋다. 


<br>


## getter


- state에 있는 데이터를 store(저장소)에서 수정하기 위해 mutation을 사용함
<br> (컴포넌트 내부에서 직접 state를 바꾸면 안됨)
<br> (또한 직접 state를 읽어오는것도 좋지 않음)

- Vuex가 getter 메서드를 실행함 <br>
-> state를 getter에 전달함



- `computed property`와 같이 저장소(store)에 직접 정의되어 우리가 원하는 컴포넌트의 내부에서 사용할 수 있음


### getter를 Vuex store에 추가하기

- mutations가 정의된 store에 getters를 추가하자
  (getter는 객체를 받음)

```js
getters: {
    // mutations가 정의된 저장소에 getters를 추가
    finalCounter(state) {
      // 첫번째 인수: state, 두번째 인수: getters
      // 계산하려는 값이 다른 getter의 결과에 따라서 달라지는 경우, getter에 다른 getter를 넣는것이 유용함
      return state.counter * 2;
    },
  },
```


```vue
computed: {
    counter() {
      // return this.$store.state.counter;

      return this.$store.getters.finalCounter;
      // state가 아닌 $store.getters에 접근
      // 여기서는 finalCounter를 호출하거나 실행하는게 아니라 그저 프로퍼티를 가리킬 뿐임
      // vuex가 getter 메서드를 실행시키고 현재 state를 getter에 전달함
    },
  },
```

<br>

## actions

- HTTP요청을 보내고 2초가 지난다음 응답을 받은 후에야 state를 변경한다고 가정해보자
<br> 비동기적으로 실행되는 코드는 즉시 실행을 완료하는 것이 아니라 미래의 어떤 시점에 완료하게 된다
<br> 


- mutation은 언제나 동기적으로 작동한다는 문제가 존재한다
<br> mutation에는 비동기적인 코드가 허용되지 않는다 
<br> 따라서 mutation이 실행되면 중단없이 단계별로 실행이 되면서 state는 즉시 바뀐다
<br> (state가 나중에 바뀌는 것은 허용되지 않는다)


- 여러 mutation이 실행되면 모든 mutation이 최신 상태를 받아야하므로 이렇게 작동하는 것이다
<br>
만약 다른 mutation이 commit되고나서 실행이 완료되지 않는다면 예기치 못한 상황이 발생하므로 프로그램에는 오류가 발생한다
<br>
따라서 mutation이 동기적으로 동작을 하는 것이다


- vuex에서 비동기적으로 코드를 작동하도록 만들기 위해 `Actions`를 사용한다


- 컴포넌트는 Actions를 trigger하고 이를 통해 mutations를 commit함


```js
  actions: {
  // mutations에 있는 것과 이름을 꼭 같게 만들필요는 없지만 같게해야 직관적으로 보기 좋다.
  increment(context) {
    // vuex가 자동으로 context를 가져옴

    /* actions는 mutations와 달리 비동기를 허용 */
    setTimeout(function () {
      context.commit('increment');
      // context는 호출할 수 있는 commit 메서드가 존재함
      // mutations를 커밋함
    }, 2000);
  },

  increase(context, payload) {
    context.commit('increase', payload);
  },
},
```


```vue
<script>
methods: {
  addOne() {

    /* actions를 이용  */
    this.$store.dispatch({
      // dispatch -> commit과 유사. 두개의 인수를 dispatch할 수 있음
      type: 'increase', // 첫번째 인수: actions 이름
      value: 10, // 두번째 인수: 잠재적인 payload
    });
  },
},
</script>
```