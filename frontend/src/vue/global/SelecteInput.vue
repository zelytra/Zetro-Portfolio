<template>
  <div class="input-wrapper">

    <div class="displayer-wrapper">
      <div class="selected-values">
        <p v-for="value of selectedValues">{{ value }}</p>
      </div>
      <img src="@assets/icons/arrow.svg" alt="arrow"/>
    </div>

    <div class="options-wrapper">
      <div class="option" v-for="option of options">
        <input type="checkbox" :id="option+'-input'" />
        <label :for="option+'input'">{{ option }}</label>
      </div>
    </div>

  </div>
</template>

<script setup lang="ts">
import {PropType} from "vue";
import {ref} from "vue";

const selectedValues = ref<string[]>([]);

defineProps({
  options: {
    type: Object as PropType<String>,
    required: true
  }
})
</script>

<style scoped lang="scss">

</style>