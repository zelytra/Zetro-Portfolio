<template>
  <header v-if="header" :class="{stuck:scrollValue>=5}">
    <svg class="logo" width="105" height="25" viewBox="0 0 105 25" fill="none" xmlns="http://www.w3.org/2000/svg">
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
      <svg class="light" width="23" height="22" viewBox="0 0 23 22" fill="none" xmlns="http://www.w3.org/2000/svg">
        <path
            d="M21.6191 0.881252C21.3412 0.602328 21.011 0.381012 20.6474 0.23C20.2838 0.0789873 19.894 0.00125122 19.5003 0.00125122C19.1066 0.00125122 18.7168 0.0789873 18.3532 0.23C17.9896 0.381012 17.6594 0.602328 17.3816 0.881252L17.3534 0.909377L12.2066 6.64688L11.3441 5.78438C11.1357 5.57349 10.8875 5.40606 10.6139 5.29178C10.3403 5.17751 10.0468 5.11867 9.75031 5.11867C9.45383 5.11867 9.16029 5.17751 8.88671 5.29178C8.61314 5.40606 8.36496 5.57349 8.15656 5.78438L0.965938 12.9656C0.825101 13.1078 0.746094 13.2999 0.746094 13.5C0.746094 13.7001 0.825101 13.8922 0.965938 14.0344L8.46594 21.5344C8.60929 21.673 8.8009 21.7505 9.00031 21.7505C9.19972 21.7505 9.39133 21.673 9.53469 21.5344L16.7159 14.3438C16.9268 14.1354 17.0943 13.8872 17.2085 13.6136C17.3228 13.34 17.3816 13.0465 17.3816 12.75C17.3816 12.4535 17.3228 12.16 17.2085 11.8864C17.0943 11.6128 16.9268 11.3646 16.7159 11.1563L15.8534 10.2938L21.5909 5.14688L21.6191 5.11875C21.898 4.8409 22.1193 4.51071 22.2703 4.14712C22.4213 3.78353 22.4991 3.3937 22.4991 3C22.4991 2.6063 22.4213 2.21647 22.2703 1.85289C22.1193 1.4893 21.898 1.15911 21.6191 0.881252ZM9.00031 19.9406L7.67844 18.6188L10.0691 16.2188C10.1983 16.0761 10.2678 15.8892 10.263 15.6967C10.2583 15.5042 10.1797 15.321 10.0436 15.1848C9.90747 15.0487 9.7242 14.9701 9.53174 14.9654C9.33927 14.9607 9.15236 15.0301 9.00969 15.1594L6.61906 17.5594L5.05344 15.9938L7.44406 13.5938C7.57333 13.4511 7.64279 13.2642 7.63805 13.0717C7.63331 12.8792 7.55474 12.696 7.41861 12.5598C7.28247 12.4237 7.0992 12.3451 6.90674 12.3404C6.71427 12.3357 6.52736 12.4051 6.38469 12.5344L3.99406 14.9344L2.55969 13.5L6.75031 9.30938L13.1909 15.75L9.00031 19.9406Z"
            fill="white"/>
      </svg>
      <LangSelector/>
      <Button @click="downloadResume()">
        <p>{{ header.curriculum }}</p>
      </Button>
    </section>
  </header>
</template>

<script setup lang="ts">
import {onMounted, onUnmounted, ref} from "vue";
import {HTTPAxios} from "@/object/HTTPAxios";
import {HeaderSite} from "@/object/UserProfile";
import LangSelector from "@/vue/preferences/LangSelector.vue";
import Button from "@/vue/global/Button.vue";

const header = ref<HeaderSite>()
const scrollValue = ref(window.scrollY)

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
  new HTTPAxios('julien.petit.pdf',null,true).get().then((response)=>{
    const blob = new Blob([response.data], {type: 'application/pdf'})
    const link = document.createElement('a')
    link.href = URL.createObjectURL(blob)
    link.setAttribute('download', 'julien.petit.pdf');
    document.body.appendChild(link);
    link.click()
  })
}

</script>

<style scoped lang="scss">
header {
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

    &:hover path {
      stroke: var(--main);
    }

    &.light:hover path {
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

</style>
