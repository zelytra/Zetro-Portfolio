<template>
  <div class="basic-text">
    <h2>{{ content.title }}</h2>
    <p>{{ content.text }}</p>
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
.basic-text {
  display: flex;
  flex-direction: column;
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
}
</style>
