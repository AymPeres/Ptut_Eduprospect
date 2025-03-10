<script setup>
import {onMounted} from "vue";
function getUtilisateur(){
fetch("http://localhost:8989/api/utilisateurs")
  .then(response => {
    if (!response.ok) {
      throw new Error("Erreur HTTP : " + response.status);
    }
    return response.json();
  })
  .then(data => {
    console.log("Liste des utilisateurs :", data);
    // Ici, tu peux traiter les données reçues, par exemple les afficher dans le DOM.
  })
  .catch(error => console.error("Erreur lors de la récupération :", error));
}
onMounted(getUtilisateur);
</script>

<template>

</template>

<style scoped>

</style>
