<template>
  <div class="links-wrapper">
    <h2>{{ content.title }}</h2>
    <div class="buttons">
      <a class="button" :href="link.link" target="_blank" v-for="link of content.links">
        <img :src="link.icon">
        <p>{{ link.name }}</p>
      </a>
    </div>
  </div>
</template>

<script setup lang="ts">
import {PropType} from "vue";
import {BasicText, ExternalLinks} from "@/object/Project";

defineProps({
  content: {
    type: Object as PropType<ExternalLinks>,
    required:true
  }
})
</script>

<style scoped lang="scss">
.links-wrapper {
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  gap: 20px;

  h2 {
    font-family: PlusJakartaSans, sans-serif;
    font-style: normal;
    font-weight: 700;
    font-size: 25px;
    line-height: 32px;
    color: var(--main);
  }

  .buttons {
    display: flex;
    gap: 10px;
    align-items: center;

    .button {
      display: flex;
      align-items: center;
      gap: 10px;
      background: rgba(255, 232, 209, 0.1);
      border: 1px solid var(--main);
      border-radius: 4px;
      padding: 15px 18px;
      cursor: pointer;

      img {
        width: 23px;
      }

      p {
        color: white;
        font-style: normal;
        font-weight: 600;
        font-size: 16px;
        line-height: 19px;
      }
    }
  }
}
</style>
