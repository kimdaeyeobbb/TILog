<template>
<!--  템플릿 태그 내에 ref에 할당된 속성값으로 찾아갈 수 있음 => 부모 컴포넌트에서 이를 이용해서 접근-->
  <button type="button" @click="childFunc" ref="btn">자식버튼</button>
</template>
<script setup>
const childFunc = function () {
  window.alert('부모 컴포넌트(ParentComponent)의 자식 태그에서 발생시킨 클릭이벤트!!');
}
</script>