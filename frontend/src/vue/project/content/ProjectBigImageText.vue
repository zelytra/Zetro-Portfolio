<template>
  <div class="big-image-text">
    <div class="content">
      <h2>{{ content.title }}</h2>
      <p>{{ content.text }}</p>
    </div>
    <div class="content image" @click="toggleZoom()">
      <img :src="content.image"/>
    </div>
  </div>
  <Modal v-model:is-modal-open="zoomIn">
    <img class="zoom-img" :src="content.image"/>
  </Modal>
</template>

<script setup lang="ts">
import {PropType, ref} from "vue";
import {BigImageText} from "@/object/Project";
import Modal from "@/vue/global/utils/Modal.vue";

const zoomIn = ref(false)
defineProps({
  content: {
    type: Object as PropType<BigImageText>,
    required: true
  }
})

function toggleZoom() {
  zoomIn.value = !zoomIn.value
}
</script>

<style scoped lang="scss">
.big-image-text {
  display: flex;
  flex-direction: column;
  gap: 15px;
  max-width: 1600px;

  .content {
    display: flex;
    flex-direction: column;
    justify-content: center;
    gap: 10px;

    h2 {
      font-style: normal;
      font-weight: 700;
      font-size: 25px;
      line-height: 32px;
      color: var(--main)
    }

    p {
      font-style: normal;
      font-weight: 400;
      font-size: 16px;
      line-height: 26px;
    }

    &.image {
      align-self: center;

      img {
        width: 100%;
        border-radius: 8px;
        overflow: hidden;
      }
    }
  }
}

.zoom-img {
  max-width: 90%;
  max-height: 90%;
  aspect-ratio: auto;
}
</style>
