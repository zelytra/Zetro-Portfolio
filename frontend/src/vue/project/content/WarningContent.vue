<template>
  <div class="content-wrapper">
    <div class="svg-container">
      <svg width="32" height="32" viewBox="0 0 32 32" fill="none" xmlns="http://www.w3.org/2000/svg">
        <path opacity="0.2"
              d="M16 28C22.6274 28 28 22.6274 28 16C28 9.37258 22.6274 4 16 4C9.37258 4 4 9.37258 4 16C4 22.6274 9.37258 28 16 28Z"
              fill="#FFE8D1"/>
        <path
            d="M16 28C22.6274 28 28 22.6274 28 16C28 9.37258 22.6274 4 16 4C9.37258 4 4 9.37258 4 16C4 22.6274 9.37258 28 16 28Z"
            stroke="#FFE8D1" stroke-width="2" stroke-linecap="round" stroke-linejoin="round"/>
        <path d="M15 15H16V22H17" stroke="#FFE8D1" stroke-width="2" stroke-linecap="round" stroke-linejoin="round"/>
        <path
            d="M16 12C16.8284 12 17.5 11.3284 17.5 10.5C17.5 9.67157 16.8284 9 16 9C15.1716 9 14.5 9.67157 14.5 10.5C14.5 11.3284 15.1716 12 16 12Z"
            fill="#FFE8D1"/>
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
    type: Object as PropType<BasicText>,
    required:true
  }
})
</script>

<style scoped lang="scss">
@import "@assets/style.scss";
.content-wrapper {
  display: flex;
  gap: 10px;
  background: var(--detail-background);
  border: 1px solid var(--detail-border);
  border-left: solid 4px var(--detail-main);
  box-shadow: 0 12px 32px var(--detail-shadow);
  border-radius: 10px;
  padding: 20px;

  @media screen and (max-width: $responsive-break-point) {
    padding: 7px;
  }

  .content {
    display: flex;
    flex-direction: column;
    gap: 6px;

    h2 {
      font-family: PlusJakartaSans, sans-serif;
      font-weight: 500;
      font-size: 16px;
      line-height: 24px;
      color: var(--main);
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
