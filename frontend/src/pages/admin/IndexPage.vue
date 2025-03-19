<template>
  <div class="index-page">
    <!-- Bouton Statistiques en haut à droite -->
    <div class="top-right-button">
      <StatButton />
    </div>

    <!-- Ton contenu principal -->
    <div class="containerStat">
      <!-- Bouton déjà existant vers /formulaire -->
      <router-link to="/formulaire" class="button">
        Statistiques
      </router-link>
    </div>
  </div>
</template>

<script>
import StatButton from "@/components/admin/statistiques/StatButton.vue";

export default {
  name: "IndexPage",
  components: {
    StatButton,
  },
};
</script>

<style scoped>
/* Le conteneur global */
.index-page {
  /* Pour que le positionnement absolute prenne comme référence toute la zone */
  position: relative;
  width: 100%;
  height: 100vh; /* S'étend sur la hauteur de la fenêtre (ou adapte selon ton besoin) */
}

/* Le conteneur qui place le bouton en haut à droite */
.top-right-button {
  position: absolute;
  top: 20px;    /* Ajuste selon l'endroit exact où tu veux le bouton */
  right: 20px;  /* Idem */
  z-index: 999; /* Au-dessus du fond violet et des éléments décoratifs */
}

/* Ton bloc existant pour le lien "Statistiques" vers /formulaire */


/* Exemple de style pour le router-link .button */
.button {
  background-color: #ED6962; /* Orange */
  color: #ffffff;
  border: none;
  width: 100px;
  height: 40px;
  border-radius: 100px;
  text-decoration: none;
  display: flex;
  justify-content: center;
  align-items: center;
  font-size: 1rem;
  font-weight: bold;
  transition: background 0.3s ease, transform 0.2s;
}

.button:hover {
  background-color: #ED6962;
  transform: scale(1.05);
}
</style>
