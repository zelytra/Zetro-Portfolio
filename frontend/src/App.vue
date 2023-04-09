<template>
  <Header/>
  <router-view v-slot="{ Component }">
    <transition mode="out-in">
      <component :is="Component"/>
    </transition>
  </router-view>
  <Footer/>
</template>

<script setup lang="ts">
import Header from "@vues/global/Header.vue"
import Footer from "@vues/global/Footer.vue"
</script>

<style scoped lang="scss">
.v-leave-active, .v-enter-active {
  transition: 0.2s ease;
}

.v-enter-from,
.v-leave-to {
  opacity: 0;
}
</style>
