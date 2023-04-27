<template>
  <section class="home-wrapper">
    <UserTitle/>
    <div class="services-wrapper">
      <Title class="title" v-if="service" :sub-title="service.subTitle" :title="service.title"/>
      <section class="specialisation" v-if="service && service.cards">
        <SkillCard v-for="(card,index) of service.cards"
                   :title="card.title"
                   :content="card.content"
                   :icon="icons[index]"/>

      </section>
    </div>
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
const icons = [crown, stack, web]

onMounted(() => {
  new HTTPAxios("user/services.json", null, true).get().then((data) => {
    service.value = data.data
  })
})
</script>

<style scoped lang="scss">
section.home-wrapper {
  display: flex;
  flex-direction: column;
  gap: 200px;
  padding: 60px 10%;
  max-width: 1600px;
  margin: auto;

  .title {
    margin: auto;
  }

  .services-wrapper {
    display: flex;
    flex-direction: column;
    gap: 80px;
  }

  section.specialisation {
    display: flex;
    justify-content: center;
    align-items: center;
    gap: 40px;
  }
}
</style>
