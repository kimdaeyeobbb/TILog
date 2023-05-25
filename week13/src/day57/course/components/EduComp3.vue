<template>
	<div>
<!--    counter를 변수처럼 사용함-->
		<button @click="increment()">Counter: {{ counter }}</button>
	</div>
</template>

<script>
import { onMounted, ref } from 'vue';

export default {
	setup() {
    // setup() 함수  내부에 원하는 만큼 함수를 만들어서 사용할 수 있음.

    // ref -> 보관용도. 저장할 수 있는 데이터: 기본형&객체형 모두 보관 가능.
    // reactive() -> 보관용도. 저장할 수 있는 데이터: 객체형만 보관 가능
		const counter = ref(0);  // 0은 기본형 => ref로 매핑. counter => 참조 가능한 함수
		const increment = () => counter.value++;     // counter로 이 값을 변화시키기 위해 value 속성 이용
    onMounted(() => {   // onMounted => mount가 일어나면 호출하라는 것 (이 컴포넌트를 포함하는 루트 컴포넌트가 ~)
			console.log('애플리케이션이 마운트 되었습니다!');
		});
		return {
      // 객체로 만들어서 리턴하는 템플릿 태그만 템플릿 영역 내에서 사용할 수 있음.
			counter,
			increment,
		};
	},
};
</script>
