<template>
  <div class="project-card">
    <div class="content banner" :style="{backgroundImage:'url('+props.blog.banner+')'}">
      <div class="tags">
        <span v-for="tag of props.blog.tags">{{ tag }}</span>
      </div>
    </div>
    <div class="content details">
      <h4>{{ props.blog.name }}</h4>
      <div class="tags">
        <span>{{ formatDate(new Date(props.blog.date)) }}</span>
      </div>
      <div class="footer-details">
        <p>{{ props.blog.description }}</p>
      </div>
    </div>
  </div>
</template>

<script setup lang="ts">
import {PropType, ref} from "vue";
import {Project} from "@/object/Project";
import {Blog} from "@/object/Blog";

const props = defineProps({
  blog: {
    type: Object as PropType<Blog>,
    required: true
  }
})

function formatDate(date: Date): string {
  const monthNames = [
    "January", "February", "March", "April", "May", "June",
    "July", "August", "September", "October", "November", "December"
  ];

  const day = date.getDate();
  const monthIndex = date.getMonth();
  const year = date.getFullYear();

  return `${day} ${monthNames[monthIndex]}, ${year}`;
}
</script>

<style scoped lang="scss">
.project-card {
  width: 320px;
  height: fit-content;
  cursor: pointer;
  flex-shrink: 0;

  .tags {
    display: flex;
    flex-wrap: wrap;
    gap: 6px;

    span {
      background: var(--main);
      padding: 5px 8px;
      border-radius: 4px;
      font-style: normal;
      font-weight: 500;
      font-size: 12px;
      line-height: 15px;
      color: var(--revert-text);
    }
  }

  .content {
    border: solid 1px var(--main);
    border-top: none;
    border-bottom-left-radius: 8px;
    border-bottom-right-radius: 8px;

    &.banner {
      width: 320px;
      height: 262px;
      aspect-ratio: auto;
      border: none;
      background-position: center;
      background-size: cover;
      background-repeat: no-repeat;
      border-radius: 8px 8px 0 0;
      background-color: var(--secondary-background);
      opacity: 70%;
      position: relative;

      .tags {
        position: absolute;
        bottom: 10px;
        left: 10px;
      }
    }

    &.details {
      padding: 18px;
      display: flex;
      flex-direction: column;
      gap: 22px;
      min-height: 200px;

      .footer-details {
        display: flex;
        justify-content: space-between;
        gap: 8px;
        align-items: start;

        img {
          padding-top: 8px;
          width: 20px;
        }
      }

      h4 {
        font-family: PlusJakartaSans, sans-serif;
        font-style: normal;
        font-weight: 500;
        font-size: 16px;
        line-height: 20px;
        color: var(--main);
        white-space: nowrap;
        overflow: hidden;
        max-width: 280px;
        position: relative;
        text-overflow: ellipsis;
      }
    }
  }

  &:hover {
    background: rgba(255, 232, 209, 0.1);
    transform: translateY(-8px);
    border-radius: 8px;

    .content.banner {
      opacity: 1;
    }
  }
}
</style>
