<template>
  <div class="index-page">
    <!-- Sidebar (FooterGestion) -->
    <FooterGestion class="sidebar" />

    <div class="top-bar">
      <DisconnectButton />
    </div>
    <!-- Bouton Statistiques en haut à droite -->

    <div class="top-right-button">
      <StatButton />
    </div>
  </div>
</template>

<script>
import StatButton from "@/components/admin/statistiques/StatButton.vue";
import FooterGestion from "@/components/admin/FooterGestion.vue";
import DisconnectButton from "@/components/admin/DisconnectButton.vue";


export default {
  name: "IndexPage",
  components: {
    StatButton,
    FooterGestion,
    DisconnectButton

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

.top-bar {
position: absolute;
top: 0px; /* Ajuste cette valeur pour aligner verticalement avec la barre orange */
left: 247px;
transform: translateX(-50%);
z-index: 999;
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
