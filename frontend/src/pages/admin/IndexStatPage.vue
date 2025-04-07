<template>
  <div class="index-page">

    <div class="top-bar">
      <DisconnectButton />
    </div>

    <!-- Sidebar (FooterStat) -->
    <FooterStatistique
      class="sidebarStat"
      @show-formation-chart="updateChart('formation')"
      @show-villes-annees-salons="updateChart('villesAnneesSalons')"
      @show-statut-chart="updateChart('statut')"
      @show-cycle-chart="updateChart('cycle')"
      @show-connaitre-isis-chart="updateChart('connaitreIsis')"
      @show-genre-chart="updateChart('genre')"
    />

    <!-- Bouton Gestion en haut à droite -->
    <div class="top-right-button">
      <GestionButton />
    </div>

    <!-- Graphique -->
    <div v-if="showChart === 'formation'" class="chart-container">
      <StatFormation />
    </div>
    <div v-if="showChart === 'villesAnneesSalons'" class="chart-container">
      <StatNbProspect />
    </div>
    <div v-if="showChart === 'statut'" class="chart-container">
      <StatStatut />
    </div>
    <div v-if="showChart === 'cycle'" class="chart-container">
      <StatCycle />
    </div>
    <div v-if="showChart === 'connaitreIsis'" class="chart-container">
      <StatConnaitreIsis />
    </div>
    <div v-if="showChart === 'genre'" class="chart-container">
      <StatGenre />
    </div>
  </div>
</template>

<script>
import FooterStatistique from "@/components/admin/FooterStatistique.vue";
import GestionButton from "@/components/admin/GestionButton.vue";
import DisconnectButton from "@/components/admin/DisconnectButton.vue"; // Import ajouté
import StatFormation from "@/components/admin/statistiques/StatFormation.vue";
import StatNbProspect from "@/components/admin/statistiques/StatNbProspect.vue";
import StatStatut from "@/components/admin/statistiques/StatStatut.vue";
import StatCycle from "@/components/admin/statistiques/StatCycle.vue";
import StatConnaitreIsis from "@/components/admin/statistiques/StatConnaitreIsis.vue";
import StatGenre from "@/components/admin/statistiques/StatGenre.vue";

export default {
  name: "IndexPage",
  components: {
    GestionButton,
    FooterStatistique,
    DisconnectButton, // Composant ajouté
    StatFormation,
    StatNbProspect,
    StatStatut,
    StatCycle,
    StatConnaitreIsis,
    StatGenre
  },
  data() {
    return {
      showChart: null
    };
  },
  methods: {
    updateChart(chartType) {
      console.log(`Showing chart for: ${chartType}`);
      this.showChart = chartType;
    }
  }
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
/* Barre du haut */
.top-bar {
  position: absolute;
  top: 0px;
  left: 247px;
  transform: translateX(-50%);
  z-index: 999;
}
.chart-container {
  position: absolute;
  top: 100px; /* Ajustez selon vos besoins */
  left: 370px; /* Ajustez selon vos besoins */
  width: calc(100% - 360px); /* Réduisez la largeur */
  height: calc(100vh - 90px); /* Réduisez la hauteur */
  background-color: #f9f9f9;
  padding: 10px; /* Réduisez le padding */
}
/* Sidebar fixe */
.sidebarStat {
  position: fixed;
  top: 0px;
  left: 0;
  width: 350px;      /* Ajuste si besoin */
  height: 100vh;
  background-color: #fff;
  z-index: 1000;
  overflow-y: scroll;
}
</style>
