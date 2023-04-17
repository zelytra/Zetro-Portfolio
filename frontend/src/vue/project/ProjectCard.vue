<template>
  <div class="project-card">
    <div class="content banner">
      <img :src="props.project.banner"/>
    </div>
    <div class="content">
      <h4>{{ props.project.name }}</h4>
      <div class="tags">
        <span v-for="tag of props.project.tags">{{ tag }}</span>
        <img src="@assets/icons/link.svg"/>
      </div>
    </div>
  </div>
</template>

<script setup lang="ts">
import {PropType, ref} from "vue";
import {Project} from "@/object/Project";

const props = defineProps({
  project: {
    type: Object as PropType<Project>,
    required: true
  }
})
</script>

<style scoped lang="scss">

</style>
