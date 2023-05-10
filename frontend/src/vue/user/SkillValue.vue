<template>
  <AppearAnimation :once="true" v-model="isOnScreen">
    <div class="skill-container">
      <h3 :class="{'opacity':isOnScreen}">{{ skill.name }}</h3>
      <div class="skill-bar">
        <div :class="{'progress-width':isOnScreen,'skill-value':true}"
             :style="{'max-width': skill.level + '%'}"/>
      </div>
    </div>
  </AppearAnimation>
</template>

<script setup lang="ts">
import {PropType, ref} from "vue";
import {Skill} from "@/object/UserProfile";
import AppearAnimation from "@/vue/global/AppearAnimation.vue";

const isOnScreen = ref(false)

defineProps({
  skill: {
    type: Object as PropType<Skill>,
    required: true
  }
})
</script>

<style scoped lang="scss">
.skill-container {
  display: flex;
  flex-direction: column;
  width: 100%;

  h3 {
    font-style: normal;
    font-weight: 500;
    font-size: 16px;
    line-height: 17px;
    color: var(--main);
    margin-bottom: 12px;
  }

  .skill-bar, .skill-value {
    height: 8px;
    border-radius: 2px;
  }

  .skill-bar {
    width: 100%;
    background: rgba(255, 232, 209, 0.1);
    overflow: hidden;
  }

  .skill-value {
    background: var(--main);
  }
}
</style>