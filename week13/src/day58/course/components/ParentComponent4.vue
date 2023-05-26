<template>
  <!--  send-message => 임의로 만든 이벤트. 자식 컴포넌트 안에서 action이 발생했을 때 부모에게 알리기 위한 용도-->
  <!--  자식 컴포넌트에서 이벤트를 발생시켜서 부모 컴포넌트에게 전달-->
  <!--  우리가 전달해야하는 내용과 연관 지어서 이벤트를 정의하면 됨-->
  <!--  child component에서 send-message가 발생하면 sendMessage를 전달하라는 것 -->
  <child-component-option @send-message="sendMessage" />
  <child-component-compo @send-message="sendMessage" />
  <child-component-setup @send-message="sendMessage" />
</template>
<script>
import ChildComponentOption from './ChildComponentOption';
import ChildComponentCompo from './ChildComponentCompo';
import ChildComponentSetup from './ChildComponentSetup';
export default {
  components: { ChildComponentOption, ChildComponentCompo, ChildComponentSetup },

  methods: {
    // 이벤트 핸들러 -> 이벤트 등록만할뿐. 자바스크립트엔진이 이벤트를 전달하는 것임
    sendMessage(data) {
      console.log("ParentComponent4에서 받는 컴포넌트에 따라 다르게 출력하는 메시지 : " + data);
    }
  }
}
</script>