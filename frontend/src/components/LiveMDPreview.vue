<template>
  <section>
    <div class="editor">
      <textarea class="text-area" v-model="preview"/>
    </div>
    <div class="render">
      <ProjectVue :project="getProject()"/>
    </div>
  </section>
</template>

<script setup lang="ts">
import {ref} from "vue";
import ProjectVue from "@/vue/project/ProjectVue.vue";
import {Project} from "@/object/Project";

const preview = ref<string>("{}")

function getProject() {
  try {
    return JSON.parse(preview.value) as Project
  } catch (e) {
    console.error(e)
    return {} as Project
  }

}
</script>

<style scoped lang="scss">
section {
  padding: 60px 10%;
  max-width: 1600px;
  margin: auto;
  display: flex;
  flex-direction: column;
  gap: 60px;
  align-items: center;
  position: relative;
  overflow: hidden;
  min-height: 400px;

  .editor {
    width: 100%;

    .text-area {
      width: 100%;
      height: 120px;
      background: transparent;
      border-radius: 8px;
      padding: 4px;
    }
  }
}
</style>