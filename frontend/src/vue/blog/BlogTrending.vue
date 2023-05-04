<template>
  <section class="blog-trending">
    <Loading v-if="loading"/>
    <div class="title-wrapper-more">
      <Title v-if="blogProvider" :title="blogProvider.title" :sub-title="blogProvider.subTitle" class="title"/>
      <router-link class="more" to="/blog">Voir plus</router-link>
    </div>
    <div class="card-wrapper" v-if="!loading">
      <transition-group>
        <BlogCard :blog="blog"
                  v-for="blog of blogs.filter((x,index)=>index<4).sort((a, b) => new Date(b.date).getTime() - new Date(a.date).getTime())"
                  @click="router.push('/blog/'+blog.urlName)"
                  :key="blog.name"/>
      </transition-group>
    </div>
  </section>
</template>

<script setup lang="ts">
import BlogCard from "@/vue/blog/BlogCard.vue";
import {onMounted, ref} from "vue";
import {Blog, BlogProvider} from "@/object/Blog";
import {HTTPAxios} from "@/object/HTTPAxios";
import {langStore} from "@/store/LangStore";
import router from "@/router";
import Title from "@/vue/global/Title.vue";
import Loading from "@/vue/global/Loading.vue";

const blogs = ref<Blog[]>([])
const loading = ref(false)

const blogProvider = ref<BlogProvider>()

onMounted(() => {
  loading.value = true
  new HTTPAxios("user/blog.json", null, true).get().then((data) => {
    blogProvider.value = data.data as BlogProvider
  })
  new HTTPAxios("git/blog/" + langStore.get(), null, false).get().then(async (response) => {
    blogs.value = response.data
    loading.value = false
  })
})
</script>

<style scoped lang="scss">
section.blog-trending {
  padding: 0 10%;
  max-width: 1600px;
  margin: auto;
  display: flex;
  flex-direction: column;
  gap: 60px;
  align-items: center;
  position: relative;
  overflow: hidden;

  .card-wrapper {
    width: 100%;
    display: flex;
    flex-wrap: wrap;
    gap: 18px;
  }

  .title-wrapper-more {
    display: flex;
    flex-direction: column;
    align-items: center;
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
