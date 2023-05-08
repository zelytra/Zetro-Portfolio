<template>
  <div class="contributor-wrapper">
    <h2>{{ content.title }}</h2>
    <div class="contributors">
      <div class="contributor" v-for="contributor of content.contributors">
        <div class="content icon">
          <img :src="contributor.icon" alt="Contributor icon"/>
        </div>
        <div class="content details">
          <h3>{{ contributor.name }}</h3>
          <div class="tags">
            <p v-for="tag of contributor.tags">{{ tag }}</p>
          </div>
        </div>
      </div>
    </div>

  </div>
</template>

<script setup lang="ts">
import {PropType} from "vue";
import {Contributor} from "@/object/Project";
import {ref} from "vue";

const props = defineProps({
  content: {
    type: Object as PropType<Contributor>,
    required: true
  }
})
</script>

<style scoped lang="scss">
.contributor-wrapper {
  display: flex;
  flex-direction: column;
  gap: 10px;
  overflow: hidden;

  h2 {
    font-style: normal;
    font-weight: 700;
    font-size: 25px;
    line-height: 32px;
    color: var(--main)
  }

  .contributors {
    display: flex;
    align-items: center;
    gap: 12px;
    flex-wrap: wrap;

    .contributor {
      display: flex;
      align-items: center;
      width: 300px;
      height: 70px;
      overflow: hidden;
      background: var(--hover-main);
      border: 1px solid #FFE8D1;
      border-radius: 8px;
      padding: 12px 23px;

      .content {
        display: flex;
        align-items: center;

        &.icon {
          width: 30%;

          img {
            width: 60px;
          }
        }

        &.details {
          display: flex;
          flex-direction: column;
          align-items: start;
          width: 70%;
          gap: 12px;

          h3 {
            font-family: PlusJakartaSans, sans-serif;
            font-style: normal;
            font-weight: 500;
            font-size: 18px;
            line-height: 22px;
            color: var(--main);
          }

          .tags {
            display: flex;
            align-items: center;
            gap: 8px;

            p {
              background: var(--main);
              color: var(--revert-text);
              border-radius: 4px;
              padding: 4px 8px;
              font-size: 14px;
            }
          }
        }
      }
    }
  }

}
</style>
