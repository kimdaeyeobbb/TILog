<template>
  <div>
    {{ groceryList}}
    <ol>
      <!--   각 구성 요소에 "키"를 제공해야 한다.  -->
      <!--    이 자리에 li태그가 들어오게 됨 (TodoItem.js참고)-->
      <!--    Key를 지정하지 않으면 에러남. 따라서 key를 반드시 지정할 것-->
      <TodoItem   v-for="item in groceryList"     :todo="item"    :key="item.id"></TodoItem>
    </ol>
  </div>
</template>

<script>
import { reactive } from 'vue'
import TodoItem from './TodoItem.js'

export default {
  components: {
    TodoItem  // 템플릿 태그에서 사용하는 태그명이 됨 (케밥케이스로 바꿔서 사용해도 됨)
  },
  setup() {
    const groceryList = reactive([
      { id: 0, text: '뷰 공부' },
      { id: 1, text: '스프링 공부' },
      { id: 2, text: '자바 공부' }
    ])
    return {
      groceryList,
    }
  }
}
</script>

<style>
li {
  list-style-position: inside;
}
</style>
