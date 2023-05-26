<!-- WorkView.vue -->
<template>
  <div class="flex-container">
    <TeamCard
        team-num="5"
        name="김대엽"
        food="치킨"
        src-url="/images/dooly.jpg"
        v-if="showEl[0]"
        @card-disappear="cardDisappear(0)"
    />
    <TeamCard
        team-num="5"
        name="김민성"
        food="마파두부"
        src-url="/images/minsung.png"
        v-if="showEl[1]"
        @card-disappear="cardDisappear(1)"
    />
    <TeamCard
        team-num="5"
        name="박주희"
        food="1955버거"
        src-url="/images/juhee.jpeg"
        v-if="showEl[2]"
        @card-disappear="cardDisappear(2)"
    />
    <TeamCard
        team-num="5"
        name="홍승희"
        food="돈까스"
        src-url="/images/seunghee.jpeg"
        v-if="showEl[3]"
        @card-disappear="cardDisappear(3)"
    />
  </div>
</template>

<script>
import TeamCard from "@/components/TeamCard.vue";
export default {
  name: "WorkView",
  components: {
    TeamCard,
  },
  data() {
    return {
      showEl: [true, true, true, true], // 각 요소의 초기 상태 설정
    };
  },
  methods: {
    cardDisappear(index) {
      this.showEl[index] = false;
    },
  },
};
</script>

<style>
.flex-container {
  display: flex;
}
</style>
