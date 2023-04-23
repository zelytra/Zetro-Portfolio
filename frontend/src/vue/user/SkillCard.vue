<template>
  <div class="skill-container">
    <div class="image-container">
      <img :src="icon" alt="Skill icon">
    </div>
    <h3>{{ title }}</h3>
    <p>{{ content }}</p>
  </div>
</template>

<script setup lang="ts">
defineProps({
  icon: String,
  title: String,
  content: String
})
</script>

<style scoped lang="scss">
.skill-container {
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  gap: 18px;
  padding: 20px;
  border: solid 1px var(--main);
  border-radius: 8px;
  width: 300px;
  height: 220px;

  .image-container {
    border: solid 1px var(--main);
    padding: 16px;
    border-radius: 8px;
    display: flex;
    justify-content: center;
  }

  h3 {
    font-family: PlusJakartaSans, sans-serif;
    font-style: normal;
    font-weight: 500;
    font-size: 16px;
    line-height: 20px;
    color: var(--main);
  }

  p {
    text-align: center;
    font-style: normal;
    font-weight: 400;
    font-size: 14px;
    line-height: 24px;
  }

  &:hover {
    background: rgba(255, 232, 209, 0.1);


    .image-container {
      background: var(--main);

      img {
        transition: filter 0ms;
        filter: brightness(0%);
      }
    }
  }
}
</style>