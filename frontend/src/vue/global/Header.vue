<template>
  <header v-if="header" :class="{stuck:scrollValue>=5}">
    <svg @click="router.push('/')" class="logo" width="105" height="25" viewBox="0 0 105 25" fill="none" xmlns="http://www.w3.org/2000/svg">
      <path
          d="M20.0346 8.31607H0.51251C0.232961 8.31607 0 8.54599 0 8.82183V11.7184C0 19.2126 4.37966 24.5 11.9742 24.5C20.7335 24.5 24.0882 18.8448 24.0882 13.9253C24.0882 13.6494 23.8552 13.4195 23.5756 13.4195H20.8732C20.5937 13.4195 20.3607 13.6494 20.3607 13.8793C20.3607 18.3391 17.1459 20.8218 11.9742 20.8218C6.75587 20.8218 3.72737 17.1896 3.72737 11.9942H23.5756C23.8552 11.9942 24.0882 11.7644 24.0882 11.4885V6.43103C24.0882 3.16666 21.8983 1.00575 18.5902 1.00575H0.65229C0.372737 1.00575 0.139776 1.23563 0.139776 1.51149V4.17816C0.139776 4.45402 0.372737 4.6839 0.65229 4.6839H18.0312C19.4289 4.6839 20.3607 5.60344 20.3607 6.98275V7.99424C20.3607 8.17815 20.221 8.31607 20.0346 8.31607ZM25.9578 13.2356V18.523C25.9578 21.7873 28.1476 23.9483 31.4557 23.9483H48.6482C48.9278 23.9483 49.1607 23.7183 49.1607 23.4425V20.7759C49.1607 20.5 48.9278 20.2701 48.6482 20.2701H32.0148C30.617 20.2701 29.6852 19.3506 29.6852 17.9712V13.2356C29.6852 8.04023 32.2944 4.17816 37.5127 4.17816C42.6378 4.17816 45.2469 7.90231 45.3402 12.9597H34.4842C34.2046 12.9597 33.9716 13.1897 33.9716 13.4655V16.1322C33.9716 16.408 34.2046 16.6379 34.4842 16.6379H48.555C48.8345 16.6379 49.0675 16.408 49.0675 16.1322V12.9597C49.0675 5.60344 45.014 0.5 37.5127 0.5C29.9181 0.5 25.9578 5.74137 25.9578 13.2356ZM56.2733 4.95976V23.4425C56.2733 23.7183 56.5062 23.9483 56.7858 23.9483H59.4881C59.7677 23.9483 60.0006 23.7183 60.0006 23.4425V4.95976C60.0006 4.77585 60.1404 4.63793 60.3268 4.63793H67.5486C67.8283 4.63793 68.0614 4.40804 68.0614 4.13218V1.46551C68.0614 1.18965 67.8283 0.959769 67.5486 0.959769H48.7253C48.4458 0.959769 48.2128 1.18965 48.2128 1.46551V4.13218C48.2128 4.40804 48.4458 4.63793 48.7253 4.63793H55.9471C56.1335 4.63793 56.2733 4.77585 56.2733 4.95976ZM81.2064 0.959769H75.4757C72.1674 0.959769 69.9313 3.16666 69.9313 6.43103V23.4425C69.9313 23.7183 70.1637 23.9483 70.4436 23.9483H73.1458C73.4251 23.9483 73.6582 23.7183 73.6582 23.4425V6.93677C73.6582 5.55747 74.5904 4.63793 75.9881 4.63793H81.2064C81.4856 4.63793 81.7187 4.40804 81.7187 4.13218V1.46551C81.7187 1.18965 81.4856 0.959769 81.2064 0.959769ZM92.8857 24.362C100.899 24.362 105 19.9943 105 12.546C105 5.09769 100.853 0.5 92.8857 0.5C84.9183 0.5 80.7715 5.09769 80.7715 12.546C80.7715 19.9943 84.8721 24.362 92.8857 24.362ZM84.6852 12.546C84.6852 7.39655 87.4344 4.17816 92.8857 4.17816C98.3371 4.17816 101.086 7.39655 101.086 12.546C101.086 17.5115 98.4771 20.6839 92.8857 20.6839C87.2482 20.6839 84.6852 17.5115 84.6852 12.546Z"
          fill="#FFE8D1"/>
    </svg>
    <nav>
      <router-link :to="'/'">
        {{ header.home }}
      </router-link>
      <router-link :to="'/projects'">
        {{ header.projects }}
      </router-link>
      <router-link :to="'/blog'">
        {{ header.blogs }}
      </router-link>
      <router-link :to="'/templates'">
        {{ header.templates }}
      </router-link>
    </nav>
    <section class="action">
      <ColorPicker/>
      <LangSelector/>
      <Button @click="downloadResume()">
        <p>{{ header.curriculum }}</p>
      </Button>
    </section>
  </header>

  <header v-if="header" class="responsive" :class="{stuck:scrollValue>=5}">
    <svg @click="router.push('/')" class="logo" width="105" height="25" viewBox="0 0 105 25" fill="none" xmlns="http://www.w3.org/2000/svg">
      <path
          d="M20.0346 8.31607H0.51251C0.232961 8.31607 0 8.54599 0 8.82183V11.7184C0 19.2126 4.37966 24.5 11.9742 24.5C20.7335 24.5 24.0882 18.8448 24.0882 13.9253C24.0882 13.6494 23.8552 13.4195 23.5756 13.4195H20.8732C20.5937 13.4195 20.3607 13.6494 20.3607 13.8793C20.3607 18.3391 17.1459 20.8218 11.9742 20.8218C6.75587 20.8218 3.72737 17.1896 3.72737 11.9942H23.5756C23.8552 11.9942 24.0882 11.7644 24.0882 11.4885V6.43103C24.0882 3.16666 21.8983 1.00575 18.5902 1.00575H0.65229C0.372737 1.00575 0.139776 1.23563 0.139776 1.51149V4.17816C0.139776 4.45402 0.372737 4.6839 0.65229 4.6839H18.0312C19.4289 4.6839 20.3607 5.60344 20.3607 6.98275V7.99424C20.3607 8.17815 20.221 8.31607 20.0346 8.31607ZM25.9578 13.2356V18.523C25.9578 21.7873 28.1476 23.9483 31.4557 23.9483H48.6482C48.9278 23.9483 49.1607 23.7183 49.1607 23.4425V20.7759C49.1607 20.5 48.9278 20.2701 48.6482 20.2701H32.0148C30.617 20.2701 29.6852 19.3506 29.6852 17.9712V13.2356C29.6852 8.04023 32.2944 4.17816 37.5127 4.17816C42.6378 4.17816 45.2469 7.90231 45.3402 12.9597H34.4842C34.2046 12.9597 33.9716 13.1897 33.9716 13.4655V16.1322C33.9716 16.408 34.2046 16.6379 34.4842 16.6379H48.555C48.8345 16.6379 49.0675 16.408 49.0675 16.1322V12.9597C49.0675 5.60344 45.014 0.5 37.5127 0.5C29.9181 0.5 25.9578 5.74137 25.9578 13.2356ZM56.2733 4.95976V23.4425C56.2733 23.7183 56.5062 23.9483 56.7858 23.9483H59.4881C59.7677 23.9483 60.0006 23.7183 60.0006 23.4425V4.95976C60.0006 4.77585 60.1404 4.63793 60.3268 4.63793H67.5486C67.8283 4.63793 68.0614 4.40804 68.0614 4.13218V1.46551C68.0614 1.18965 67.8283 0.959769 67.5486 0.959769H48.7253C48.4458 0.959769 48.2128 1.18965 48.2128 1.46551V4.13218C48.2128 4.40804 48.4458 4.63793 48.7253 4.63793H55.9471C56.1335 4.63793 56.2733 4.77585 56.2733 4.95976ZM81.2064 0.959769H75.4757C72.1674 0.959769 69.9313 3.16666 69.9313 6.43103V23.4425C69.9313 23.7183 70.1637 23.9483 70.4436 23.9483H73.1458C73.4251 23.9483 73.6582 23.7183 73.6582 23.4425V6.93677C73.6582 5.55747 74.5904 4.63793 75.9881 4.63793H81.2064C81.4856 4.63793 81.7187 4.40804 81.7187 4.13218V1.46551C81.7187 1.18965 81.4856 0.959769 81.2064 0.959769ZM92.8857 24.362C100.899 24.362 105 19.9943 105 12.546C105 5.09769 100.853 0.5 92.8857 0.5C84.9183 0.5 80.7715 5.09769 80.7715 12.546C80.7715 19.9943 84.8721 24.362 92.8857 24.362ZM84.6852 12.546C84.6852 7.39655 87.4344 4.17816 92.8857 4.17816C98.3371 4.17816 101.086 7.39655 101.086 12.546C101.086 17.5115 98.4771 20.6839 92.8857 20.6839C87.2482 20.6839 84.6852 17.5115 84.6852 12.546Z"
          fill="#FFE8D1"/>
    </svg>
    <section class="action">
      <ColorPicker/>
      <LangSelector/>
      <div class="burger-button" :class="{cross:!deployMenu}" @click="toggleMenu()">
        <span class="bar"/>
        <span class="bar"/>
        <span class="bar"/>
      </div>
    </section>
    <transition name="menu">
        <nav class="menu" v-if="!deployMenu">
          <router-link class="router-link" :to="'/'" @click="toggleMenu()">
            {{ header.home }}
          </router-link>
          <router-link class="router-link" :to="'/projects'" @click="toggleMenu()">
            {{ header.projects }}
          </router-link>
          <router-link class="router-link" :to="'/blog'" @click="toggleMenu()">
            {{ header.blogs }}
          </router-link>
          <router-link class="router-link" :to="'/templates'" @click="toggleMenu()">
            {{ header.templates }}
          </router-link>
        </nav>
    </transition>
  </header>
