<template>
  <div class="index-page">
    <!-- Bouton Statistiques en haut à droite -->
    <div class="top-right-button">
      <StatButton />
    </div>

    <!-- FooterGestion ajouté -->
    <FooterGestion />
  </div>
</template>

<script>
import StatButton from "@/components/admin/statistiques/StatButton.vue";
import FooterGestion from "@/components/admin/statistiques/FooterGestion.vue";

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
  height: 100vh; /* S'étend sur toute la hauteur */
}

/* Placement du bouton Statistiques en haut à droite */
.top-right-button {
  position: absolute;
  top: 20px;
  right: 20px;
  z-index: 999;
}

/* Animation du bouton */
.button:hover {
  background-color: #ED6962;
  transform: scale(1.05);
}
</style>
