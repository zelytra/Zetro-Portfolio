<template>
  <transition>
    <div class="modal" v-if="isModalOpen">
      <div class="content-modal" v-click-outside="() => toggleModal()">
        <svg width="40" height="40" viewBox="0 0 40 40" fill="none" xmlns="http://www.w3.org/2000/svg"
             @click="toggleModal()">
          <path class="stroke"
                d="M19.9997 36.6663C29.2044 36.6663 36.6663 29.2044 36.6663 19.9997C36.6663 10.7949 29.2044 3.33301 19.9997 3.33301C10.7949 3.33301 3.33301 10.7949 3.33301 19.9997C3.33301 29.2044 10.7949 36.6663 19.9997 36.6663Z"
                stroke="#FFE8D1" stroke-width="2" stroke-linecap="round" stroke-linejoin="round"/>
          <path class="fill" d="M25 15L15 25" stroke="#FFE8D1" stroke-width="2" stroke-linecap="round"
                stroke-linejoin="round"/>
          <path class="fill" d="M15 15L25 25" stroke="#FFE8D1" stroke-width="2" stroke-linecap="round"
                stroke-linejoin="round"/>
        </svg>
        <slot/>
      </div>
    </div>
  </transition>
</template>

<script setup lang="ts">

const props = defineProps({
  isModalOpen: {
    type: Boolean
  }
})

const emits = defineEmits(['update:isModalOpen'])

function toggleModal() {
  console.log(props.isModalOpen)
  emits('update:isModalOpen', !props.isModalOpen)
}
</script>

<style scoped lang="scss">
.modal {
  position: fixed;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  z-index: 99;
  backdrop-filter: blur(4px);
  display: flex;
  justify-content: center;
  align-items: center;

  .content-modal {
    position: relative;
    display: flex;
    justify-content: start;
    align-items: center;
    flex-direction: column;
    background: red;
    max-width: 90%;

    svg {
      cursor: pointer;
      width: 35px;
      position: absolute;
      top: -35px;
      right: -35px;

      path {
        &.fill {
          fill: var(--main);
        }

        &.stroke {
          stroke: var(--main);
        }
      }
    }
  }
}

.v-enter-active,
.v-leave-active {
  transition: opacity 0.2s ease;
}

.v-enter-from,
.v-leave-to {
  opacity: 0;
}
</style>