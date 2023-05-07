<template>
  <article class="project">
    <Button @click="router.push('/projects')">
      <p>{{"<- Retour"}}</p>
    </Button>
    <component v-for="content of project.contents"
               :is="getComponent(content)"
               :content="content"/>
  </article>
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
import ProjectSkills from "@/vue/project/content/ProjectSkills.vue";
import ProjectContributor from "@/vue/project/content/ProjectContributor.vue";
import WarningContent from "@/vue/project/content/WarningContent.vue";
import ErrorContent from "@/vue/project/content/ErrorContent.vue";
import InformationContent from "@/vue/project/content/InformationContent.vue";
import ExternalLinksVue from "@/vue/project/content/ExternalLinksVue.vue";
import router from "@/router";
import Button from "@/vue/global/Button.vue";

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
    case 'ProjectSkill':
      return ProjectSkills
    case 'Contributor':
      return ProjectContributor
    case 'Warning':
      return WarningContent
    case 'Error':
      return ErrorContent
    case 'Information':
      return InformationContent
    case 'ExternalLinks':
      return ExternalLinksVue
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
