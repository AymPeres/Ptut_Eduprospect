<template>
  <div class="stat-genre">
    <h2>Répartition des genres des prospects</h2>
    <div class="chart-container">
      <canvas id="genreChart"></canvas>
    </div>
  </div>
</template>

<script>
import { ref, onMounted } from 'vue';
import { Chart } from 'chart.js/auto';
import prospects from '/src/assets/prospectsData.js'; // Importation des prospects

export default {
  name: 'StatGenre',
  setup() {
    // Comptabilisation du nombre de prospects par genre
    const countProspectsByGenre = () => {
      const genreCounts = {
        'Homme': 0,
        'Femme': 0,
        'Non spécifié': 0,
      };

      prospects.forEach((prospect) => {
        genreCounts[prospect.genre]++;
      });

      return genreCounts;
    };

    const genreCounts = countProspectsByGenre();

    // Données pour le graphique
    const data = {
      labels: ['Homme', 'Femme', 'Non spécifié'],
      datasets: [
        {
          label: 'Répartition des genres des prospects',
          data: [
            genreCounts['Homme'],
            genreCounts['Femme'],
            genreCounts['Non spécifié'],
          ],
          backgroundColor: ['#3498db', '#e74c3c', '#95a5a6'],
          borderWidth: 1,
        },
      ],
    };

    // Création du graphique à l'initialisation
    onMounted(() => {
      const ctx = document.getElementById('genreChart').getContext('2d');
      new Chart(ctx, {
        type: 'pie',
        data: data,
        options: {
          responsive: true,
          plugins: {
            legend: {
              position: 'top',
            },
            tooltip: {
              enabled: true,
            },
          },
        },
      });
    });

    return {};
  },
};
</script>

<style scoped>
@import url("https://fonts.googleapis.com/css2?family=Plus+Jakarta+Sans:wght@400;700&display=swap");

.stat-genre h2 {
  font-family: "Plus Jakarta Sans", sans-serif;
  color: #181818;
  text-align: center;
  font-size: 1.5rem;
  margin-bottom: 20px;
}

.chart-container {
  width: 60%;
  margin: 0 auto;
  background-color: #FFFFFF;
  padding: 20px;
}
</style>
