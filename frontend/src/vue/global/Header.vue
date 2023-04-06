<template>
  <header>
    <img src="@assets/icons/full_logo.svg"/>
    <nav>
      <router-link v-for="route in routes.routes"
                   :key="route.name"
                   :to="route.path">
        {{ route.name }}
      </router-link>
    </nav>
    <section class="action">
      <img src="@assets/icons/light.svg"/>
      <img src="@assets/icons/lang.svg"/>
      <div class="cv-button">
        <p>Mon CV</p>
      </div>
    </section>
  </header>
</template>

<script setup lang="ts">
import * as routes from '@/router'

</script>

<style scoped lang="scss">
header {
  display: flex;
  align-items: center;
  width: 80%;
  margin: auto;
  padding: 24px 0;
  justify-content: space-between;

  nav {
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

    .cv-button {
      padding: 14px 22px;
      border: 1px solid var(--main);
      border-radius: 8px;
      cursor: pointer;

      &:hover {
        background: var(--main);

        p {
          color: var(--revert-text);
        }
      }
    }
  }
}

</style>
