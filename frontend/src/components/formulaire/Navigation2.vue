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
                <button @click="selectSalon(salon)">
                  {{ salon.nom }}
                </button>
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
import { useRouter } from 'vue-router'

const router = useRouter()

const url = "/api/navigation/annees"
const annees = ref([])
const citiesByAnnee = ref({})
const salonsByCity = ref({})
const openedAnnees = ref(new Set())
const openedCities = ref(new Set())

onMounted(fetchAnnees)

async function fetchAnnees() {
  try {
    const res = await fetch(url)
    annees.value = await res.json()
  } catch (error) {
    console.error("Erreur fetch annees :", error)
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
    const res = await fetch(`${url}/${annee}/villes`)
    const data = await res.json()
    citiesByAnnee.value[annee] = data
  } catch (error) {
    console.error("Erreur fetch villes :", error)
  }
}

async function fetchSalons(annee, city) {
  try {
    const res = await fetch(`${url}/${annee}/villes/${city}/salons`)
    const data = await res.json()
    salonsByCity.value[`${annee}-${city}`] = data
  } catch (error) {
    console.error("Erreur fetch salons :", error)
  }
}

function selectSalon(salon) {
  router.push(`/${salon.nom}`)
}
</script>

<style scoped>
@import url('https://fonts.googleapis.com/css2?family=Plus+Jakarta+Sans:wght@400;500;700&display=swap');

.navigation {
  padding: 1rem;
  background-color: white;
  color: black;
  font-family: 'Plus Jakarta Sans', sans-serif;
  border-radius: 10px;
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
</style>
