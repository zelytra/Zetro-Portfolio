<template>
  <div class="custom-loader"/>
</template>

<script setup lang="ts">

</script>

<style scoped>
.custom-loader {
  width:50px;
  height:50px;
  display: grid;
  color: var(--main);

  position: fixed;
  top: 50%;
  left: 50%;
  transform: translate(-50%,-50%);
}

.custom-loader:before,
.custom-loader:after {
  content: "";
  grid-area: 1/1;
  margin: 0 0 15px 15px;
  --c1:linear-gradient(90deg,#0000 calc(100%/3),currentColor 0 calc(2*100%/3),#0000 0);
  --c2:linear-gradient( 0deg,#0000 calc(100%/3),currentColor 0 calc(2*100%/3),#0000 0);
  background:
      var(--c1),
      var(--c2),
      var(--c1),
      var(--c2);
  background-size:300% 4px,4px 300%;
  background-repeat: no-repeat;
  animation: l2 1s infinite linear;
}
.custom-loader:after {
  margin: 15px 15px 0 0;
  transform: scale(-1,-1);
}

@keyframes l2 {
  0%   {background-position: 50%  0,100% 100%,0    100%,0 0}
  25%  {background-position: 0    0,100% 50% ,0    100%,0 0}
  50%  {background-position: 0    0,100% 0   ,50%  100%,0 0}
  75%  {background-position: 0    0,100% 0   ,100% 100%,0 50%}
  75.01%{background-position: 100% 0,100% 0   ,100% 100%,0 50%}
  100% {background-position: 50%  0,100% 0   ,100% 100%,0 100%}
}
</style>
