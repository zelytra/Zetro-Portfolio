<template>
  <div class="content-displayer-wrapper">
    <!-- <Summary :headings="headings"/> -->
    <div class="markdown-wrapper">
      <transition mode="in-out">
        <Loading v-if="loading"/>
      </transition>
      <Button @click="router.back()">
        <p>{{ "<- Retour" }}</p>
      </Button>
      <div id="content" v-html="renderResult"/>
    </div>
  </div>
</template>

<script setup lang="ts">
import {marked} from "marked";
import {onMounted, nextTick, ref} from "vue";
import Loading from "../global/utils/Loading.vue";
import axios from "axios";
import Button from "@/vue/global/form/Button.vue";
import router from "@/router";
import Summary from "@/vue/blog/Summary.vue";

const mdFile = ref();
const renderResult = ref("");
const loading = ref<boolean>(false)
const headings = ref<Element[]>([])

const props = defineProps({
  markdownSrc: {
    type: String,
    required: true
  }
})

onMounted(() => {
  loading.value = true;
  axios.get(props.markdownSrc).then((response) => {
    console.debug("[GET] " + props.markdownSrc)
    mdFile.value = response.data;
    renderResult.value = marked(mdFile.value);
    nextTick(() => {
      headings.value = getHeadings()
    })
    loading.value = false;
  }).catch(() => {
    loading.value = false;
  })
})

function getHeadings(): Element[] {
  const headings = Array.from(document.getElementById('content')!.querySelectorAll('h1,h2,h3'));
  return headings.map((heading) => heading);
}

function scrollToHeading(heading: string) {
  const targetHeading = document.querySelector(`h1,h2,h3:contains("${heading}")`);
  if (targetHeading) {
    targetHeading.scrollIntoView({behavior: 'smooth'});
  }
}
</script>

<style lang="scss">

.v-enter-active,
.v-leave-active {
  transition: 0.2s ease;
}

.v-enter-from,
.v-leave-from {
  opacity: 0;
}

