<template>
  <div class="container">
    <router-link to="/formulaire" class="button">
      Espace<br />
      Formulaire
    </router-link>

    <router-link to="/admin/login" class="button">
      Espace<br />
      Administrateur
    </router-link>
  </div>
</template>

<script>
export default {
  name: "IndexPage",
};
</script>

<style scoped>
.container {
  display: flex;
  justify-content: center; /* Centre horizontalement le groupe de boutons */
  align-items: center;     /* Aligne verticalement les boutons */
  gap: 24rem;               /* Espacement entre les deux boutons */
}

.button {
  /* Permet d'empiler le texte sur plusieurs lignes */
  display: inline-flex;
  flex-direction: column; /* Met "Espace" au-dessus de "Formulaire" ou "Administrateur" */
  justify-content: center;
  align-items: center;
  text-align: center;

  /* Taille fixe pour rendre les boutons identiques */
  width: 220px;
  height: 80px;

  /* Style du bouton */
  background-color: #ED6962;
  color: #ffffff;
  font-size: 1.2rem;
  font-weight: bold;
  line-height: 1.2;       /* Contrôle l'espacement entre les lignes */
  padding: 0.5rem;        /* Petite marge intérieure */
  border: none;
  border-radius: 100px;
  text-decoration: none;

  /* Transition (effet hover) */
  transition: background 0.3s ease, transform 0.2s;
}

.button:hover {
  background-color: #ED6962;
  transform: scale(1.05);
}
</style>
