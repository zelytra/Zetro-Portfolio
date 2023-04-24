<template>
  <div class="image-text">
    <div class="content">
      <h2>{{ content.title }}</h2>
      <p>{{ content.text }}</p>
    </div>
    <div class="content">
      <img :src="content.image"/>
    </div>
  </div>
</template>

<script setup lang="ts">
import {PropType} from "vue";
import {ImageText} from "@/object/Project";

defineProps({
  content: {
    type: Object as PropType<ImageText>,
    required:true
  }
})
</script>

<style scoped lang="scss">
.image-text {
  display: flex;
  justify-content: space-between;
  max-width: 1600px;

  .content {
    display: flex;
    flex-direction: column;
    justify-content: center;
    gap: 10px;
    max-width: 75%;

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

    img {
      width: 180px;
      aspect-ratio: auto;
      border-radius: 8px;
      overflow: hidden;
    }
  }
}
</style>
