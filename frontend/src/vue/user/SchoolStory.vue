<template>
  <section class="school-story-wrapper" v-if="school">
    <AppearAnimation :once="true" v-model="isOnScreen">
      <Title class="title" :sub-title="school.subTitle" title="Formations et compétences"
             :class="{'slide-left-to-right':isOnScreen}" :style="'opacity:0'"/>
      <div class="content-wrapper">
        <div class="content school">
          <div class="school-detail" v-for="schoolStory of school.schools" :class="{'slide-right-to-left':isOnScreen}">
            <svg width="16" height="16" viewBox="0 0 16 16" fill="none" xmlns="http://www.w3.org/2000/svg">
              <circle cx="8" cy="8" r="8" fill="white"/>
            </svg>
            <h3>{{ schoolStory.location }}</h3>
            <p>{{ schoolStory.name }}</p>
            <h4>{{ schoolStory.date }}</h4>
          </div>
        </div>
        <div class="content skill">
          <p>{{ school.resume }}</p>
          <SkillValue v-for="skill of skills" :skill="skill"/>
        </div>
      </div>
    </AppearAnimation>
  </section>
</template>

<script setup lang="ts">
import Title from "@/vue/global/utils/Title.vue";
import {School, SchoolStory, Skill} from "@/object/UserProfile";
import {onMounted, onUnmounted, ref} from "vue";
import SkillValue from "@/vue/user/SkillValue.vue";
import {HTTPAxios} from "@/object/utils/HTTPAxios";
import {onIntersect} from "@/object/utils/IntersectionListener";
import AppearAnimation from "@/vue/global/AppearAnimation.vue";

const school = ref<School>()
const skills = ref<Skill[]>([])
const isOnScreen = ref(false);

onMounted(() => {
  new HTTPAxios("user/shool-stories.json", null, true).get().then((data) => {
    school.value = data.data
  })
  new HTTPAxios("user/skills.json", null, true).get().then((data) => {
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
        height: fit-content;
        border-left: solid 2px var(--primary-text);
      }

      .school-detail {
        position: relative;
        padding-left: 24px;
        padding-bottom: 40px;
        display: flex;
        flex-direction: column;
        gap: 10px;
        overflow: visible;
        opacity: 0;

        &:last-child {
          height: 0;
          padding-bottom: 0;
          overflow: visible;
        }

        svg {
          position: absolute;
          top: 0;
          left: -9px;

          circle {
            fill: var(--primary-text);
          }
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
