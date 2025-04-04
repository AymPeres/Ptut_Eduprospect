<template>
  <div class="index-page">
    <!-- Sidebar fixe -->
    <FooterGestion class="sidebar" @salon-chosen="onSalonChosen" />

    <!-- Barre du haut -->
    <div class="top-bar">
      <DisconnectButton />
    </div>
    <div class="top-right-button">
      <StatButton />
    </div>

    <!-- Zone principale -->
    <div class="main-content">
      <!-- Affiche le tableau UNIQUEMENT si un salon est sélectionné -->
      <InscriptionsTable
        v-if="selectedSalon"
        :salon="selectedSalon"
      />
    </div>
  </div>
</template>

<script setup>
import { ref } from 'vue'

import StatButton from "@/components/admin/statistiques/StatButton.vue"
import FooterGestion from "@/components/admin/FooterGestion.vue"
import DisconnectButton from "@/components/admin/DisconnectButton.vue"
import InscriptionsTable from "@/components/admin/InscriptionsTable.vue"

// On stocke ici le salon actuellement choisi
const selectedSalon = ref(null)

// Quand la sidebar nous dit qu’un salon a été choisi
function onSalonChosen(salon) {
  selectedSalon.value = salon
}
</script>

<style scoped>
.index-page {
  position: relative;
  width: 100%;
  height: 100vh;
}

/* Barre du haut */
.top-bar {
  position: absolute;
  top: 0px;
  left: 247px;
  transform: translateX(-50%);
  z-index: 999;
}

/* Bouton stats en haut à droite */
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
  width: 350px;      /* Ajuste si besoin */
  height: 100vh;
  background-color: #fff;
  z-index: 1000;
}

/* Zone principale (le reste de l'écran) */
.main-content {
  margin-left: 350px; /* Laisse la place pour la sidebar */
  padding: 20px;
  height: 100%;
  overflow-y: auto;
  background-color: #f8f8f8; /* Couleur de fond optionnelle */
}
</style>
