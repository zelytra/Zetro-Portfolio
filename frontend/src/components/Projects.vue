<template>
  <section v-for="c of project.contents">
    <component :is="getComponent(c)"/>
  </section>
</template>

<script setup lang="ts">
import {Content, Project} from "@/object/Project";
import {BasicText, ImageText} from "@/object/Project";
import ProfessionalStory from "@/vue/user/ProfessionalStory.vue";
import UserTitle from "@/vue/user/UserTitle.vue";
import PageNotFound from "@components/PageNotFound.vue";

const project: Project = {
  banner: "",
  icon: "",
  link: "",
  name: "",
  tags: [],
  title: "",
  description: "",
  contents: [
    {
      type: "BasicText",
      title: "",
      text: ""
    },
    {
      type: "ImageText",
      title: "",
      text: "",
      image: ""
    }
  ]
}

function getComponent(content: Content): any {
  if (content.type == 'BasicText') {
    return ProfessionalStory
  } else if (content.type == 'ImageText') {
    return UserTitle
  } else {
    return PageNotFound
  }
}
</script>

<style scoped lang="scss">

</style>
