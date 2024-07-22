<template>
  <section class="blog-trending" v-if="blogs.length>0">
    <!-- <Loading v-if="loading"/> -->
    <div class="title-wrapper-more">
      <Title v-if="blogProvider" :title="blogProvider.title" :sub-title="blogProvider.subTitle" class="title"/>
      <Button @click="router.push('/blog')">
        <p v-if="buttonTraduction">{{buttonTraduction.more}} -></p>
      </Button>
    </div>
    <AppearAnimation :once="true" v-model="onScreen" :threshold="0.2">
      <div class="card-wrapper" v-if="!loading">
        <BlogCard :blog="blog"
                  :class="{'slide-right-to-left':onScreen}"
                  v-for="(blog,indexAnimation) of blogs.filter((x,index)=>index<4).sort((a, b) => new Date(b.date).getTime() - new Date(a.date).getTime())"
                  :style="['animation-delay:'+indexAnimation*0.2+'s','opacity:0']"
                  @click="router.push('/blog/'+blog.urlName)"
                  :key="blog.name"/>
      </div>
    </AppearAnimation>
  </section>
</template>

<script setup lang="ts">
import BlogCard from "@/vue/blog/BlogCard.vue";
import {onMounted, ref} from "vue";
import {Blog, BlogProvider} from "@/object/Blog";
import {HTTPAxios} from "@/object/utils/HTTPAxios";
import {langStore} from "@/store/LangStore";
import router from "@/router";
import Title from "@/vue/global/utils/Title.vue";
import Loading from "@/vue/global/utils/Loading.vue";
import Button from "@/vue/global/form/Button.vue";
import AppearAnimation from "@/vue/global/utils/AppearAnimation.vue";
import {ButtonTraduction} from "@/object/Button";

const blogs = ref<Blog[]>([])
const loading = ref(false)
const onScreen = ref(false)
const blogProvider = ref<BlogProvider>()
const buttonTraduction = ref<ButtonTraduction>()

onMounted(() => {
  loading.value = true
  new HTTPAxios("user/blog.json", null, true).get().then((data) => {
    blogProvider.value = data.data as BlogProvider
  })
  new HTTPAxios("git/blog/" + langStore.get(), null, false).get().then(async (response) => {
    blogs.value = response.data
  })
  new HTTPAxios("/buttons.json", null, true).get().then((data) => {
    buttonTraduction.value = data.data as ButtonTraduction
    loading.value = false
  })
})
</script>

<style scoped lang="scss">
@import "@assets/style.scss";

section.blog-trending {
  max-width: 1600px;
  display: flex;
  flex-direction: column;
  gap: 60px;
  width: 100%;
  position: relative;
  overflow: hidden;

  .card-wrapper {
    width: 100%;
    display: flex;
    flex-wrap: wrap;
    gap: 18px;
    padding-bottom: 10px;

    @media screen and (max-width: $responsive-break-point) {
      flex-wrap: nowrap;
      overflow: hidden;
      overflow-x: auto;
      padding-bottom: 12px;
    }
  }

  .title-wrapper-more {
    display: flex;
    align-items: center;
    justify-content: space-between;
    width: 100%;
    gap: 10px;

    @media screen and (max-width: $responsive-break-point) {
      flex-direction: column;
    }

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
