<template>
  <div class="login-container">
    <h2 class="login-title">Entrez votre mot de passe</h2>

    <form class="login-form">
      <input type="password" class="password-input" placeholder="Mot de passe" />

      <div class="login-actions">
        <a href="#" class="forgot-link">mot de passe oublié ?</a>
        <router-link to="/admin" class="login-button">Se connecter</router-link>


      </div>
    </form>
  </div>
</template>

<script>
export default {
  name: "LoginPage",
  methods: {
    goToAdmin() {
      this.$router.push("/adminlayout"); // Redirige vers la page admin
    },
  },
};
</script>


<style scoped>
/* 1) Import de la police Plus Jakarta Sans */
@import url("https://fonts.googleapis.com/css2?family=Plus+Jakarta+Sans:wght@400;700&display=swap");

/* 2) Conteneur global : on centre verticalement et horizontalement */
.login-container {
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: flex-start;      /* Centre verticalement dans l'espace dispo */
  min-height: 10vh;            /* Ajuste pour positionner par rapport au logo */
  max-width: 600px;            /* Largeur max de la « boîte » du formulaire */
  margin: 0 auto;              /* Centre horizontalement */
  font-family: 'Plus Jakarta Sans', sans-serif;
}

/* 3) Titre au-dessus du champ */
.login-title {
  color: #ED6962;              /* Sur fond violet géré par le layout */
  font-size: 1.4rem;
  margin-bottom: 1.5rem;
  text-align: center;
  font-weight: bold;           /* Met le texte en gras */
}


/* 4) Le formulaire en colonne, centré */
.login-form {
  display: flex;
  flex-direction: column;
  width: 100%;                 /* S'étire jusqu'à max-width du conteneur */
  max-width: 500px;
  align-items: center;
}

/* 5) Champ de saisie du mot de passe */
.password-input {
  width: 100%;
  padding: 0.8rem;
  border-radius: 4px;
  border: none;
  margin-bottom: 1rem;
  font-size: 1rem;
}

/* 6) Ligne contenant le lien + bouton */
.login-actions {
  display: flex;
  justify-content: space-between;
  align-items: center;
  width: 100%;
}

/* Lien "mot de passe oublié ?" */
.forgot-link {
  color: #ffffff;
  font-size: 0.9rem;
  text-decoration: underline;
}

/* Bouton "Se connecter" */
.login-button {
  background-color: #ED6962;   /* Orange */
  color: #ffffff;
  border: none;
  padding: 0.8rem 1.5rem;
  border-radius: 4px;
  font-size: 1rem;
  cursor: pointer;
  transition: background-color 0.3s ease, transform 0.2s;
}

/* Effet hover */
.login-button:hover {
  background-color: #ED6962;
  transform: scale(1.03);
}
</style>
