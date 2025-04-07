<template>
  <div class="footer-gestion">
    <div class="logo">
      <img src="@/assets/images/logoIsis/logo-ISIS-horizontal-RVB.png" alt="Logo de l'école" />
    </div>
    <div class="content">
      <p>Espace administrateur</p>
    </div>
    <!-- Affichage de la navigation avec propagation de l'événement -->
    <Navigation @salon-chosen="handleSalonChosen" />

    <!-- Bouton pour afficher/cacher le formulaire d'ajout -->
    <button class="toggle-add-salon" @click="toggleAddSalon">
      Ajouter un salon
    </button>

    <!-- Composant AddSalon affiché conditionnellement -->
    <AddSalon v-if="showAddSalon" />
  </div>
</template>

<script setup>
import { ref } from 'vue'
import Navigation from '@/components/Navigation.vue'
import AddSalon from '@/components/AddSalon.vue'

// On définit l'émission de l'événement "salon-chosen" pour le parent
const emit = defineEmits(['salon-chosen'])

// Variable réactive pour contrôler l'affichage du formulaire d'ajout
const showAddSalon = ref(false)

// Fonction pour basculer la visibilité du formulaire d'ajout
function toggleAddSalon() {
  showAddSalon.value = !showAddSalon.value
}

// Fonction qui reçoit l'événement "salon-chosen" de Navigation et le transmet
function handleSalonChosen(salon) {
  emit('salon-chosen', salon)
}
</script>

<style scoped>
.footer-gestion {
  position: relative;
  top: 0;
  left: 0;
  width: 350px;
  min-height: 100vh; /* La sidebar s'étend sur toute la hauteur */
  background-color: white;
  display: flex;
  flex-direction: column;
  align-items: center;
}
/* Sidebar fixe */

.logo img {
  width: 150px; /* Taille du logo */
  height: auto;
}

.content {
  color: #333;
  font-size: 0.9rem;
  margin-top: 20px;
  text-align: center;
  margin-bottom: 30px;
}

.toggle-add-salon {
  margin-bottom: 20px;
  padding: 0.5rem 1rem;
  cursor: pointer;
  background-color: #ED6962;
  color: #fff;
  border: none;
  border-radius: 4px;

}
</style>
