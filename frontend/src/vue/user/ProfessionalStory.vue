<template>
  <AppearAnimation :once="true" v-model="onScreen">
    <section class="professional-story-wrapper" v-if="professional">
      <div class="content">
        <Title title="Expériences de travail" sub-title="PARCROUS PROFESSIONNEL"/>
        <div class="company-selector">
          <p v-for="(story,index) of professional.stories"
             @click="updateStory(story)"
             :class="{selected:selectedStory.company===story.company,'slide-left-to-right':onScreen}"
             :style="'animation-delay:'+index*0.2+'s'">{{ story.company }}
            <span
                v-if="selectedStory.company===story.company">{{ ">" }}
          </span>
          </p>
        </div>
      </div>
      <div class="job-animation-container">
        <Transition name="job">
          <div class="content story" v-if="selectedStory" :key="selectedStory.company">
            <h4 :class="{'opacity':onScreen}">{{ selectedStory.title }}</h4>
            <p class="location" :class="{'opacity':onScreen}">{{ selectedStory.location }}</p>
            <p class="date" :class="{'opacity':onScreen}">{{ selectedStory.date }}</p>
            <div class="tags">
              <span :class="{'slide-bottom-to-top':onScreen}"
                    class="tag"
                    v-for="(tag,index) of selectedStory.tags"
                    :style="'animation-delay:'+index*0.2+'s'">{{
                  tag
                }}</span>
            </div>
            <hr :class="{'slide-right-to-left':onScreen}">
            <ul>
              <li :class="{'slide-bottom-to-top':onScreen}"
                  v-for="(content,index) of selectedStory.content"
                  :style="'animation-delay:'+index*0.1+'s'"
              >- {{ content }}</li>
            </ul>
          </div>
        </Transition>
      </div>
    </section>
  </AppearAnimation>
</template>

<script setup lang="ts">
import Title from "@/vue/global/utils/Title.vue";
import {Professional, ProfessionalStory} from "@/object/UserProfile";
import {onMounted, ref} from "vue";
import {HTTPAxios} from "@/object/utils/HTTPAxios";
import {BasicText} from "@/object/Project";
import AppearAnimation from "@/vue/global/AppearAnimation.vue";

const professional = ref<Professional>()
const selectedStory = ref();
const onScreen = ref(false)

onMounted(() => {
  new HTTPAxios("user/professional-stories.json", null, true).get().then((data) => {
    professional.value = data.data as Professional
    selectedStory.value = professional.value.stories[0]
  })
})

async function updateStory(story: ProfessionalStory) {
  selectedStory.value = story
}
</script>

<style scoped lang="scss">
.professional-story-wrapper {
  width: inherit;
  min-height: 400px;
  display: flex;
  align-items: start;
  gap: 40px;
  flex-wrap: wrap;

  .job-animation-container {
    position: relative;
    flex-grow: 1;
  }

  .content {

    .company-selector {
      width: fit-content;
      margin-top: 60px;
      display: flex;
      flex-direction: column;
      gap: 12px;

      p {
        width: 250px;
        padding: 16px 32px;
        //border: solid 1px var(--main);
        color: white;
        border-radius: 4px;
        cursor: pointer;
        position: relative;

        span {
          font-weight: 500;
          top: 50%;
          right: 15px;
          transform: translate(0, -50%);
          position: absolute;
          color: var(--main);
        }

        &:hover {
          background: rgba(255, 232, 209, 0.1);
        }

        &.selected {
          color: var(--main);
          background: rgba(255, 232, 209, 0.1);
        }
      }
    }

    &.story {
      display: flex;
      flex-direction: column;
      gap: 16px;
      width: inherit;

      h4 {
        font-family: PlusJakartaSans, sans-serif;
        font-style: normal;
        font-weight: 700;
        font-size: 18px;
        line-height: 23px;
        color: var(--main);
      }

      p {
        &.location {
          font-weight: 400;
          font-size: 14px;
          line-height: 17px;
        }

        .date {
          font-style: normal;
          font-weight: 500;
          font-size: 14px;
          line-height: 24px;
        }
      }

      ul {
        list-style: none;
        display: flex;
        flex-direction: column;
        gap: 16px;

        li {
          font-style: normal;
          font-weight: 400;
          font-size: 16px;
          line-height: 19px;
        }
      }

      hr {
        color: var(--main);
        width: 100%;
        margin: 15px 0;
      }

      .tags {
        display: flex;
        gap: 10px;

        span {
          border: 1px solid #BDBDBD;
          border-radius: 4px;
          padding: 4px 8px;
        }
      }

    }
  }
}

.job-enter-active {
  transition: all 0.65s ease-in-out;
}

.job-leave-active {
  transition: all 0.5s ease-in-out;
}

.job-leave-to {
  opacity: 0;
  transform: translateY(-80px);
  position: absolute;
}

.job-enter-from {
  opacity: 0;
  transform: translateY(80px);
  position: absolute;
}
</style>
