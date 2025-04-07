<template>
  <div class="navigation">
    <h2>Veuillez choisir un événement</h2>

    <!-- Arborescence Année > Ville > Salon -->
    <ul>
      <li v-for="annee in annees" :key="annee">
        <button @click="toggleAnnee(annee)">
          {{ openedAnnees.has(annee) ? '📂' : '📁' }} {{ annee }}
        </button>

        <!-- Villes pour l'année -->
        <ul v-if="openedAnnees.has(annee)">
          <li v-for="city in citiesByAnnee[annee] || []" :key="city">
            <button @click="toggleCity(annee, city)">
              {{ isCityOpen(annee, city) ? '📂' : '📁' }} {{ city }}
            </button>

            <!-- Salons pour la ville -->
            <ul v-if="isCityOpen(annee, city)">
              <li v-for="salon in salonsByCity[`${annee}-${city}`] || []" :key="salon.id">
                <button @click="chooseSalon(salon)">
                  {{ salon.nom }}
                </button>
                <button class="delete-btn" @click="deleteSalon(salon)">🗑️</button>
              </li>
            </ul>
          </li>
        </ul>
      </li>
    </ul>
  </div>
</template>

<script setup>
import { ref, onMounted } from 'vue'

const emit = defineEmits(['salon-chosen'])

const annees = ref([])
const citiesByAnnee = ref({})
const salonsByCity = ref({})

const openedAnnees = ref(new Set())
const openedCities = ref(new Set())

const url = "/api/navigation/annees"

onMounted(fetchAnnees)

async function fetchAnnees() {
  try {
    const response = await fetch(url)
    annees.value = await response.json()
  } catch (error) {
    console.error("Erreur fetch annees:", error)
  }
}

function toggleAnnee(annee) {
  if (openedAnnees.value.has(annee)) {
    openedAnnees.value.delete(annee)
  } else {
    openedAnnees.value.add(annee)
    fetchCities(annee)
  }
}

function toggleCity(annee, city) {
  const key = `${annee}-${city}`
  if (openedCities.value.has(key)) {
    openedCities.value.delete(key)
  } else {
    openedCities.value.add(key)
    fetchSalons(annee, city)
  }
}

function isCityOpen(annee, city) {
  return openedCities.value.has(`${annee}-${city}`)
}

async function fetchCities(annee) {
  try {
    const response = await fetch(`${url}/${annee}/villes`)
    const data = await response.json()
    citiesByAnnee.value[annee] = data
  } catch (error) {
    console.error("Erreur fetch villes:", error)
  }
}

async function fetchSalons(annee, city) {
  try {
    const response = await fetch(`${url}/${annee}/villes/${city}/salons`)
    const data = await response.json()
    salonsByCity.value[`${annee}-${city}`] = data
  } catch (error) {
    console.error("Erreur fetch salons:", error)
  }
}

function chooseSalon(salon) {
  emit('salon-chosen', salon)
}

async function deleteSalon(salon) {
  if (confirm(`Supprimer le salon "${salon.nom}" ?`)) {
    try {
      const response = await fetch(`/api/salons/${salon.id}`, {
        method: 'DELETE'
      })
      if (!response.ok) throw new Error("Suppression échouée")
      await fetchSalons(salon.annee, salon.ville) // Recharge les salons
    } catch (error) {
      console.error("Erreur suppression salon:", error)
    }
  }
}
</script>

<style scoped>
.navigation {
  padding: 1rem;
  background-color: #ffffff;
  color: black;
  font-family: 'Plus Jakarta Sans', sans-serif;
}

ul {
  list-style: none;
  padding-left: 1rem;
}

ul ul {
  border-left: 2px solid #ccc;
  margin-left: 0.5rem;
  padding-left: 0.5rem;
}

button {
  margin: 0.3rem;
  padding: 0.5rem 1rem;
  font-family: 'Plus Jakarta Sans', sans-serif;
  background-color: #f0f0f0;
  border: none;
  cursor: pointer;
  border-radius: 5px;
}

button:hover {
  background-color: #ddd;
}

.delete-btn {
  background-color: white;
  color: white;
  border: none;
  cursor: pointer;
  font-family: 'Plus Jakarta Sans', sans-serif;
  border-radius: 10%;
}

.delete-btn:hover {
  background-color: #ED6962;
  transform: scale(1.05);
}
</style>
