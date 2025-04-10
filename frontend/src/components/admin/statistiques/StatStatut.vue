<template>
  <div class="stat-statut">
    <h2>Nombre de Prospects par Statut</h2>
    <div class="chart-container">
      <canvas id="statutChart"></canvas>
    </div>
  </div>
</template>

<script setup>
import { ref, computed, onMounted } from 'vue'
import { Chart } from 'chart.js/auto'

// Stocke les inscriptions (ou prospects) récupérées depuis l'API
const inscriptions = ref([])

// Fonction pour récupérer les inscriptions via l'API
async function fetchInscriptions() {
  try {
    const response = await fetch('/api/inscriptions')
    if (!response.ok) {
      throw new Error(`HTTP error: ${response.status}`)
    }
    // On attend ici que l'API renvoie un tableau d'objets comportant la propriété "statut"
    inscriptions.value = await response.json()
  } catch (err) {
    console.error("Erreur lors de la récupération des inscriptions:", err)
  }
}

// Calcule le nombre de prospects par statut
const statutCounts = computed(() => {
  const counts = {}
  inscriptions.value.forEach(inscription => {
    // On vérifie que la propriété "statut" est définie
    if (inscription.statut !== undefined && inscription.statut !== null) {
      counts[inscription.statut] = (counts[inscription.statut] || 0) + 1
    }
  })
  return counts
})

onMounted(async () => {
  await fetchInscriptions()

  // Récupère le contexte du canvas du graphique
  const ctx = document.getElementById('statutChart').getContext('2d')
  const dataCounts = statutCounts.value

  // Prépare les labels et valeurs
  const labels = Object.keys(dataCounts)
  const values = labels.map(label => dataCounts[label])

  // Création du graphique en barres
  new Chart(ctx, {
    type: 'bar',
    data: {
      labels: labels,
      datasets: [{
        label: 'Nombre de prospects par statut',
        data: values,
        backgroundColor: '#9059a0', // Couleur d'arrière-plan pour les barres
        borderColor: '#9059a0',
        borderWidth: 1,
      }]
    },
    options: {
      responsive: true,
      scales: {
        y: {
          beginAtZero: true,
        }
      },
      plugins: {
        legend: {
          display: false // On masque la légende si non nécessaire
        },
        tooltip: {
          enabled: true,
        },
      }
    }
  })
})
</script>

<style scoped>
@import url('https://fonts.googleapis.com/css2?family=Plus+Jakarta+Sans:wght@400;500;700&display=swap');

.stat-statut {
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
