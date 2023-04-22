<template>
  <footer>
    <section class="upper-side">
      <div class="content resume">
        <img alt="logo" src="@assets/icons/full_logo.svg"/>
        <p>Je suis un designer web UI/UX créatif avec plus de 4 ans d'expérience. Je suis également expérimenté dans les
          domaines de la conception de logo, de la conception de sites web et de la conception de marque.</p>
      </div>
      <div class="content">
        <h3>LIENS</h3>
        <a href="">Autres</a>
        <a href="">Autres</a>
        <a href="">Autres</a>
        <a href="">Autres</a>
        <a href="">Autres</a>
      </div>
      <div class="content">
        <h3>LIENS</h3>
        <a href="">Autres</a>
        <a href="">Autres</a>
        <a href="">Autres</a>
        <a href="">Autres</a>
        <a href="">Autres</a>
      </div>
      <div class="content">
        <h3>LIENS</h3>
        <a href="">Figma</a>
        <a href="">Adobe</a>
        <a href="">Dribbble</a>
        <a href="">Behance</a>
        <a href="">Themeforest</a>
      </div>
      <div class="content">
        <div class="badge facebook">
          <img src="@assets/icons/facebook.svg"/>
          <p>Facebook</p>
        </div>
        <div class="badge linkedin">
          <img src="@assets/icons/linkedin.svg"/>
          <p>Linkedin</p>
        </div>
        <div class="badge twitter">
          <img src="@assets/icons/twitter.svg"/>
          <p>Twitter</p>
        </div>
        <div class="badge instagram">
          <img src="@assets/icons/instagram.svg"/>
          <p>Instagram</p>
        </div>
      </div>
    </section>
    <hr>
    <h5>Copyright © ZeTro - Developpé par <a href="https://zelytra.fr" target="_blank">Zelytra</a></h5>
  </footer>
</template>

<script setup lang="ts">
</script>

<style scoped lang="scss">
footer {
  display: flex;
  max-width: 1600px;
  flex-direction: column;
  align-items: center;
  overflow: hidden;
  position: sticky;
  top: 100vh;
  margin: 120px 10% 62px 10%;

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
        height: 90%;
        width: fit-content;
        border-radius: 5px;
        padding: 12px;
        cursor: pointer;

        &.facebook {
          background: rgba(24, 119, 242, 0.08);

          p {
            color: #BDBDBD;
          }
        }

        &.linkedin {
          background: #0E76A8;

          p {
            color: white;
          }
        }

        &.twitter {
          background: rgba(29, 161, 242, 0.08);

          p {
            color: #BDBDBD;
          }
        }

        &.instagram {
          background: linear-gradient(45deg, rgba(255, 214, 0, 0.08) 8.39%, rgba(255, 1, 0, 0.08) 50%, rgba(216, 0, 185, 0.08) 91.61%);

          p {
            color: #BDBDBD;
          }
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
