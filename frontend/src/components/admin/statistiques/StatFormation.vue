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

// Variable réactive pour stocker les inscriptions récupérées depuis l'API
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

// Calcule le nombre d'inscriptions par formation de manière dynamique
const formationCounts = computed(() => {
  const counts = {}
  inscriptions.value.forEach(inscription => {
    // On vérifie que l'attribut "formation" existe et n'est pas vide
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
  // Récupère les inscriptions avant de créer le graphique
  await fetchInscriptions()

  // Prépare les labels et valeurs à partir des résultats du comptage
  const counts = formationCounts.value
  const labels = Object.keys(counts)
  const values = labels.map(label => counts[label])

  // Pour chaque label, on génère une couleur aléatoire
  const colors = labels.map(() => getRandomColor())

  // Crée le graphique en secteur (pie chart)
  const ctx = document.getElementById('formationChart').getContext('2d')
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
  })
})
</script>

<style scoped>
@import url('https://fonts.googleapis.com/css2?family=Plus+Jakarta+Sans:wght@400;500;700&display=swap');

.stat-formation {
  font-family: 'Plus Jakarta Sans', sans-serif;
  text-align: center;
  color: #181818;
  margin-top: 20px;
}

.chart-container {
  width: 60%;
  margin: 0 auto;
  padding: 20px;
  background-color: #FFFFFF;
}
</style>
