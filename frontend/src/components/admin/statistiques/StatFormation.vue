<template>
  <div class="stat-formation">
    <h2>Statistiques par Formation</h2>
    <canvas id="formationChart"></canvas>
  </div>
</template>

<script>
import { ref, onMounted } from "vue";
import { Chart } from "chart.js/auto";
import prospects from "/src/assets/prospectsData.js"; // Le fichier des prospects

export default {
  name: "StatFormation",
  setup() {
    const formations = ["Terminale", "Première", "Réorientation", "BTS", "Médecine", "BUT"];

    // Compter le nombre de prospects par formation
    const countProspectsByFormation = () => {
      const formationCounts = formations.reduce((acc, formation) => {
        acc[formation] = 0;
        return acc;
      }, {});

      prospects.forEach(prospect => {
        formationCounts[prospect.formation]++;
      });

      return formationCounts;
    };

    const formationCounts = countProspectsByFormation();

    const colors = [
      "#8E24AA", // Couleur pour "Terminale" (violet foncé)
      "#6e7ac8", // Couleur pour "Première" (bleu foncé)
      "#ED6962", // Couleur pour "Réorientation" (corail)
      "#1565C0", // Couleur pour "BTS" (bleu moyen)
      "#db6eed", // Couleur pour "Médecine" (violet moyen)
      "#00BCD4", // Couleur pour "BUT" (bleu turquoise)
    ];

    // Création du graphique
    onMounted(() => {
      const ctx = document.getElementById("formationChart").getContext("2d");
      new Chart(ctx, {
        type: "pie",
        data: {
          labels: formations,
          datasets: [{
            label: 'Nombre de prospects par formation',
            data: formations.map(formation => formationCounts[formation]),
            backgroundColor: colors, // Appliquer les couleurs adaptées
            borderWidth: 1,
          }]
        },
        options: {
          responsive: true,
        }
      });
    });

    return {};
  }
};
</script>

<style scoped>
.stat-formation {
  width: 100%;
  max-width: 600px;
  margin: 0 auto;
  padding: 20px;
  text-align: center;
}

h2 {
  color: #333;
}
</style>
