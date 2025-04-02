<template>
  <div class="main-content">
    <HomeButton />
    <form class="questionnaire" @submit.prevent="submitForm">
      <label for="genre">Vous êtes :</label>
      <select id="genre" v-model="genre" required>
        <option value="" disabled selected>Sélectionnez votre genre</option>
        <option value="homme">Homme</option>
        <option value="femme">Femme</option>
      </select>

      <label for="interet">Vous êtes intéressé par :</label>
      <select id="interet" v-model="interet" required>
        <option value="" disabled selected>Sélectionnez un intérêt</option>
        <option value="cycle-prepa">Cycle préparatoire</option>
        <option value="cycle-ingenieur">Cycle ingénieur</option>
      </select>

      <label for="statut">Sous statut :</label>
      <select id="statut" v-model="statut" required>
        <option value="" disabled selected>Sélectionnez votre statut</option>
        <option value="apprenti">Apprenti</option>
        <option value="etudiant">Étudiant</option>
      </select>

      <label for="origine">Comment nous avez-vous connus ?</label>
      <select id="origine" v-model="origine" required>
        <option value="" disabled selected>Sélectionnez une option</option>
        <option value="forum">Forum</option>
        <option value="reseaux">Réseaux sociaux</option>
        <option value="bouche">Bouche à oreille</option>
        <option value="autre">Autre</option>
      </select>

      <button type="submit" class="btn-valider">Valider</button>
    </form>

    <Footer />
  </div>
</template>

<script>
import HomeButton from "@/components/formulaire/HomeButton.vue";
import Footer from "@/components/formulaire/Footer.vue";

export default {
  name: "QuestionsProspect",
  components: {
    HomeButton,
    Footer,
  },
  data() {
    return {
      genre: "",
      interet: "",
      statut: "",
      origine: "",
    };
  },
  methods: {
    async submitForm() {
      // On assemble les données du formulaire
      const formData = {
        genre: this.genre,
        interet: this.interet,
        statut: this.statut,
        origine: this.origine
      };

      try {
        const response = await fetch("http://localhost:8989/api/inscriptions", {
          method: "POST",
          headers: {
            "Content-Type": "application/json"
          },
          body: JSON.stringify(formData)
        });

        if (!response.ok) {
          throw new Error(`Erreur : ${response.statusText}`);
        }

        const data = await response.json();
        alert("Inscription enregistrée avec succès !");
        // Réinitialise le formulaire
        this.genre = "";
        this.interet = "";
        this.statut = "";
        this.origine = "";
      } catch (error) {
        console.error("Erreur lors de l'enregistrement de l'inscription :", error);
        alert("Erreur lors de l'enregistrement, veuillez réessayer.");
      }
    }
  }
};
</script>

<style scoped>
.main-content {
  min-height: 100vh;
  display: flex;
  flex-direction: column;
  justify-content: space-between;
  align-items: center;
}

.questionnaire {
  width: 100%;
  max-width: 600px;
  display: flex;
  flex-direction: column;
  gap: 15px;
  padding: 0;
  border: none;
  background-color: transparent;
  box-shadow: none;
}

label {
  font-size: 1.2rem;
  font-weight: bold;
}

select, .btn-valider {
  padding: 10px;
  font-size: 1rem;
  width: 100%;
}

.btn-valider {
  background-color: #FA7268;
  color: white;
  border: none;
  cursor: pointer;
  border-radius: 5px;
}
</style>
