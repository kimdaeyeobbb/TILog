# Proxy

## 프록시 서버

- `proxy server`는 클라이언트가 자신을 통해 다른 네트워크 서비스에 간접적으로 접속할 수 있게 해주는 응용 프로그램


- `proxy`
  - 서버와 클라이언트 사이를 중계기로서 대리로 통신을 수행함


- `proxy server`
  - 클라이언트(브라우저)와 서버 사이에서 HTTP 요청과 응답을 대신 처리해줌


### 프록시 서버는 왜 사용하는가?

- 프로젝트를 진행할 경우, 클라이언트인 `vue application`과 `server application`을 분리해서 개발하고 
각각을 별도의 주소(도메인 혹은 포트를 달리함)로 운영하게 되는 경우가 많다


- 이렇게 클라이언트와 서버 애플리케이션이 별도의 포트를 사용하는 경우 클라이언트 애플리케이션에서 
서버로 HTTP 요청을 하게 되면 CORS 문제가 발생하는데, 이러한 문제를 해결하기 위해 `Proxy server`를 사용하게 된다


<br>


## CORS

- 웹 애플리케이션에서 도메인, 포트, 프로토콜이 다른 곳으로 HTTP 요청을 보낼 수 없도록 브라우저가 요청을 막는 보안 정책


<br>

## vue 데이터 바인딩

### :one: 데이터가 HTML 태그 안에 텍스트로 바인딩

```vue
<template>
  <div>
    <p>{{ textData }}</p>
  </div>
</template>

<script>
import { ref } from 'vue';

export default {
  setup() {
    const textData = ref("안녕하세요!");

    return {
      textData,
    };
  },
};
</script>
```


### :two: 데이터가 HTML 태그의 속성(attribute)으로 바인딩

```vue
<template>
  <div>
    <a :href="linkData">{{ linkText }}</a>
  </div>
</template>

<script>
import { ref } from 'vue';

export default {
  setup() {
    const linkData = ref("https://www.example.com");
    const linkText = ref("여기를 클릭하세요");

    return {
      linkData,
      linkText,
    };
  },
};
</script>

```


### :three: 데이터가 HTML의 Form element의 value에 바인딩되는 경우

```vue
<template>
  <div>
    <input type="text" v-model="inputData" />
    <p>{{ inputData }}</p>
  </div>
</template>

<script>
import { ref } from 'vue';

export default {
  setup() {
    const inputData = ref("");

    return {
      inputData,
    };
  },
};
</script>

```

### :four: 다중 데이터가 HTML의 다중 element를 생성하기 위해 바인딩

```vue
<template>
  <div>
    <ul>
      <li v-for="item in itemList" :key="item.id">{{ item.text }}</li>
    </ul>
  </div>
</template>

<script>
import { ref } from 'vue';

export default {
  setup() {
    const itemList = ref([
      { id: 1, text: "아이템 1" },
      { id: 2, text: "아이템 2" },
      { id: 3, text: "아이템 3" },
    ]);

    return {
      itemList,
    };
  },
};
</script>

```


<br>


