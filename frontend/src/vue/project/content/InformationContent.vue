<template>
  <div class="content-wrapper">
    <div class="svg-container">
      <svg width="32" height="32" viewBox="0 0 32 32" fill="none" xmlns="http://www.w3.org/2000/svg">
        <path opacity="0.2"
              d="M16 28C22.6274 28 28 22.6274 28 16C28 9.37258 22.6274 4 16 4C9.37258 4 4 9.37258 4 16C4 22.6274 9.37258 28 16 28Z"
              fill="#5056E0"/>
        <path
            d="M16 28C22.6274 28 28 22.6274 28 16C28 9.37258 22.6274 4 16 4C9.37258 4 4 9.37258 4 16C4 22.6274 9.37258 28 16 28Z"
            stroke="#5056E0" stroke-width="2" stroke-linecap="round" stroke-linejoin="round"/>
        <path d="M15 15H16V22H17" stroke="#5056E0" stroke-width="2" stroke-linecap="round" stroke-linejoin="round"/>
        <path
            d="M16 12C16.8284 12 17.5 11.3284 17.5 10.5C17.5 9.67157 16.8284 9 16 9C15.1716 9 14.5 9.67157 14.5 10.5C14.5 11.3284 15.1716 12 16 12Z"
            fill="#5056E0"/>
      </svg>
    </div>
    <div class="content">
      <h2>{{ content.title }}</h2>
      <p>{{ content.text }}</p>
    </div>
  </div>
</template>

<script setup lang="ts">
import {PropType} from "vue";
import {BasicText} from "@/object/Project";

defineProps({
  content: {
    type: Object as PropType<BasicText>
  }
})
</script>

<style scoped lang="scss">
.content-wrapper {
  display: flex;
  gap: 10px;
  background: rgba(80, 86, 224, 0.1);
  border: 1px solid rgba(80, 86, 224, 0.1);
  box-shadow: 0 12px 32px rgba(6, 28, 61, 0.08);
  border-left: solid 4px #5056E0;
  border-radius: 10px;
  padding: 20px;

  .content {
    display: flex;
    flex-direction: column;
    gap: 6px;

    h2 {
      font-family: PlusJakartaSans, sans-serif;
      font-weight: 500;
      font-size: 16px;
      line-height: 24px;
      color: #5056E0;
    }

    p {
      font-family: PlusJakartaSans, sans-serif;
      font-style: normal;
      font-weight: 400;
      font-size: 14px;
      line-height: 20px;
    }
  }
}
</style>
