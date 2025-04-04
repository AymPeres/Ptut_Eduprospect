<template>
  <div class="navigation">
    <h2>Veuillez choisir un événement</h2>

    <!-- Liste des années -->
    <div>
      <h3>Années</h3>
      <ul>
        <li v-for="annee in annees" :key="annee">
          <button @click="selectAnnee(annee)">{{ annee }}</button>
        </li>
      </ul>
    </div>

    <!-- Liste des villes -->
    <div v-if="cities.length">
      <h3>Villes pour l'année {{ selectedAnnee }}</h3>
      <ul>
        <li v-for="city in cities" :key="city">
          <button @click="selectCity(city)">{{ city }}</button>
        </li>
      </ul>
    </div>

    <!-- Liste des salons -->
    <div v-if="salons.length">
      <h3>Salons pour la ville {{ selectedCity }}</h3>
      <ul>
        <li v-for="salon in salons" :key="salon.id">
          <button @click="chooseSalon(salon)">{{ salon.nom }}</button>
          <button class="delete-btn" @click="deleteSalon(salon)">🗑️</button>
        </li>
      </ul>
    </div>
  </div>
</template>

<script setup>
import { ref, onMounted } from 'vue'

// On définit l’événement qu’on va émettre vers FooterGestion
const emit = defineEmits(['salon-chosen'])

const annees = ref([])
const cities = ref([])
const salons = ref([])
const selectedAnnee = ref(null)
const selectedCity = ref(null)
const url = "/api/navigation/annees"

onMounted(fetchAnnees)

async function fetchAnnees() {
  try {
    const response = await fetch(`${url}`)
    const data = await response.json()
    annees.value = data
  } catch (error) {
    console.error("Erreur fetch annees:", error)
  }
}

async function selectAnnee(annee) {
  selectedAnnee.value = annee
  selectedCity.value = null
  salons.value = []
  try {
    const response = await fetch(`${url}/${annee}/villes`)
    const data = await response.json()
    cities.value = data
  } catch (error) {
    console.error("Erreur fetch villes:", error)
  }
}

async function selectCity(city) {
  selectedCity.value = city
  try {
    const response = await fetch(`${url}/${selectedAnnee.value}/villes/${city}/salons`)
    const data = await response.json()
    salons.value = data
  } catch (error) {
    console.error("Erreur fetch salons:", error)
  }
}

function chooseSalon(salon) {
  // On émet l’événement "salon-chosen" vers FooterGestion,
  // en lui passant l’objet salon (avec id, nom, etc.)
  emit('salon-chosen', salon)
}

async function deleteSalon(salon) {
  if (confirm(`Supprimer le salon "${salon.nom}" ?`)) {
    try {
      const response = await fetch(`/api/salons/${salon.id}`, { method: 'DELETE' })
      if (!response.ok) {
        throw new Error(`Erreur: ${response.statusText}`)
      }
      // Après suppression, on recharge la liste des salons
      await selectCity(selectedCity.value)
    } catch (error) {
      console.error("Erreur lors de la suppression du salon :", error)
    }
  }
}
</script>

<style scoped>
.navigation {
  padding: 1rem;
  background-color: #FFFFFF;
  color: black;
  font-family: 'Plus Jakarta Sans', sans-serif;
}

button {
  margin: 0.3rem;
  padding: 0.5rem 1rem;
  font-family: 'Plus Jakarta Sans', sans-serif;
}

.delete-btn {
  background-color: red;
  color: white;
  border: none;
  cursor: pointer;
  font-family: 'Plus Jakarta Sans', sans-serif;
}
</style>
