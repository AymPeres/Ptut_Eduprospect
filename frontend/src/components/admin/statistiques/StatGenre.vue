<template>
  <div class="stat-genre">
    <h2>Répartition des genres des prospects</h2>
    <div class="chart-container">
      <canvas id="genreChart"></canvas>
    </div>
  </div>
</template>

<script setup>
import { ref, computed, onMounted } from 'vue'
import { Chart } from 'chart.js/auto'

// Stocke les inscriptions récupérées du backend
const inscriptions = ref([])

// Fonction pour récupérer les inscriptions depuis l'API
async function fetchInscriptions() {
  try {
    const response = await fetch('/api/inscriptions')
    if (!response.ok) {
      throw new Error(`HTTP error: ${response.status}`)
    }
    // Supposons que l'API renvoie un tableau d'objets avec la propriété "sexe"
    inscriptions.value = await response.json()
  } catch (err) {
    console.error("Erreur lors de la récupération des inscriptions:", err)
  }
}

// Calcule le nombre de prospects par genre
const genreCounts = computed(() => {
  const counts = {
    Homme: 0,
    Femme: 0,
    Autre: 0,
  }
  inscriptions.value.forEach((inscription) => {
    // Normaliser ou adapter selon les valeurs réelles (ex. "homme", "femme", etc.)
    if (inscription.sexe === 'Homme') counts.Homme++
    else if (inscription.sexe === 'Femme') counts.Femme++
    else counts.Autre++
  })
  return counts
})

onMounted(async () => {
  // Récupère d'abord les inscriptions
  await fetchInscriptions()

  // Crée le graphique une fois que les inscriptions sont chargées
  const ctx = document.getElementById('genreChart').getContext('2d')
  new Chart(ctx, {
    type: 'pie',
    data: {
      labels: ['Homme', 'Femme', 'Autre'],
      datasets: [
        {
          label: 'Répartition des genres',
          data: [
            genreCounts.value.Homme,
            genreCounts.value.Femme,
            genreCounts.value.Autre
          ],
          backgroundColor: ['#3498db', '#e74c3c', '#95a5a6'],
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

.stat-genre {
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
