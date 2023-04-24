<template>
  <section class="home-wrapper">
    <UserTitle/>
    <Title class="title" v-if="service" :sub-title="service.subTitle" :title="service.title"/>
    <section class="specialisation" v-if="service">
      <SkillCard :title="service.cards[0].title"
                 :content="service.cards[0].content"
                 :icon="crown"/>
      <SkillCard :title="service.cards[1].title"
                 :content="service.cards[1].content"
                 :icon="stack"/>
      <SkillCard :title="service.cards[2].title"
                 :content="service.cards[2].content"
                 :icon="web"/>
    </section>
    <ProfessionalStory class="professional-wrapper"/>
    <SchoolStory/>
  </section>
</template>

<script setup lang="ts">
import UserTitle from "@/vue/user/UserTitle.vue";
import Title from "@/vue/global/Title.vue";
import SkillCard from "@/vue/user/SkillCard.vue";
import crown from "@assets/icons/crown.svg"
import stack from "@assets/icons/stack.svg"
import web from "@assets/icons/web.svg"
import ProfessionalStory from "@/vue/user/ProfessionalStory.vue";
import SchoolStory from "@/vue/user/SchoolStory.vue";
import {onMounted, ref} from "vue";
import {Service} from "@/object/UserProfile";
import {HTTPAxios} from "@/object/HTTPAxios";

const service = ref<Service>()

onMounted(() => {
  new HTTPAxios("user/services.json", null, true).get().then((data) => {
    service.value = data.data
  })
})
</script>

<style scoped lang="scss">
section.home-wrapper {
  padding: 60px 10%;
  max-width: 1600px;
  margin: auto;

  .title {
    margin: 120px auto;
  }

  section.specialisation {
    display: flex;
    justify-content: center;
    align-items: center;
    gap: 40px;
  }

  .professional-wrapper {
    margin: 120px auto;
  }
}
</style>
