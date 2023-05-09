<template>
  <div class="selector-wrapper">
    <div class="button" @click="openOption()">
      <svg width="23" height="23" viewBox="0 0 23 23" fill="none" xmlns="http://www.w3.org/2000/svg">
        <path
            d="M11.3545 21.5C16.8773 21.5 21.3545 17.0228 21.3545 11.5C21.3545 5.97715 16.8773 1.5 11.3545 1.5C5.83164 1.5 1.35449 5.97715 1.35449 11.5C1.35449 17.0228 5.83164 21.5 11.3545 21.5Z"
            stroke="white" stroke-width="2" stroke-linecap="round" stroke-linejoin="round"/>
        <path d="M1.35449 11.5H21.3545" stroke="white" stroke-width="2" stroke-linecap="round" stroke-linejoin="round"/>
        <path
            d="M11.3545 1.5C13.8558 4.23835 15.2772 7.79203 15.3545 11.5C15.2772 15.208 13.8558 18.7616 11.3545 21.5C8.85321 18.7616 7.43174 15.208 7.35449 11.5C7.43174 7.79203 8.85321 4.23835 11.3545 1.5Z"
            stroke="white" stroke-width="2" stroke-linecap="round" stroke-linejoin="round"/>
      </svg>
    </div>

    <transition>
      <div class="wrapper options" v-if="toggleOption" v-click-outside="() => closeOption()"
           @mouseleave="closeOption()">
        <div class="option"
             v-for="lang of langs"
             @click="langStore.set(lang.tag)">
          <label>{{ lang.display }}</label>
        </div>
      </div>
    </transition>

  </div>
</template>

<script setup lang="ts">
import {onMounted, ref} from "vue";
import {Lang} from "@/object/Preferences";
import axios from "axios";
import {langStore} from "@/store/LangStore";

const toggleOption = ref<boolean>(false)
const langs = ref<Lang[]>([])

onMounted(() => {
  axios.get("https://raw.githubusercontent.com/" + import.meta.env.VITE_GITHUB_HOST + "/main/lang.json").then((data) => {
    langs.value = data.data as Lang[]
  })
})

function openOption() {
  toggleOption.value = true
}

function closeOption() {
  toggleOption.value = false;
}
</script>

<style scoped lang="scss">
.selector-wrapper {
  position: relative;

  svg {
    cursor: pointer;

    &:hover path {
      stroke: var(--main);
    }

    &.light:hover path {
      stroke: none;
      fill: var(--main);
    }
  }

  .wrapper {
    border: 1px solid var(--main);
    border-radius: 8px;
    padding: 10px 19px;
    background: var(--input-background);

    &.options {
      top: 46px;
      right: 0;
      position: absolute;
      z-index: 99;
      width: auto;
      display: flex;
      flex-direction: column;
      gap: 6px;

      .option {
        padding: 10px;
        border-radius: 8px;
        display: flex;
        align-items: center;
        gap: 6px;
        cursor: pointer;
        filter: brightness(0.8);

        &:hover {
          filter: brightness(1);
        }

        label {
          cursor: pointer;
          color: var(--primary-text);
        }

        &.selected {
          label {
            color: var(--main);
          }
        }
      }
    }
  }
}

.v-leave-active, .v-enter-active {
  transition: 0.2s ease;
}

.v-enter-from,
.v-leave-to {
  opacity: 0;
}
</style>
