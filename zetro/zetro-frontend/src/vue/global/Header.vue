<template>
  <header v-if="header" :class="{stuck:scrollValue>=5}">
    <div class="logo" v-html="logoUrl" @click="router.push('/')"/>
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
    <div class="logo" v-html="logoUrl" @click="router.push('/')"/>
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
import axios from "axios";

const header = ref<HeaderSite>()
const scrollValue = ref(window.scrollY)
const deployMenu = ref<boolean>(true)
const router = useRouter()
const logoUrl = ref<string>("")

onMounted(() => {
  axios.get("https://raw.githubusercontent.com/" + import.meta.env.VITE_GITHUB_HOST + "/main/.assets/logo/large-logo.svg").then((data) => {
    logoUrl.value = data.data
  })

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

  .logo:deep {
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
