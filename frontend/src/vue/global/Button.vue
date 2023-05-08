<template>
  <div class="custom-button">
    <slot/>
  </div>
</template>

<script setup lang="ts">

</script>

<style scoped lang="scss">
.custom-button {
  padding: 10px 22px;
  border: 1px solid var(--main);
  border-radius: 8px;
  cursor: pointer;
  display: flex;
  align-items: center;
  gap: 4px;
  max-width: fit-content;
  align-self: start;

  :slotted(p) {
    color: var(--main);
  }

  :slotted(svg) path {
    fill: var(--main);
  }

  &:hover {
    background: var(--main);

    :slotted(p) {
      color: var(--revert-text);
    }

    :slotted(svg) path {
      fill: var(--revert-text);
    }
  }
}
</style>