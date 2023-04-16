<template>
  <div class="contributor-wrapper">
    <h2>{{ content.title }}</h2>

    <div class="contributors">
      <div class="contributor" v-for="contributor of content.contributors">

        <img :src="contributor.icon"/>
        <h3>{{ contributor.name }}</h3>

        <div class="tags" v-for="tag of contributor.tags">
          <p>{{ tag }}</p>
        </div>

      </div>
    </div>
  </div>
</template>

<script setup lang="ts">
import {PropType} from "vue";
import {BasicText, Contributor} from "@/object/Project";

defineProps({
  content: {
    type: Object as PropType<Contributor>
  }
})
</script>

<style scoped lang="scss">
.contributor-wrapper {
  display: flex;
  flex-direction: column;
  gap: 10px;

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
    justify-content: center;
    gap: 20px;

    .contributor {
      display: flex;
      flex-direction: column;
      justify-content: center;
      align-items: center;

      img {
        width: 30px;
      }
    }
  }

}
</style>
