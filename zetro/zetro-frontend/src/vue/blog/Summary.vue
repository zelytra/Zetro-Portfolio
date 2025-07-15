<template>
  <div class="summary">
    <p v-for="heading of headings"
       @click="scrollToHeading(heading)">
      - {{ heading.innerHTML }}
    </p>
  </div>
</template>

<script setup lang="ts">
import {PropType} from "vue";

defineProps({
  headings: Object as PropType<Element[]>
})

function scrollToHeading(heading: Element) {
  const targetHeading = document.getElementById(heading.id);
  if (!targetHeading) return;
  const headerOffset = 100;
  const elementPosition = targetHeading!.getBoundingClientRect().top;
  const offsetPosition = elementPosition + window.screenY - headerOffset;
  window.scrollTo({top: offsetPosition, behavior: 'smooth'})
}
</script>

<style scoped lang="scss">
.summary {
  display: flex;
  flex-direction: column;
  align-items: start;
  gap: 10px;
  min-width: 15%;

  p {
    font-family: PlusJakartaSans, sans-serif;
    color: var(--primary-text);
    filter: brightness(0.9);
    cursor: pointer;
    font-size: 15px;

    &:hover {
      filter: brightness(1);
    }
  }
}
</style>
