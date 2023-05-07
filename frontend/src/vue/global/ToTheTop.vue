<template>
  <transition>
    <span class="to-the-top" v-if="scrollValue>=100" @click="scrollToTop()">
        <svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke-width="1.5" stroke="currentColor"
             class="w-6 h-6">
          <path stroke-linecap="round" stroke-linejoin="round" d="M12 19.5v-15m0 0l-6.75 6.75M12 4.5l6.75 6.75"/>
        </svg>
    </span>
  </transition>
</template>

<script setup lang="ts">
import {onMounted, ref} from "vue";

const scrollValue = ref(window.scrollY)

onMounted(() => {
  window.addEventListener('scroll', scrollHandler)
})

function scrollHandler(event: any) {
  scrollValue.value = window.scrollY
}

function scrollToTop() {
  window.scrollTo({top: 0})
}
</script>

<style scoped lang="scss">

.to-the-top {
  position: fixed;
  background: transparent;
  border: solid 2px var(--main);
  display: flex;
  justify-content: center;
  padding: 4px;
  width: fit-content;
  height: fit-content;
  border-radius: 8px;
  cursor: pointer;
  right: 45px;
  bottom: 45px;

  svg {
    width: 30px;
    height: 30px;
    stroke: var(--main);
  }

  &:hover {
    background: var(--main);

    svg {
      stroke: var(--primary-background);
    }
  }
}

</style>
