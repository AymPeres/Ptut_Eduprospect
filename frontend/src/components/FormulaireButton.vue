<template>
  <router-link to="/formulaire" class="formulaire-button">
    Espace Formulaire
  </router-link>
</template>

<script>
export default {
  name: "FormulaireButton",
};
</script>

<style scoped>
.formulaire-button {
  display: inline-block;
  background-color: #FA7268; /* Couleur du bouton */
  color: #FFFFFF;
  padding: 1rem 2rem;
  font-size: 1.2rem;
  border-radius: 25px; /* Bords arrondis pour un effet “pill” */
  text-decoration: none;
  text-align: center;
  cursor: pointer;
  transition: background-color 0.3s ease;
  box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
}

.formulaire-button:hover {
  background-color: #e9655f; /* Légèrement plus foncé au survol */
}
</style>
