<template>
  <footer v-if="footer">
    <section class="upper-side">
      <div class="content resume">
        <img alt="logo" src="@assets/icons/full_logo.svg"/>
        <p>{{ footer.resume }}</p>
      </div>
      <div class="content" v-if="footer.shortcut" v-for="shortcut of footer.shortcut">
        <h3>{{shortcut.title}}</h3>
        <a v-for="link of shortcut.content" :href="link.link">{{link.name}}</a>
      </div>
      <div class="content">
        <a class="badge" :href="footer.facebook">
          <img src="@assets/icons/facebook.svg" alt="facebook"/>
          <p>Facebook</p>
        </a>
        <a class="badge" :href="footer.linkedin">
          <img src="@assets/icons/linkedin.svg" alt="linkedin"/>
          <p>Linkedin</p>
        </a>
        <a class="badge" :href="footer.twitter">
          <img src="@assets/icons/twitter.svg" alt="twitter"/>
          <p>Twitter</p>
        </a>
        <a class="badge" :href="footer.figma">
          <img src="@assets/icons/figma.svg" alt="figma"/>
          <p>Figma</p>
        </a>
      </div>
    </section>
    <hr>
    <h5>Copyright © ZeTro - {{ footer.develop }} <a href="https://zelytra.fr" target="_blank">Zelytra</a></h5>
    <h5 class="cgu">
      <router-link to="/cgu">CGU</router-link>
    </h5>
  </footer>
</template>

<script setup lang="ts">
import {onMounted, ref} from "vue";
import {FooterSite} from "@/object/UserProfile";
import {HTTPAxios} from "@/object/HTTPAxios";

const footer = ref<FooterSite>()

onMounted(() => {
  new HTTPAxios("global/footer.json", null, true).get().then((data) => {
    footer.value = data.data as FooterSite
  })
})
</script>

<style scoped lang="scss">
footer {
  display: flex;
  max-width: 1600px;
  width: 90%;
  flex-direction: column;
  align-items: center;
  overflow: hidden;
  position: sticky;
  top: 100vh;
  margin: 170px auto 60px auto;

  p {
    font-weight: 300;
    font-size: 15px;
    line-height: 24px;
  }

  img[alt="logo"] {
    width: 120px;
  }

  hr {
    width: 100%;
    color: var(--main);
    margin: 30px 0;
    opacity: 50%;
  }

  .cgu {
    position: absolute;
    bottom: 0;
    left: 0;
  }

  section.upper-side {
    display: flex;
    justify-content: space-between;
    width: 100%;
    gap: 24px;
    margin: auto;

    .content {
      display: flex;
      flex-direction: column;
      gap: 12px;

      &.resume {
        max-width: 35%;
      }

      h3 {
        color: var(--main);
        font-weight: 400;
        font-size: 16px;
        margin-bottom: 16px;
      }

      a {
        font-weight: 400;
        font-size: 16px;

        &:hover {
          color: var(--main);
        }


      }

      .badge {
        display: flex;
        align-items: center;
        justify-content: space-between;
        gap: 8px;
        height: 25px;
        width: fit-content;
        border-radius: 5px;
        padding: 12px;
        cursor: pointer;
        background: rgba(255, 232, 209, 0.1);
        border: 1px solid rgba(255, 232, 209, 0.1);

        &:hover {
          border: 1px solid #FFE8D1;
        }
      }
    }
  }

  h5 {
    a:hover {
      color: var(--main);
    }
  }

}
</style>
