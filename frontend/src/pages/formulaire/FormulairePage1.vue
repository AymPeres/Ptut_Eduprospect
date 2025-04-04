<template>
  <form>
    <div class="input-group">
      <label for="nom">Nom :</label>
      <input id="nom" type="text" v-model="localData.nom" required />
    </div>

    <div class="input-group">
      <label for="prenom">Prénom :</label>
      <input id="prenom" type="text" v-model="localData.prenom" required />
    </div>

    <div class="input-group">
      <label for="formation">Formation :</label>
      <input id="formation" type="text" v-model="localData.formation" required />
    </div>

    <div class="input-group">
      <label for="ville">Ville :</label>
      <input id="ville" type="text" v-model="localData.ville" required />
    </div>

    <div class="input-group">
      <label for="codePostal">Code postal :</label>
      <input id="codePostal" type="text" v-model="localData.codePostal" required />
    </div>

    <div class="input-group">
      <label for="email">Adresse mail :</label>
      <input id="email" type="email" v-model="localData.email" required />
    </div>

    <div class="input-group">
      <label for="telephone">Numéro de téléphone :</label>
      <input id="telephone" type="tel" v-model="localData.telephone" required />
    </div>

    <button type="button" class="submit-button" @click="validerEtContinuer">
      Suivant
    </button>
  </form>
</template>

<script setup>
import { defineProps, defineEmits, reactive } from 'vue'

const props = defineProps({
  inscriptionData: {
    type: Object,
    required: true
  }
})
const emit = defineEmits(['go-next'])

// Création d'une copie locale pour la page 1
const localData = reactive({ ...props.inscriptionData })

function validerEtContinuer() {
  // Éventuelle validation des champs peut être ajoutée ici
  console.log("Données page 1 :", localData)
  // Émet l'événement en transmettant les données de page 1
  emit('go-next', localData)
}
</script>

<style scoped>
.input-group {
  margin-bottom: 1rem;
}

label {
  display: block;
  font-size: 1rem;
  margin-bottom: 0.5rem;
}

input {
  width: 100%;
  padding: 0.6rem;
  border: 1px solid #ddd;
  border-radius: 5px;
  font-size: 1rem;
}

.submit-button {
  width: 100%;
  padding: 0.8rem;
  background-color: #FA7268;
  border: none;
  color: white;
  font-size: 1.1rem;
  font-weight: bold;
  border-radius: 5px;
  cursor: pointer;
  margin-top: 1rem;
}

.submit-button:hover {
  background-color: #d95a50;
}
</style>
