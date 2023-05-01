<template>
  <section class="marked-wrapper">
    <MarkdownVue markdown-src="https://raw.githubusercontent.com/ZeTro-dev/portfolio/main/fr/CGU.md"/>
  </section>
</template>

<script setup lang="ts">
import MarkdownVue from "@/vue/blog/MarkdownVue.vue";
</script>

<style scoped lang="scss">
.marked-wrapper {
  padding: 60px 10%;
  max-width: 1600px;
  margin: auto;
  display: flex;
  flex-direction: column;
  gap: 60px;
  align-items: center;
  position: relative;
  overflow: hidden;
  min-height: 300px;
}
</style>