</template>

<script setup lang="ts">
import {onMounted, onUnmounted, ref} from "vue";
import {HTTPAxios} from "@/object/utils/HTTPAxios";
import {HeaderSite} from "@/object/UserProfile";
import LangSelector from "@/vue/preferences/LangSelector.vue";
import Button from "@/vue/global/form/Button.vue";
import ColorPicker from "@/vue/preferences/ColorPicker.vue";
import {useRouter} from "vue-router";

const header = ref<HeaderSite>()
const scrollValue = ref(window.scrollY)
const deployMenu = ref<boolean>(true)
const router = useRouter()

onMounted(() => {
  new HTTPAxios("global/header.json", null, true).get().then((data) => {
    header.value = data.data as HeaderSite
  })
  window.addEventListener('scroll', scrollHandler)
})

onUnmounted(() => {
  window.removeEventListener('scroll', scrollHandler)
})

function scrollHandler(event: any) {
  scrollValue.value = window.scrollY
}

function downloadResume() {
  new HTTPAxios('julien.petit.pdf', null, true).get().then((response) => {
    const blob = new Blob([response.data], {type: 'application/pdf'})
    const link = document.createElement('a')
    link.href = URL.createObjectURL(blob)
    link.setAttribute('download', 'julien.petit.pdf');
    document.body.appendChild(link);
    link.click()
  })
}

