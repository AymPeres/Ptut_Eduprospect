<template>
  <form class="questionnaire" @submit.prevent="validerEtSoumettre">
    <label for="sexe">Vous êtes :</label>
    <select id="sexe" v-model="inscriptionData.sexe" required>
      <option value="" disabled selected>Sélectionnez votre genre</option>
      <option value="homme">Homme</option>
      <option value="femme">Femme</option>
      <option value="autre">Autre</option>
    </select>

    <label for="interet">Vous êtes intéressé par :</label>
    <select id="interet" v-model="inscriptionData.interet" required>
      <option value="" disabled selected>Sélectionnez un intérêt</option>
      <option value="cycle-prepa">Cycle préparatoire</option>
      <option value="cycle-ingenieur">Cycle ingénieur</option>
    </select>

    <label for="statut">Sous statut :</label>
    <select id="statut" v-model="inscriptionData.statut" required>
      <option value="" disabled selected>Sélectionnez votre statut</option>
      <option value="apprenti">Apprenti</option>
      <option value="etudiant">Étudiant</option>
    </select>

    <label for="origineContact">Comment nous avez-vous connus ?</label>
    <select id="origineContact" v-model="inscriptionData.origineContact" required>
      <option value="" disabled selected>Sélectionnez une option</option>
      <option value="forum">Forum/Salon</option>
      <option value="reseaux">Réseaux sociaux</option>
      <option value="bouche">Bouche à oreille</option>
      <option value="site">Site Web</option> <!-- correction ici -->
      <option value="autre">Autre</option>
    </select>


    <div class="buttons-container">
      <button type="button" class="back-button" @click="$emit('go-back')">
        Retour
      </button>
      <button type="button" class="submit-button" @click="validerEtSoumettre">
        Envoyer
      </button>
    </div>
  </form>
</template>

<script setup>
import { defineProps, defineEmits, onMounted, onUnmounted } from 'vue';

const props = defineProps({
  inscriptionData: {
    type: Object,
    required: true
  }
});

const emit = defineEmits(['go-back', 'submit']);

function validerEtSoumettre() {
  emit('submit');
}

// Intercepter le clic sur le bouton retour du navigateur
function handlePopState() {
  const pwd = prompt("Entrez le mot de passe pour quitter cette page :");
  if (pwd === "1234") {
    window.removeEventListener("popstate", handlePopState);
    history.back();
  } else {
    // Bloquer la navigation arrière
    history.pushState(null, document.title, location.href);
  }
}

onMounted(() => {
  // Ajoute un nouvel état dans l'historique pour pouvoir intercepter le retour
  history.pushState(null, document.title, location.href);
  window.addEventListener("popstate", handlePopState);
});

onUnmounted(() => {
  window.removeEventListener("popstate", handlePopState);
});
</script>

<style scoped>
.questionnaire {
  display: flex;
  flex-direction: column;
  gap: 1rem;
}

label {
  font-size: 1rem;
  font-weight: bold;
}

select {
  width: 100%;
  padding: 0.6rem;
  border: 1px solid #ddd;
  border-radius: 5px;
  font-size: 1rem;
}

.buttons-container {
  display: flex;
  justify-content: space-between;
}

.back-button {
  padding: 0.8rem 1.5rem;
  background-color: #f0f0f0;
  border: 1px solid #ddd;
  border-radius: 5px;
  font-size: 1rem;
  cursor: pointer;
}

.back-button:hover {
  background-color: #e3e3e3;
}

.submit-button {
  padding: 0.8rem 1.5rem;
  background-color: #FA7268;
  border: none;
  color: white;
  font-size: 1.1rem;
  font-weight: bold;
  border-radius: 5px;
  cursor: pointer;
}

.submit-button:hover {
  background-color: #d95a50;
}
</style>
