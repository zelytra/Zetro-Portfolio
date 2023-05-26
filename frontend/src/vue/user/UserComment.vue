<template>
  <section class="user-comments-wrapper" v-if="userComments">
    <Title :title="userComments.title" :sub-title="userComments.subTitle"/>
    <AppearAnimation :once="true" v-model="isOnScreen">
      <div class="comments-wrapper">
        <div class="comment" :class="{'slide-bottom-to-top':isOnScreen}" v-for="comment of userComments.comments">
          <div class="header">
            <img :src="comment.icon"/>
            <h3>{{ comment.name }}</h3>
          </div>
          <p>{{ comment.comment }}</p>
        </div>
      </div>
    </AppearAnimation>
  </section>
</template>

<script setup lang="ts">
import {onMounted, ref} from "vue";
import {UserComment} from "@/object/UserProfile";
import {HTTPAxios} from "@/object/utils/HTTPAxios";
import Title from "@/vue/global/utils/Title.vue";
import AppearAnimation from "@/vue/global/utils/AppearAnimation.vue";

const userComments = ref<UserComment>()
const isOnScreen = ref(false)

onMounted(() => {
  new HTTPAxios("user/user-comments.json", null, true).get().then((data) => {
    userComments.value = data.data as UserComment
  })
})
</script>

<style scoped lang="scss">
@import "@assets/style.scss";

.user-comments-wrapper {
  display: flex;
  flex-direction: column;
  align-items: center;
  gap: 80px;

  .comments-wrapper {
    display: flex;
    align-items: center;
    justify-content: space-between;
    gap: 18px;
    flex-wrap: nowrap;
    @media screen and (max-width: $responsive-break-point) {
      flex-wrap: wrap;
    }

    .comment {
      padding: 24px;
      border: solid 1px var(--main);
      border-radius: 8px;
      display: flex;
      flex-direction: column;
      gap: 12px;
      background: var(--hover-main);
      opacity: 0;

      @media screen and (max-width: $responsive-break-point) {
        padding: 12px;
      }

      .header {
        display: flex;
        align-items: center;
        gap: 12px;

        img {
          width: 60px;
          height: 60px;
        }

        h3 {
          font-family: PlusJakartaSans, sans-serif;
          font-style: normal;
          font-weight: 500;
          font-size: 18px;
          line-height: 22px;
          color: var(--main);
        }
      }


    }
  }
}
</style>
