<template>
  <div class="skill-container">
    <div class="image-container">
      <slot/>
    </div>
    <h3>{{ title }}</h3>
    <p>{{ content }}</p>
  </div>
</template>

<script setup lang="ts">
defineProps({
  title: String,
  content: String
})
</script>

<style scoped lang="scss">
.skill-container {
  display: flex;
  flex-direction: column;
  justify-content: space-between;
  align-items: center;
  gap: 18px;
  padding: 20px;
  border: solid 1px var(--main);
  border-radius: 8px;
  width: 300px;
  height: 220px;
  overflow: hidden;

  .image-container {
    border: solid 1px var(--main);
    padding: 16px;
    border-radius: 8px;
    display: flex;
    justify-content: center;

    :slotted(svg) {
      &.fill path{
        fill: var(--main);
      }
      &.stroke path{
        stroke: var(--main)
      }
    }
  }

  h3 {
    font-family: PlusJakartaSans, sans-serif;
    font-style: normal;
    font-weight: 500;
    font-size: 16px;
    line-height: 20px;
    color: var(--main);
  }

  p {
    text-align: center;
    font-style: normal;
    font-weight: 400;
    font-size: 14px;
    line-height: 24px;
    height: 100%;
  }

  &:hover {
    background: var(--hover-main);


    .image-container {
      background: var(--main);

      :slotted(svg) {
        &.fill path{
          fill: var(--primary-background);
        }
        &.stroke path{
          stroke: var(--primary-background);
        }
      }
    }
  }
}
</style>
