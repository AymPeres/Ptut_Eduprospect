<template>
  <div class="index-page">
    <!-- Sidebar (FooterStat) -->
    <FooterStatistique class="sidebarStat" />

    <!-- Bouton Gestion en haut à droite -->
    <div class="top-right-button">
      <GestionButton />
    </div>
  </div>
</template>

<script>
import FooterStatistique from "@/components/admin/FooterStatistique.vue";
import GestionButton from "@/components/admin/GestionButton.vue";

export default {
  name: "IndexPage",
  components: {
    GestionButton,
    FooterStatistique,
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

/* La sidebar blanche (FooterStat) */
.sidebarStat {
  position: fixed;
  top: 0;
  left: 0;
  width: 350px;      /* Ajuste selon la largeur désirée */
  height: 100vh;     /* Toute la hauteur de l'écran */
  background-color: #fff;
  z-index: 1000;     /* Devant le fond violet */
}
</style>
