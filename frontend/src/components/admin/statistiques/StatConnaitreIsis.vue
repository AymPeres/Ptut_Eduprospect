<template>
  <div class="stat-connaitre-isis">
    <h2>Connaître Isis</h2>
    <div class="chart-container">
      <canvas id="connaitreIsisChart"></canvas>
    </div>
  </div>
</template>

<script setup>
import { ref, computed, onMounted } from 'vue'
import { Chart } from 'chart.js/auto'

// Référence pour les inscriptions et l'instance du graphique
const inscriptions = ref([])
let chartInstance = null

// Fonction pour récupérer les inscriptions via l'API
async function fetchInscriptions() {
  try {
    const response = await fetch('/api/inscriptions')
    if (!response.ok) {
      throw new Error(`HTTP error: ${response.status}`)
    }
    inscriptions.value = await response.json()
  } catch (err) {
    console.error("Erreur lors de la récupération des inscriptions:", err)
  }
}

// Mapping entre les valeurs et les labels affichés
const valueToLabelMap = {
  'forum': 'Salons',
  'reseaux': 'Réseaux sociaux',
  'bouche': 'Bouche à oreille',
  'site': 'Site web',
  'Professeur': 'Autre',
  'autre': 'Autre'
}


// Calcul réactif des comptes par mode de connaissance
const modeConnaissanceCounts = computed(() => {
  const counts = {
    'Bouche à oreille': 0,
    'Site web': 0,
    'Réseaux sociaux': 0,
    'Salons': 0,
    'Autre': 0
  }
  inscriptions.value.forEach((inscription) => {
    const origineValue = inscription.origineContact || 'autre'
    const label = valueToLabelMap[origineValue] || 'Autre'
    counts[label]++
  })
  return counts
})

// Fonction qui rafraîchit le graphique
async function updateChart() {
  await fetchInscriptions()
  const labels = Object.keys(modeConnaissanceCounts.value)
  const data = labels.map(label => modeConnaissanceCounts.value[label])

  // Couleurs définies pour chaque segment
  const backgroundColor = [
    '#9059a0', // Bouche à oreille
    '#ed6962', // Site web
    '#2f2769', // Réseaux sociaux
    '#5f4e9b', // Salons
    '#9C27B0'  // Autre

  ]

  const ctx = document.getElementById('connaitreIsisChart').getContext('2d')

  if (chartInstance) {
    chartInstance.destroy()
  }

  chartInstance = new Chart(ctx, {
    type: 'pie',
    data: {
      labels: labels,
      datasets: [
        {
          label: 'Nombre de prospects par mode de connaissance',
          data: data,
          backgroundColor: backgroundColor,
          borderWidth: 1,
        },
      ],
    },
    options: {
      responsive: true,
      plugins: {
        legend: {
          position: 'top',
        },
        tooltip: {
          enabled: true,
          callbacks: {
            label: function(context) {
              const label = context.label || ''
              const value = context.raw || 0
              const total = context.dataset.data.reduce((acc, val) => acc + val, 0)
              const percentage = Math.round((value / total) * 100)
              return `${label}: ${value} (${percentage}%)`
            }
          }
        },
      },
    },
  })
}

onMounted(async () => {
  await updateChart()
})

defineExpose({ updateChart })
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

.chart-container {
  width: 100%;
  margin: 0 auto;
  padding: 20px;
  background-color: #FFFFFF;
}
</style>
