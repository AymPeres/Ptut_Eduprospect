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

    <!-- Section principale pour afficher les inscriptions -->
    <div class="main-content">
      <InscriptionsTable />
    </div>
  </div>
</template>

<script setup>
import StatButton from "@/components/admin/statistiques/StatButton.vue";
import FooterGestion from "@/components/admin/FooterGestion.vue";
import DisconnectButton from "@/components/admin/DisconnectButton.vue";
import InscriptionsTable from "@/components/admin/InscriptionsTable.vue";
</script>

<style scoped>
.index-page {
  position: relative;
  width: 100%;
  height: 100vh;
}

/* Top bar */
.top-bar {
  position: absolute;
  top: 0px;
  left: 247px;
  transform: translateX(-50%);
  z-index: 999;
}

/* Bouton en haut à droite */
.top-right-button {
  position: absolute;
  top: 20px;
  right: 20px;
  z-index: 999;
}

/* Sidebar fixe */
.sidebar {
  position: fixed;
  top: 0;
  left: 0;
  width: 350px;      /* Ajuste selon la largeur désirée */
  height: 100vh;     /* Toute la hauteur de l'écran */
  background-color: #fff;
  z-index: 1000;     /* Devant le fond violet */
}

/* Contenu principal (espace réservé aux inscriptions) */
.main-content {
  margin-left: 350px; /* Pour laisser de l'espace à la sidebar */
  padding: 20px;
  height: 100%;
  overflow-y: auto;
  background-color: #f8f8f8; /* Couleur de fond optionnelle */
}
</style>
