<template>
  <div class="markdown-wrapper">
    <transition mode="in-out">
      <Loading v-if="loading"/>
    </transition>
    <transition-group mode="in-out">
      <Button @click="router.back()">
        <p>{{"<- Retour"}}</p>
      </Button>
      <div id="content" v-html="renderResult"/>
    </transition-group>
  </div>
</template>

<script setup lang="ts">
import {marked} from "marked";
import {onMounted, ref} from "vue";
import Loading from "../global/Loading.vue";
import axios from "axios";
import Button from "@/vue/global/Button.vue";
import router from "@/router";

const mdFile = ref();
const renderResult = ref("");
const loading = ref<boolean>(false)

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
    loading.value = false;
  }).catch(() => {
    loading.value = false;
  })
})

function copyLink() {
  navigator.clipboard.writeText(window.location.toString()).then(() => {

  })
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
</style>
