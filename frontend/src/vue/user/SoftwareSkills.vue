<template>
  <section class="software-wrapper" v-if="softwareSkills">
    <Title :title="softwareSkills.title" :sub-title="softwareSkills.subTitle"/>
    <div class="skills">
      <SkillValue class="skill" :skill="skill" v-for="skill of softwareSkills.skills"/>
    </div>
  </section>

</template>

<script setup lang="ts">
import Title from "@/vue/global/Title.vue";
import {onMounted, ref} from "vue";
import {SoftwareSkill} from "@/object/UserProfile";
import {HTTPAxios} from "@/object/HTTPAxios";
import SkillValue from "@/vue/user/SkillValue.vue";

const softwareSkills = ref<SoftwareSkill>()

onMounted(() => {
  new HTTPAxios("user/software-skills.json", null, true).get().then((data) => {
    softwareSkills.value = data.data as SoftwareSkill
  })
})
</script>

<style scoped lang="scss">
.software-wrapper {
  display: flex;
  flex-direction: column;
  gap: 12px;

  .skills {
    display: flex;
    align-items: center;
    flex-wrap: wrap;
    gap: 40px;


    .skill {
      width: 48%;
    }
  }
}
</style>