<template>
  <section class="projects" v-if="!selectedProject">
    <Loading v-if="!selectedProject && loading"/>
    <Title v-if="projectProvider" :title="projectProvider.title" :sub-title="projectProvider.subTitle" class="title"/>
    <div class="filters-wrapper">
      <SelectInput v-if="projectProvider"
                   v-for="provider of projectProvider.filters"
                   :options="provider.tags"
                   @select-change="updateFilter(provider.name,$event)"
                   :place-holder="provider.name"/>
    </div>
    <div class="card-wrapper" v-if="!loading">
      <transition-group>
        <ProjectCard :project="project"
                     v-for="project of filteredProject"
                     @click="router.push('/projects/'+project.name)"
                     :key="project.name"/>
      </transition-group>
    </div>
  </section>
  <section class="projects" v-else>
    <ProjectVue v-if="selectedProject" :project="selectedProject"/>
  </section>
</template>

<script setup lang="ts">
import type {Project, ProjectProvider} from "@/object/Project";
import ProjectVue from "@/vue/project/ProjectVue.vue"
import {onMounted, ref} from "vue";
import {GitNode} from "@/object/GitNode";
import {HTTPAxios} from "@/object/HTTPAxios";
import Title from "@/vue/global/Title.vue";
import ProjectCard from "@/vue/project/ProjectCard.vue";
import {onBeforeRouteUpdate, useRoute} from "vue-router";
import router from "@/router";
import Loading from "@/vue/global/Loading.vue";
import SelectInput from "@/vue/global/SelectInput.vue";

const projects = ref<Project[]>([])
const filterMap = ref<Map<string, string[]>>(new Map<string, string[]>())
const filteredProject = ref<Project[]>([])
const selectedProject = ref()
const nodes = ref<GitNode[]>([])
const route = useRoute()
const loading = ref(false)

const projectProvider = ref<ProjectProvider>()

onMounted(() => {
  loading.value = true
  new HTTPAxios("user/project.json", null, true).get().then((data) => {
    projectProvider.value = data.data as ProjectProvider
  })
  new HTTPAxios("git/project", null, false).get().then(async (response) => {
    nodes.value = response.data
    for (const node of nodes.value) {
      await loadProject(node.url)
    }
    updateFilter('', [])
    updateSelectedProject(route.params.project as string)
    loading.value = false
  })
})

onBeforeRouteUpdate((newRoute: any) => {
  updateSelectedProject(newRoute.params.project)
})

function updateFilter(key: string, value: string[]) {
  filterMap.value.set(key, value);

  filteredProject.value = projects.value;
  if (filterMap.value.size > 0) {
    // filter projects that do not match the filters
    const filterValues = projects.value.filter((project) => {
      return Array.from(filterMap.value).some(([filterKey, filterValues]) => {
        return project.tags.some((tagValue) => filterValues.includes(tagValue));
      });
    });

    if (Array.from(filterMap.value.values()).every((value) => value.length === 0)) {
      // no filter, show all projects
      filteredProject.value = projects.value;
    } else {
      // filter projects that do not match the filters
      filteredProject.value = filterValues;
    }
  }
}

function updateSelectedProject(projectName: string) {
  if (projectName) {
    for (let project of projects.value) {
      if (project.name === projectName) {
        selectedProject.value = project
        filteredProject.value = projects.value
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
  min-height: 300px;

  .filters-wrapper {
    display: flex;
    gap: 12px;
    align-items: center;
    align-self: start;
  }

  .card-wrapper {
    display: flex;
    flex-wrap: wrap;
    gap: 18px;
  }
}

.v-enter-active {
  transition: 0.2s ease;
}

.v-leave-active {
  position: absolute;
}

.v-enter-from,
.v-leave-to {
  opacity: 0;
}
</style>
