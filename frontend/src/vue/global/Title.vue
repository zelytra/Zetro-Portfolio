<template>
  <div class="title-wrapper">
    <h2>- {{ subTitle }}</h2>
    <h1>{{ title }}</h1>
  </div>
</template>

<script setup lang="ts">
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