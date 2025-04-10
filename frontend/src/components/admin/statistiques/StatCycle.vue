<template>
  <div class="stat-interet">
    <h2>Répartition par Intérêt</h2>
    <div class="chart-container">
      <canvas id="interetChart"></canvas>
    </div>
  </div>
</template>

<script setup>
import { ref, computed, onMounted } from 'vue'
import { Chart } from 'chart.js/auto'

// Stocke les inscriptions récupérées depuis le backend
const inscriptions = ref([])

// Fonction pour récupérer les inscriptions via l'API
async function fetchInscriptions() {
  try {
    const response = await fetch('/api/inscriptions')
    if (!response.ok) {
      throw new Error(`HTTP error: ${response.status}`)
    }
    // On s'attend ici à ce que chaque inscription possède la propriété "interet"
    inscriptions.value = await response.json()
  } catch (err) {
    console.error("Erreur lors de la récupération des inscriptions:", err)
  }
}

// Calcule le nombre d'inscriptions par intérêt
const interestCounts = computed(() => {
  // On attend deux valeurs : 'cycle-prepa' et 'cycle-ingenieur'
  const counts = {
    'cycle-prepa': 0,
    'Cycle ingénieur': 0
  }
  inscriptions.value.forEach((inscription) => {
    if (inscription.interet === 'cycle-prepa') counts['cycle-prepa']++
    else if (inscription.interet === 'Cycle ingénieur') counts['Cycle ingénieur']++
  })
  return counts
})

onMounted(async () => {
  // Récupère d'abord les inscriptions
  await fetchInscriptions()

  // Création du graphique une fois les données chargées
  const ctx = document.getElementById('interetChart').getContext('2d')
  new Chart(ctx, {
    type: 'pie',
    data: {
      labels: ['Cycle préparatoire', 'Cycle ingénieur'],
      datasets: [
        {
          label: 'Répartition par Intérêt',
          data: [
            interestCounts.value['cycle-prepa'],
            interestCounts.value['Cycle ingénieur']
          ],
          backgroundColor: ['#3498db', '#e74c3c'], // Ajuste les couleurs si besoin
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
        },
      },
    },
  })
})
</script>

<style scoped>
@import url('https://fonts.googleapis.com/css2?family=Plus+Jakarta+Sans:wght@400;500;700&display=swap');

.stat-interet {
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
