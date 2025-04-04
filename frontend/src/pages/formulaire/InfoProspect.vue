<template>
  <div class="page-container">
    <HomeButton />
    <div class="info-prospect-container">
      <h1>Formulaire d'inscription pour le salon {{ salon }}</h1>
      <form @submit.prevent="submitForm">
        <div class="input-group">
          <label for="name">Nom :</label>
          <input type="text" v-model="name" required />
        </div>
        <div class="input-group">
          <label for="surname">Prénom :</label>
          <input type="text" v-model="surname" required />
        </div>
        <div class="input-group">
          <label for="formation">Formation :</label>
          <input type="text" v-model="formation" required />
        </div>
        <div class="input-group">
          <label for="ville">Ville :</label>
          <input type="text" v-model="ville" required />
        </div>
        <div class="input-group">
          <label for="codePostal">Code postal :</label>
          <input type="text" v-model="codePostal" required />
        </div>
        <div class="input-group">
          <label for="email">Adresse mail :</label>
          <input type="email" v-model="email" required />
        </div>
        <div class="input-group">
          <label for="numero">Numéro de téléphone :</label>
          <input type="tel" v-model="numero" required />
        </div>
        <button type="submit" class="submit-button">Envoyer</button>
      </form>
    </div>
    <Footer />
  </div>
</template>

<script>
import HomeButton from "@/components/formulaire/HomeButton.vue";
import Footer from "@/components/formulaire/Footer.vue";

export default {
  name: "InfoProspect",
  components: { HomeButton, Footer },
  data() {
    return {
      // On récupère ici le paramètre "salon" (id ou nom selon votre config) depuis la route
      salon: this.$route.params.salon,
      name: "",
      surname: "",
      formation: "",
      ville: "",
      codePostal: "",
      email: "",
      numero: "",
    };
  },
  methods: {
    async submitForm() {
      // On prépare les données de l'inscription en incluant le salon (via son id)
      const inscriptionData = {
        nom: this.name,
        prenom: this.surname,
        formation: this.formation,
        ville: this.ville,
        codePostal: this.codePostal,
        email: this.email,
        telephone: this.numero,
        salon: { id: this.salon }  // Assurez-vous que "salon" correspond à l'ID du salon sélectionné
      };

      try {
        const response = await fetch("/api/inscriptions", {
          method: "POST",
          headers: {
            "Content-Type": "application/json"
          },
          body: JSON.stringify(inscriptionData)
        });
        if (!response.ok) {
          throw new Error(`HTTP error: ${response.status}`);
        }
        const data = await response.json();
        alert("Inscription enregistrée avec succès !");
        // On peut ensuite rediriger vers une autre page, par exemple pour les questions
        this.$router.push("/questions-prospect");
      } catch (error) {
        console.error("Erreur lors de la soumission du formulaire:", error);
        alert("Erreur lors de l'enregistrement, veuillez réessayer.");
      }
    },
  },
  beforeRouteLeave(to, from, next) {
    if (to.path === "/formulaire") {
      const motDePasse = prompt("Entrez le mot de passe pour revenir en arrière :");
      if (motDePasse === null) return;
      if (motDePasse === "1234") {
        next();
      } else {
        alert("Mot de passe incorrect !");
        next(false);
      }
    } else {
      next();
    }
  },
};
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
}

.submit-button:hover {
  background-color: #d95a50;
}
</style>
