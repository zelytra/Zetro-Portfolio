<template>
  <section class="projects">
    <Loading v-if="loading"/>
    <Title v-if="templateProvider" :title="templateProvider.title" :sub-title="templateProvider.subTitle"
           class="title"/>
    <div class="filters-wrapper">
      <SelectInput v-if="templateProvider"
                   v-for="provider of templateProvider.filters"
                   :options="provider.tags"
                   @select-change="updateFilter(provider.name,$event)"
                   :place-holder="provider.name"/>
      <RangeSelectInput @select-change="updatePriceFilter($event)"
                        :place-holder="'Price'"/>
    </div>
    <div class="card-wrapper" v-if="!loading">
      <transition-group>
        <TemplateCard :template="template"
                      v-for="(template,index) of filteredTemplate.sort((a, b) => new Date(b.date).getTime() - new Date(a.date).getTime())"
                      @click="redirectTo(template.redirection)"
                      :key="template.name"/>
      </transition-group>
    </div>
  </section>
</template>

<script setup lang="ts">
import {onMounted, ref} from "vue";
import {GitNode} from "@/object/utils/GitNode";
import {HTTPAxios} from "@/object/utils/HTTPAxios";
import Title from "@/vue/global/utils/Title.vue";
import Loading from "@/vue/global/utils/Loading.vue";
import SelectInput from "@/vue/global/form/SelectInput.vue";
import {langStore} from "@/store/LangStore";
import {Template, TemplateProvider} from "@/object/Template";
import TemplateCard from "@/vue/template/TemplateCard.vue";
import RangeSelectInput from "@/vue/global/form/RangeSelectInput.vue";
import {Range} from "@/object/UserProfile";
import AppearAnimation from "@/vue/global/utils/AppearAnimation.vue";

const templates = ref<Template[]>([])
const filterMap = ref<Map<string, string[]>>(new Map<string, string[]>())
const filteredTemplate = ref<Template[]>([])
const nodes = ref<GitNode[]>([])
const loading = ref(false)
const onScreen = ref(false)
const templateProvider = ref<TemplateProvider>()

onMounted(() => {
  loading.value = true
  new HTTPAxios("user/templates.json", null, true).get().then((data) => {
    templateProvider.value = data.data as TemplateProvider
  })
  new HTTPAxios("git/template/" + langStore.get(), null, false).get().then(async (response) => {
    nodes.value = response.data
    for (const node of nodes.value) {
      await loadTemplate(node.url)
    }
    updateFilter('', [])
    loading.value = false
  })
})

function updateFilter(key: string, value: string[]) {
  filterMap.value.set(key, value);

  filteredTemplate.value = templates.value;
  if (filterMap.value.size > 0) {
    // filter projects that do not match the filters
    const filterValues = templates.value.filter((template) => {
      return Array.from(filterMap.value).some(([filterKey, filterValues]) => {
        return template.tags.some((tagValue) => filterValues.includes(tagValue));
      });
    });

    if (Array.from(filterMap.value.values()).every((value) => value.length === 0)) {
      // no filter, show all projects
      filteredTemplate.value = templates.value;
    } else {
      // filter projects that do not match the filters
      filteredTemplate.value = filterValues;
    }
  }
}

function updatePriceFilter(range: Range) {
  if (!range) {
    filteredTemplate.value = templates.value
    return
  }
  filteredTemplate.value = templates.value.filter((template) =>
      template.price >= range.min && template.price <= range.max
  )
}

async function loadTemplate(url: string) {
  await new HTTPAxios(url.split(langStore.get() + "/")[1], null, true).get().then((response) => {
    templates.value.push(response.data)
  })
}

function redirectTo(link: string) {
  window.open(link, "blank")
}
</script>

<style scoped lang="scss">
@import "@assets/style.scss";

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
  min-height: 400px;

  .filters-wrapper {
    display: flex;
    gap: 12px;
    width: 100%;
    justify-content: center;
    align-items: center;
    align-self: start;
    @media screen and (max-width: $responsive-break-point) {
      flex-direction: column;
    }
  }

  .card-wrapper {
    display: flex;
    flex-wrap: wrap;
    gap: 18px;
    justify-content: center;
    width: 100%;
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
