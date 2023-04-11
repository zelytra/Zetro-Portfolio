<template>
  <section class="user-title">
    <div class="content">
      <h3>- JE M'APPELLE</h3>
      <h1>Julien <span>Petit.</span></h1>
      <p>Je suis un designer web UI/UX créatif avec plus de 4 ans d'expérience en conception d'interfaces utilisateur,
        logo, site web et branding, travaillant à créer des designs innovants pour répondre aux besoins des clients et
        offrir une expérience utilisateur optimale.</p>
      <div class="social-icons">
        <a href=""><img src="@assets/icons/instagram_white.svg" alt="Instagram"/></a>
        <a href=""><img src="@assets/icons/github_white.svg" alt="Github"/></a>
        <a href=""><img src="@assets/icons/twitter_white.svg" alt="Twitter"/></a>
        <a href=""><img src="@assets/icons/linkedin_white.svg" alt="Linkedin"/></a>
      </div>
    </div>
    <div class="content">
      <div class="logo-container">
        <img class="logo" src="@assets/icons/logo.svg" alt="Logo"/>
      </div>
    </div>
  </section>
</template>

<script setup lang="ts">

</script>

<style scoped lang="scss">
section.user-title {
  display: flex;
  justify-content: space-between;
  width: inherit;
  margin: 120px auto;

  .content {
    display: flex;
    flex-direction: column;
    max-width: 60%;
    gap: 12px;

    .logo-container {
      border-radius: 50%;
      padding: 40px;
      border: solid var(--main) 12px;
      display: flex;
      justify-content: center;
      align-items: center;
      width: 150px;
      height: 150px;
      position: relative;

      &:before {
        content: '';
        position: absolute;
        top: 50%;
        left: 50%;
        transform: translate(-50%, -50%);
        width: inherit;
        height: inherit;
        border-radius: 50%;
        padding: 40px;
        border: solid var(--main) 12px;
        filter: blur(40px);
      }
    }

    h3 {
      font-weight: 500;
      font-size: 16px;
      line-height: 24px;
      color: var(--primary-text);
      letter-spacing: 7.5px;
    }

    h1 {
      font-family: PlusJakartaSans, sans-serif;
      font-style: normal;
      font-weight: 700;
      font-size: 55px;
      line-height: 55px;
      color: var(--primary-text);

      span {
        color: var(--main);
      }
    }

    p {
      font-weight: 400;
      font-size: 16px;
      line-height: 32px;
    }

    .social-icons{
      display: flex;
      gap: 32px;

    }

  }
}
</style>