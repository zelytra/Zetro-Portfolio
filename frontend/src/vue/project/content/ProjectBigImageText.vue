<template>
  <div class="big-image-text">
    <div class="content">
      <h2>{{ content.title }}</h2>
      <p>{{ content.text }}</p>
    </div>
    <div class="content image">
      <img :src="content.image"/>
    </div>
  </div>
</template>

<script setup lang="ts">
import {PropType} from "vue";
import {BigImageText} from "@/object/Project";

defineProps({
  content: {
    type: Object as PropType<BigImageText>
  }
})
</script>

<style scoped lang="scss">
.big-image-text {
  display: flex;
  flex-direction: column;
  gap: 15px;

  .content {
    display: flex;
    flex-direction: column;
    justify-content: center;
    gap: 10px;

    h2 {
      font-style: normal;
      font-weight: 700;
      font-size: 25px;
      line-height: 32px;
      color: var(--main)
    }

    p {
      font-style: normal;
      font-weight: 400;
      font-size: 16px;
      line-height: 26px;
    }

    &.image {
      align-self: center;

      img {
        max-height: 500px;
        aspect-ratio: auto;
        border-radius: 8px;
        overflow: hidden;
      }
    }
  }
}
</style>
