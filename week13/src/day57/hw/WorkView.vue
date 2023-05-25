<template>
  <div class="flex-container">
    <TeamCard
      team-num="5"
      name="김대엽"
      food="치킨"
      src-url="/images/dooly.jpg"
    />
    <TeamCard
      team-num="5"
      name="김민성"
      food="마파두부"
      src-url="/images/minsung.png"
    />
    <TeamCard
      team-num="5"
      name="박주희"
      food="1955버거"
      src-url="/images/juhee.jpeg"
    />
    <TeamCard
      team-num="5"
      name="홍승희"
      food="돈까스"
      src-url="/images/seunghee.jpeg"
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
};
</script>

<style>
.flex-container {
  display: flex;
}
</style>
