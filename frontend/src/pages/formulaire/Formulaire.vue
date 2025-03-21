<template>
  <div class="formulaire-container">
    <HomeButton />
    <div class="title-container">
      <h1>Formulaire d'inscription</h1>
      <p>Veuillez sélectionner un salon</p>
    </div>

    <div class="dropdown-container">
      <select v-model="selectedSalon" class="salon-dropdown">
        <option value="" disabled selected>Sélectionnez votre salon</option>
        <option value="Infosup">Infosup</option>
        <option value="Forum des métiers">Forum des métiers</option>
        <option value="Lycée Borde-Basse">Lycée Borde-Basse</option>
      </select>

      <div v-if="selectedSalon">
        <p>Vous avez sélectionné le salon {{ selectedSalon }}</p>
      </div>
    </div>

    <div class="button-container">
      <button @click="submitForm" class="submit-button">Choisir ce salon</button>
    </div>
  </div>
</template>

<script>
import HomeButton from "@/components/formulaire/HomeButton.vue";

export default {
  name: "Formulaire",
  components: { HomeButton },
  data() {
    return {
      selectedSalon: "",
    };
  },
  methods: {
    submitForm() {
      if (this.selectedSalon) {
        this.$router.push({ name: "InfoProspect", params: { salon: this.selectedSalon } });
      } else {
        alert("Veuillez sélectionner un salon.");
      }
    },
  },
};
</script>

<style scoped>
.formulaire-container {
  width: 100%;
  max-width: 600px;
  margin: 0 auto;
  padding: 20px;
}

.title-container {
  margin-bottom: 20px;
}

h1 {
  font-size: 2.5rem;
  font-weight: bold;
  color: #FA7268;
  margin-bottom: 0.5rem;
}

p {
  font-size: 1.5rem;
  font-weight: bold;
  color: #ffffff;
  margin-top: 0;
  text-align: center;
}

.dropdown-container {
  margin-bottom: 30px;
}

.salon-dropdown {
  width: 100%;
  padding: 0.8rem;
  margin: 1rem 0;
  border: 1px solid #ddd;
  border-radius: 5px;
  font-size: 1rem;
}

.submit-button {
  width: 100%;
  padding: 1rem;
  background-color: #FA7268;
  border: none;
  color: white;
  font-size: 1.1rem;
  font-weight: bold;
  border-radius: 5px;
  cursor: pointer;
  transition: background 0.3s ease;
}

.submit-button:hover {
  background-color: #d95a50;
}
</style>
