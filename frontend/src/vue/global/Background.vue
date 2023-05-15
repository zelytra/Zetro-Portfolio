<template>
  <div class="background-wrapper">
    <svg width="358" height="829" viewBox="0 0 358 829" fill="none" xmlns="http://www.w3.org/2000/svg"
         class="left-shape"
         v-for="(x,index) of leftShapeNumber"
         :style="'top:'+index*(400+offsetLeft)+'px'"
    >
      <g opacity="0.19">
        <rect opacity="0.08" x="374.954" width="243.038" height="243.038" rx="40" transform="rotate(45 374.954 0)"
              fill="white"/>
        <rect opacity="0.08" x="499.938" y="281.214" width="243.038" height="243.038" rx="40"
              transform="rotate(45 499.938 281.214)" fill="white"/>
        <rect opacity="0.08" x="296.838" y="484.313" width="243.038" height="243.038" rx="40"
              transform="rotate(45 296.838 484.313)" fill="white"/>
        <rect opacity="0.08" x="171.854" y="203.099" width="243.038" height="243.038" rx="40"
              transform="rotate(45 171.854 203.099)" fill="white"/>
      </g>
    </svg>

  </div>
</template>

<script setup lang="ts">
import {onMounted, onUnmounted, ref} from "vue";
import {onBeforeRouteUpdate} from "vue-router";

const leftShapeNumber = ref(0)
const offsetLeft = 300;
let listenerInstance: string | number | NodeJS.Timer | undefined;

onMounted(() => {
  listenerInstance = setInterval(() => {
    resizeListener()
  }, 150)
})

onUnmounted(() => {
  clearInterval(listenerInstance)
})

function resizeListener() {
  leftShapeNumber.value = 0
  leftShapeNumber.value = Math.abs(Math.round(document.documentElement.scrollHeight / (400 + offsetLeft)))
  //console.log(leftShapeNumber.value)
}
</script>

<style scoped lang="scss">
.background-wrapper {
  position: absolute;
  top: 0;
  width: 100%;
  z-index: 0;
  height: 100%;

  .left-shape {
    position: absolute;
    width: 200px;
    height: 400px;
    right: 0;

    path {
      fill: red;
    }
  }
}
</style>
