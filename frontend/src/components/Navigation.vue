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

    <!-- Liste des villes pour l'année sélectionnée -->
    <div v-if="cities.length">
      <h3>Villes pour l'année {{ selectedAnnee }}</h3>
      <ul>
        <li v-for="city in cities" :key="city">
          <button @click="selectCity(city)">{{ city }}</button>
        </li>
      </ul>
    </div>

    <!-- Liste des salons pour la ville sélectionnée -->
    <div v-if="salons.length">
      <h3>Salons pour la ville {{ selectedCity }}</h3>
      <ul>
        <li v-for="salon in salons" :key="salon.id">
          <button @click="selectSalon(salon)">{{ salon.nom }}</button>
          <!-- Bouton de suppression avec l'emoji poubelle -->
          <button class="delete-btn" @click="deleteSalon(salon)">🗑️</button>
        </li>
      </ul>
    </div>
  </div>
</template>

<script setup>
import { ref, onMounted } from 'vue';

// Déclaration des variables réactives
const annees = ref([]);
const cities = ref([]);
const salons = ref([]);
const selectedAnnee = ref(null);
const selectedCity = ref(null);
const url = "/api/navigation/annees";

// Récupération des années via fetch
const fetchAnnees = async () => {
  try {
    const response = await fetch(`${url}`);
    const data = await response.json();
    annees.value = data;
    console.log("Années :", annees.value);
  } catch (error) {
    console.error("Erreur lors du chargement des années :", error);
  }
};

// Sélection d'une année et récupération des villes correspondantes
const selectAnnee = async (annee) => {
  selectedAnnee.value = annee;
  selectedCity.value = null;
  salons.value = []; // Réinitialisation des salons lors du changement d'année
  try {
    const response = await fetch(`${url}/${annee}/villes`);
    const data = await response.json();
    cities.value = data;
    console.log("Villes :", cities.value);
  } catch (error) {
    console.error(`Erreur lors de la récupération des villes pour l'année ${annee} :`, error);
  }
};

// Sélection d'une ville et récupération des salons correspondants
const selectCity = async (city) => {
  selectedCity.value = city;
  try {
    const response = await fetch(`${url}/${selectedAnnee.value}/villes/${city}/salons`);
    const data = await response.json();
    salons.value = data;
    console.log("Salons :", salons.value);
  } catch (error) {
    console.error(`Erreur lors de la récupération des salons pour la ville ${city} :`, error);
  }
};

// Action lors du clic sur un salon (exemple, affiche en console)
const selectSalon = (salon) => {
  console.log("Salon sélectionné :", salon);
  // Ajoute ici la logique souhaitée, comme rediriger vers une page de détails
};

// Méthode pour supprimer un salon et actualiser la page
const deleteSalon = async (salon) => {
  if (confirm(`Confirmez-vous la suppression du salon "${salon.nom}" ?`)) {
    try {
      const response = await fetch(`/api/salons/${salon.id}`, {
        method: 'DELETE'
      });
      if (!response.ok) {
        throw new Error(`Erreur lors de la suppression : ${response.statusText}`);
      }
      console.log("Salon supprimé :", salon);

      // Recharger la page après la suppression
      window.location.reload();
    } catch (error) {
      console.error("Erreur lors de la suppression du salon :", error);
    }
  }
};

onMounted(fetchAnnees);
</script>

<style scoped>
.navigation {
  padding: 1rem;
  background-color: #FFFFFF;
  color: black;
}

button {
  margin: 0.3rem;
  padding: 0.5rem 1rem;
}

.delete-btn {
  background-color: red;
  color: white;
  border: none;
  cursor: pointer;
}
</style>
