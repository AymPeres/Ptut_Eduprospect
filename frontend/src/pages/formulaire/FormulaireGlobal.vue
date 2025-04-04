<template>
  <div class="page-container">
    <HomeButton />
    <div class="info-prospect-container">
      <h1>Formulaire d'inscription pour le salon {{ salon }}</h1>

      <!-- Affichage conditionnel des pages -->

      <div v-if="etape === 1">

        <!-- Passe les données globales au composant enfant -->

        <FormulairePage1 :inscriptionData="inscriptionData" @go-next="passerAEtape2" />

      </div>

      <div v-else-if="etape === 2">

        <FormulairePage2 :inscriptionData="inscriptionData" @go-back="passerAEtape1" @submit="soumettreFormulaire" />

      </div>



      <div v-if="message" class="message" :class="{ 'error': erreur }">

        {{ message }}

      </div>

    </div>

    <Footer />

  </div>

</template>



<script setup>

import { ref, reactive } from 'vue'

import {useRoute, useRouter} from 'vue-router'

import HomeButton from "@/components/formulaire/HomeButton.vue"

import Footer from "@/components/formulaire/Footer.vue"

import FormulairePage1 from './FormulairePage1.vue'

import FormulairePage2 from './FormulairePage2.vue'



const router = useRouter()

const etape = ref(1)

const message = ref('')

const erreur = ref(false)


const route = useRoute()
const salon = route.params.salon;
console.log(salon)


// Objet global partagé pour stocker les données du formulaire

const inscriptionData = reactive({

  nom: '',

  prenom: '',

  formation: '',

  ville: '',

  codePostal: '',

  email: '',

  telephone: '',

  sexe: '',

  statut: '',

  interet: '',

  origineContact: '',

  // Fixe le salon à 1 pour Info Sup 2025

  salon: { id: 1 }

})



function passerAEtape1() {

  etape.value = 1

  message.value = ''

}



function passerAEtape2(dataPage1) {

  // Met à jour inscriptionData avec les données reçues de la page 1

  Object.assign(inscriptionData, dataPage1)

  etape.value = 2

  message.value = ''

}



async function soumettreFormulaire() {

  try {

    // Envoie les données globales complètes au backend

    const response = await fetch("/api/inscriptions", {

      method: "POST",

      headers: {

        "Content-Type": "application/json"

      },

      body: JSON.stringify(inscriptionData)

    })

    if (!response.ok) {

      throw new Error(`Erreur HTTP: ${response.status}`)

    }

    await response.json()

    erreur.value = false

    message.value = "Inscription enregistrée avec succès !"

    // Optionnel : rediriger après le succès

    etape.value = 1


    Object.assign(inscriptionData, {
      nom: '',
      prenom: '',
      formation: '',
      ville: '',
      codePostal: '',
      email: '',
      telephone: '',
      sexe: '',
      statut: '',
      interet: '',
      origineContact: '',
      salon: { id: 1 }
    });


  } catch (error) {

    console.error("Erreur lors de la soumission:", error)

    erreur.value = true

    message.value = `Erreur lors de l'envoi du formulaire: ${error.message}`

  }

}

</script>



<style scoped>

.page-container {

  display: flex;

  flex-direction: column;

  min-height: 100vh;

}



.info-prospect-container {

  flex-grow: 1;

  display: flex;

  flex-direction: column;

  justify-content: flex-start;

  padding: 10px;

  max-width: 800px;

  margin: 0 auto;

  margin-bottom: 100px;

}



h1 {

  font-size: 2rem;

  color: #FA7268;

  margin-bottom: 1rem;

}



.message {

  margin-top: 20px;

  padding: 10px;

  border-radius: 5px;

  background-color: #d4edda;

  color: #155724;

}



.message.error {

  background-color: #f8d7da;

  color: #721c24;

}

</style>

