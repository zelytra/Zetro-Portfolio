<template>
  <section class="home-wrapper">
    <UserTitle/>
    <Title class="title" sub-title="SERVICES" title="Spécialisé dans"/>
    <section class="specialisation">
      <SkillCard title="UI/UX Design"
                 content="Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed suscipit condimentum dolor. Nullam eu sollicitudin lacus."
                 :icon="crown"/>
      <SkillCard title="Graphiste"
                 content="Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed suscipit condimentum dolor. Nullam eu sollicitudin lacus."
                 :icon="stack"/>
      <SkillCard title="Web Development"
                 content="Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed suscipit condimentum dolor. Nullam eu sollicitudin lacus."
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
</script>

<style scoped lang="scss">
section.home-wrapper {
  padding: 60px 10%;
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
