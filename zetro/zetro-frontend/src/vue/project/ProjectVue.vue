<template>
  <article class="project">
    <Button @click="router.push('/projects')">
      <p v-if="buttonTraduction">{{ "<- "+buttonTraduction.back }}</p>
    </Button>
    <component v-for="content of project.contents"
               :is="getComponent(content)"
               :content="content"/>
    <ProjectTrending/>
  </article>
</template>

<script setup lang="ts">
import {onMounted, PropType, ref} from "vue";
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
import Button from "@/vue/global/form/Button.vue";
import {useHead, useServerHead} from "unhead";
import ProjectTrending from "@/vue/project/ProjectTrending.vue";
import {HTTPAxios} from "@/object/utils/HTTPAxios";
import {ButtonTraduction} from "@/object/Button";

const buttonTraduction = ref<ButtonTraduction>()
const props = defineProps({
  project: {
    type: Object as PropType<Project>,
    required: true
  }
})

onMounted(()=>{
  new HTTPAxios("/buttons.json", null, true).get().then((data) => {
    buttonTraduction.value = data.data as ButtonTraduction
  })
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
  width: 100%;
}
</style>
