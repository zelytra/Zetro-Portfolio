<template>
  <section class="school-story-wrapper">
    <Title class="title" sub-title="PARCOURS D'APPRENTISSAGE" title="Formations et compétences"/>
    <div class="content-wrapper">
      <div class="content school">
        <div class="school-detail" v-for="school of schools">
          <svg width="16" height="16" viewBox="0 0 16 16" fill="none" xmlns="http://www.w3.org/2000/svg">
            <circle cx="8" cy="8" r="8" fill="white"/>
          </svg>
          <h3>{{ school.location }}</h3>
          <p>{{ school.name }}</p>
          <h4>{{ school.date }}</h4>
        </div>
      </div>
      <div class="content skill">
        <p>Depuis plus de 4 ans, j'apprends continuellement dans le domaine du design web, graphisme et j'expérimente de
          nouvelles approches et de nouveaux styles. Vous trouverez ici un résumé de mes compétences.</p>
        <SkillValue v-for="skill of skills" :skill="skill"/>
      </div>
    </div>
  </section>
</template>

<script setup lang="ts">
import Title from "@/vue/global/Title.vue";
import {SchoolStory, Skill} from "@/object/UserProfile";
import {onMounted, ref} from "vue";
import SkillValue from "@/vue/user/SkillValue.vue";
import {HTTPAxios} from "@/object/HTTPAxios";

const schools = ref<SchoolStory[]>([])
const skills = ref<Skill[]>([])

onMounted(() => {
  new HTTPAxios("user/shool-stories.json").get().then((data) => {
    schools.value = data.data
  })
  new HTTPAxios("user/skills.json").get().then((data) => {
    skills.value = data.data
  })
})
</script>

<style scoped lang="scss">
.school-story-wrapper {
  width: inherit;

  .content-wrapper {
    display: flex;
    justify-content: space-between;
    margin-top: 80px;

    .content {
      max-width: 50%;

      &.skill {
        display: flex;
        flex-direction: column;
        gap: 30px;
      }

      &.school {
        border-left: solid 2px white;
      }

      .school-detail {
        position: relative;
        padding-left: 24px;
        padding-bottom: 40px;
        display: flex;
        flex-direction: column;
        gap: 10px;
        overflow: visible;

        &:last-child {
          height: 0;
          padding-bottom: 0;
          overflow: visible;
        }

        svg {
          position: absolute;
          top: 0;
          left: -9px;
        }

        h3 {
          font-family: PlusJakartaSans, sans-serif;
          font-style: normal;
          font-weight: 500;
          font-size: 20px;
          line-height: 20px;
          color: var(--main);
        }

        h4 {
          font-style: normal;
          font-weight: 500;
          font-size: 16px;
          line-height: 17px;
          color: var(--main);
          margin-top: 14px;
        }

        p {
          font-style: normal;
          font-weight: 400;
          font-size: 16px;
          line-height: 17px;
        }
      }
    }
  }
}
</style>