.content-displayer-wrapper {
  display: flex;
  justify-content: center;
  align-items: start;
  gap: 8px;

  .markdown-wrapper {
    user-select: text !important;
    width: 100%;
    padding: 0 5% 5% 5%;
    position: relative;

    @media screen and (max-width: 1140px) {
      padding: 0 4px 4px 4px;
    }
  }

  #content {
    width: inherit;
    min-height: 300px;
    display: flex;
    flex-direction: column;

    a, a > em, a > strong, a > del {
      font-family: Inter, sans-serif;
      color: var(--main);

      opacity: 0.8;

      &:hover {
        opacity: 1;
      }
    }

    h1 {
      font-family: PlusJakartaSans, sans-serif;
      font-size: 36px;
      font-weight: 700;
      margin: 24px 0 12px 0;
      color: var(--main);
    }

    h2 {
      font-family: PlusJakartaSans, sans-serif;
      font-size: 24px;
      font-weight: 700;
      color: var(--main);
      margin: 24px 0 12px 0;
    }

    h3 {
      font-family: PlusJakartaSans, sans-serif;
      font-size: 18px;
      font-weight: 700;
      color: var(--main);
      margin: 12px 0 2px 0;
    }

    h4 {
      font-family: PlusJakartaSans, sans-serif;
      font-size: 16px;
      font-weight: 700;
      color: var(--main);
      margin: 12px 0 2px 0;
    }

    h5 {
      font-family: PlusJakartaSans, sans-serif;
      font-size: 14px;
      font-weight: 700;
      color: var(--main);
      margin: 12px 0 2px 0;
    }

    h6 {
      font-family: PlusJakartaSans, sans-serif;
      font-size: 12px;
      font-weight: 700;
      color: var(--main);
      margin: 12px 0 2px 0;
    }

    hr {
      border: none;
      background-color: var(--main);
      height: 2px;
      border-radius: 2px;
      margin: 30px auto;
      width: 100%;
    }

    code {
      padding: 2px;
      font-family: Inter, sans-serif;
      border-radius: 4px;
      color: var(--primary-text);
      font-style: normal;
      font-weight: 400;
      font-size: 16px;
      line-height: 125%;

      background-color: var(--heavy-background);
    }

    pre {
      background-color: var(--heavy-background);
      padding: 12px;
      margin: 8px 0;
      border-radius: 7px;

      code {
        padding: 0;
        background: none;
        font-family: Inter, serif;
        font-size: 14px;
      }
    }

    p {
      margin: 6px 0 0 0;
      font-family: Inter, sans-serif;
      font-size: 16px;
      text-align: justify;


      em {
        font-family: Inter, serif;
        font-style: italic;
      }

      strong {
        font-family: Inter, serif;
        font-weight: 700;
      }

      code {
        width: fit-content;
      }

      del {
        text-decoration: line-through;
      }
    }

    blockquote {
      border-left: solid var(--main) 4px;
      background: rgba(255, 232, 209, 0.1);
      border-radius: 7px;
      margin-top: 4px;
      padding: 8px;

      :not(:first-child) {
        margin-left: 4px;
      }

      p {
        margin: 0 0 0 12px;
        font-family: Inter, sans-serif;
        font-weight: 400;
      }
    }

    ul, ol {
      padding: 4px;
      margin-left: 20px;
      font-family: Inter, sans-serif;
      font-weight: 400;
    }

    table {
      padding: 24px;
      width: 100%;
      margin: 12px;

      tr:last-child td:first-child {
        border-bottom-left-radius: 5px;
      }

      tr:last-child td:last-child {
        border-bottom-right-radius: 5px;
      }

      tr:first-child th:first-child {
        border-top-left-radius: 5px;
      }

      tr:first-child th:last-child {
        border-top-right-radius: 5px;
      }

      tr {
        th {
          background: rgba(255, 232, 209, 0.4);
          padding: 12px;
          color: var(--revert-text);
          font-weight: 500;
          font-size: 16px;
        }
      }


      tbody {

        tr {
          text-align: center;

          td {
            padding: 4px;
            color: var(--primary-text);

            img {
              display: block;
              margin-left: auto;
              margin-right: auto;
              image-rendering: pixelated;
            }
          }

          &:nth-child(2n) td {
            background: #272523;
          }

          &:nth-child(2n+1) td {
            background: #3C3835;
          }
        }
      }

      @media screen and (max-width: 1140px) {
        padding: 12px;
        margin: 0;
        tr {
          td {
            padding: 1px;
          }

          th {
            padding: 4px;
          }
        }
      }
    }

    img {
      width: 100%;
    }
  }

  .content-wrapper {
    display: flex;
    gap: 10px;

    &.info {
      background: var(--info-background);
      border: 1px solid var(--info-border);
      box-shadow: 0 12px 32px var(--info-shadow);
      border-left: solid 4px var(--info-main);

      svg path {
        &.stroke {
          stroke: var(--info-main)
        }

        &.fill {
          fill: var(--info-main)
        }
      }
    }

    &.warn {
      background: var(--detail-background);
      border: 1px solid var(--detail-border);
      box-shadow: 0 12px 32px var(--detail-shadow);
      border-left: solid 4px var(--detail-main);

      svg path {
        &.stroke {
          stroke: var(--detail-main)
        }

        &.fill {
          fill: var(--detail-main)
        }
      }
    }

    &.error {
      background: var(--error-background);
      border: 1px solid var(--error-border);
      box-shadow: 0 12px 32px var(--error-shadow);
      border-left: solid 4px var(--error-main);

      svg path {
        &.stroke {
          stroke: var(--error-main)
        }

        &.fill {
          fill: var(--error-main)
        }
      }
    }

    border-radius: 10px;
    padding: 20px;

    .content {
      display: flex;
      flex-direction: column;
      gap: 6px;

      h2 {
        font-family: PlusJakartaSans, sans-serif;
        font-weight: 500 !important;
        font-size: 16px !important;
        line-height: 24px;
        margin: 0 !important;

        &.info {
          color: var(--info-main) !important;
        }

        &.warn {
          color: var(--detail-main) !important;
        }

        &.error {
          color: var(--error-main) !important;
        }
      }

      p {
        font-family: PlusJakartaSans, sans-serif;
        font-style: normal;
        font-weight: 400;
        font-size: 14px;
        line-height: 20px;
      }
    }
  }
}
</style>
