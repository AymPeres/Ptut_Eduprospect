<template>
  <div class="stat-formation">
    <h2>Statistiques par Formation</h2>
    <div class="chart-container">
      <canvas id="formationChart"></canvas>
    </div>
  </div>
</template>

<script setup>
import { ref, computed, onMounted } from 'vue'
import { Chart } from 'chart.js/auto'

const inscriptions = ref([])

// Fonction pour récupérer les inscriptions via l'API
async function fetchInscriptions() {
  try {
    const response = await fetch('/api/inscriptions')
    if (!response.ok) {
      throw new Error(`HTTP error: ${response.status}`)
    }
    // L'API doit renvoyer un tableau d'objets comportant la propriété "formation"
    inscriptions.value = await response.json()
  } catch (err) {
    console.error("Erreur lors de la récupération des inscriptions:", err)
  }
}

// Calcule le nombre d'inscriptions par formation
const formationCounts = computed(() => {
  const counts = {}
  inscriptions.value.forEach(inscription => {
    if (inscription.formation) {
      // On retire les espaces en début et fin
      const formation = inscription.formation.trim()
      if (formation) {
        counts[formation] = (counts[formation] || 0) + 1
      }
    }
  })
  return counts
})

// Fonction pour générer une couleur hexadécimale aléatoire
function getRandomColor() {
  return '#' + Math.floor(Math.random()*16777215).toString(16).padStart(6, '0')
}

onMounted(async () => {
  await fetchInscriptions();

  const counts = formationCounts.value;
  const labels = Object.keys(counts);
  const values = labels.map(label => counts[label]);

  // Palette de base (peut être agrandie selon vos besoins)
  const baseColors = [
    '#ED6962', // Corail chaud (similaire à la première barre)

    '#9059A0', // Violet moyen (similaire à la deuxième barre)
    '#5F4E9B', // Violet profond (similaire à la troisième barre)
    '#2F2769', // Violet très sombre (similaire à la quatrième barre)
    // Varier autour du corail/rose

    '#1F1A43', // Ton plus clair, pratique pour les hover
    // Varier autour du violet moyen
    '#A77ABF', // Violet clair, pastel
    '#7B4791', // Violet foncé, plus neutre
    // Varier autour du violet profond
    '#3E3378', // Violet sombre, légèrement plus bleuté
      // Presque un violet noir, pour du texte très contrasté
  ];

  // Créer une palette étendue avec des nuances
  const extendedColors = [];
  baseColors.forEach(color => {
    // Couleur originale
    extendedColors.push(color);

    // Version plus claire (ajouter transparence)
    extendedColors.push(color + '99'); // 60% d'opacité

    // Version encore plus claire
    extendedColors.push(color + '66'); // 40% d'opacité
  });

  // Assigner les couleurs aux formations
  const colors = labels.map((_, index) => extendedColors[index % extendedColors.length]);

  const ctx = document.getElementById('formationChart').getContext('2d');
  // reste du code comme avant
  new Chart(ctx, {
    type: 'pie',
    data: {
      labels: labels,
      datasets: [{
        label: 'Nombre d\'inscriptions par formation',
        data: values,
        backgroundColor: colors,
        borderWidth: 1,
      }]
    },
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
    }
  });
});
</script>

<style scoped>
@import url('https://fonts.googleapis.com/css2?family=Plus+Jakarta+Sans:wght@400;500;700&display=swap');

.stat-formation {
  font-family: "Plus Jakarta Sans", sans-serif;
  color: #181818;
  width: 100%;
  max-width: 600px;
  margin: 0 auto;
  padding: 20px;
  text-align: center;
}

.chart-container {
  width: 100%;
  margin: 0 auto;
  padding: 20px;
  background-color: #FFFFFF;
}
</style>
