<template>
  <AppearAnimation :once="true" v-model="onScreen">
    <div class="title-wrapper">
      <h2 :class="{'slide-left-to-right':onScreen}">- {{ subTitle }}</h2>
      <h1 :class="{'slide-top-to-bottom':onScreen}">{{ title }}</h1>
    </div>
  </AppearAnimation>
</template>

<script setup lang="ts">
import {ref} from "vue";
import AppearAnimation from "@/vue/global/AppearAnimation.vue";

const onScreen = ref(false)

defineProps({
  title: String,
  subTitle: String
})
</script>

<style scoped lang="scss">
.title-wrapper {
  width: fit-content;
  display: flex;
  flex-direction: column;
  justify-content: center;

  h2 {
    font-style: normal;
    font-weight: 500;
    font-size: 12px;
    line-height: 24px;
    letter-spacing: 7.5px;
    color: var(--primary-text);
    text-transform: uppercase;
  }

  h1 {
    font-family: PlusJakartaSans, sans-serif;
    font-style: normal;
    font-weight: 700;
    font-size: 36px;
    line-height: 45px;
    color: var(--main);
  }
}
</style>
