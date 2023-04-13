<template>
  <section class="project">
    <component v-for="content of project.contents"
               :is="getComponent(content)"
               :content="content"/>
  </section>
</template>

<script setup lang="ts">
import {PropType} from "vue";
import {Content} from "@/object/Project";
import {Project} from "@/object/Project";
import PageNotFound from "@components/PageNotFound.vue";
import ProjectTitle from "@/vue/project/content/ProjectTitle.vue";
import ProjectBasicText from "@/vue/project/content/ProjectBasicText.vue";
import ProjectImageText from "@/vue/project/content/ProjectImageText.vue";
import ProjectBigImageText from "@/vue/project/content/ProjectBigImageText.vue";

defineProps({
  project: {
    type: Object as PropType<Project>,
    required: true
  }
})

function getComponent(content: Object): any {
  switch ((content as Content).type) {
    case 'Title':
      return ProjectTitle
    case 'BasicText':
      return ProjectBasicText
    case 'ImageText':
      return ProjectImageText
    case 'BigImageText':
      return ProjectBigImageText
    default:
      return PageNotFound
  }
}
</script>

<style scoped lang="scss">
.project {
  display: flex;
  flex-direction: column;
  gap: 30px;
}
</style>
