<template>
  <div class="project-skill">
    <div class="content">
      <h2>{{ content.title }}</h2>
      <p>{{ content.text }}</p>
    </div>
    <div class="content skill">
      <SkillValue v-for="skill of content.skills" :skill="skill"/>
    </div>
  </div>
</template>

<script setup lang="ts">
import {PropType} from "vue";
import {BasicText, ProjectSkill} from "@/object/Project";
import SkillValue from "@/vue/user/SkillValue.vue";

defineProps({
  content: {
    type: Object as PropType<ProjectSkill>,
    required: true
  }
})
</script>

<style scoped lang="scss">
.project-skill {
  display: flex;
  justify-content: center;
  align-items: center;
  gap: 10px;

  .content {
    width: 50%;

    h2 {
      font-style: normal;
      font-weight: 700;
      font-size: 25px;
      line-height: 32px;
      color: var(--main)
    }

    p {
      font-style: normal;
      font-weight: 400;
      font-size: 16px;
      line-height: 26px;
    }

    &.skill {
      display: flex;
      flex-direction: column;
      gap: 20px;
      width: 100%;
    }
  }
}
</style>