function toggleMenu() {
  deployMenu.value = !deployMenu.value;
}

</script>

<style scoped lang="scss">
@import "@assets/style.scss";

header {
  &.responsive {
    display: none;
  }

  display: flex;
  align-items: center;
  width: 90%;
  max-width: 1600px;
  margin: auto;
  padding: 12px 12px;
  justify-content: space-between;
  position: sticky;
  top: 0;
  z-index: 999;

  .logo {
    path {
      fill: var(--main);
    }
  }


  &.stuck {
    top: 25px;
    background: var(--header-background);
    border-radius: 8px;
  }

  svg {
    cursor: pointer;

    &:hover:not(.logo) path {
      stroke: var(--main);
    }

    &.light:hover:not(.logo) path {
      stroke: none;
      fill: var(--main);
    }
  }

  nav {
    position: absolute;
    top: 50%;
    left: 50%;
    transform: translate(-50%, -50%);
    display: flex;
    align-items: center;
    gap: 40px;

    .router-link-active {
      color: var(--primary-text);
    }

    a:hover {
      color: var(--main);
    }
  }

  section.action {
    display: flex;
    align-items: center;
    gap: 16px;
  }
}

@media screen and (max-width: $responsive-break-point) {
  header:not(.responsive) {
    display: none;
  }

  header.responsive {
    display: flex;

    .menu {
      position: absolute;
      top: 50px;
      width: 100%;
      background: var(--header-background);
      display: flex;
      flex-direction: column;
      justify-content: center;
      align-items: center;
      z-index: 999;
      left: 0;
      transform: none;
      gap: 16px;

      .router-link {
        width: 100%;
        text-align: center;
        padding: 12px 0;
      }

      .router-link-active {
        color: var(--primary-text);
      }
    }

    .action .burger-button {
      display: flex;
      flex-direction: column;
      justify-content: space-between;
      align-items: center;
      width: 26px;
      height: 24px;
      cursor: pointer;
      margin-right: 8px;

      &.cross {
        :nth-child(1) {
          transform: rotate(45deg) translate(8px, 8px);
        }

        :nth-child(2) {
          opacity: 0;
        }

        :nth-child(3) {
          transform: rotate(-45deg) translate(8px, -8px);
        }

      }

      .bar {
        height: 2px;
        width: inherit;
        border-radius: 2px;
        background-color: var(--main);
      }
    }
  }
}

.menu-enter-active {
  transition: all 0.5s ease-in-out;
}
.menu-enter-from,
.menu-leave-to {
  opacity: 0;
  transform: translateY(-8%);
}

</style>
