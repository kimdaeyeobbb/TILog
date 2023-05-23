# Vue

- 사용자 인터페이스를 구축하기 위한 JavaScript 프레임워크
- HTML/CSS/JavaScript 기반으로 구축되며 단순한것부터 복잡한것까지 사용자 인터페이스를 효율적으로 개발할 수 있는 컴포넌트 기반 프로그래밍 모델을 제공함

- 선언적 렌더링 (Declartive Rendering)
  - Vue는 표준 HTML을 템플릿 문법으로 확장하여 JavaScript의 상태(state)를 기반으로 화면에 출력될 HTML을 선언적으로 작성할 수 있음

- 반응성 (Reactivity)
  - Vue는 JavaScript의 상태(state)를 추적하고, 변경이 발생하면 DOM을 효율적으로 업데이트하는 것을 자동으로 수행함

## Vue is Progressive Framework

- 뷰는 사용목적에 따라 다양하게 사용할 수 있다
  - 빌드 과정 없이 정적 HTML에 적용
  - 모든 페이지에 웹 컴포넌트로 추가
  - 싱글 페이지 어플리케이션 (SPA: Single Page Application)
  - Fullstack / 서버 사이드 렌더링 
  - Jamstack / 정적 사이트 생성 (SSG: Static-Site-Generation)
  - 데스크톱, 모바일, WebGL 또는 터미널을 대상으로 하는 경우

## Single File Component

- 빌드 도구를 사용화는 대부분의 Vue 프로젝트는 HTML과 유사한 싱글 파일 컴포넌트(SFC, `*.vue`파일이라고도 함)라는 파일 형식을 사용하여 Vue 컴포넌트를 작성함
- Vue SFC는 이름에서 알 수 있듯이 컴포넌트의 논리(JavaScript), 템플릿(HTML) 및 스타일(CSS)을 하나의 파일에 캡슐화함

```html
<script>
export default {
  data() {
    return {
      count: 0
    }
  }
}
</script>

<template>
  <button @click="count++">숫자 세기: {{ count }}</button>
</template>

<style scoped>
button {
  font-weight: bold;
}
</style>

```

### SFC의 장점

- 친숙한 HTML,CSS 및 JavaScript 문법을 사용하여 모듈화된 컴포넌트 작성
- 본질적으로 사용 목적에 따라 구성됨
- 런타임 컴파일 비용이 없는 사전 컴파일된 템플릿
- 컴포넌트 단위 CSS
- 컴포지션 API로 작업할 때 더욱 인체공학적인 문법
- 템플릿과 스크립트를 교차 분석하여 컴파일 시간을 더욱 최적화
- 템플릿 표현식을 지원하는 IDE의 자동 완성 및 유형 검사
- 즉시 사용가능한 핫 모듈 교체 지원

### vue를 사용하는데 있어 권장되는 접근 방식

- 싱글 페이지 앱 (Single Page Apllication: SPA)
- 정적 사이트 생성 (Static-Site Generator: SSG)
- 더 나은 개발 경험(DX)을 위해 프론트엔드 개발 방식에 합리적으로 빌드 방식 도입


<br>


### vue SFC의 작동 방식

- vue SFC는 프레임워크별 파일 형식이며, @vue/compiler-sfc를 통해 표준 JavaScript와 CSS로 미리 컴파일 되어있어야 함
- 컴파일된 SFC는 표준 JavaScript(ES)모듈임
<br> (즉, 적절한 빌드 설정으로 SFC를 모듈처럼 가져올 수 있음)


```javascript
import MyComponent from './MyComponent.vue'

export default {
  components: {
    MyComponent
  }
}

```





<br>


## API 스타일


- Vue 컴포넌트는 `Option API`와 `Composition API` 스타일로 작성할 수 있음


### Option API

- 옵션 API를 사용하여 옵션의 `data`, `methods` 및 `mounted`같은 객체를 사용하여
컴포넌트의 로직을 정의함

