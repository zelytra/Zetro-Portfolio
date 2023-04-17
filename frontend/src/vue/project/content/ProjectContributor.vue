<template>
  <div class="contributor-wrapper">
    <h2>{{ content.title }}</h2>
    <div class="contributor-slider">
      <span class="slider-button left" @click="updateSlider(cardSize)"><img src="@assets/icons/arrow.svg"></span>
      <div class="contributors" :style="{justifyContent:content.contributors.length===1?'center':'space-between'}">

        <div class="contributor" v-for="contributor of content.contributors"
             :style="{transform:'translateX('+sliderValue+'px)'}">
          <div class="image-container">
            <img :src="contributor.icon"/>
          </div>
          <h3>{{ contributor.name }}</h3>

          <div class="tags">
            <p v-for="tag of contributor.tags">{{ tag }}</p>
          </div>

        </div>

      </div>
      <span class="slider-button right" :style="{transform:'rotate(180deg)'}" @click="updateSlider(-cardSize)"><img
          src="@assets/icons/arrow.svg"></span>
    </div>
  </div>
</template>

<script setup lang="ts">
import {PropType} from "vue";
import {Contributor} from "@/object/Project";
import {ref} from "vue";

const cardSize = ref(310);
const sliderValue = ref(0);

const props = defineProps({
  content: {
    type: Object as PropType<Contributor>
  }
})

function updateSlider(value: number) {
  if (!props.content) return;
  if (sliderValue.value + value > 0 || sliderValue.value + value < -(props.content.contributors.length - 3) * cardSize.value) return
  sliderValue.value += value
  console.log(sliderValue.value)
}
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

  .contributor-slider {
    position: relative;
    justify-content: center;
    align-items: center;
    z-index: 99;

    .slider-button {
      position: absolute;
      top: 50%;
      font-size: 25px;
      cursor: pointer;
      padding: 10px;
      border-radius: 100%;
      width: 30px;
      height: 30px;
      display: flex;
      justify-content: center;
      align-items: center;
      z-index: 99;

      &:hover {
        background: rgba(255, 232, 209, 0.1);
      }

      &.right {
        right: -90px;
      }

      &.left {
        left: -90px;
      }
    }
  }

  .contributors {
    display: flex;
    align-items: center;
    gap: 20px;
    margin-top: 40px;
    flex-wrap: nowrap;
    flex-direction: row;
    transition: transform 0.7s ease-in-out;
    overflow-x: hidden;
    height: 290px;

    .contributor {
      display: flex;
      flex-direction: column;
      justify-content: center;
      align-items: center;
      background: rgba(255, 232, 209, 0.1);
      border: 1px solid var(--main);
      border-radius: 8px;
      width: 300px;
      height: 180px;
      position: relative;
      flex-shrink: 0;

      .image-container {
        position: absolute;
        top: 0;
        left: 50%;
        transform: translate(-50%, -50%);
        border-radius: 50%;
        padding: 20px;
        border: solid 5px var(--main);
        width: 60px;
        height: 60px;
        overflow: hidden;
        background-color: var(--primary-background);
        display: flex;
        justify-content: center;
        align-items: center;

        img {
          width: inherit;
        }
      }

      h3 {
        margin-top: 16px;
        font-family: PlusJakartaSans, sans-serif;
        font-style: normal;
        font-weight: 500;
        font-size: 18px;
        line-height: 20px;
      }

      .tags {
        margin-top: 12px;
        display: flex;
        align-items: center;
        gap: 10px;

        p {
          background: var(--primary-background);
          border-radius: 4px;
          padding: 4px 8px;
          color: var(--main);
        }
      }
    }
  }

}
</style>
