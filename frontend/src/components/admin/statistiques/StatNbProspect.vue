<template>
  <div class="stat-nb-prospect">
    <h2>Nombre de Prospects par Critère</h2>
    <div class="filters">
      <button @click="setCriterion('ville')">Ville</button>
      <button @click="setCriterion('annee')">Année</button>
      <button @click="setCriterion('salon')">Salon</button>
    </div>
    <div class="chart-container">
      <canvas id="nbProspectChart"></canvas>
    </div>
  </div>
</template>

<script setup>
import { ref, onMounted, watch } from 'vue'
import { Chart } from 'chart.js/auto'

// Stocke les inscriptions récupérées depuis l'API
const inscriptions = ref([])
// Critère sélectionné (par défaut "ville")
const selectedCriterion = ref('ville')
// Référence vers le graphique
const chart = ref(null)

// Fonction pour récupérer les inscriptions via l'API
async function fetchInscriptions() {
  try {
    const response = await fetch('/api/inscriptions')
    if (!response.ok) {
      throw new Error(`HTTP error: ${response.status}`)
    }
    inscriptions.value = await response.json()
    console.log("Inscriptions récupérées :", inscriptions.value)
  } catch (error) {
    console.error("Erreur lors de la récupération des inscriptions:", error)
  }
}

// Calcule le nombre de prospects selon le critère choisi
function countProspectsByCriterion(criterion) {
  const counts = {}

  inscriptions.value.forEach(inscription => {
    let key = ''
    if (criterion === 'ville') {
      // Pour le critère "ville", utiliser la propriété `ville` de l'inscription (renseignée par l'étudiant)
      key = inscription.ville ? inscription.ville.trim() : 'Non spécifiée'
    }
    else if (criterion === 'annee') {
      // Pour "annee", on recherche dans l'objet 'salon' le champ 'annee'
      const data = inscription.salon
      if (data && data.annee) {
        key = data.annee.toString()
      } else {
        key = 'Année inconnue'
      }
    }
    else if (criterion === 'salon') {
      // Pour "salon", utiliser par exemple le champ 'nom' dans l'objet 'salon'
      const data = inscription.salon
      if (data && data.nom) {
        key = data.nom.trim()
      } else {
        key = 'Salon non spécifié'
      }
    }

    if (key !== undefined && key !== null && key !== '') {
      counts[key] = (counts[key] || 0) + 1
    }
  })

  console.log(`Comptage pour le critère "${criterion}" :`, counts)
  return counts
}

// Crée ou met à jour le graphique
function updateChart() {
  // Détruire le graphique existant s'il existe déjà
  if (chart.value) {
    chart.value.destroy()
    chart.value = null
  }

  const ctx = document.getElementById("nbProspectChart")?.getContext("2d")
  if (!ctx) {
    console.error("Canvas context not found")
    return
  }

  if (!selectedCriterion.value) {
    console.warn("No criterion selected")
    return
  }

  const data = countProspectsByCriterion(selectedCriterion.value)
  const labels = Object.keys(data)
  const values = labels.map(label => data[label])

  if (labels.length === 0 || values.length === 0) {
    console.warn("No data available for the selected criterion")
    return
  }

  // Définir le libellé approprié selon le critère
  let labelText
  switch(selectedCriterion.value) {
    case 'ville':
      labelText = 'Nombre de prospects par ville'
      break
    case 'annee':
      labelText = 'Nombre de prospects par année'
      break
    case 'salon':
      labelText = 'Nombre de prospects par salon'
      break
    default:
      labelText = `Nombre de prospects par ${selectedCriterion.value}`
  }

  chart.value = new Chart(ctx, {
    type: "bar",
    data: {
      labels: labels,
      datasets: [{
        label: labelText,
        data: values,
        backgroundColor: "#9059a0",
        borderColor: "#9059a0",
        borderWidth: 1,
      }]
    },
    options: {
      responsive: true,
      animation: false,
      scales: {
        y: {
          beginAtZero: true
        }
      },
      plugins: {
        legend: {
          position: 'top'
        },
        tooltip: {
          enabled: true,
        },
      }
    }
  })
  console.log("Graphique mis à jour avec le critère :", selectedCriterion.value)
}

// Met à jour le critère et donc le graphique
function setCriterion(criterion) {
  selectedCriterion.value = criterion
  console.log("Critère sélectionné :", criterion)
}

onMounted(async () => {
  await fetchInscriptions()
  updateChart()
})

// Met à jour le graphique dès que le critère change
watch(selectedCriterion, () => {
  updateChart()
})
</script>

<style scoped>
@import url("https://fonts.googleapis.com/css2?family=Plus+Jakarta+Sans:wght@400;700&display=swap");

.stat-nb-prospect {
  font-family: 'Plus Jakarta Sans', sans-serif;
  text-align: center;
  color: #181818;
  margin-top: 20px;
}

.filters {
  display: flex;
  gap: 10px;
  justify-content: center;
  margin-bottom: 20px;
}

.filters button {
  background-color: #f1645d;
  color: white;
  border: none;
  padding: 10px 20px;
  border-radius: 5px;
  cursor: pointer;
  transition: background-color 0.3s;
}

.filters button:hover {
  background-color: #d14a44;
}

.chart-container {
  width: 60%;
  margin: 0 auto;
  padding: 20px;
  background-color: #FFFFFF;
}
</style>
