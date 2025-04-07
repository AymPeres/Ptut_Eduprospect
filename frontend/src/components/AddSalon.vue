<template>
  <div class="add-salon">
    <h2>Ajouter un événement</h2>
    <form @submit.prevent="submitForm">
      <div class="form-group">
        <label for="annee">Année :</label>
        <input type="number" id="annee" v-model.number="salon.annee" required />
      </div>
      <div class="form-group">
        <label for="ville">Ville :</label>
        <input type="text" id="ville" v-model="salon.ville" required />
      </div>
      <div class="form-group">
        <label for="nom">Nom de l'événement :</label>
        <input type="text" id="nom" v-model="salon.nom" required />
      </div>
      <!-- Ajoute d'autres champs si nécessaire -->
      <button type="submit">Ajouter</button>
    </form>
  </div>
</template>

<script setup>
import { ref } from 'vue';

const salon = ref({
  annee: null,
  ville: '',
  nom: ''
});

const submitForm = async () => {
  try {
    const response = await fetch('/api/salons', {
      method: 'POST',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify(salon.value)
    });
    if (!response.ok) {
      throw new Error(`HTTP error: ${response.status}`);
    }
    const data = await response.json();
    console.log('Salon ajouté:', data);

    // Réinitialiser le formulaire après succès
    salon.value = { annee: null, ville: '', nom: '' };

    // Recharger la page complète
    window.location.reload();
  } catch (error) {
    console.error("Erreur lors de l'ajout du salon:", error);
  }
};
</script>

<style scoped>
.add-salon {
  padding: 1rem;
  background-color: #f5f5f5;
  border-radius: 5px;
  max-width: 400px;
  margin-bottom: 30px;
  color: #181818;
}

.form-group {
  margin-bottom: 1rem;
}

label {
  display: block;
  margin-bottom: 0.5rem;
}

input {
  width: 100%;
  padding: 0.5rem;
  box-sizing: border-box;
}

button {
  background-color: #ED6962;
  color: white;
  border: none;
  padding: 0.6rem 1.2rem;
  border-radius: 4px;
  cursor: pointer;
}
</style>
