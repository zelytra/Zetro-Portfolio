<template>
  <div class="not-found">
    <h1>404</h1>
    <p>Nous ne somme pas parvenus a trouver la page que vous cherchez.</p>
  </div>
</template>

<script setup lang="ts">

</script>

<style scoped lang="scss">
.not-found{
  width: 100%;
  height: calc(100vh - 255px);
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;

  h1{
    color: var(--main);
    font-size: 120px;
  }
}
</style>
