<template>
  <div class="selector-wrapper">
    <div class="button" @click="openOption()">
      <svg class="light" width="23" height="22" viewBox="0 0 23 22" fill="none" xmlns="http://www.w3.org/2000/svg">
        <path
            d="M21.6191 0.881252C21.3412 0.602328 21.011 0.381012 20.6474 0.23C20.2838 0.0789873 19.894 0.00125122 19.5003 0.00125122C19.1066 0.00125122 18.7168 0.0789873 18.3532 0.23C17.9896 0.381012 17.6594 0.602328 17.3816 0.881252L17.3534 0.909377L12.2066 6.64688L11.3441 5.78438C11.1357 5.57349 10.8875 5.40606 10.6139 5.29178C10.3403 5.17751 10.0468 5.11867 9.75031 5.11867C9.45383 5.11867 9.16029 5.17751 8.88671 5.29178C8.61314 5.40606 8.36496 5.57349 8.15656 5.78438L0.965938 12.9656C0.825101 13.1078 0.746094 13.2999 0.746094 13.5C0.746094 13.7001 0.825101 13.8922 0.965938 14.0344L8.46594 21.5344C8.60929 21.673 8.8009 21.7505 9.00031 21.7505C9.19972 21.7505 9.39133 21.673 9.53469 21.5344L16.7159 14.3438C16.9268 14.1354 17.0943 13.8872 17.2085 13.6136C17.3228 13.34 17.3816 13.0465 17.3816 12.75C17.3816 12.4535 17.3228 12.16 17.2085 11.8864C17.0943 11.6128 16.9268 11.3646 16.7159 11.1563L15.8534 10.2938L21.5909 5.14688L21.6191 5.11875C21.898 4.8409 22.1193 4.51071 22.2703 4.14712C22.4213 3.78353 22.4991 3.3937 22.4991 3C22.4991 2.6063 22.4213 2.21647 22.2703 1.85289C22.1193 1.4893 21.898 1.15911 21.6191 0.881252ZM9.00031 19.9406L7.67844 18.6188L10.0691 16.2188C10.1983 16.0761 10.2678 15.8892 10.263 15.6967C10.2583 15.5042 10.1797 15.321 10.0436 15.1848C9.90747 15.0487 9.7242 14.9701 9.53174 14.9654C9.33927 14.9607 9.15236 15.0301 9.00969 15.1594L6.61906 17.5594L5.05344 15.9938L7.44406 13.5938C7.57333 13.4511 7.64279 13.2642 7.63805 13.0717C7.63331 12.8792 7.55474 12.696 7.41861 12.5598C7.28247 12.4237 7.0992 12.3451 6.90674 12.3404C6.71427 12.3357 6.52736 12.4051 6.38469 12.5344L3.99406 14.9344L2.55969 13.5L6.75031 9.30938L13.1909 15.75L9.00031 19.9406Z"
            fill="white"/>
      </svg>
    </div>

    <transition>
      <div class="options" v-if="toggleOption" v-click-outside="() => closeOption()"
           @mouseleave="closeOption()">
        <div class="option"
             v-for="color of colors"
             @click="replaceCSSVariables(color)">
          <span :style="{background:color.main}"/>
        </div>
      </div>
    </transition>

  </div>
</template>

<script setup lang="ts">
import {onMounted, ref} from "vue";
import axios from "axios";
import {replaceCSSVariables} from "@/object/utils/Color";

const toggleOption = ref<boolean>(false)
const colors = ref<any[]>()

onMounted(() => {
  axios.get("https://raw.githubusercontent.com/" + import.meta.env.VITE_GITHUB_HOST + "/main/palette/default.json").then((data) => {
    replaceCSSVariables(data.data)
  })
  axios.get("https://raw.githubusercontent.com/" + import.meta.env.VITE_GITHUB_HOST + "/main/palette/colors.json").then((data) => {
    colors.value = data.data
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

  .options {
    border: 1px solid var(--main);
    border-radius: 8px;
    padding: 10px 19px;
    background: var(--input-background);
    top: 46px;
    right: 0;
    position: absolute;
    z-index: 99;
    display: flex;
    gap: 6px;

    .option {
      padding: 10px;
      border-radius: 8px;
      display: flex;
      align-items: center;
      cursor: pointer;
      filter: brightness(0.8);
      width: 25px;
      height: 25px;

      &:hover {
        filter: brightness(1);
      }

      span {
        width: inherit;
        height: inherit;
        border-radius: 50% 50% 50% 0;
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
