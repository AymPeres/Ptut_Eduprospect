<template>
  <div class="index-page">
    <!-- Sidebar (FooterGestion) -->
    <FooterGestion class="sidebar" />

    <!-- Bouton Statistiques en haut à droite -->

    <div class="top-right-button">
      <StatButton />
    </div>
  </div>
</template>

<script>
import StatButton from "@/components/admin/statistiques/StatButton.vue";
import FooterGestion from "@/components/admin/FooterGestion.vue";


export default {
  name: "IndexPage",
  components: {
    StatButton,
    FooterGestion,

  },
};
</script>

<style scoped>
/* Le conteneur global */
.index-page {
  position: relative;
  width: 100%;
  height: 100vh;
}

/* Le conteneur qui place le bouton en haut à droite */
.top-right-button {
  position: absolute;
  top: 20px;
  right: 20px;
  z-index: 999;
}

/* La sidebar blanche (FooterGestion) */
.sidebar {
  position: fixed;
  top: 0;
  left: 0;
  width: 350px;      /* Ajuste selon la largeur désirée */
  height: 100vh;     /* Toute la hauteur de l'écran */
  background-color: #fff;
  z-index: 1000;     /* Devant le fond violet */
}

</style>
