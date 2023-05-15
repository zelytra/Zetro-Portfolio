<template>
  <section class="home-wrapper">
    <UserTitle @on-loaded="onLoad = true"/>
    <ServicesTrending v-if="onLoad"/>
    <ProjectTrending v-if="onLoad"/>
    <ProfessionalStory v-if="onLoad"/>
    <BlogTrending v-if="onLoad"/>
    <SchoolStory v-if="onLoad"/>
    <SoftwareSkills v-if="onLoad"/>
  </section>
</template>

<script setup lang="ts">
import UserTitle from "@/vue/user/UserTitle.vue";
import ProfessionalStory from "@/vue/user/ProfessionalStory.vue";
import SchoolStory from "@/vue/user/SchoolStory.vue";
import BlogTrending from "@/vue/blog/BlogTrending.vue";
import ProjectTrending from "@/vue/project/ProjectTrending.vue";
import SoftwareSkills from "@/vue/user/SoftwareSkills.vue";
import ServicesTrending from "@/vue/user/services/ServicesTrending.vue";
import {ref} from "vue";

const onLoad = ref(false)
</script>

<style scoped lang="scss">
@import "@assets/style.scss";
section.home-wrapper {
  display: flex;
  flex-direction: column;
  gap: 200px;
  padding: 60px 10%;
  max-width: 1600px;
  margin: auto;
  z-index: 1;


  @media screen and (max-width: $responsive-break-point) {
    padding: 60px 10%;
  }
}
</style>
