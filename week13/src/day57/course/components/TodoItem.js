export default {
  // 내부에 필요한 구성요소를 정의

    props: {  // Props -> 프로퍼티를 전달받는 아이. 얘를 태그로 사용할 떄 todo라는 이름으로 객체형식으로 전달 받을 수 있다는 것
      todo: Object
    },
    template: '<li>{{ todo.text }}</li>'    // 텍스트 부분만 출력하겠다는 것 -> li태그를 만들어냄
  }
