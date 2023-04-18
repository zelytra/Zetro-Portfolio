<template>
  <section class="projects" v-if="!selectedProject">
    <Title title="Mes projets" sub-title="Mes oeuvres"/>
    <div class="card-wrapper">
      <ProjectCard :project="project" v-for="project of projects" @click="router.push('/projects/'+project.name)"/>
    </div>
  </section>
  <section class="projects" v-else>
    <ProjectVue v-if="selectedProject" :project="selectedProject"/>
  </section>
</template>

<script setup lang="ts">
import type {Project} from "@/object/Project";
import ProjectVue from "@/vue/project/ProjectVue.vue"
import {onMounted, ref} from "vue";
import {GitNode} from "@/object/GitNode";
import {HTTPAxios} from "@/object/HTTPAxios";
import Title from "@/vue/global/Title.vue";
import ProjectCard from "@/vue/project/ProjectCard.vue";
import {onBeforeRouteUpdate, useRoute} from "vue-router";
import router from "@/router";

const projects = ref<Project[]>([])
const selectedProject = ref()
const nodes = ref<GitNode[]>([])
const route = useRoute()

onMounted(() => {
  new HTTPAxios("git/project", null, false).get().then(async (response) => {
    nodes.value = response.data
    for (const node of nodes.value) {
      await loadProject(node.url)
    }
    updateSelectedProject(route.params.project as string)
  })
})

onBeforeRouteUpdate((newRoute: any) => {
  updateSelectedProject(newRoute.params.project)
})

function updateSelectedProject(projectName:string){
  if (projectName) {
    for (let project of projects.value) {
      if (project.name === projectName) {
        selectedProject.value = project
        break
      }
    }
  }else {
    selectedProject.value = null;
  }
}

async function loadProject(url: string) {
  await new HTTPAxios(url.split("fr/")[1], null, true).get().then((response) => {
    projects.value.push(response.data)
  })
}
</script>

<style scoped lang="scss">
section.projects {
  margin: 60px 10%;
  display: flex;
  flex-direction: column;
  gap: 10px;

  .card-wrapper {
    display: flex;
    gap: 18px;
  }
}
</style>
