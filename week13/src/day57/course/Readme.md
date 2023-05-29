# Vue

## Vue Router

- 뷰 라이브러리를 이용하여 Single Page Application을 구현할 때 사용하는 라이브러리

- 무엇을 클릭하면 어떤 컴포넌트로 현재 화면 위치를 옮기는 기능을 지원하는 것

### 뷰 라우터 설치


```bash
npm install vue-router
```

### 뷰 라우터 등록

```javascript
/* router 인스턴스 생성 */
var router = new VueRouter({
    // 라우터 옵션
})

/* 인스턴스에 라우터 인스턴스 등록 */
new Vue({
    router: router
})
```


### 뷰 라우터 옵션

- 라우트 등록 후 보통 2가지의 옵션을 필수로 지정함

1. `routes`: 라우팅할 URL과 컴포넌트 값을 지정
2. `mode`: URL의 해쉬 값 제거 속성


```javascript
new VueRouter({
    mode: 'history',
    routes: [
        {path: '/login', component: LoginComponent},
        {path: '/home', component: HomeComponent}
    ]
})

// 이 코드는 라우팅시 URL에 #값을 제거하고, URL값이 /login과 /home일 때 
// 각각 로그인 컴포넌트와 홈 컴포넌트를 뿌려줌
```


### router-view

```vue
<div id="app">
  <router-view></router-view>
</div>
```

- 브라우저의 주소창에서 URL이 변경되면, 앞서 정의한 routes 속성에 따라
해당 컴포넌트가 화면에 뿌려짐


- 이때 뿌려지는 지점이 템플릿의 `<router-view>`임

- 앞서 정의한 라우팅 옵션 기준으로 `/login`은 로그인 컴포넌트를
`/home`은 홈 컴포넌트를 화면에 표시함


### router-link

- 화면에서 특정 링크를 클릭해서 페이지를 이동할 수 있게 해주는 것이 `<router-link>`
<br> (일반적으로 웹 페이지에서 페이지를 이동할 때에는 사용자가 url을 다 쳐서 이동하지는 않음)


```vue
<router-link to="이동할 URL"></router-link>
```


```vue
<div>
  <router-link to="/login"></router-link>
</div>
```

위 코드를 실행할 경우 화면에서는 `<a>`태그로 변형되어서 나옴<br>
따라서 `<a>`태그를 클릭하면 `/login` URL로 이동함


<br>


### 컴포넌트 구조


#### index.js


- 라우팅과 관련된 정보를 포함

- 화면에 보여지는 컴포넌트들의 정보를 포함하고 있음

```js
import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'
import StudyView1 from "@/views/StudyView1.vue";

const routes = [
  {
    path: '/',
    name: 'home',
    component: HomeView
  },
  {
    path: '/about',
    name: 'about',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import(/* webpackChunkName: "about" */ '../views/AboutView.vue')
  },
  {
    path:'/study1',
    name:'study1',
    component: StudyView1
  }
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router

```


#### App.vue

- 라우팅과 관련된 정보를 포함

```vue
<template>
  <nav>
    <router-link to="/">Home</router-link> |
    <router-link to="/about">About</router-link> |
    <router-link to="/study1">Study1</router-link>
  </nav>
  <router-view/>
  <img src="./assets/logo.png" alt="Vue logo"/>
  <HelloWorld msg="Danny의 Vue 학습"/>
</template>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}

nav {
  padding: 30px;
}

nav a {
  font-weight: bold;
  color: #2c3e50;
}

nav a.router-link-exact-active {
  color: #42b983;
}
</style>
<script setup>
import HelloWorld from "@/components/HelloWorld.vue";
</script>
```

<br>


## vue 및 웹 컴포넌트

- Vue
  - 뷰는 사용자 인터페이스를 만들기 위한 프레임워크
  - 컴포넌트 기반의 SPA(Single Page Application)사이트를 구축할 수 있음

- `웹 컴포넌트`
  - 개발자가 재사용 가능한 사용자 정의 엘리먼트를 만들 수 있는 웹 네티이브 API 집합을 포괄적으로 지칭하는 용어
  - 모던 프론트엔드 라이브러리와 프레임워크는 컴포넌트를 이용하여 페이지의 규모가 커질수록 html구조가 복잡해지고 style 관리가 힘들어지는 문제와, js 파일의 규모가 커지면서 모듈의 관리가 어려워지는 문제를 해결하였음


  




<br>

## ref 

https://joshua1988.github.io/vue-camp/ts/refs.html#ref-%E1%84%89%E1%85%A9%E1%86%A8%E1%84%89%E1%85%A5%E1%86%BC%E1%84%8B%E1%85%B5%E1%84%85%E1%85%A1%E1%86%AB

https://vuejs.org/guide/essentials/template-refs.html

## reactive()


## vue watch

https://v2.ko.vuejs.org/v2/guide/computed.html


https://joshua1988.github.io/vue-camp/syntax/watch.html


https://ko.vuejs.org/guide/essentials/watchers.html


https://vueframework.com/docs/v3/ko/ko-KR/api/computed-watch-api.html


https://ui.toast.com/weekly-pick/ko_20190307

