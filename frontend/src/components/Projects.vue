<template>
  <section class="projects" v-if="!selectedProject && !loading">
    <Loading v-if="!selectedProject && loading"/>
    <Title title="Mes projets" sub-title="Mes oeuvres" class="title"/>
    <div class="card-wrapper" v-if="!loading">
      <transition-group>
        <ProjectCard :project="project" v-for="project of projects" @click="router.push('/projects/'+project.name)" :key="project.name"/>
      </transition-group>
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
import Loading from "@/vue/global/Loading.vue";

const projects = ref<Project[]>([])
const selectedProject = ref()
const nodes = ref<GitNode[]>([])
const route = useRoute()
const loading = ref(false)

onMounted(() => {
  loading.value = true
  new HTTPAxios("git/project", null, false).get().then(async (response) => {
    nodes.value = response.data
    for (const node of nodes.value) {
      await loadProject(node.url)
    }
    updateSelectedProject(route.params.project as string)
    loading.value = false
  })
})

onBeforeRouteUpdate((newRoute: any) => {
  updateSelectedProject(newRoute.params.project)
})

function updateSelectedProject(projectName: string) {
  if (projectName) {
    for (let project of projects.value) {
      if (project.name === projectName) {
        selectedProject.value = project
        break
      }
    }
  } else {
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
  padding: 60px 10%;
  max-width: 1600px;
  margin: auto;
  display: flex;
  flex-direction: column;
  gap: 60px;
  align-items: center;
  position: relative;
  overflow: hidden;

  .card-wrapper {
    display: flex;
    flex-wrap: wrap;
    gap: 18px;
  }
}

.v-leave-active, .v-enter-active {
  transition: 0.2s ease;
}

.v-enter-from,
.v-leave-to {
  opacity: 0;
}
</style>
