<template>
  <section class="project-trending">
    <!-- <Loading v-if="loading"/> -->
    <div class="title-wrapper-more">
      <Title v-if="projectProvider" :title="projectProvider.title" :sub-title="projectProvider.subTitle" class="title"/>
      <Button @click="router.push('/projects')">
        <p>Voir plus -></p>
      </Button>
    </div>
    <div class="card-wrapper" v-if="!loading">
      <transition-group>
        <ProjectCard :project="project"
                     v-for="project of projects.sort((a, b) => new Date(b.date).getTime() - new Date(a.date).getTime())"
                     @click="router.push('/projects/'+project.url)"
                     :key="project.name"/>
      </transition-group>
    </div>
  </section>
</template>

<script setup lang="ts">
import {onMounted, ref} from "vue";
import {Project, ProjectProvider} from "@/object/Project";
import {GitNode} from "@/object/utils/GitNode";
import {HTTPAxios} from "@/object/utils/HTTPAxios";
import {langStore} from "@/store/LangStore";
import router from "@/router";
import ProjectCard from "@/vue/project/ProjectCard.vue";
import Loading from "@/vue/global/utils/Loading.vue";
import Title from "@/vue/global/utils/Title.vue";
import Button from "@/vue/global/form/Button.vue";

const projects = ref<Project[]>([])
const nodes = ref<GitNode[]>([])
const loading = ref(false)

const projectProvider = ref<ProjectProvider>()

onMounted(() => {
  loading.value = true
  new HTTPAxios("user/project.json", null, true).get().then((data) => {
    projectProvider.value = data.data as ProjectProvider
  })
  new HTTPAxios("git/project/" + langStore.get(), null, false).get().then(async (response) => {
    nodes.value = response.data
    for (const [index, value] of nodes.value.entries()) {
      if (index >= 5) break
      await loadProject(value.url)
    }
    loading.value = false
  })
})

async function loadProject(url: string) {
  await new HTTPAxios(url.split(langStore.get() + "/")[1], null, true).get().then((response) => {
    projects.value.push(response.data)
  })
}
</script>

<style scoped lang="scss">
section.project-trending {
  max-width: 1600px;
  display: flex;
  width: 100%;
  flex-direction: column;
  gap: 60px;
  position: relative;
  overflow: hidden;

  .card-wrapper {
    display: flex;
    flex-wrap: wrap;
    gap: 18px;
  }

  .title-wrapper-more {
    display: flex;
    align-items: center;
    justify-content: space-between;
    width: 100%;
    gap: 10px;

    .more:hover {
      color: var(--main);
    }
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
