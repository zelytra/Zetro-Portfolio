<template>
  <div class="project-card">
    <div class="content banner" :style="{backgroundImage:'url('+props.project.banner+')'}"/>
    <div class="content details">
      <h4>{{ props.project.name }}</h4>
      <div class="tags">
        <span v-for="tag of props.project.tags">{{ tag }}</span>
        <img src="@assets/icons/link.svg"/>
      </div>
    </div>
  </div>
</template>

<script setup lang="ts">
import {PropType, ref} from "vue";
import {Project} from "@/object/Project";

const props = defineProps({
  project: {
    type: Object as PropType<Project>,
    required: true
  }
})
</script>

<style scoped lang="scss">
.project-card {
  width: 300px;
  height: 400px;
  background: rgba(255, 232, 209, 0.1);
  border-radius: 8px;
  overflow: hidden;
  border: solid 1px var(--main);
  cursor: pointer;
  flex-shrink: 0;

  .content {

    &.banner {
      width: 100%;
      height: 70%;
      border: none;
      background-position: center;
      background-size: cover;
      background-repeat: no-repeat;
    }

    &.details {
      padding: 18px;
      display: flex;
      flex-direction: column;
      gap: 22px;

      h4 {
        font-family: PlusJakartaSans, sans-serif;
        font-style: normal;
        font-weight: 500;
        font-size: 16px;
        line-height: 20px;
        color: var(--main);
      }

      .tags {
        display: flex;
        flex-wrap: wrap;
        gap: 6px;

        span {
          padding: 4px 8px;
          border: 1px solid #FFE8D1;
          border-radius: 4px;
          font-style: normal;
          font-weight: 500;
          font-size: 12px;
          line-height: 15px;
          color: var(--main);
        }
      }
    }
  }
}
</style>
