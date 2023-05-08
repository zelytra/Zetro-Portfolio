<template>
  <section class="blogs" v-if="!selectedBlog">
    <Loading v-if="!selectedBlog && loading"/>
    <Title v-if="blogProvider" :title="blogProvider.title" :sub-title="blogProvider.subTitle" class="title"/>
    <div class="filters-wrapper">
      <SelectInput v-if="blogProvider"
                   v-for="provider of blogProvider.filters"
                   :options="provider.tags"
                   @select-change="updateFilter(provider.name,$event)"
                   :place-holder="provider.name"/>
    </div>
    <div class="card-wrapper" v-if="!loading">
      <transition-group>
        <BlogCard :blog="blog"
                     v-for="blog of filteredBlog.sort((a, b) => new Date(b.date).getTime() - new Date(a.date).getTime())"
                     @click="router.push('/blog/'+blog.urlName)"
                     :key="blog.name"/>
      </transition-group>
    </div>
  </section>
  <section class="blogs" v-else>
    <MarkdownVue v-if="selectedBlog" :markdown-src="selectedBlog"/>
  </section>
</template>

<script setup lang="ts">
import {onMounted, ref} from "vue";
import {HTTPAxios} from "@/object/HTTPAxios";
import Title from "@/vue/global/Title.vue";
import {onBeforeRouteUpdate, useRoute} from "vue-router";
import router from "@/router";
import Loading from "@/vue/global/Loading.vue";
import SelectInput from "@/vue/global/SelectInput.vue";
import {Blog, BlogProvider} from "@/object/Blog";
import MarkdownVue from "@/vue/blog/MarkdownVue.vue";
import BlogCard from "@/vue/blog/BlogCard.vue";
import {langStore} from "@/store/LangStore";

const blogs = ref<Blog[]>([])
const filterMap = ref<Map<string, string[]>>(new Map<string, string[]>())
const filteredBlog = ref<Blog[]>([])
const selectedBlog = ref()
const route = useRoute()
const loading = ref(false)

const blogProvider = ref<BlogProvider>()

onMounted(() => {
  loading.value = true
  new HTTPAxios("user/blog.json", null, true).get().then((data) => {
    blogProvider.value = data.data as BlogProvider
  })
  new HTTPAxios("git/blog/" + langStore.get(), null, false).get().then(async (response) => {
    blogs.value = response.data
    updateFilter('', [])
    updateSelectedBlog(route.params.blog as string)
    loading.value = false
  })
})

onBeforeRouteUpdate((newRoute: any) => {
  updateSelectedBlog(newRoute.params.blog)
})

function updateFilter(key: string, value: string[]) {
  filterMap.value.set(key, value);

  filteredBlog.value = blogs.value;
  if (filterMap.value.size > 0) {
    // filter projects that do not match the filters
    const filterValues = blogs.value.filter((blog) => {
      return Array.from(filterMap.value).some(([filterKey, filterValues]) => {
        return blog.tags.some((tagValue) => filterValues.includes(tagValue));
      });
    });

    if (Array.from(filterMap.value.values()).every((value) => value.length === 0)) {
      // no filter, show all projects
      filteredBlog.value = blogs.value;
    } else {
      // filter projects that do not match the filters
      filteredBlog.value = filterValues;
    }
  }
}

function updateSelectedBlog(blogUrlName: string) {
  if (blogUrlName) {
    for (let blog of blogs.value) {
      if (blog.urlName === blogUrlName) {
        selectedBlog.value = blog.url
        filteredBlog.value = blogs.value
        break
      }
    }
  } else {
    selectedBlog.value = null;
  }
}
</script>

<style scoped lang="scss">
section.blogs {
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
  }

  .card-wrapper {
    width: 100%;
    display: flex;
    flex-wrap: wrap;
    justify-content: center;
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
