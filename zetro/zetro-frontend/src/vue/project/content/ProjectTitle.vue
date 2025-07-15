<template>
  <div class="project-title">
    <div class="content">
      <h1>{{ content.title }}</h1>
      <p>{{ content.description }}</p>
      <div class="tags">
        <span v-for="tag of content.tags">{{ tag }}</span>
      </div>
    </div>
    <div class="content">
      <img :src="content.icon"/>
    </div>
  </div>
</template>

<script setup lang="ts">
import {PropType} from "vue";
import {Title} from "@/object/Project";

defineProps({
  content: {
    type: Object as PropType<Title>,
    required: true
  }
})
</script>

<style scoped lang="scss">
@import "@assets/style.scss";

.project-title {
  display: flex;
  width: auto;
  justify-content: space-between;
  align-items: start;

  @media screen and (max-width: $responsive-break-point) {
    align-items: center;
  }

  .content {
    display: flex;
    flex-direction: column;
    gap: 12px;
    max-width: 65%;

    h1 {
      font-family: PlusJakartaSans, sans-serif;
      font-style: normal;
      font-weight: 700;
      font-size: 35px;
      line-height: 42px;
      color: var(--main);
    }

    p {
      font-style: normal;
      font-weight: 400;
      font-size: 16px;
      line-height: 26px;

    }

    img {
      width: 180px;
      border-radius: 8px;
      overflow: hidden;
      align-self: center;

      @media screen and (max-width: $responsive-break-point) {
        width: 80px;
      }
    }

    .tags {
      display: flex;
      gap: 10px;

      span {
        border: 1px solid var(--main);
        border-radius: 4px;
        padding: 4px 8px;
        color: var(--main);
      }
    }
  }
}
</style>
