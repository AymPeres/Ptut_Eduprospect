<template>
  <div class="stat-connaitre-isis">
    <h2>Connaître Isis</h2>
    <div class="chart-container">
      <canvas id="connaitreIsisChart"></canvas>
    </div>
  </div>
</template>

<script>
import { ref, onMounted } from 'vue';
import { Chart } from 'chart.js/auto';
import prospects from '/src/assets/prospectsData.js'; // Importation des prospects

export default {
  name: 'StatConnaitreIsis',
  setup() {
    // Comptabilisation du nombre de prospects par mode de connaissance
    const countProspectsByModeConnaissance = () => {
      const modeCounts = {
        'Bouche à oreille': 0,
        'Site web': 0,
        'Réseaux sociaux': 0,
        'Salons': 0,
        'Professeurs': 0,
      };

      prospects.forEach((prospect) => {
        modeCounts[prospect.connaissance_ecole]++;
      });

      return modeCounts;
    };

    const modeCounts = countProspectsByModeConnaissance();

    // Données du graphique
    const data = {
      labels: ['Bouche à oreille', 'Site web', 'Réseaux sociaux', 'Salons', 'Professeurs'],
      datasets: [
        {
          label: 'Nombre de prospects par mode de connaissance',
          data: [
            modeCounts['Bouche à oreille'],
            modeCounts['Site web'],
            modeCounts['Réseaux sociaux'],
            modeCounts['Salons'],
            modeCounts['Professeurs'],
          ],
          backgroundColor: ['#FF5733', '#33FF57', '#3357FF', '#F4C342', '#9C27B0'],
          borderWidth: 1,
        },
      ],
    };

    // Création du graphique à l'initialisation
    onMounted(() => {
      const ctx = document.getElementById('connaitreIsisChart').getContext('2d');
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

.stat-connaitre-isis {
  font-family: "Plus Jakarta Sans", sans-serif;
  color: #181818;
  width: 100%;
  max-width: 600px;
  margin: 0 auto;
  padding: 20px;
  text-align: center;
}



</style>
