<template>
  <section class="services-wrapper">
    <Title class="title" v-if="service" :sub-title="service.subTitle" :title="service.title"/>
    <AppearAnimation :once="true" v-model="isOnScreen" :threshold="0.2">
      <section class="specialisation" v-if="service && service.cards">
        <SkillCard :class="{'slide-left-to-right':isOnScreen}" :title="getCard(0).title"
                   :content="getCard(0).content">
          <svg class="stroke fill" width="19" height="16" viewBox="0 0 19 16" fill="none"
               xmlns="http://www.w3.org/2000/svg">
            <path d="M1.5 15H17.5M1.5 1V12H17.5V1L13.5 5L9.5 1L5.5 5L1.5 1Z" stroke="#FFE8D1" stroke-width="1.5"
                  stroke-linecap="round" stroke-linejoin="round"/>
          </svg>
        </SkillCard>
        <SkillCard :class="{'slide-bottom-to-top':isOnScreen}" :style="'animation-delay:0.2s'" :title="getCard(1).title"
                   :content="getCard(1).content">
          <svg class="fill" width="18" height="18" viewBox="0 0 18 18" fill="none" xmlns="http://www.w3.org/2000/svg">
            <path fill-rule="evenodd" clip-rule="evenodd"
                  d="M10.0878 0.251698C9.43681 -0.0803184 8.55464 -0.0854414 7.89841 0.24572C5.60476 1.73726 3.1796 3.15909 1.10231 4.58476C0.793141 4.83439 0.573731 5.19713 0.577475 5.62411C0.581203 6.04933 0.805078 6.40722 1.11237 6.65274C3.1796 7.89854 5.60476 9.32037 7.84769 10.9529C8.49872 11.2849 9.38089 11.29 10.0371 10.9588C12.3952 9.32037 13.3653 8.84643 16.8332 6.6198C17.1424 6.37017 17.3618 6.00743 17.3581 5.58046C17.3543 5.15524 17.1305 4.79734 16.8232 4.55183C14.8204 3.15909 12.3952 1.73726 10.0878 0.251698ZM8.56611 1.50902C8.7986 1.3917 9.18051 1.39281 9.41458 1.51218C11.4252 2.68515 13.3653 4.10698 15.8238 5.59018C13.8503 6.95065 11.9102 8.37248 9.36942 9.69554C9.13693 9.81286 8.75502 9.81175 8.52095 9.69238C6.20197 8.37248 4.14966 6.95065 2.11175 5.61438C4.14966 4.10698 5.60476 3.15909 8.56611 1.50902Z"
                  fill="#FFE8D1"/>
            <path
                d="M17.8895 9.10286C18.1023 9.43591 17.9985 9.87446 17.6577 10.0824L11.7332 13.6966C10.9401 14.0598 9.96418 14.5337 9 14.5338C8.03582 14.5338 7.05986 14.0598 6.20197 13.6969L0.342448 10.1236C0.00157168 9.91574 -0.102304 9.47721 0.110436 9.14413C0.323176 8.81104 0.771971 8.70954 1.11285 8.91742L6.97237 12.4907C7.50023 12.8126 8.2497 13.112 9 13.1119C9.7503 13.1119 10.4349 12.8125 10.9626 12.4905L16.8871 8.87632C17.2279 8.66838 17.6767 8.76981 17.8895 9.10286Z"
                fill="#FFE8D1"/>
            <path
                d="M17.8895 12.6619C18.1023 12.9949 17.9985 13.4334 17.6577 13.6414L12.5271 16.7722C10.9401 17.531 10.2178 17.9999 8.96764 18C7.7175 18.0001 6.0898 17.057 5.40793 16.7726L0.342374 13.6826C0.00152299 13.4747 -0.102298 13.0362 0.110482 12.7031C0.323263 12.3701 0.772071 12.2686 1.11292 12.4765L6.17848 15.5665C6.92836 16.0239 7.93142 16.4296 8.96764 16.4295C10.0039 16.4295 11.0067 16.0237 11.7564 15.5662L16.887 12.4354C17.2278 12.2275 17.6766 12.3288 17.8895 12.6619Z"
                fill="#FFE8D1"/>
          </svg>

        </SkillCard>
        <SkillCard :class="{'slide-right-to-left':isOnScreen}" :title="getCard(2).title"
                   :content="getCard(2).content">
          <svg class="stroke" width="23" height="23" viewBox="0 0 23 23" fill="none"
               xmlns="http://www.w3.org/2000/svg">
            <path
                d="M11.3545 21.5C16.8773 21.5 21.3545 17.0228 21.3545 11.5C21.3545 5.97715 16.8773 1.5 11.3545 1.5C5.83164 1.5 1.35449 5.97715 1.35449 11.5C1.35449 17.0228 5.83164 21.5 11.3545 21.5Z"
                stroke="white" stroke-width="2" stroke-linecap="round" stroke-linejoin="round"/>
            <path d="M1.35449 11.5H21.3545" stroke="white" stroke-width="2" stroke-linecap="round"
                  stroke-linejoin="round"/>
            <path
                d="M11.3545 1.5C13.8558 4.23835 15.2772 7.79203 15.3545 11.5C15.2772 15.208 13.8558 18.7616 11.3545 21.5C8.85321 18.7616 7.43174 15.208 7.35449 11.5C7.43174 7.79203 8.85321 4.23835 11.3545 1.5Z"
                stroke="white" stroke-width="2" stroke-linecap="round" stroke-linejoin="round"/>
          </svg>

        </SkillCard>
      </section>
    </AppearAnimation>
  </section>
</template>

<script setup lang="ts">
import {onMounted, ref} from "vue";
import {HTTPAxios} from "@/object/utils/HTTPAxios";
import {Service} from "@/object/UserProfile";
import Title from "@/vue/global/utils/Title.vue";
import AppearAnimation from "@/vue/global/utils/AppearAnimation.vue";
import SkillCard from "@/vue/user/services/SkillCard.vue";

const service = ref<Service>()
const isOnScreen = ref(false)

onMounted(() => {
  new HTTPAxios("user/services.json", null, true).get().then((data) => {
    service.value = data.data
  })
})

function getCard(index: number) {
  return service.value!.cards[index]
}
</script>

<style scoped lang="scss">
@import "@assets/style.scss";

.title {
  margin: auto;
}

.services-wrapper {
  display: flex;
  flex-direction: column;
  gap: 80px;

}

section.specialisation {
  display: flex;
  justify-content: center;
  align-items: center;
  gap: 40px;
  @media screen and (max-width: $responsive-break-point) {
    flex-direction: column;
  }
}
</style>
