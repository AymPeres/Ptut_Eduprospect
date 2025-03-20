<template>
  <div class="index-page">
    <!-- Bouton Statistiques en haut à droite -->
    <div class="top-right-button">
      <StatButton />
    </div>
  </div>
</template>

<script>
import StatButton from "@/components/admin/statistiques/StatButton.vue";

export default {
  name: "IndexPage",
  components: {
    StatButton,
  },
};
</script>

<style scoped>
/* Le conteneur global */
.index-page {
  /* Pour que le positionnement absolute prenne comme référence toute la zone */
  position: relative;
  width: 100%;
  height: 100vh; /* S'étend sur la hauteur de la fenêtre (ou adapte selon ton besoin) */
}

/* Le conteneur qui place le bouton en haut à droite */
.top-right-button {
  position: absolute;
  top: 20px;    /* Ajuste selon l'endroit exact où tu veux le bouton */
  right: 20px;  /* Idem */
  z-index: 999; /* Au-dessus du fond violet et des éléments décoratifs */
}

/* Ton bloc existant pour le lien "Statistiques" vers /formulaire */




.button:hover {
  background-color: #ED6962;
  transform: scale(1.05);
}
</style>
