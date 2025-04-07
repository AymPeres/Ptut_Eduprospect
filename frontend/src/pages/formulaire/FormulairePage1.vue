<template>
  <form @submit.prevent="validerEtContinuer">
    <div class="input-group">
      <label for="nom">Nom * :</label>
      <input id="nom" type="text" v-model="localData.nom" required placeholder="Entrez votre nom" />
    </div>
    <div class="input-group">
      <label for="prenom">Prénom * :</label>
      <input id="prenom" type="text" v-model="localData.prenom" required placeholder="Entrez votre prénom" />
    </div>
    <div class="input-group">
      <label for="formation">Formation * :</label>
      <input id="formation" type="text" v-model="localData.formation" required placeholder="Entrez votre formation" />
    </div>
    <div class="input-group">
      <label for="ville">Ville * :</label>
      <input id="ville" type="text" v-model="localData.ville" required placeholder="Entrez votre ville" />
    </div>
    <div class="input-group">
      <label for="codePostal">Code postal * :</label>
      <input
        id="codePostal"
        type="text"
        v-model="localData.codePostal"
        required
        pattern="^[0-9]+$"
        title="Veuillez entrer uniquement des chiffres"
        placeholder="Entrez votre code postal (Chiffres uniquement)"
      />
    </div>
    <div class="input-group">
      <label for="email">Adresse mail * :</label>
      <input
        id="email"
        type="email"
        v-model="localData.email"
        required
        pattern=".+@.+\..+"
        title="L'adresse mail doit contenir un '@' et un '.'"
        placeholder="Entrez votre adresse mail"
      />
    </div>
    <div class="input-group">
      <label for="telephone">Numéro de téléphone :</label>
      <input
        id="telephone"
        type="tel"
        v-model="localData.telephone"
        pattern="^[0-9]+$"
        title="Veuillez entrer uniquement des chiffres"
        placeholder="Entrez votre numéro de téléphone (facultatif)"
      />
    </div>
    <button type="submit" class="submit-button">
      Suivant
    </button>
  </form>
</template>

<script setup>
import { defineProps, defineEmits, reactive, onMounted, onUnmounted } from 'vue'

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
  console.log("Données page 1 :", localData)
  emit('go-next', localData)
}

// Intercepter le bouton retour du navigateur
function handlePopState() {
  const pwd = prompt("Entrez le mot de passe pour quitter cette page :")
  if (pwd === "1234") {
    window.removeEventListener("popstate", handlePopState)
    history.back()
  } else {
    history.pushState(null, document.title, location.href)
  }
}

onMounted(() => {
  history.pushState(null, document.title, location.href)
  window.addEventListener("popstate", handlePopState)
})

onUnmounted(() => {
  window.removeEventListener("popstate", handlePopState)
})
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
