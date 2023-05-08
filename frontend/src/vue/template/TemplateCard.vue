<template>
  <div class="template-card">
    <div class="content banner" :style="{backgroundImage:'url('+props.template.banner+')'}"/>
    <div class="content details">
      <div class="title">
        <h4>{{ props.template.name }}</h4>
        <p>{{ props.template.price }}€</p>
      </div>
      <div class="footer-details">
        <div class="tags">
          <span v-for="tag of props.template.tags">{{ tag }}</span>
        </div>
      </div>
    </div>
  </div>
</template>

<script setup lang="ts">
import {PropType} from "vue";
import {Template} from "@/object/Template";

const props = defineProps({
  template: {
    type: Object as PropType<Template>,
    required: true
  }
})
</script>

<style scoped lang="scss">
.template-card {
  width: 285px;
  height: fit-content;
  cursor: pointer;
  flex-shrink: 0;

  &:hover {
    background: rgba(255, 232, 209, 0.1);
    transform: translateY(-8px);
    border-radius: 8px;

    .content.banner {
      opacity: 1;
    }
  }

  .content {
    border: solid 1px var(--main);
    border-top: none;
    border-bottom-left-radius: 8px;
    border-bottom-right-radius: 8px;

    &.banner {
      width: 285px;
      height: 330px;
      aspect-ratio: auto;
      border: none;
      background-position: center;
      background-size: cover;
      background-repeat: no-repeat;
      border-radius: 8px 8px 0 0;
      background-color: var(--secondary-background);
      opacity: 50%;
    }

    &.details {
      padding: 18px;
      display: flex;
      flex-direction: column;
      gap: 22px;
      min-height: 60px;

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

      .title {
        display: flex;
        align-items: center;
        justify-content: space-between;

        h4 {
          font-family: PlusJakartaSans, sans-serif;
          font-style: normal;
          font-weight: 500;
          font-size: 16px;
          line-height: 20px;
          color: var(--main);
        }
      }

      .tags {
        display: flex;
        flex-wrap: wrap;
        //overflow: hidden;
        gap: 6px;

        span {
          padding: 5px 8px;
          border: 1px solid var(--main);
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
