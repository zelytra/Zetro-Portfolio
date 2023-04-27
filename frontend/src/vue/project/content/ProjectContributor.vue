<template>
  <div class="contributor-wrapper">
    <h2>{{ content.title }}</h2>
    <div class="contributor-slider">
      <span class="slider-button left" @click="updateSlider(-1)"><img src="@assets/icons/arrow.svg"></span>
      <div class="contributors" :style="{justifyContent:content.contributors.length<3?'center':'space-between'}">

        <div class="contributor" v-if="content.contributors.length >=3">
          <div class="image-container">
            <img
                :src="index===0?content.contributors[content.contributors.length-1].icon:content.contributors[index-1].icon"/>
          </div>
          <h3>{{
              index === 0 ? content.contributors[content.contributors.length - 1].name : content.contributors[index - 1].name
            }}</h3>
          <div class="tags">
            <p v-for="tag of index===0?content.contributors[content.contributors.length-1].tags:content.contributors[index-1].tags">
              {{ tag }}</p>
          </div>
        </div>

        <div class="contributor">
          <div class="image-container">
            <img :src="content.contributors[index].icon"/>
          </div>
          <h3>{{ content.contributors[index].name }}</h3>
          <div class="tags">
            <p v-for="tag of content.contributors[index].tags">{{ tag }}</p>
          </div>
        </div>
        <div class="contributor" v-if="content.contributors.length >=3">
          <div class="image-container">
            <img
                :src="index===content.contributors.length-1?content.contributors[0].icon:content.contributors[index+1].icon"/>
          </div>
          <h3>{{
              index === content.contributors.length - 1 ? content.contributors[0].name : content.contributors[index + 1].name
            }}</h3>
          <div class="tags">
            <p v-for="tag of index===content.contributors.length-1?content.contributors[0].tags:content.contributors[index+1].tags">
              {{ tag }}</p>
          </div>
        </div>

      </div>
      <span class="slider-button right" :style="{transform:'rotate(180deg)'}" @click="updateSlider(1)"><img
          src="@assets/icons/arrow.svg"></span>
    </div>
  </div>
</template>

<script setup lang="ts">
import {PropType} from "vue";
import {Contributor} from "@/object/Project";
import {ref} from "vue";

const index = ref(0)

const props = defineProps({
  content: {
    type: Object as PropType<Contributor>,
    required: true
  }
})

function updateSlider(value: number) {
  if (!props.content) return
  if (index.value + value < 0) {
    index.value = props.content.contributors.length - 1;
  } else if (index.value + value >= props.content.contributors.length) {
    index.value = 0
  } else {
    index.value += value;
  }
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
    display: flex;
    position: relative;
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
    width: 100%;

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