- 옵션으로 정의된 속성은 컴포넌트 인스턴스를 가리키는 함수 내부의 `this`에 노출됨

```vue
<script>
export default {
  // data()에서 반환된 속성들은 반응적인 상태가 되어 `this`에 노출됩니다.
  data() {
    return {
      count: 0
    }
  },

  // methods는 속성 값을 변경하고 업데이트 할 수 있는 함수.
  // 템플릿 내에서 이벤트 리스너로 바인딩 될 수 있음.
  methods: {
    increment() {
      this.count++
    }
  },

  // 생명주기 훅(Lifecycle hooks)은 컴포넌트 생명주기의 여러 단계에서 호출됩니다.
  // 이 함수는 컴포넌트가 마운트 된 후 호출됩니다.
  mounted() {
    console.log(`숫자 세기의 초기값은 ${ this.count } 입니다.`)
  }
}
</script>

<template>
  <button @click="increment">숫자 세기: {{ count }}</button>
</template>

```


### Composition API

- 컴포지션 API를 사용하는 경우, `import`해서 가져온 API 함수들을 사용하여 컴포넌트의 로직을 정의함
- SFC에서 Composition API는 일반적으로 `<script setup>`과 함께 사용됨

- `setup`
  - `setup` 속성은 vue가 더 적은 코드 문맥으로 컴포지션 API를 사용하고, 컴파일시 의도한대로 올바르게 동작할 수 있게 코드를 반환하도록 하는 힌트임
  - 예를 들어 `<script setup>`에 `import`되어 가져온 객체들과 선언된 최상위 변수 및 함수는 템플릿에서 직접 사용할 수 있음

```vue
<script setup>
import { ref, onMounted } from 'vue'

// 반응적인 상태의 속성
const count = ref(0)

// 속성 값을 변경하고 업데이트 할 수 있는 함수.
function increment() {
  count.value++
}

// 생명 주기 훅
onMounted(() => {
  console.log(`숫자 세기의 초기값은 ${ count.value } 입니다.`)
})
</script>

<template>
  <button @click="increment">숫자 세기: {{ count }}</button>
</template>

```




<br>


## CDN에서 Vue 사용

- 시스템에 미리 뷰 라이브러리를 설치하지 않아도 끌어다가 사용할 수 있는 방식임
- 조금 더 가벼운 구현 방법

### :one: 글로벌 빌드 사용

```html
<script src="https://unpkg.com/vue@3/dist/vue.global.js"></script>

<!-- 메시지 속성 값 출력 -->
<div id="app">{{ message }}</div>

<script>
  const { createApp } = Vue

  createApp({
    data() {
      return {
        message: 'Hello Vue!'
      }
    }
  }).mount('#app')
</script>
```

### :two: ES 모듈 빌드 사용

- 모듈로 자바스크립트 소스 파일을 끌어와서 사용하는 것

```html
<div id="app">{{ message }}</div>

<script type="module">
  import { createApp } from 'https://unpkg.com/vue@3/dist/vue.esm-browser.js'

  createApp({
    data() {
      return {
        message: 'Hello Vue!'
      }
    }
  }).mount('#app')
</script>

```

- `https://unpkg.com/vue@3/dist/vue.esm-browser.js'를 하나의 모듈로 보고 여기서 `createApp`만 사용하겠다는 것

- createApp 부분도 하나의 모듈로 지정이 되어야함


### :three: import map 활성화


```html
import { createApp } from 'vue'
```


```html
<script type="importmap">
  {
    "imports": {
      "vue": "https://unpkg.com/vue@3/dist/vue.esm-browser.js"
    }
  }
</script>

<div id="app">{{ message }}</div>

<script type="module">
  import { createApp } from 'vue'

  createApp({
    data() {
      return {
        message: 'Hello Vue!'
      }
    }
  }).mount('#app')
</script>
```


<br>


