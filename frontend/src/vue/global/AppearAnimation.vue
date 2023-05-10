<template>
  <div class="appear-animation" ref="scrollRef">
    <slot/>
  </div>
</template>

<script setup lang="ts">


import {onMounted, onUnmounted, ref} from "vue";
import {onIntersect} from "@/object/utils/IntersectionListener";

const observer = ref<IntersectionObserver>();
const scrollRef = ref();

const props = defineProps({
  once: Boolean,
  modelValue: Boolean
})

const emits = defineEmits(['update:modelValue'])

onMounted(() => {
  observer.value = onIntersect(scrollRef.value, () => {
    emits('update:modelValue', true)
  }, () => {
    emits('update:modelValue', false)
  }, props.once, {
    threshold: 0.85,
  });
})


onUnmounted(() => {
  if (observer.value) observer.value.disconnect();
})
</script>

<style scoped>

</style>