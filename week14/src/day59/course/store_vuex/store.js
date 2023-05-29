// 원래이름 => store/index.js
import { createStore } from "vuex";

export default createStore({
  state: {
    counter: 10
  },
  getters: {
    time2(state) {  // proxy객체로 감싸짐
      return state.counter * 2;   // counter값을 2배로 만들어서 리턴
      // 서버에게서 게시글을 다 읽어와서 리스트 객체로 만드는 것은 state에 담는 것임
      // 게시판에 대한 array 객체로 만들어서 적당한 이름으로 정의하면 counter 내의 state에 접근하는 것도 가능하지만 얘는 읽는 것만 가능
      // geteer의 함수 내의 요소는 이와 달리 필터링해서 읽어갈 수 있음
      // getters는 추가적인 기능을 처리한 결과를 읽어갈 수 있음
      // 단, counter를 변경할 수는 없음 (읽어갈때에는 원하는 연산을 해서 읽어갈 수 있음. 혹은 원하는 애들만 읽어갈 수 있음)
    }
  },
  mutations: {   // proxy객체로 감싸짐
    setCounter(state, value) {
      // 첫인자: 공유할 데이터.
      // 두번쨰 인자: 전달된 데이터.
      state.counter = value;
      // mutaiotns는 state의 데이터를 바꿀 수 있음.
      // 따라서 value에 전달된 것으로 counter를 갱신
    }
  },
  actions: {
    // actions는 비동기 호출이 된다.
    setLayzCounter(context) {
      // actions에 정의되는 객체들은 context 객체를 전달받음
      // context객체를 받아서 commit 객체를 호출을 통해 mutation에 있는 함수를 호출하여 주어진 함수의 state값을 변경시킬 수 있음
      // 직접 변경하면 안됨!!
      setTimeout(() => context.commit('setCounter', 1000), 5000)
      // 5000 =>  5초 후에 수행하도록 함
      // settimeout => 자체적으로 비동기 호출을 내장하고 있음
      // 5초가 지나면 자동으로 1000으로 바뀌게 만듦
    }
  }

});
