<template>
  <div class="main-content">
    <form class="questionnaire">
      <label for="genre">Vous êtes :</label>
      <select id="genre" v-model="genre">
        <option value="homme">Homme</option>
        <option value="femme">Femme</option>
      </select>

      <label for="interet">Vous êtes intéressé par :</label>
      <select id="interet" v-model="interet">
        <option value="cycle-prepa">Cycle préparatoire</option>
        <option value="cycle-ingenieur">Cycle ingénieur</option>
      </select>

      <label for="statut">Sous statut :</label>
      <select id="statut" v-model="statut">
        <option value="apprenti">Apprenti</option>
        <option value="etudiant">Étudiant</option>
      </select>

      <label for="origine">Comment nous avez-vous connus ?</label>
      <select id="origine" v-model="origine">
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
import Footer from "@/components/formulaire/Footer.vue"; // Importation du footer

export default {
  name: "QuestionsProspect",
  components: {
    Footer, // Déclaration du footer
  },
  data() {
    return {
      genre: "",
      interet: "",
      statut: "",
      origine: "",
    };
  },
};
</script>

<style scoped>
.main-content {
  min-height: 100vh; /* Assure que la page occupe toute la hauteur de la fenêtre */
  display: flex;
  flex-direction: column;
  justify-content: space-between; /* Assure que le contenu est réparti entre le haut et le bas */
  align-items: center; /* Centre le contenu horizontalement */
}

.questionnaire {
  width: 100%;
  max-width: 600px; /* Limite la largeur du formulaire */
  display: flex;
  flex-direction: column;
  gap: 15px;
  padding: 0; /* Enlève le padding pour éviter le cadre */
  border: none; /* Enlève la bordure */
  background-color: transparent; /* Fond transparent */
  box-shadow: none; /* Enlève l'ombre */
}

label {
  font-size: 1.2rem;
  font-weight: bold;
}

select, .btn-valider {
  padding: 10px;
  font-size: 1rem;
  width: 100%; /* Les champs prennent toute la largeur du formulaire */
}

.btn-valider {
  background-color: #FA7268;
  color: white;
  border: none;
  cursor: pointer;
  border-radius: 5px;
}
</style>
